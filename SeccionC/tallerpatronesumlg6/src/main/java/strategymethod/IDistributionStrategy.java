package strategymethod;

import java.util.List;
import model.Bodega;
import model.Producto;

public interface IDistributionStrategy {
    boolean distribuir(List<Producto> productos, Bodega destino);
}