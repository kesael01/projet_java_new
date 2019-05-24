/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formation.DAO;

/**
 *
 * @author sandrine
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.*;
import Formation.metier.API_SESSIONCOURS1;


public class API_SESSIONCOURS1DAO extends DAO<API_SESSIONCOURS1>{
    /**
     * création d'une session sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj session à créer
     * @return session créé
     */
    @Override
    public API_SESSIONCOURS1 create(API_SESSIONCOURS1 obj) throws SQLException {

        String req1 = "insert into API_SESSIONCOURS1(idsesscours,datedebut,datefin,nbreinscrits,idcours,idlocal) values(?,?,?,?,?,?)";
        String req2 = "select idsesscours from API_SESSIONCOURS1 where nbreinscrits=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getIdsesscours());
            pstm1.setInt(2, obj.getIdlocal());
            pstm1.setInt(3, obj.getIdcours());
            pstm1.setInt(4, obj.getNbreinscrits());
            pstm1.setTime(5, (Time) obj.getDatedebut());
            pstm1.setTime(6, (Time) obj.getDatefin());
            
            
             int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation session, aucune ligne créée");
            }
           
            pstm2.setInt(1, obj.getNbreinscrits());
          
            
            try (ResultSet rs = pstm2.executeQuery()) {
                
                if (rs.next()) {
                    int idsesscours = rs.getInt(1);
                   
                    obj.setIdsesscours(idsesscours);
                   
                    return read(idsesscours);
                    
                } else {
                   
                    throw new SQLException("erreur de création de la session, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données de la session sur base de son id
     *
     * @throws SQLException code inconnu
     * @param idsesscours identifiant de la session
     * @return session trouvé
     */
    @Override
    public API_SESSIONCOURS1 read(int idsesscours) throws SQLException {

        String req = "select * from API_SESSIONCOURS1 where idsesscours = ?";
       
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            
            pstm.setInt(1, idsesscours);
            
            try (ResultSet rs = pstm.executeQuery()) {
              
                if (rs.next()) {
                   
                    int idlocal = rs.getInt("idlocal");
                    int idcours = rs.getInt("idcours");
                    int nbreinscrits = rs.getInt("nbreinscrits");
                    
                    Date datedebut = rs.getDate("datedebut");
                    Date datefin = rs.getDate("datefin");
                    
                    
                    
                 
                    
                   
                    
                    return new API_SESSIONCOURS1(idsesscours,datedebut,datefin,nbreinscrits,idcours,idlocal);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }
    
     

    /**
     * mise à jour des données de la session sur base de son identifiant
     *
     * @return local
     * @param obj session à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public API_SESSIONCOURS1 update(API_SESSIONCOURS1 obj) throws SQLException {
        String req = "update API_SESSCOURS1 set nbreinscrits=? where idsesscours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
           
            pstm.setInt(2, obj.getIdsesscours());
            
            pstm.setInt(1, obj.getNbreinscrits());
            
            
            
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne local mise à jour");
            }
            return read(obj.getIdsesscours());
        }
    }

    /**
     * effacement dune session sur base de son id
     *
     * @throws SQLException erreur d'effacement
     * @param obj session à effacer
     */
    @Override
    public void delete(API_SESSIONCOURS1 obj) throws SQLException {

        String req = "delete from API_SESSIONCOURS where idsesscours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdsesscours());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne session effacée");
            }

        }
    }

    @Override
    public API_SESSIONCOURS1 read1(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public List<API_SESSIONCOURS1> affsesscours(int id) throws SQLException {
        List<API_SESSIONCOURS1> l = new ArrayList();
        String req = "select * from API_SESSIONCOURS1 where idcours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idsesscours = rs.getInt("idsesscours");
                    int idlocal = rs.getInt("IDlocal");
                    int idcours = rs.getInt("IDcours");
                    int nbreinscrits = rs.getInt("nbreinscrits");
                    Date datedebut = rs.getDate("datedebut");
                    Date datefin = rs.getDate("datefin");
                   
                    l.add(new API_SESSIONCOURS1(idsesscours,datedebut,datefin,nbreinscrits,idcours,idlocal));
                }
            }
        }
        return l;
    }
     
     public List<API_SESSIONCOURS1> rechNom(int id) throws SQLException {
        List<API_SESSIONCOURS1> plusieurs = new ArrayList<>();
        String req = "select * from API_SESSIONCOURS1 where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idsesscours = rs.getInt("idsesscours");
                    int idlocal = rs.getInt("idlocal");
                    int idcours = rs.getInt("idcours");
                    int nbreinscrits = rs.getInt("heures");
                    Date datedebut=rs.getDate("datedebut");
                    Date datefin = rs.getDate("datefin");
                
                    
                    plusieurs.add(new API_SESSIONCOURS1(idsesscours,datedebut,datefin,nbreinscrits,idcours,idlocal));
                }

                if (!trouve) {
                    throw new SQLException("id inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
    }


    

}

    

