package iteratormethod;

public interface InventarioAggregate {
    ProductoIterator crearIterator(String tipo);
}