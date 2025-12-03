package model;

public class SolicitudCambio {
    private final Producto producto;
    private boolean enPeriodoGarantia = false;
    private boolean falloCubierto = false;
    private boolean inventarioDisponible = false;
    private boolean aprobacionGerente = false;
    private String resultado = "PENDIENTE";
    public SolicitudCambio(Producto producto) { this.producto = producto; }
    public Producto getProducto() { return producto; }
    public boolean isEnPeriodoGarantia() { return enPeriodoGarantia; }
    public void setEnPeriodoGarantia(boolean enPeriodoGarantia) { this.enPeriodoGarantia = enPeriodoGarantia; }
    public boolean isFalloCubierto() { return falloCubierto; }
    public void setFalloCubierto(boolean falloCubierto) { this.falloCubierto = falloCubierto; }
    public boolean isInventarioDisponible() { return inventarioDisponible; }
    public void setInventarioDisponible(boolean inventarioDisponible) { this.inventarioDisponible = inventarioDisponible; }
    public boolean isAprobacionGerente() { return aprobacionGerente; }
    public void setAprobacionGerente(boolean aprobacionGerente) { this.aprobacionGerente = aprobacionGerente; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}