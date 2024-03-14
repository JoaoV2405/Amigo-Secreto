package com.example.amigo_secreto.gui;
import com.example.amigo_secreto.exception.GrupoExisteException;
import com.example.amigo_secreto.negocio.*;
import com.example.amigo_secreto.negocio.beans.Grupo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CadastroGrupos implements Initializable {
    @FXML
    public TextField nome;
    @FXML
    public DatePicker data;
    String nomeG;
    LocalDate dataG;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void sorteioTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("Sorteio.fxml");

    }

    public void presentesTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("CadastroPresente.fxml");

    }

    public void pessoasTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("cadastroPessoas.fxml");

    }

    public void cancel(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("hello-view.fxml");
    }

    public void pessoasGrupo(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("AddPessoaGrupo.fxml");
    }

    public void salvar(MouseEvent mouseEvent) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText("");
        sucesso.setTitle("Sucesso!");
        erro.setHeaderText("");
        erro.setTitle("Erro");
        nomeG = nome.getText();
        dataG = data.getValue();
        if(nomeG.length()>0 && dataG!=null){
            try{
                Grupo g = new Grupo(nomeG, dataG);
                ControladorGrupo.getInstance().cadastrarGrupo(g);
                sucesso.setContentText("Grupo Cadastrado!");
                sucesso.show();
                nome.clear();
            } catch (GrupoExisteException e) {
                erro.setContentText("Já existe grupo com este nome!");
                erro.show();
            }
        }else{
            erro.setContentText("Campo nulo!");
            erro.show();
        }
    }
}
