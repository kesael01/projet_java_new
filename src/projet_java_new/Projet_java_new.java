/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java_new;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import Formation.DAO.API_SESSIONCOURS1DAO;
import Formation.DAO.API_COURS1DAO;
import Formation.DAO.DAO;
import Formation.metier.API_SESSIONCOURS1;
import Formation.metier.API_COURS1;
import Myconnections.DBConnection;
/**
 *
 * @author sandrine
 */
public class Projet_java_new {

    Scanner sc = new Scanner(System.in);
    //Instanciation de la variable globale vt de la classe 
    API_SESSIONCOURS1 session = null;
    API_COURS1 cours = null;
    //Instanciation de la variable globale tx de la classe DAO
    DAO<API_SESSIONCOURS1> sess = null;
    DAO<API_COURS1> crs = null;
//Constructeur par défaut 

    public Projet_java_new() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        crs = new API_COURS1DAO();
        crs.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.nouveau cours \n2.recherche sur base de lidentifiant\n3.recherche sur base de nom de la matiere\n4.modification\n5.suppression\n6.affichage des cours\n7.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    nouveau();
                    break;
                case 2:
                recherche();
                    break;
                case 3:
                   rechnom1();
                    break;
                case 4:
                    modif();
                    break;
                case 5:
                    sup();
                    break;
                
                case 7:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 7);
        DBConnection.closeConnection();
    }

    public void nouveau() {

        System.out.print("matiere :");
        String matiere = sc.nextLine();
        System.out.print("heures :");
        int heures= sc.nextInt();
         sc.skip("\n");
        
        cours = new API_COURS1(matiere, heures);
        try {
            cours = crs.create(cours);
            System.out.println("cours actuel : " + cours);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void recherche() {
        try {
            System.out.println("id recherché :");
            int nc = sc.nextInt();
            cours= crs.read(nc);
          
                    /*try {
                    List<API_SESSIONCOURS1> alc = ((API_SESSIONCOURS1DAO) sess).rechNom(nc);
                            for (API_SESSIONCOURS1 cl : alc) {
                                System.out.println(cl);
                            }
                        } catch (SQLException e) {
                            System.out.println("erreur " + e.getMessage());
                        }*/

            //System.out.println("cours actuel : " + cours);
            System.out.println("session " + session);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modif() {
        try {
            System.out.println("identifiant :");
            int id = sc.nextInt();
          
             cours=crs.read(id);
              System.out.println(cours);
                 /*try {
                    List<API_SESSIONCOURS1> alc = ((API_SESSIONCOURS1DAO) sess).rechNom(id);
                            for (API_SESSIONCOURS1 cl : alc) {
                                System.out.println(cl);
                            }
                        } catch (SQLException e) {
                            System.out.println("erreur " + e.getMessage());
                        }*/
          
            System.out.println("nombre d'heures ");
            int nbre=sc.nextInt();
          
             cours.setHeures(nbre);
             
           crs.update(cours);
            System.out.println(crs.read(id));
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void sup() {
        try {
            System.out.println("id :");
            int id = sc.nextInt();
             cours=crs.read(id);
              System.out.println(cours);
            crs.delete(cours);
            System.out.println("ligne supprime");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

   
    
    public void rechnom1() {
        System.out.println("matiere : ");
        String matiere = sc.nextLine();
        try {
            List<API_COURS1> alc = ((API_COURS1DAO) crs).rechNom1(matiere);
            for (API_COURS1 cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechnom2(int id) {
        
        try {
            List<API_SESSIONCOURS1> l = ((API_SESSIONCOURS1DAO) sess).rechNom(id);
            for (API_SESSIONCOURS1 cl : l) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    
    }
   

    
    public static void main(String[] args) {
        // TODO code application logic here
        Projet_java_new gc = new  Projet_java_new();
        gc.gestion();
    }
    
}
