package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.exception.PresenteExisteException;
import com.example.amigo_secreto.exception.PresenteNaoExisteException;
import com.example.amigo_secreto.negocio.*;
import com.example.amigo_secreto.negocio.beans.Participante;
import com.example.amigo_secreto.negocio.beans.Presente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PresentePessoa implements Initializable {
    @FXML
    public ComboBox pessoa;
    @FXML
    public ListView<Presente> todos;
    @FXML
    public ListView<Presente> presentePessoa;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pessoa.getItems().addAll(ControladorParticipante.getInstance().getparticipantes());
        todos.getItems().addAll(ControladorPresente.getInstance().getPresentes());
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

    public void salvar(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Sucesso");
        alert.setContentText("Alterações salvas");
        alert.show();
        SceneCreator.launchScene("hello-view.fxml");
    }
    public void pessoasel(ActionEvent actionEvent) {
        Participante p = (Participante) pessoa.getSelectionModel().getSelectedItem();
        presentePessoa.getItems().clear();
        presentePessoa.getItems().addAll(p.getPresente());
    }

    public void add(MouseEvent mouseEvent) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setHeaderText("");
        erro.setTitle("Erro");
        Participante p = (Participante) pessoa.getSelectionModel().getSelectedItem();
        Presente presente = todos.getSelectionModel().getSelectedItem();
        if (p != null) {
            if (presentePessoa.getItems().contains(presente) || p.getPresente().contains(presente)) {
                erro.setContentText("Presente já adicionado na lista do participante!");
                erro.show();
            } else {
                if (presente != null) {
                    presentePessoa.getItems().add(presente);
                    try {
                        ControladorParticipante.getInstance().cadastrarPresente(p, presente);
                    } catch (PresenteExisteException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    erro.setContentText("Campo nulo!");
                    erro.show();
                }
            }

        }
    }


    public void del(MouseEvent mouseEvent) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        erro.setHeaderText("");
        erro.setTitle("Erro");
        sucesso.setHeaderText("");
        sucesso.setTitle("Sucesso");
        sucesso.setContentText("Presente deletado");
        Participante p = (Participante) pessoa.getSelectionModel().getSelectedItem();

        if(presentePessoa.getSelectionModel().getSelectedItem()!=null) {
            Presente presente = presentePessoa.getSelectionModel().getSelectedItem();
            if (!presentePessoa.getItems().contains(presente)) {
                erro.setContentText("Selecione um presente válido");
                erro.show();
            } else {
                if (p != null && presente != null) {
                    try {
                        ControladorParticipante.getInstance().delPresentePessoa(p, presente);
                        sucesso.show();
                    } catch (PresenteNaoExisteException e) {
                        erro.show();
                    }
                    presentePessoa.getItems().remove(presente);
                } else {
                    erro.setContentText("Campo nulo!");
                    erro.show();
                }
            }
        } else if (todos.getSelectionModel().getSelectedItem()!=null) {
            Presente presente = todos.getSelectionModel().getSelectedItem();
            if (!todos.getItems().contains(presente)) {
                erro.setContentText("Selecione um presente válido");
                erro.show();
            } else {
                if (presente != null) {
                    try {
                        for (int i = 0; i < ControladorParticipante.getInstance().getparticipantes().size(); i++) {
                            Participante pessoa = ControladorParticipante.getInstance().getparticipantes().get(i);
                            if(pessoa.getPresente().contains(presente)){
                                ControladorParticipante.getInstance().delPresentePessoa(pessoa, presente);
                                presentePessoa.getItems().remove(presente);
                            }
                        }
                        ControladorPresente.getInstance().delPresente(presente);
                        sucesso.show();
                    } catch (PresenteNaoExisteException e) {
                        erro.show();
                    }
                    todos.getItems().remove(presente);
                } else {
                    erro.setContentText("Campo nulo!");
                    erro.show();
                }
            }
        }
    }

    public void todosLista(MouseEvent mouseEvent) {
    }
}
