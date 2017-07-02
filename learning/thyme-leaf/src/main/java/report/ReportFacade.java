package report;

/**
 * Created by Winiar on 01.07.2017.
 */
public class ReportFacade {

    public <T> T doTheJOb(Report<T> report) {
        return report.generate();
    }
}
