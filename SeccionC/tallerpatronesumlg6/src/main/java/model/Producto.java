package model;

import java.math.BigDecimal;

public class Producto {
    private final String id;
    private final String nombre;
    private String estado; // Ejemplo: "Disponible", "Falla", "Reparación"
    private final BigDecimal precioVenta;
    private final String tiendaId;
    public Producto(String id, String nombre, String estado, BigDecimal precioVenta, String tiendaId) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.precioVenta = precioVenta;
        this.tiendaId = tiendaId;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public BigDecimal getPrecioVenta() { return precioVenta; }
    public String getTiendaId() { return tiendaId; }
    @Override
    public String toString() {return nombre + " (ID: " + id + ", Estado: " + estado + ", Precio: " + precioVenta + ")";}
}
