/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues.PosteVue;

import hirepromarwen.entities.Poste;
import hirepromarwen.services.PosteServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddPosteController implements Initializable {

    @FXML
    private TextField tfPoste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddPosteController(ActionEvent event) {
        String poste = tfPoste.getText();

        Poste P = new Poste(poste);
        PosteServiceImpl Impl = new PosteServiceImpl();
        Impl.addEntity(P);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Poste Ajouté avec succes", ButtonType.OK);
        a.show();
        tfPoste.setText("");

    }

}

/*import Vues.PosteVue.PosteManagementController;
import hirepromarwen.entities.Poste;
import hirepromarwen.services.PosteServiceImpl;
import java.io.IOException;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 *//*
public class AddPosteController implements Initializable {
    
    @FXML
    private TextField tfPoste;

    /**
     * Initializes the controller class.
 *//*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML
    private void addPoste(ActionEvent event) throws IOException {
        if (tfPoste.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Poste invalide(s)", ButtonType.OK);
            a.showAndWait();
        } else {
            PosteServiceImpl sp = new PosteServiceImpl();
            //Poste p = new Poste(tfPoste.getText());
            //sp.addEntity(p);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Poste added !", ButtonType.OK);
            a.showAndWait();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PosteManagement.fxml"));
            Parent root = loader.load();
            tfPoste.getScene().setRoot(root);
            PosteManagementController apc = loader.getController();
            apc.setPoste(tfPoste.getText());
        }

    }

    
}*/
