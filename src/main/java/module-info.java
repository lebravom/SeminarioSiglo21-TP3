module edu.siglo21.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    opens edu.siglo21.app to javafx.fxml;
    exports edu.siglo21.app;
    exports edu.siglo21.app.Controller;
    opens edu.siglo21.app.Controller to javafx.fxml;
}