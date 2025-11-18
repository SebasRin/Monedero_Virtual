package App;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaTransaccionProgramada {

    public VentanaTransaccionProgramada() {

        Stage stage = new Stage();

        TextField idCliente = new TextField();
        idCliente.setPromptText("ID del cliente");

        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Depósito", "Retiro", "Transferencia");
        tipo.setPromptText("Tipo de transacción");

        TextField idOrigen = new TextField();
        idOrigen.setPromptText("ID monedero origen (si aplica)");

        TextField idDestino = new TextField();
        idDestino.setPromptText("ID monedero destino (si aplica)");

        TextField monto = new TextField();
        monto.setPromptText("Monto");

        TextField fecha = new TextField();
        fecha.setPromptText("Fecha ejecución (AAAA-MM-DD)");

        Label msg = new Label();
        Button programar = new Button("Programar");

        programar.setOnAction(e -> {

            Cliente cliente = VENTANAPRINCIPAL.getBanco().buscarCliente(idCliente.getText());

            if (cliente == null) {
                msg.setText("Cliente no encontrado.");
                return;
            }

            double m;
            try {
                m = Double.parseDouble(monto.getText());
            } catch (Exception ex) {
                msg.setText("Monto inválido.");
                return;
            }

            // Convertir fecha
            Date fechaEjec;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fechaEjec = sdf.parse(fecha.getText());
            } catch (Exception ex) {
                msg.setText("Formato de fecha incorrecto.");
                return;
            }

            Transaccion trans = null;

            switch (tipo.getValue()) {

                case "Depósito": {
                    Monedero destino = cliente.buscarMonedero(idDestino.getText());
                    if (destino == null) {
                        msg.setText("Monedero destino no encontrado.");
                        return;
                    }
                    trans = new Deposito(m, destino);
                    break;
                }

                case "Retiro": {
                    Monedero origen = cliente.buscarMonedero(idOrigen.getText());
                    if (origen == null) {
                        msg.setText("Monedero origen no encontrado.");
                        return;
                    }
                    trans = new Retiro(m, origen);
                    break;
                }

                case "Transferencia": {
                    Monedero origen = cliente.buscarMonedero(idOrigen.getText());
                    Monedero destino = cliente.buscarMonedero(idDestino.getText());
                    if (origen == null || destino == null) {
                        msg.setText("Origen o destino no encontrado.");
                        return;
                    }
                    trans = new Transferencia(m, origen, destino);
                    break;
                }

                default:
                    msg.setText("Seleccione tipo de transacción.");
                    return;
            }

            // Crear transacción programada correcta (usa Date)
            TransaccionProgramada tp =
                    new TransaccionProgramada(trans, fechaEjec);

            VENTANAPRINCIPAL.getBanco().agregarTransaccionProgramada(tp);

            msg.setText("Transacción programada con éxito.");
        });

        VBox root = new VBox(10,
                idCliente,
                tipo,
                idOrigen,
                idDestino,
                monto,
                fecha,
                programar,
                msg
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 350, 420));
        stage.setTitle("Programar Transacción");
        stage.show();
    }
}
