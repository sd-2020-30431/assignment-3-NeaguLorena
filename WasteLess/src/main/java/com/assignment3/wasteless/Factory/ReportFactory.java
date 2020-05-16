package com.assignment3.wasteless.Factory;

import com.assignment3.wasteless.Presentation.Model.ReportGenerator;
import com.assignment3.wasteless.Presentation.Model.ReportType;

public abstract class ReportFactory {

    public abstract ReportGenerator getReport(ReportType reportType);
}
