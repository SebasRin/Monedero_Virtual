package App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaTransferencia {

    public VentanaTransferencia() {

        Stage stage = new Stage();

        TextField idOrigen = new TextField();
        idOrigen.setPromptText("ID Cliente Origen");

        TextField monederoOrigen = new TextField();
        monederoOrigen.setPromptText("Monedero Origen");

        TextField idDestino = new TextField();
        idDestino.setPromptText("ID Cliente Destino");

        TextField monederoDestino = new TextField();
        monederoDestino.setPromptText("Monedero Destino");

        TextField montoField = new TextField();
        montoField.setPromptText("Monto");

        Label msg = new Label();
        Button btn = new Button("Transferir");

        btn.setOnAction(e -> {

            Cliente c1 = VENTANAPRINCIPAL.getBanco().buscarCliente(idOrigen.getText());
            Cliente c2 = VENTANAPRINCIPAL.getBanco().buscarCliente(idDestino.getText());

            if (c1 == null || c2 == null) {
                msg.setText("Cliente origen o destino inválido.");
                return;
            }

            Monedero m1 = c1.buscarMonedero(monederoOrigen.getText());
            Monedero m2 = c2.buscarMonedero(monederoDestino.getText());

            if (m1 == null || m2 == null) {
                msg.setText("Monedero inválido.");
                return;
            }

            double monto = Double.parseDouble(montoField.getText());

            Transferencia t = new Transferencia(monto, m1, m2);
            t.setClienteInvolucrado(c1);

            VENTANAPRINCIPAL.getBanco().ejecutarTransaccion(t);

            msg.setText("Transferencia exitosa.");
        });

        VBox root = new VBox(10, idOrigen, monederoOrigen, idDestino, monederoDestino, montoField, btn, msg);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 320, 320));
        stage.setTitle("Transferencia");
        stage.show();
    }
}
