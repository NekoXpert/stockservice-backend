package com.webapp.stockservice_backend.services;



import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.webapp.stockservice_backend.models.Producto;
import com.webapp.stockservice_backend.models.SolicitudServicio;
import com.webapp.stockservice_backend.repositories.ProductoRepository;
import com.webapp.stockservice_backend.repositories.SolicitudServicioRepository;
import com.webapp.stockservice_backend.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SolicitudServicioRepository solicitudServicioRepository;

    @Override
    public byte[] generarReporteInventario() throws Exception {
        try {
            List<Producto> productos = productoRepository.findAll();
            return generarPDF(productos);
        } catch (Exception e) {
            throw new Exception("Error al generar el reporte de inventario", e);
        }
    }

    @Override
    public byte[] generarReporteSolicitudes() throws Exception {
        try {
            List<SolicitudServicio> solicitudes = solicitudServicioRepository.findAll();
            return generarPDF(solicitudes);
        } catch (Exception e) {
            throw new Exception("Error al generar el reporte de solicitudes", e);
        }
    }

    private byte[] generarPDF(List<?> data) throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdfDoc);

            if (data.isEmpty()) {
                document.add(new Paragraph("No data available"));
            } else if (data.get(0) instanceof Producto) {
                Table table = new Table(new float[] { 3, 3, 3, 3 });
                table.addCell("ID");
                table.addCell("Nombre");
                table.addCell("Cantidad");
                table.addCell("Precio");

                for (Producto producto : (List<Producto>) data) {
                    table.addCell(producto.getId().toString());
                    table.addCell(producto.getNombre());
                    table.addCell(String.valueOf(producto.getCantidad()));
                    table.addCell(String.valueOf(producto.getPrecio()));
                }

                document.add(table);
            } else if (data.get(0) instanceof SolicitudServicio) {
                Table table = new Table(new float[] { 3, 3, 3, 3, 3, 3 });
                table.addCell("ID");
                table.addCell("Cliente");
                table.addCell("Descripción");
                table.addCell("Estado");
                table.addCell("Técnico Asignado");
                table.addCell("Fecha de Creación");

                for (SolicitudServicio solicitud : (List<SolicitudServicio>) data) {
                    table.addCell(solicitud.getId().toString());
                    table.addCell(solicitud.getClienteNombre());
                    table.addCell(solicitud.getDescripcion());
                    table.addCell(solicitud.getEstado());
                    table.addCell(solicitud.getTecnicoAsignado() != null ? solicitud.getTecnicoAsignado().getNombre()
                            : "No asignado");
                    table.addCell(solicitud.getFechaCreacion().toString());
                }

                document.add(table);
            }

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new Exception("Error al generar el PDF", e);
        }
    }
}
