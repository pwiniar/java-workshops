import yahoofinance.quotes.fx.FxSymbols;

import java.io.*;
import java.math.BigDecimal;
import java.net.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Pawel on 2016-11-02.
 */
public class Main {

    //jeden watek nasluchuje, drugi sprawdza czy byly jakies update

    private final static FxRates fxRates = new FxRates();
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws IOException {

        RequestType requestType = RequestType.CSV2;

        switch (requestType) {
            case HTTP_GET:
                runHttpGet();
                break;
            case CSV:
                runCsv();
                break;
            case HTTP_POST:
                runPost();
                break;
            case POST_SOCKET:
                runPostSocket();
                break;
            case CSV2:
                runCSV2();
                break;
        }
    }

    private enum RequestType {
        HTTP_GET, HTTP_POST, CSV, CSV2, POST_SOCKET
    }

    private static void runPost() throws IOException {
        String request = "http://finance.yahoo.com/webservice/v1/symbols/YHOO,AAPL/quote?format=json&view=detail";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static void runHttpGet() throws IOException {
        String request = "http://api.search.yahoo.com/WebSearchService/V1/webSearch?appid=YahooDemo&query=umbrella&results=10";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HTTP");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static void runCsv() {
        Map<String, BigDecimal> quotes = new HashMap<>();
        List<String> symbols = new ArrayList<>(Arrays.asList(
                FxSymbols.USDGBP,
                FxSymbols.USDEUR,
                FxSymbols.USDAUD,
                FxSymbols.USDCHF,
                FxSymbols.USDJPY,
                FxSymbols.USDCAD,
                FxSymbols.USDSGD,
                FxSymbols.USDNZD,
                FxSymbols.USDHKD,
                FxSymbols.GBPUSD,
                FxSymbols.GBPEUR,
                FxSymbols.GBPAUD));

        for (int i = 0; i < 5; i++) {
            for (String s : symbols) {
                BigDecimal price = fxRates.getFxForSymbol(s);

                if (!quotes.keySet().contains(s)) {
                    quotes.put(s, price);
                } else {
                    BigDecimal oldPrice = quotes.get(s);
                    if (price.compareTo(oldPrice) == 1) {
                        LOGGER.info("Change for : " + s + " " + "from : " + oldPrice + " to " + price);
                        quotes.put(s, price);
                    }
                }
            }
        }

        for (String s : quotes.keySet()) {
            System.out.println(s + ":" + quotes.get(s));

        }
    }

    private static void runPostSocket() {
        try {
            // Create POST repository string
            String postdata = "appid" + "=" + URLEncoder.encode("YahooDemo", "UTF-8");
            postdata += "&" + "query" + "=" + URLEncoder.encode("umbrella", "UTF-8");
            postdata += "&" + "results" + "=" + URLEncoder.encode("10", "UTF-8");

            // Create a socket to the host
            String hostname = "api.search.yahoo.com";
            int port = 80;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket socket = new Socket(addr, port);

            // Send header
            String path = "/WebSearchService/V1/webSearch";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            bw.write("POST " + path + " HTTP/1.0\r\n");
            bw.write("Content-Length: " + postdata.length() + "\r\n");
            bw.write("Content-Type: application/x-www-form-urlencoded\r\n");
            bw.write("\r\n");

            // Send POST repository string
            bw.write(postdata);
            bw.flush();

            // Process the response from Yahoo! Web Services
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println("Web services request failed");
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }

    }

    private static void runCSV2() {
        String csvData = null;

        try {

            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT+BOEING&f=snbaopl1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}