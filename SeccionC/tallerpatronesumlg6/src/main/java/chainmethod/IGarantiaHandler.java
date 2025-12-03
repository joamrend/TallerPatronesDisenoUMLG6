package chainmethod;

import model.SolicitudCambio;

public interface IGarantiaHandler {
    IGarantiaHandler setSiguiente(IGarantiaHandler siguiente);
    SolicitudCambio manejarSolicitud(SolicitudCambio solicitud);
}