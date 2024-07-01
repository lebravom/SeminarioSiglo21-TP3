package edu.siglo21.app.Controller;

import edu.siglo21.app.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;

public class loginController {

    @FXML
    private AnchorPane mainForm;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private TextField contrasena;

    @FXML
    private Button closeBtn;
    @FXML
    private Button loginBtn;

    private double x=0;
    private double y=0;
    public void close(){
        System.exit(0);
    }

    public void loginAdmin() throws IOException {
        Usuario admin = new Usuario("Admin", "Admin");

        if(nombreUsuario.getText().isEmpty() || contrasena.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensaje de error");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario o contraseña en blanco.");
            alerta.showAndWait();
        } else if (nombreUsuario.getText().equals(admin.getUsuario()) && contrasena.getText().equals(admin.getContrasena())) {

            //Esconder la ventana principal si ingresa con exito.
            loginBtn.getScene().getWindow().hide();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ingreso Exitoso");
            alerta.setHeaderText(null);
            alerta.setContentText("Ingreso exitoso.");
            alerta.showAndWait();

            Parent root = FXMLLoader.load(App.class.getResource("principalVista.fxml"));
            //Parent root = FXMLLoader.load(App.class.getResource("principalVista.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);


            root.setOnMousePressed((MouseEvent event )-> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event)->{
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

            // Para que no se muestren los botones por defecto de minimizar y cerrar.
            stage.initStyle(StageStyle.TRANSPARENT);


            stage.setScene((scene));
            stage.show();
        } else if( !(nombreUsuario.getText().equals(admin.getUsuario())) || !(contrasena.getText().equals(admin.getContrasena()))){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensaje de error");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario y/o contraseña incorrecto");
            alerta.showAndWait();
        }
    }


}