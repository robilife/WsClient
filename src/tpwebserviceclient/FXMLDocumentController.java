/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpwebserviceclient;

import Utils.Utils;
import com.robilife.service.Personne;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author khk
 */
public class FXMLDocumentController implements Initializable {
    
    private static final String ERRORECHEC = "Echec de l'opération, une erreur est survenue";
    private static final String ECHEC = "Echec de l'opération";
    private static final String ERROR = "Error";
    private static final String SUCCESS = "Succès";
    private static final String OPERATIONSUCCESS = "Opération effectuée avec succès";
    
    @FXML
    private TextField tbxNom;

    @FXML
    private TextField tbxPrenom;

    @FXML
    private Button btnAjout;

    @FXML
    private Button btnActualiser;

    @FXML
    private TableView<Personne> tvListPersonne;

    @FXML
    private TableColumn<Personne, String> tcNom;

    @FXML
    private TableColumn<Personne, String> tcPrenom;

    @FXML
    private TableColumn<Personne, String> tcTelephone;

    @FXML
    private TableColumn<Personne, String> tcAdresse;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    private ObservableList<Personne> listPersonne;
    
    private boolean validateFields() {
        return !tbxNom.getText().equals("")
                && !tbxPrenom.getText().equals("");
    }

    private void alertError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void alertInformation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        tbxNom.setText("");
        tbxPrenom.setText("");
    }

    private void cellValueFactory() {
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    }
    
    private void loadData() {
        listPersonne = FXCollections.observableArrayList();
        Utils utils = new Utils();
        listPersonne.addAll(utils.getPersonneService().personneList());
        tvListPersonne.setItems(listPersonne);
    }

    public void activer() {
        btnAjout.setDisable(false);
        btnActualiser.setDisable(true);
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
    }

    public void desactiver() {
        btnAjout.setDisable(true);
        btnActualiser.setDisable(false);
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    }
    
    private void refreshTableView() {
        cellValueFactory();
        loadData();
    }
    
    @FXML
    void getPersonne(MouseEvent event) {
        Personne personne = tvListPersonne.getSelectionModel().getSelectedItem();
        tbxPrenom.setText(personne.getPrenom());
        tbxNom.setText(personne.getNom());
        desactiver();
    }
    
    @FXML
    void actualiseInfo(ActionEvent event) {
        activer();
        refreshTableView();
        clearFields();
    }
    
    @FXML
    void addPersonne(ActionEvent event) {
        try {
            if (validateFields()) {
                Personne personne = new Personne();
                personne.setNom(tbxNom.getText());
                personne.setPrenom(tbxPrenom.getText());
                Utils utils = new Utils();
                if (utils.getPersonneService().addPersonne(personne)) {
                    alertInformation(SUCCESS, OPERATIONSUCCESS);
                    clearFields();
                    refreshTableView();
                } else {
                    alertError(ERROR, ECHEC);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError(ERROR, ERRORECHEC);
        }
    }
    
    @FXML
    void deletePersonne(ActionEvent event) {
        try {
            desactiver();
            Utils utils = new Utils();
            Personne personne = tvListPersonne.getSelectionModel().getSelectedItem();
            if (utils.getPersonneService().deletePersonne( new Long(personne.getId()))) {
                alertInformation(SUCCESS, OPERATIONSUCCESS);
                refreshTableView();
                clearFields();
            } else {
                alertError(ERROR, ECHEC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError(ERROR, ERRORECHEC);
        }
    }
    
    @FXML
    void updatePersonne(ActionEvent event) {
        try {
            desactiver();
            Utils utils = new Utils();
            Personne personne = tvListPersonne.getSelectionModel().getSelectedItem();
            personne.setPrenom(tbxPrenom.getText());
            personne.setNom(tbxNom.getText());
            if (utils.getPersonneService().updatePersonne( new Long(personne.getId()), personne)) {
                alertInformation(SUCCESS, OPERATIONSUCCESS);
                refreshTableView();
                clearFields();
            } else {
                alertError(ERROR, ECHEC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError(ERROR, ERRORECHEC);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            activer();
            cellValueFactory();
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
}
