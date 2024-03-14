package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.negocio.*;
import com.example.amigo_secreto.negocio.beans.Grupo;
import com.example.amigo_secreto.negocio.beans.Participante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConsultaAmgSecreto implements Initializable {
    @FXML
    public ComboBox pessoa;
    @FXML
    public ComboBox grupo;
    @FXML
    public PasswordField senha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grupo.getItems().addAll(ControladorGrupo.getInstance().getGrupos());

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

    public void grupos(ActionEvent actionEvent) {
        Grupo gp = (Grupo)grupo.getSelectionModel().getSelectedItem();
        if(gp!=null){
            pessoa.getItems().clear();
            pessoa.getItems().addAll(gp.getIntegrante());
        }
    }

    public void pessoas(ActionEvent actionEvent) {
    }

    public void consultar(MouseEvent mouseEvent) {
        String senhaAutenticar = senha.getText();
        Participante p = (Participante) pessoa.getSelectionModel().getSelectedItem();
        Grupo g = (Grupo) grupo.getSelectionModel().getSelectedItem();
        if (p != null || g != null) {
            if (!g.isSorteado()) {
                if (p != null) {
                    if (senhaAutenticar.equals(p.getSenha())) {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Amigo Secreto");
                        alerta.setHeaderText("");
                        alerta.setContentText("O amigo  secreto de '" + p.getApelido() + "' " + "é '" + p.getAmigoSecreto() + "'");
                        alerta.show();
                    } else {
                        Alert erro = new Alert(Alert.AlertType.ERROR);
                        erro.setTitle("Erro");
                        erro.setHeaderText("");
                        erro.setContentText("Senha incorreta!");
                        erro.show();
                    }
                } else {
                    Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setTitle("Erro");
                    erro.setHeaderText("");
                    erro.setContentText("User nulo!");
                    erro.show();
                }
            } else {
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setTitle("Erro");
                erro.setHeaderText("");
                erro.setContentText("Sorteio não realizado neste grupo!");
                erro.show();
            }
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("");
            erro.setContentText("Selecione Grupo e Pessoa para consultar amigo secreto!");
            erro.show();
        }
    }
}
