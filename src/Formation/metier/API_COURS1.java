package Formation.metier;

/**
 *classe metier de gestion dun cours
 * @author sandrine kemayou
 * @version 1.0
 */
public class API_COURS1 {
   /**
   * identifiant unique du cours
   */
    protected int idcours;
   /**
   * nombre d'heures de cours
   */
    protected int heures;
   /**
   *  matiere
   */
    protected String matiere;
   /**
   *constructeur par defaut
   */
    public API_COURS1(){
        
    }
   /**
   * constructeur parametré
   *  @param idcours identifiant unique du cours, affecté par la base de données
   * @param heures nombres d'heures de cours
   * @param matiere nom de la matiere
   */

    public API_COURS1(int idcours, int heures, String matiere) {
        this.idcours = idcours;
        this.heures = heures;
        this.matiere = matiere;
    }
    /**
    * getter idcours
    * @return identifiant du cours
    */
    public int getIdcours() {
        return idcours;
    }
    /**
     * setter idcours
     * @param idcours identifiant du client
     */
    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }
    /**
    * getter heures
    * @return le nombre d'heures de cours
    */
    public int getHeures() {
        return heures;
    }
    /**
     * setter heures
     * @param heures nombre d'heures de cours
     */
    public void setHeures(int heures) {
        this.heures = heures;
    }
    /**
    * getter matiere
    * @return la matiere
    */
    public String getMatiere() {
        return matiere;
    }
    /**
     * setter matiere
     * @param matiere la matiere
     */
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    /**
    * méthode toString
    * @return informations complètes
    */
    @Override
    public String toString() {
        return "API_COURS1{" + "idcours=" + idcours + ", heures=" + heures + ", matiere=" + matiere + '}';
    }
    
    
}
