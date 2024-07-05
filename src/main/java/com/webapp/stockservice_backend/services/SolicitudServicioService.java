package com.webapp.stockservice_backend.services;



import com.webapp.stockservice_backend.models.SolicitudServicio;
import java.util.List;

public interface SolicitudServicioService {
    SolicitudServicio registrarSolicitud(SolicitudServicio solicitud) throws Exception;

    SolicitudServicio asignarTecnico(Long solicitudId, Long tecnicoId) throws Exception;

    List<SolicitudServicio> obtenerSolicitudes();

    List<SolicitudServicio> filtrarSolicitudesPorEstado(String estado);

    List<SolicitudServicio> filtrarSolicitudesPorCliente(String clienteNombre);

    SolicitudServicio actualizarEstado(Long solicitudId, String estado) throws Exception;
}
