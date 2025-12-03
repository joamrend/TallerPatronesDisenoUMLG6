package strategymethod;

import java.util.List;
import model.Bodega;
import model.Producto;

public class EstrategiaAutomotriz implements IDistributionStrategy {
    @Override
    public boolean distribuir(List<Producto> productos, Bodega destino) {
        System.out.println("🚛 Distribuyendo " + productos.size() + " productos vía AUTOMOTRIZ a " + destino.getNombre() + ".");
        // Lógica: Calcular combustible, ruta de carretera, etc.
        return true;
    }
}