/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirepromarwen.services;

import hirepromarwen.entities.Offre;
import hirepromarwen.interfaces.ICRUD;
import hirepromarwen.utils.MyConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class OffreEmploiServiceImpl implements ICRUD<Offre>{

    @Override
    public void addEntity(Offre t) {
        String requete ="INSERT INTO offre(lieuT,descriptif,dateDebutOffre,dateFinOffre,typeEmploi,TypeLieuTravail,idUser,poste) VALUES "+"(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getLieuT());
            pst.setString(2, t.getDescriptif());
            pst.setDate(3, Date.valueOf(t.getDateDebutOffre()));
             pst.setDate(4, Date.valueOf(t.getDateFinOffre()));
            pst.setString(5, t.getTypeEmploi().toString());
            pst.setString(6, t.getTypeLieuTravail().toString());
            pst.setInt(7, t.getIdUser());
             pst.setInt(8, t.getPoste());
            pst.executeUpdate();
            System.out.println("offre added");
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }    }

    @Override
    public List<Offre> displayEntities() {
        List<Offre> myList = new ArrayList<>();
        try {
            String requete="SELECT*FROM offre";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =st.executeQuery(requete);
            while (rs.next()){
            Offre offre = new Offre();
            offre.setIdOffre(rs.getInt(1));
            offre.setLieuT(rs.getString("lieuT"));
            offre.setDescriptif(rs.getString("descriptif"));
            // offre.setDateDebutOffre(Date.valueOf(rs.getDate("date debut")));
           // offre.setDateDebutOffre(rs.getDate("date debut"));
           // offre.setDateFinOffre(rs.getDate("date fin"));
            offre.setIdUser(rs.getInt("idUser"));
            offre.setPoste(rs.getInt("poste"));

           
                
              myList.add(offre);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `offre` WHERE idOffre = " + id;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(req);
            System.out.println("OffreEmploi Deleted.. !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void modifier(Offre t) {
        try { //lieu,descriptif,dateDebutOffre,dateFinOffre,typeEmploi,typeLieuTravail,idUser,poste,question
        String req = "UPDATE offre SET lieu=?, descriptif=?, dateDebutOffre=?, dateFinOffre=?, typeEmploi=?, typeLieuTravail=?, idUser=?, poste=? WHERE idOffre=?";
        PreparedStatement st = MyConnection.getInstance().getCnx().prepareStatement(req);
            st.setString(1, t.getLieuT());
            st.setString(2, t.getDescriptif());
         //   st.setDate(3, t.getDateDebutOffre());
          //  st.setDate(4, t.getDateFinOffre());
            st.setString(5, t.getTypeEmploi().toString());
            st.setString(6, t.getTypeLieuTravail().toString());
            st.setInt(7, t.getIdUser());
            st.setInt(8, t.getPoste());
            st.setInt(9, t.getIdUser());
            st.executeUpdate();
        System.out.println("OffreEpmloi updated!");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
    
    
}
