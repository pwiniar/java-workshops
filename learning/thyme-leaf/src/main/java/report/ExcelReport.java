package report;

/**
 * Created by Winiar on 01.07.2017.
 */
public class ExcelReport implements Report<Excel> {
    @Override
    public Excel generate() {
        Excel excel = new Excel();
        excel.setName("report.Excel name");
        return excel;
    }
}
