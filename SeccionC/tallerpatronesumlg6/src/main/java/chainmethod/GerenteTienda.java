package chainmethod;

import java.math.BigDecimal;
import model.SolicitudCambio;

public class GerenteTienda extends AbstractHandler {
    private static final BigDecimal UMBRAL_APROBACION = new BigDecimal("1000.00");
    @Override
    public SolicitudCambio manejarSolicitud(SolicitudCambio solicitud) {
        if (solicitud.getProducto().getPrecioVenta().compareTo(UMBRAL_APROBACION) > 0) {
            // Si requiere aprobación, el gerente debe actuar.
            solicitud.setAprobacionGerente(true); // Simulación de aprobación
            if (solicitud.isAprobacionGerente()) {
                log("Producto es caro. Aprobación del Gerente: OK");
            } else {
                solicitud.setResultado("RECHAZO_GERENTE");
                log("Producto es caro. Aprobación del Gerente: RECHAZADO");
                return solicitud;
            }
        } else {
            log("Producto es barato. No requiere aprobación de Gerencia.");
        }
        // Es el último paso de aprobación condicional, pasa al siguiente (que puede ser null)
        return super.manejarSolicitud(solicitud);
    }
}