package chainmethod;

import model.SolicitudCambio;

public class JefeInventario extends AbstractHandler {
    @Override
    public SolicitudCambio manejarSolicitud(SolicitudCambio solicitud) {
        // Lógica de verificación: Asumimos que hay inventario si el ID es par.
        boolean inventarioOK = Integer.parseInt(solicitud.getProducto().getId()) % 2 == 0;
        solicitud.setInventarioDisponible(inventarioOK);
        log("Certificando existencia en bodega: " + (inventarioOK ? "OK" : "RECHAZADO"));

        if (!inventarioOK) {
            solicitud.setResultado("RECHAZO_SIN_INVENTARIO");
            return solicitud;
        }
        // Si pasa, llama al siguiente en la cadena
        return super.manejarSolicitud(solicitud);
    }
}