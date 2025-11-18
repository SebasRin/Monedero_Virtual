package App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.*;

public class VentanaRegistrarCliente {

    public VentanaRegistrarCliente() {

        Stage stage = new Stage();

        TextField id = new TextField();
        id.setPromptText("ID del cliente");

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        TextField correo = new TextField();
        correo.setPromptText("Correo");

        Button registrar = new Button("Registrar");

        Label mensaje = new Label();

        registrar.setOnAction(e -> {
            Cliente c = new Cliente(id.getText(), nombre.getText(), correo.getText());

            VENTANAPRINCIPAL.getBanco().registrarCliente(c);
            mensaje.setText("Cliente registrado.");
        });

        VBox root = new VBox(10, id, nombre, correo, registrar, mensaje);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 280, 250));
        stage.setTitle("Registrar Cliente");
        stage.show();
    }
}
