package strategymethod;

import java.util.List;
import model.Bodega;
import model.Producto;

public class LogisticaDepartamento {
    private IDistributionStrategy estrategia;
    public void setEstrategia(IDistributionStrategy estrategia) {
        this.estrategia = estrategia;
        System.out.println("\n⚙️ Estrategia de distribución configurada: " + estrategia.getClass().getSimpleName());
    }
    public boolean ejecutarDistribucion(List<Producto> productos, Bodega destino) {
        if (estrategia == null) {
            System.err.println("❌ Error: No se ha configurado ninguna estrategia de distribución.");
            return false;
        }
        System.out.println("📦 Iniciando distribución...");
        return this.estrategia.distribuir(productos, destino);
    }
}