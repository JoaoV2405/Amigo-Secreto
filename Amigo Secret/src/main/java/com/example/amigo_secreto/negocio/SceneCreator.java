package com.example.amigo_secreto.negocio;

import com.example.amigo_secreto.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneCreator {

    public static void launchScene (String sceneName) throws IOException {

        // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(sceneName));
        HelloApplication.setRoot(loader.load());
        Scene scene = new Scene(HelloApplication.getRoot());
        HelloApplication.getStage().setScene(scene);
        HelloApplication.getStage().show();
    }
}
