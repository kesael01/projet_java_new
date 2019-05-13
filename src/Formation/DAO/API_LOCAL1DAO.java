/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formation.DAO;

/**
 *
 * @author sandrine KEMAYOU
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import Formation.metier.API_LOCAL1;

public class API_LOCAL1DAO extends DAO<API_LOCAL1> {
    
   
    /**
     * création d'un local sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj local à créer
     * @return local créé
     */
    @Override
    public API_LOCAL1 create(API_LOCAL1 obj) throws SQLException {

        String req1 = "insert into API_LOCAL1(places,sigle,description) values(?,?,?)";
        String req2 = "select idlocal from API_LOCAL1 where sigle=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getPlaces());
            pstm1.setString(2, obj.getSigle());
            pstm1.setString(3, obj.getDescription());
             int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation local, aucune ligne créée");
            }
           
            pstm2.setString(1, obj.getSigle());
          
            
            try (ResultSet rs = pstm2.executeQuery()) {
                
                if (rs.next()) {
                    int idlocal = rs.getInt(1);
                   
                    obj.setIdlocal(idlocal);
                   
                    return read(idlocal);
                    
                } else {
                   
                    throw new SQLException("erreur de création du local, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données dU LOCAL sur base de son SIGLE
     *
     * @throws SQLException code inconnu
     * @param idlocal identifiant du local
     * @return LOCAL trouvé
     */
    @Override
    public API_LOCAL1 read(int idlocal) throws SQLException {

        String req = "select * from API_LOCAL1 where idlocal = ?";
       
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            
            pstm.setInt(1, idlocal);
            
            try (ResultSet rs = pstm.executeQuery()) {
              
                if (rs.next()) {
                   
                    String sigle = rs.getString("sigle");
                    
                    String description = rs.getString("description");
                 
                    int places = rs.getInt("places");
                   
                    
                    return new API_LOCAL1(idlocal,places,sigle,description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }
    
     /** 
     * @param sigle
     * @return
     * @throws SQLException 
     */
     @Override
     public API_LOCAL1 read1(String sigle) throws SQLException {

        String req = "select * from API_LOCAL1 where sigle = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, sigle);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                   int idlocal = rs.getInt("idlocal");
                    String description = rs.getString("description");
                    int places = rs.getInt("places");
                    
                    return new API_LOCAL1(idlocal,places,sigle,description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du client sur base de son identifiant
     *
     * @return local
     * @param obj local à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public API_LOCAL1 update(API_LOCAL1 obj) throws SQLException {
        String req = "update API_LOCAL1 set places=? where sigle= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
           
            pstm.setString(2, obj.getSigle());
            
            pstm.setInt(1, obj.getPlaces());
            
            
            
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne local mise à jour");
            }
            return read1(obj.getSigle());
        }
    }

    /**
     * effacement dun local sur base de son sigle
     *
     * @throws SQLException erreur d'effacement
     * @param obj local à effacer
     */
    @Override
    public void delete(API_LOCAL1 obj) throws SQLException {

        String req = "delete from API_LOCAL1 where sigle= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getSigle());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne client effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les locaux portant un
     * certain nom
     * @param nomrech nom du local recherché
     * @return liste de locaux
     * @throws SQLException local inconnu
     */
    public List<API_LOCAL1> rechNom(String nomrech) throws SQLException {
        List<API_LOCAL1> plusieurs = new ArrayList<>();
        String req = "select * from API_LOCAL1 where sigle = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, nomrech);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idlocal = rs.getInt("IDlocal");
                    int places = rs.getInt("places");
                    String sigle= rs.getString("sigle");
                    String description = rs.getString("description");
                    
                    plusieurs.add(new API_LOCAL1(idlocal,places,sigle,description));
                }

                if (!trouve) {
                    throw new SQLException("sigle inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
    }
    /**
     * méthode permettant de récupérer tous les locaux portant une
     * certaine description
     * @param descr description partielle  du local recherché
     * @return liste de locaux
     * @throws SQLException local inconnu
     */
    public List<API_LOCAL1> rechNom1(String descr) throws SQLException {
        List<API_LOCAL1> plusieurs = new ArrayList<>();
        String req = "select * from API_LOCAL1 where description like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+descr+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idlocal = rs.getInt("IDlocal");
                    int places = rs.getInt("places");
                    String sigle= rs.getString("sigle");
                    String description = rs.getString("description");
                    
                    plusieurs.add(new API_LOCAL1(idlocal,places,sigle,description));
                }

                if (!trouve) {
                    throw new SQLException("description inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
    }


}
