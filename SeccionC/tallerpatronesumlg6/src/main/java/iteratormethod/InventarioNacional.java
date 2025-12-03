package iteratormethod;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import model.Producto;

public class InventarioNacional implements InventarioAggregate {
    private final List<Producto> productos;
    public InventarioNacional(List<Producto> productos) {
        this.productos = productos;
    }
    @Override
    public ProductoIterator crearIterator(String tipo) {
        if ("WEB".equalsIgnoreCase(tipo)) {
            return new IteradorCompradorWeb(productos);
        } else if ("FALLAS".equalsIgnoreCase(tipo)) {
            return new IteradorProveedorFallas(productos);
        }
        return null; // Podría devolver un iterador por defecto o lanzar excepción
    }
    // AbstractIterator no se requiere aquí, se implementa directamente la interfaz
    private static class IteradorCompradorWeb implements ProductoIterator {
        private final List<Producto> productosDisponibles;
        private int posicion = 0;
        public IteradorCompradorWeb(List<Producto> todosLosProductos) {
            // Lógica de filtro: Solo disponibles
            this.productosDisponibles = todosLosProductos.stream()
                .filter(p -> "Disponible".equals(p.getEstado()))
                .collect(Collectors.toList());
        }
        @Override
        public boolean hasNext() {
            return posicion < productosDisponibles.size();
        }
        @Override
        public Producto next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return productosDisponibles.get(posicion++);
        }
    }
    private static class IteradorProveedorFallas implements ProductoIterator {
        private final List<Producto> productosConFalla;
        private int posicion = 0;
        public IteradorProveedorFallas(List<Producto> todosLosProductos) {
            this.productosConFalla = todosLosProductos.stream()
                .filter(p -> "Falla".equals(p.getEstado()))
                .collect(Collectors.toList());
        }
        @Override
        public boolean hasNext() {
            return posicion < productosConFalla.size();
        }
        @Override
        public Producto next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return productosConFalla.get(posicion++);
        }
    }
}