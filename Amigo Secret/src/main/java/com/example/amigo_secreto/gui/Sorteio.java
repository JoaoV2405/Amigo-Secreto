package com.example.amigo_secreto.gui;

import com.example.amigo_secreto.exception.*;
import com.example.amigo_secreto.negocio.*;
import com.example.amigo_secreto.negocio.beans.Grupo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sorteio implements Initializable {
    @FXML ComboBox grupoC;
    @FXML
    Button sortear;
    @FXML
    Button pessoas;
    @FXML
    Button grupos;
    @FXML
    Button presentes;
    @FXML
    Button consultaAmgSecreto;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grupoC.getItems().addAll(ControladorGrupo.getInstance().getGrupos());
    }


    @FXML
    public void sortear(ActionEvent event) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setHeaderText("");
        erro.setTitle("Erro");
        if((grupoC.getValue() !=null)){
            try {
                ControladorSorteio.getInstance().sorteio2((Grupo) grupoC.getValue());
                Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
                sucesso.setHeaderText("");
                sucesso.setTitle("Sucesso");
                sucesso.setContentText("Sorteio realizado com sucesso!");
                sucesso.show();

            } catch (DataMenorException dme) {
                erro.setContentText("Data do sorteio deve ser menor ou igual a data atual!");
                erro.show();
            } catch (JaSorteadoException e) {
                erro.setContentText("Grupo já Sorteado!");
                erro.show();
            }catch(ParticipantesInsuficientesException pi){
                erro.setContentText("Grupo deve ter mais de 2 participantes para realizar o sorteio");
                erro.show();
            }

        }else{
                erro.setContentText("Cadastre um grupo antes de sortear!");
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

    public void consultaAmgSecreto(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("ConsultaAmigoSecreto.fxml");

    }

    public void pessoasTela(MouseEvent mouseEvent) throws IOException {
        SceneCreator.launchScene("cadastroPessoas.fxml");

    }
}
