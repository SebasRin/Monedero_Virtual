package App;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaRangoCliente {

    public VentanaRangoCliente() {

        Stage stage = new Stage();

        TextField idCliente = new TextField();
        idCliente.setPromptText("ID del cliente");

        Button consultar = new Button("Consultar rango");
        Label msg = new Label();
        Label nombre = new Label();
        Label puntos = new Label();
        Label rango = new Label();
        Label beneficio = new Label();

        consultar.setOnAction(e -> {

            Cliente c = VENTANAPRINCIPAL.getBanco().buscarCliente(idCliente.getText());

            if (c == null) {
                msg.setText("Cliente no encontrado.");
                nombre.setText("");
                puntos.setText("");
                rango.setText("");
                beneficio.setText("");
                return;
            }

            msg.setText("Información del cliente:");

            nombre.setText("Nombre: " + c.getNombre());
            puntos.setText("Puntos acumulados: " + c.getPuntosAcumulados());
            rango.setText("Rango actual: " + c.getRangoActual().getClass().getSimpleName());


            beneficio.setText("Beneficio: " + c.getRangoActual().beneficio());

        });

        VBox root = new VBox(10, idCliente, consultar, msg, nombre, puntos, rango, beneficio);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 350));
        stage.setTitle("Rango del Cliente");
        stage.show();
    }
}
