package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.ParticipanteNaoExisteException;
import com.example.amigo_secreto.negocio.*;
import com.example.amigo_secreto.negocio.beans.Grupo;
import com.example.amigo_secreto.negocio.beans.Participante;
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

public class AddPessoaGrupo implements Initializable {
    @FXML
    ComboBox grupo;
    @FXML
    ListView<Participante> pessoasTotal;
    @FXML
    ListView<Participante> pessoasgp;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pessoasTotal.getItems().addAll(ControladorParticipante.getInstance().getparticipantes());
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

    public void gruposel(ActionEvent actionEvent) {
        Grupo gp = (Grupo) grupo.getSelectionModel().getSelectedItem();
        pessoasgp.getItems().clear();
        pessoasgp.getItems().addAll(gp.getIntegrante());
    }

    public void add(MouseEvent mouseEvent) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setHeaderText("");
        erro.setTitle("Erro");
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText("");
        sucesso.setTitle("Sucesso");
        Grupo gp = (Grupo) grupo.getSelectionModel().getSelectedItem();
        Participante p = pessoasTotal.getSelectionModel().getSelectedItem();
        if(gp != null) {
            if (pessoasgp.getItems().contains(p) || gp.getIntegrante().contains(p)) {
                erro.setContentText("Não pode adicionar o mesmo participante ao grupo!");
                erro.show();
            } else {
                if (p != null) {
                    if(!gp.isSorteado()){
                        gp.setSorteado(true);
                    }
                    pessoasgp.getItems().add(p);
                    try {
                        ControladorGrupo.getInstance().addPessoaGrupo(p, gp);
                        sucesso.setContentText("Pessoa adicionada com sucesso!");
                        sucesso.show();
                    } catch (ParticipanteExisteException e) {
                        erro.show();
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
        sucesso.setContentText("Participante deletado");
        Grupo gp = (Grupo) grupo.getSelectionModel().getSelectedItem();
        if(pessoasgp.getSelectionModel().getSelectedItem()!=null){
            Participante p = pessoasgp.getSelectionModel().getSelectedItem();
            if(!pessoasgp.getItems().contains(p)){
                erro.setContentText("Selecione um participante válido");
                erro.show();
            }else {
                if (gp != null && p != null) {
                    try {
                        ControladorGrupo.getInstance().delPessoaGrupo(p,gp);
                        sucesso.show();
                    } catch (ParticipanteNaoExisteException e) {
                        erro.setContentText("Participante não existe");
                        erro.show();
                    }
                    pessoasgp.getItems().remove(p);
                } else {
                    erro.setContentText("Campo nulo!");
                    erro.show();
                }
            }
        } else if (pessoasTotal.getSelectionModel().getSelectedItem()!=null) {
            Participante p = pessoasTotal.getSelectionModel().getSelectedItem();
            if (!pessoasTotal.getItems().contains(p)) {
                erro.setContentText("Selecione um participante válido");
                erro.show();
            } else {
                if (p != null) {
                    try {
                        for (int i = 0; i < ControladorGrupo.getInstance().getGrupos().size(); i++) {
                            Grupo g = ControladorGrupo.getInstance().getGrupos().get(i);

                            if(g.getIntegrante().contains(p)){
                                ControladorGrupo.getInstance().delPessoaGrupo(p,g);
                                pessoasgp.getItems().remove(p);
                            }
                        }

                        ControladorParticipante.getInstance().removerparticipante(p);
                    } catch (ParticipanteNaoExisteException e) {
                        erro.setContentText("Participante não Existe!");
                        erro.show();
                    }
                    sucesso.show();
                    pessoasTotal.getItems().remove(p);
                } else {
                    erro.setContentText("Campo nulo!");
                    erro.show();
                }
            }

        }
    }

    public void save(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Sucesso");
        alert.setContentText("Alterações salvas");
        alert.show();
        SceneCreator.launchScene("hello-view.fxml");
    }

    public void cancel(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("hello-view.fxml");

    }
}
