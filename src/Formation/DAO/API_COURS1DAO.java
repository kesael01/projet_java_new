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
import java.util.*;
import Formation.metier.API_COURS1;


public class API_COURS1DAO extends DAO<API_COURS1>{
    /**
     * création d'un local sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj local à créer
     * @return local créé
     */
    @Override
    public API_COURS1 create(API_COURS1 obj) throws SQLException {

        String req1 = "insert into API_COURS1(MATIERE,HEURES) values(?,?)";
        String req2 = "select IDCOURS from API_COURS1 where HEURES=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatiere()); 
           //pstm1.setInt(1, obj.getIdcours());
            pstm1.setInt(2, obj.getHeures());
             int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation cours, aucune ligne créée");
            }
           
            pstm2.setInt(1, obj.getHeures());
          
            
            try (ResultSet rs = pstm2.executeQuery()) {
                
                if (rs.next()) {
                    int idcours = rs.getInt(1);
                   
                    obj.setIdcours(idcours);
                   
                    return read(idcours);
                    
                } else {
                   
                    throw new SQLException("erreur de création du cours, record introuvable");
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
    public API_COURS1 read(int idcours) throws SQLException {

        String req = "select * from API_COURS1 where idcours = ?";
       
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            
            pstm.setInt(1, idcours);
            
            try (ResultSet rs = pstm.executeQuery()) {
              
                if (rs.next()) {
                   
                    int heures = rs.getInt("heures");
                    
                    String matiere = rs.getString("matiere");
                 
                    
                   
                    
                    return new API_COURS1(idcours,matiere,heures);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }
    
     /** 
     * @param matiere
     * @return
     * @throws SQLException 
     */
     @Override
     public API_COURS1 read1(String matiere) throws SQLException {

     String req = "select * from API_COURS1 where matiere = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, matiere);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                   int idcours = rs.getInt("idcours");
                    int heures= rs.getInt("heures");
                    
                    
                     return new API_COURS1(idcours,matiere,heures);

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
    public API_COURS1 update(API_COURS1 obj) throws SQLException {
        String req = "update API_COURS1 set heures=? where matiere= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
           
            pstm.setString(2, obj.getMatiere());
            
            pstm.setInt(1, obj.getHeures());
            
            
            
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne local mise à jour");
            }
            return read1(obj.getMatiere());
        }
    }

    /**
     * effacement dun cours sur base de la matiere
     *
     * @throws SQLException erreur d'effacement
     * @param obj local à effacer
     */
    @Override
    public void delete(API_COURS1 obj) throws SQLException {

        String req = "delete from API_COURS1 where matiere= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getMatiere());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne cours effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous le cours portant un
     * certain id
     * @param id id du cours recherché
     * @return liste de cours
     * @throws SQLException cours inconnu
     */
    public List<API_COURS1> rechNom(int id) throws SQLException {
        List<API_COURS1> plusieurs = new ArrayList<>();
        String req = "select * from API_COURS1 where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idcours = rs.getInt("idcours");
                    int heures = rs.getInt("heures");
                    String matiere= rs.getString("matiere");
                
                    
                    plusieurs.add(new API_COURS1(idcours,matiere,heures));
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
     * méthode permettant de récupérer tous les cours portant une
     * certaine description
     * @param mat description partielle  du cours recherché
     * @return liste de cours
     * @throws SQLException cours inconnu
     */
    public List<API_COURS1> rechNom1(String mat) throws SQLException {
        List<API_COURS1> plusieurs = new ArrayList<>();
        String req = "select * from API_COURS1 where matiere like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+mat+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idcours = rs.getInt("idcours");
                    int heures = rs.getInt("heures");
                    String matiere= rs.getString("matiere");
                    
                    
                    plusieurs.add(new API_COURS1(idcours,matiere,heures));
                }

                if (!trouve) {
                    throw new SQLException("matiere  inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
    }


}

    

