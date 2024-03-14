package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.negocio.SceneCreator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Inicial implements Initializable {
    @FXML
    Button pessoas;
    @FXML
    Button grupos;
    @FXML
    Button presentes;
    @FXML
    Button sorteio;
    public void sorteioTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("Sorteio.fxml");
    }

    public void presentesTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("CadastroPresente.fxml");

    }

    public void gruposTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("CadastroGrupos.fxml");

    }


    public void pessoasTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("cadastroPessoas.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
