package App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaRetiro {

    public VentanaRetiro() {

        Stage stage = new Stage();

        TextField idCliente = new TextField();
        idCliente.setPromptText("ID Cliente");

        TextField idMonedero = new TextField();
        idMonedero.setPromptText("ID Monedero origen");

        TextField montoField = new TextField();
        montoField.setPromptText("Monto");

        Label msg = new Label();
        Button btn = new Button("Retirar");

        btn.setOnAction(e -> {
            Cliente c = VENTANAPRINCIPAL.getBanco().buscarCliente(idCliente.getText());
            if (c == null) {
                msg.setText("Cliente no encontrado.");
                return;
            }

            Monedero m = c.buscarMonedero(idMonedero.getText());
            if (m == null) {
                msg.setText("Monedero no encontrado.");
                return;
            }

            double monto = Double.parseDouble(montoField.getText());
            Retiro r = new Retiro(monto, m);
            r.setClienteInvolucrado(c);

            VENTANAPRINCIPAL.getBanco().ejecutarTransaccion(r);

            msg.setText("Retiro exitoso.");
        });

        VBox root = new VBox(10, idCliente, idMonedero, montoField, btn, msg);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 260));
        stage.setTitle("Retiro");
        stage.show();
    }
}
