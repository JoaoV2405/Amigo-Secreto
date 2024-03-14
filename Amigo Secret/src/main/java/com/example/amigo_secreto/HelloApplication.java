package com.example.amigo_secreto;

import com.example.amigo_secreto.negocio.SceneCreator;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    static Parent root;
    static Stage primaryStage;

    public static Parent getRoot() {
        return root;
    }
    public static Stage getStage() {

        return primaryStage;
    }

    static void setStage(Stage stage) {

        HelloApplication.primaryStage = stage;
    }
    public static void setRoot(Parent root) {
        HelloApplication.root = root;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        HelloApplication.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            // setting up the login scene
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            HelloApplication.primaryStage = primaryStage;
            primaryStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("/scenes/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
    }
//    @FXML
//    public void trocaCadastro(MouseEvent event) throws IOException {
//        SceneCreator.launchScene("hello-view.fxml");
//    }

    public static void main(String[] args) {
        launch();
    }
}