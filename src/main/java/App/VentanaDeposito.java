package App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaDeposito {

    public VentanaDeposito() {

        Stage stage = new Stage();

        TextField idCliente = new TextField();
        idCliente.setPromptText("ID Cliente");

        TextField idMonedero = new TextField();
        idMonedero.setPromptText("ID Monedero destino");

        TextField montoField = new TextField();
        montoField.setPromptText("Monto");

        Label msg = new Label();
        Button btn = new Button("Depositar");

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
            Deposito d = new Deposito(monto, m);
            d.setClienteInvolucrado(c);

            VENTANAPRINCIPAL.getBanco().ejecutarTransaccion(d);

            msg.setText("Depósito realizado.");
        });

        VBox root = new VBox(10, idCliente, idMonedero, montoField, btn, msg);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 260));
        stage.setTitle("Depósito");
        stage.show();
    }
}
