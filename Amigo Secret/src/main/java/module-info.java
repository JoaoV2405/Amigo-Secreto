module com.example.amigo_secreto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.amigo_secreto to javafx.fxml;
    exports com.example.amigo_secreto;
    exports com.example.amigo_secreto.negocio;
    opens com.example.amigo_secreto.negocio to javafx.fxml;
    exports com.example.amigo_secreto.gui;
    opens com.example.amigo_secreto.gui to javafx.fxml;
    exports com.example.amigo_secreto.exception;
    opens com.example.amigo_secreto.exception to javafx.fxml;
    exports com.example.amigo_secreto.negocio.beans;
    opens com.example.amigo_secreto.negocio.beans to javafx.fxml;
}