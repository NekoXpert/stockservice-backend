package com.webapp.stockservice_backend.services;


import java.util.List;

public interface ReporteService {
    byte[] generarReporteInventario() throws Exception;

    byte[] generarReporteSolicitudes() throws Exception;
}
