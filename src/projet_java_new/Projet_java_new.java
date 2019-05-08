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
import Formation.DAO.API_LOCAL1DAO;
import Formation.DAO.DAO;
import Formation.metier.API_LOCAL1;
import Myconnections.DBConnection;
/**
 *
 * @author sandrine
 */
public class Projet_java_new {

    /**
     * @param args the command line arguments
     */
    

    Scanner sc = new Scanner(System.in);
    API_LOCAL1 loActuel = null;
    DAO<API_LOCAL1> API_LOCAL1DAO = null;

    public Projet_java_new() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        API_LOCAL1DAO = new API_LOCAL1DAO();
        API_LOCAL1DAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.nouveau \n2.recherche sur base de sigle\n3.recherche sur description1\n4.modification\n5.suppression\n6.fin");
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
                
                case 6:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 7);
        DBConnection.closeConnection();
    }

    public void nouveau() {

        System.out.print("sigle :");
        String sigle= sc.nextLine();
        System.out.print("description :");
        String description = sc.nextLine();
        System.out.print("places:");
        int places = sc.nextInt();
        sc.skip("\n");
        
        loActuel = new API_LOCAL1(0, places,sigle,description);
        try {
            loActuel = API_LOCAL1DAO.create(loActuel);
            System.out.println("local actuel : " + loActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void recherche() {
        try {
            System.out.println("sigle recherché :");
            String nc = sc.nextLine();
            loActuel = API_LOCAL1DAO.read1(nc);
            System.out.println("local actuel : " + loActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modif() {
        try {
            System.out.println("sigle :");
            String sigle = sc.nextLine();
           
            System.out.println("nombre de places ");
            int place=sc.nextInt();
             loActuel.setSigle(sigle);
             loActuel.setPlaces(place);
           API_LOCAL1DAO.update(loActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void sup() {
        try {
            System.out.println("sigle :");
            String sigle = sc.nextLine();
            API_LOCAL1DAO.delete(loActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

   
    
    public void rechnom1() {
        System.out.println("description : ");
        String description = sc.nextLine();
        try {
            List<API_LOCAL1> alc = ((API_LOCAL1DAO) API_LOCAL1DAO).rechNom1(description);
            for (API_LOCAL1 cl : alc) {
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
