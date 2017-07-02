package report;

/**
 * Created by Winiar on 01.07.2017.
 */
public class App {

    public static void main(String[] args) {

        ReportFacade reportFacade = new ReportFacade();

        ExcelReport excelReport = new ExcelReport();
        HtmlReport htmlReport = new HtmlReport();

        String s = reportFacade.doTheJOb(htmlReport);
        String excel = reportFacade.doTheJOb(excelReport).getName();

        System.out.println(s);
        System.out.println(excel);


    }

}
