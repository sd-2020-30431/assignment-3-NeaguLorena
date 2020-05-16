package com.assignment3.wasteless.Factory;

import com.assignment3.wasteless.Presentation.Model.MonthlyReport;
import com.assignment3.wasteless.Presentation.Model.ReportGenerator;
import com.assignment3.wasteless.Presentation.Model.ReportType;

public class MonthlyReportFactory extends ReportFactory {

    @Override
    public ReportGenerator getReport(ReportType reportType) {
        return new MonthlyReport();
    }
}