package com.webapp.stockservice_backend.services;

import com.webapp.stockservice_backend.models.SolicitudServicio;
import com.webapp.stockservice_backend.models.Tecnico;
import com.webapp.stockservice_backend.repositories.SolicitudServicioRepository;
import com.webapp.stockservice_backend.repositories.TecnicoRepository;
import com.webapp.stockservice_backend.services.SolicitudServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServicioServiceImpl implements SolicitudServicioService {

    @Autowired
    private SolicitudServicioRepository solicitudServicioRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public SolicitudServicio registrarSolicitud(SolicitudServicio solicitud) throws Exception {
        try {
            return solicitudServicioRepository.save(solicitud);
        } catch (Exception e) {
            throw new Exception("Error al registrar la solicitud de servicio", e);
        }
    }

    @Override
    public SolicitudServicio asignarTecnico(Long solicitudId, Long tecnicoId) throws Exception {
        try {
            Optional<SolicitudServicio> optionalSolicitud = solicitudServicioRepository.findById(solicitudId);
            Optional<Tecnico> optionalTecnico = tecnicoRepository.findById(tecnicoId);

            if (optionalSolicitud.isPresent() && optionalTecnico.isPresent()) {
                SolicitudServicio solicitud = optionalSolicitud.get();
                Tecnico tecnico = optionalTecnico.get();
                solicitud.setTecnicoAsignado(tecnico);
                return solicitudServicioRepository.save(solicitud);
            } else {
                throw new Exception("Solicitud o Técnico no encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error al asignar el técnico a la solicitud", e);
        }
    }

    @Override
    public List<SolicitudServicio> obtenerSolicitudes() {
        return solicitudServicioRepository.findAll();
    }

    @Override
    public List<SolicitudServicio> filtrarSolicitudesPorEstado(String estado) {
        return solicitudServicioRepository.findAll().stream()
                .filter(solicitud -> solicitud.getEstado().equals(estado))
                .toList();
    }

    @Override
    public List<SolicitudServicio> filtrarSolicitudesPorCliente(String clienteNombre) {
        return solicitudServicioRepository.findAll().stream()
                .filter(solicitud -> solicitud.getClienteNombre().contains(clienteNombre))
                .toList();
    }

    @Override
    public SolicitudServicio actualizarEstado(Long solicitudId, String estado) throws Exception {
        try {
            Optional<SolicitudServicio> optionalSolicitud = solicitudServicioRepository.findById(solicitudId);
            if (optionalSolicitud.isPresent()) {
                SolicitudServicio solicitud = optionalSolicitud.get();
                solicitud.setEstado(estado);
                return solicitudServicioRepository.save(solicitud);
            } else {
                throw new Exception("Solicitud no encontrada");
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el estado de la solicitud", e);
        }
    }
}
