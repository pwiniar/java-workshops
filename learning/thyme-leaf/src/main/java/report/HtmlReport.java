package report;

/**
 * Created by Winiar on 01.07.2017.
 */
public class HtmlReport implements Report<String> {

    @Override
    public String generate() {
        return "html report";
    }
}
