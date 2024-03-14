package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.exception.PresenteExisteListaException;
import com.example.amigo_secreto.negocio.*;
import com.example.amigo_secreto.negocio.beans.Presente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroPresente implements Initializable {
@FXML
private TextField categoria;
    @FXML
    private TextField descricao;
    @FXML
    private TextField preco;
    String precoP;
    String categoriaP;
    String descricaoP;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
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

    public void cancel(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("hello-view.fxml");
    }

    public void salvar(MouseEvent mouseEvent) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText("");
        sucesso.setTitle("Sucesso!");
        erro.setHeaderText("");
        erro.setTitle("Erro");
        float precof = 0;
        precoP = preco.getText();
        categoriaP = categoria.getText();
        descricaoP = descricao.getText();
        try {
            precof = Float.parseFloat(precoP);
            if (categoriaP.length() > 0 && descricaoP.length() > 0 && precof > 0) {
                try {
                    Presente presente = new Presente(categoriaP, descricaoP, precof);
                    ControladorPresente.getInstance().cadastrarPresente(presente);
                    sucesso.setContentText("Presente Cadastrado!");
                    sucesso.show();
                    descricao.clear();
                    categoria.clear();
                    preco.clear();
                } catch (PresenteExisteListaException e) {
                    erro.setContentText("Presente já existe");
                    erro.show();
                }
            } else {
                erro.setContentText("Campo de texto nulo!");
                erro.show();
            }
        } catch (NumberFormatException e) {
        erro.setContentText("Preço inválido");
        erro.show();
    }

    }
}
