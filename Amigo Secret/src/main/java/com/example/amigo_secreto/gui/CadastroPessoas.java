package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.negocio.ControladorParticipante;
import com.example.amigo_secreto.negocio.beans.Participante;
import com.example.amigo_secreto.negocio.SceneCreator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroPessoas implements Initializable {
    @FXML
    public Button salvar;
    @FXML
    public TextField apelido;
    @FXML

    public PasswordField senha;
    @FXML
    public Button cancelar;
    @FXML
    public Button presentePessoas;
    @FXML
    public TextField nome;
    String apelidoP;
    String nomeP;
    String senhaP;

    public TextField getApelido() {
        return apelido;
    }

    public void setApelido(TextField apelido) {
        this.apelido = apelido;
    }

    public PasswordField getSenha() {
        return senha;
    }

    public void setSenha(PasswordField senha) {
        this.senha = senha;
    }

    public TextField getNome() {
        return nome;
    }

    public void setNome(TextField nome) {
        this.nome = nome;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void save(MouseEvent mouseEvent) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText("");
        sucesso.setTitle("Sucesso!");
        erro.setHeaderText("");
        erro.setTitle("Erro");
        senhaP = senha.getText();
        apelidoP = apelido.getText();
        nomeP = nome.getText();
        if (nomeP.length()>0 && apelidoP.length()>0 && senhaP.length()>0) {
            try {
                Participante p = new Participante(apelidoP, nomeP, senhaP);
                ControladorParticipante.getInstance().cadastrarparticipante(p);
                sucesso.setContentText("Participante Cadastrado!");
                sucesso.show();
                senha.clear();
                apelido.clear();
                nome.clear();
            } catch (ParticipanteExisteException e) {
                erro.setContentText("Já Existe Participante com esse apelido!");
                erro.show();
            }
        } else {
            erro.setContentText("Campo de texto nulo!");
            erro.show();
        }

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

    public void presentePessoa(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("PresentePessoa.fxml");
    }
    public void cancel(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("hello-view.fxml");    }
}


