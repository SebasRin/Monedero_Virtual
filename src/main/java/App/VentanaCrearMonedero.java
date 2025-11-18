package App;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaCrearMonedero {

    public VentanaCrearMonedero() {

        Stage stage = new Stage();

        TextField idCliente = new TextField();
        idCliente.setPromptText("ID del cliente");

        TextField idMonedero = new TextField();
        idMonedero.setPromptText("ID del monedero");

        TextField nombreMonedero = new TextField();
        nombreMonedero.setPromptText("Nombre del monedero");

        Label msg = new Label();
        Button crear = new Button("Crear");

        crear.setOnAction(e -> {

            Cliente c = VENTANAPRINCIPAL.getBanco().buscarCliente(idCliente.getText());

            if (c == null) {
                msg.setText("Cliente no encontrado.");
                return;
            }

            // Crear correctamente el monedero
            Monedero m = new Monedero(
                    idMonedero.getText(),
                    nombreMonedero.getText(),
                    0
            );

            m.setCliente(c);        // asignar dueño
            c.agregarMonedero(m);   // agregar al cliente

            msg.setText("Monedero creado.");
        });

        VBox root = new VBox(10, idCliente, idMonedero, nombreMonedero, crear, msg);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 260));
        stage.setTitle("Crear Monedero");
        stage.show();
    }
}
