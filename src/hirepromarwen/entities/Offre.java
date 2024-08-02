/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirepromarwen.entities;

import hirepromarwen.enums.TypeLieuTravail;
import hirepromarwen.enums.TypeEmploi;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Offre {
    private int idOffre;
    private String lieuT;
    private String descriptif;
    private LocalDate dateDebutOffre;
    private LocalDate dateFinOffre;
    private TypeEmploi typeEmploi;
    private TypeLieuTravail typeLieuTravail;
    private int idUser;
    private int poste;
    
    public Offre() {
    }

    public Offre( String lieuT, String descriptif, LocalDate dateDebutOffre, LocalDate dateFinOffre, TypeEmploi typeEmploi, TypeLieuTravail typeLieuTravail, int idUser, int poste) {
      
        this.lieuT = lieuT;
        this.descriptif = descriptif;
        this.dateDebutOffre = dateDebutOffre;
        this.dateFinOffre = dateFinOffre;
        this.typeEmploi= typeEmploi;
        this.typeLieuTravail = typeLieuTravail;
        this.idUser = idUser;
        this.poste = poste;
    }

    public String getLieuT() {
        return lieuT;
    }

    public LocalDate getDateDebutOffre() {
        return dateDebutOffre;
    }

    public LocalDate getDateFinOffre() {
        return dateFinOffre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getPoste() {
        return poste;
    }

 

  public TypeEmploi getTypeEmploi(){
      
      return typeEmploi;
  }

    public TypeLieuTravail getTypeLieuTravail() {
        return typeLieuTravail;
    }

    public void setDateDebutOffre(LocalDate dateDebutOffre) {
        this.dateDebutOffre = dateDebutOffre;
    }

    public void setDateFinOffre(LocalDate dateFinOffre) {
        this.dateFinOffre = dateFinOffre;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLieuT(String lieuT) {
        this.lieuT = lieuT;
    }

    public void setPoste(int poste) {
        this.poste = poste;
    }



    public void setTyepTravail(TypeEmploi typeEmploi) {
        this.typeEmploi = typeEmploi;
    }

    public void setTypeLieuTravail(TypeLieuTravail typeLieuTravail) {
        this.typeLieuTravail = typeLieuTravail;
    }

    @Override
    public String toString() {
        return "Offre{" + "idOffre=" + idOffre + ", lieuT=" + lieuT + ", descriptif=" + descriptif + ", dateDebutOffre=" + dateDebutOffre + ","
                + " dateFinOffre=" + dateFinOffre + ", typeEmploi=" + typeEmploi + ", typeLieuTravail=" + typeLieuTravail + ", idUser=" + idUser + 
                ", poste=" + poste + '}';
    }
}
