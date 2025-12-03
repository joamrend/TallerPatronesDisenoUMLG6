package chainmethod;

import model.SolicitudCambio;

public abstract class AbstractHandler implements IGarantiaHandler {
    private IGarantiaHandler siguienteHandler;
    @Override
    public IGarantiaHandler setSiguiente(IGarantiaHandler siguiente) {
        this.siguienteHandler = siguiente;
        return siguiente; // Permite el encadenamiento fluido: handlerA.setSiguiente(handlerB).setSiguiente(handlerC)
    }
    @Override
    public SolicitudCambio manejarSolicitud(SolicitudCambio solicitud) {
        // Si hay un siguiente handler, pasar la solicitud a él.
        if (siguienteHandler != null) {
            return siguienteHandler.manejarSolicitud(solicitud);
        }
        // Si es el final de la cadena y no hay resultado de rechazo, se aprueba implícitamente.
        if ("PENDIENTE".equals(solicitud.getResultado())) {
            solicitud.setResultado("APROBADO_FINAL");
        }
        return solicitud;
    }
    protected void log(String mensaje) {
        System.out.println("  [" + this.getClass().getSimpleName() + "] " + mensaje);
    }
}