package App;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaAnalisisPatrones {

    private AnalisisPatrones analisis = new AnalisisPatrones();

    public VentanaAnalisisPatrones() {

        Stage stage = new Stage();

        TextField categoria = new TextField();
        categoria.setPromptText("Categoría (Ej: Comida)");

        TextField monto = new TextField();
        monto.setPromptText("Monto gastado");

        Button registrar = new Button("Registrar gasto");
        Button generar = new Button("Generar reporte");

        Label msg = new Label();
        TextArea reporte = new TextArea();
        reporte.setEditable(false);

        registrar.setOnAction(e -> {

            try {
                double m = Double.parseDouble(monto.getText());

                analisis.registrarGasto(categoria.getText(), m);
                msg.setText("Gasto registrado.");

            } catch (Exception ex) {
                msg.setText("Monto inválido.");
            }

        });

        generar.setOnAction(e -> {
            analisis.generarReporte();

            String ultimoReporte = analisis.getReportesGenerados()
                    .get( analisis.getReportesGenerados().size() - 1 );

            reporte.setText(ultimoReporte);
        });

        VBox root = new VBox(10, categoria, monto, registrar, generar, msg, reporte);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 350, 450));
        stage.setTitle("Análisis de patrones de gasto");
        stage.show();
    }
}
