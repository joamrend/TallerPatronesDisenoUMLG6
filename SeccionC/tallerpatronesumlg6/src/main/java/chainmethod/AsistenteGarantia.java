package chainmethod;

import model.SolicitudCambio;

public class AsistenteGarantia extends AbstractHandler {
    @Override
    public SolicitudCambio manejarSolicitud(SolicitudCambio solicitud) {
        // Lógica de verificación: Asumimos que la garantía siempre está activa para este ejemplo.
        boolean periodoOK = true; // Simulación: verificar fecha de compra
        solicitud.setEnPeriodoGarantia(periodoOK);
        log("Verificando período de garantía: " + (periodoOK ? "OK" : "RECHAZADO"));
        if (!periodoOK) {
            solicitud.setResultado("RECHAZO_GARANTIA_VENCIDA");
            return solicitud;
        }
        // Si pasa, llama al siguiente en la cadena
        return super.manejarSolicitud(solicitud);
    }
}