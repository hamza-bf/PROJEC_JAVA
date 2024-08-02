/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hirepromarwen.tests;

import hirepromarwen.entities.Offre;
import hirepromarwen.entities.Poste;
import hirepromarwen.enums.TypeEmploi;
import hirepromarwen.enums.TypeLieuTravail;
import hirepromarwen.services.OffreEmploiServiceImpl;
import hirepromarwen.services.PosteServiceImpl;
import hirepromarwen.utils.MyConnection;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class MainTest {
      public static void main (String[] args){
    MyConnection mc = new MyConnection();
    // Add and Display Poste  
       Poste p1 = new Poste("Software Engineer");
         PosteServiceImpl PS = new PosteServiceImpl();
          PS.addEntity(p1);
          System.out.println(PS.displayEntities());
    // Offre CRUD
     Offre o1 = new Offre ("Canada", "Ingénieur full stack avec des connaissances", LocalDate.of(2020, 5, 17),LocalDate.of(2021, 8, 31),TypeEmploi.TempsPlein,TypeLieuTravail.SurSite,1,1);
     Offre o2 = new Offre("Germany1"," Ingénieur full stack avec des connaissances",LocalDate.of(2020, 5, 17),LocalDate.of(2021, 8, 31),TypeEmploi.TempsPlein,TypeLieuTravail.SurSite,1,1);
         OffreEmploiServiceImpl OES = new OffreEmploiServiceImpl();
          OES.addEntity(o1);
          OES.addEntity(o2); 
         // OES.modifier(o2);
          //OES.supprimer(8);
          System.out.println(OES.displayEntities());
          


    
}
}