package iteratormethod;

import java.util.Iterator;
import model.Producto;

public interface ProductoIterator extends Iterator<Producto> {
    // Hereda hasNext() y next() de java.util.Iterator
}