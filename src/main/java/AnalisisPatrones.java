import java.util.ArrayList;
import java.util.List;

public class AnalisisPatrones {
    private List<String> reportesGenerados;
    private List<String> categorias;
    private List<Double> gastosPorCategoria;

    public AnalisisPatrones() {
        this.reportesGenerados = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.gastosPorCategoria = new ArrayList<>();
    }

    public List<String> getReportesGenerados() {
        return reportesGenerados;
    }

    public void setReportesGenerados(List<String> reportesGenerados) {
        this.reportesGenerados = reportesGenerados;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public List<Double> getGastosPorCategoria() {
        return gastosPorCategoria;
    }

    public void setGastosPorCategoria(List<Double> gastosPorCategoria) {
        this.gastosPorCategoria = gastosPorCategoria;
    }
}
