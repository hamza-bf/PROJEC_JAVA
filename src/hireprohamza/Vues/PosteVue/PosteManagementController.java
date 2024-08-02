/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hireprohamza.Vues.PosteVue;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import hireprohamza.entities.Poste;
import hireprohamza.utils.MyConnection;

import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PosteManagementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<?>POSTETABLE;
    @FXML
    private TableColumn<Poste, String>idPosteColumn;
    @FXML
    private TableColumn<Poste, String>PosteNameColumn;
    
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Poste poste = null ;
    
    ObservableList<Poste>  PosteList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadDate();
    } 
     public void setPoste(String poste){
      //  lblPoste.setText(poste);
    }
    


    
    @FXML
    private void close (MouseEvent event){
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        
    }
    @FXML
    private void getADDView (MouseEvent event){
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Vues/addPoste.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PosteManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void refreshTable (){
         try {
            PosteList.clear();
            
            query = "SELECT * FROM `poste`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                PosteList.add(new  Poste(
                        resultSet.getInt("idP"),
                        resultSet.getString("poste")));
                //POSTETABLE.setItems(PosteList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PosteManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void LoadDate() {
        
        connection = MyConnection.getInstance().getCnx();
        refreshTable();

        idPosteColumn.setCellValueFactory(new PropertyValueFactory<>("idP"));
        PosteNameColumn.setCellValueFactory(new PropertyValueFactory<>("poste"));

        
        
         
    }
}
    


