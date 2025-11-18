package App;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VENTANAPRINCIPAL extends Application {

    private static BancoVirtual banco = new BancoVirtual();

    public static BancoVirtual getBanco() {
        return banco;
    }

    @Override
    public void start(Stage stage) {

        // BOTONES PRINCIPALES
        Button registrarCliente = new Button("Registrar Cliente");
        Button crearMonedero = new Button("Crear Monedero");
        Button deposito = new Button("Realizar Depósito");
        Button retiro = new Button("Realizar Retiro");
        Button transferencia = new Button("Realizar Transferencia");

        // NUEVOS BOTONES
        Button rangoCliente = new Button("Rango del Cliente");
        Button analisisPatrones = new Button("Análisis de Patrones");
        Button transProg = new Button("Transacción Programada");

        // ACCIONES DE LOS BOTONES
        registrarCliente.setOnAction(e -> new VentanaRegistrarCliente());
        crearMonedero.setOnAction(e -> new VentanaCrearMonedero());
        deposito.setOnAction(e -> new VentanaDeposito());
        retiro.setOnAction(e -> new VentanaRetiro());
        transferencia.setOnAction(e -> new VentanaTransferencia());

        rangoCliente.setOnAction(e -> new VentanaRangoCliente());
        analisisPatrones.setOnAction(e -> new VentanaAnalisisPatrones());
        transProg.setOnAction(e -> new VentanaTransaccionProgramada());

        // LAYOUT
        VBox root = new VBox(12,
                registrarCliente,
                crearMonedero,
                deposito,
                retiro,
                transferencia,
                rangoCliente,
                analisisPatrones,
                transProg
        );

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 320, 420);
        stage.setScene(scene);
        stage.setTitle("Banco Virtual - JavaFX");
        stage.show();
    }
}
