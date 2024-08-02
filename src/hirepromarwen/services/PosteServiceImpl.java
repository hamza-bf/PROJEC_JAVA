/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirepromarwen.services;

import hirepromarwen.entities.Poste;
import hirepromarwen.interfaces.ICRUD;
import hirepromarwen.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**REFRECH
 *
 * @author ASUS
 */
public class PosteServiceImpl implements ICRUD<Poste>{


    @Override
    public void addEntity(Poste poste) {
        String requete ="INSERT INTO poste(poste) VALUES "+"(?)";
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, poste.getPoste());
            pst.executeUpdate();
            System.out.println("Poste Added!!");
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        
    }  
    }

    @Override
    public List<Poste> displayEntities() {
      List<Poste> myList = new ArrayList<>();
        try {
            String requete="SELECT * FROM poste";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =st.executeQuery(requete);
            while (rs.next()){
            Poste poste = new Poste();
            poste.setIdP(rs.getInt(1));
            poste.setPoste(rs.getString("poste"));
       
              myList.add(poste);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    @Override
    public void supprimer(int id) {
             try {
            String req = "DELETE FROM `poste` WHERE idP = " + id;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(req);
            System.out.println("poste Deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Poste poste) {
       try {
        String req = "UPDATE poste SET poste=? WHERE idP=?";
        PreparedStatement st = MyConnection.getInstance().getCnx().prepareStatement(req);
        st.setString(1, poste.getPoste());
        st.setInt(2,poste.getIdP() ); 
        st.executeUpdate();
        System.out.println("poste Updated!");
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    
    }

 
}
     
    

