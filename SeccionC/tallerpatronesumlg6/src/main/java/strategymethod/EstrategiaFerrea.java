package strategymethod;

import java.util.List;
import model.Bodega;
import model.Producto;

public class EstrategiaFerrea implements IDistributionStrategy {
    @Override
    public boolean distribuir(List<Producto> productos, Bodega destino) {
        System.out.println("🚂 Distribuyendo " + productos.size() + " productos vía FÉRREA a " + destino.getNombre() + ". Requiere vagón especial.");
        // Lógica: Reservar vagón, verificar horarios de tren.
        return true;
    }
}