/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formation.metier;

/**
 *
 * @author sandrine
 */
public class API_FORMATEUR1 {
     /**
   * identifiant unique du formateur
   */
    protected int idform;
    /**
   * numero de la rue
   */
    protected int number;
    /**
   * matricule
   */
    protected String matricule;
    /**
   * nom du formateur
   */
    protected String nom;
    /**
   * prenom du formateur
   */
    protected String prenom;
    /**
   * rue
   */
    protected String rue;
    /**
   * localite
   */
    protected String localite;
    /**
   * numero de telephone
   */
    protected String tel;
  
    /**
   * constructeur non parametré
   */
    public API_FORMATEUR1(){
        
    }
    /**
   * constructeur parametré
   *  @param idform identifiant unique du formateur, affecté par la base de données
   * @param number numero
   * @param matricule matricle du formateur
   * @param nom nom du formateur
   * @param prenom du formateur
   * @param rue 
   * @param localite
   * @param tel telephone du formateur
   */
    
    public API_FORMATEUR1(int idform, int number, String matricule, String nom, String prenom, String rue, String localite, String tel) {
        this.idform = idform;
        this.number = number;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.localite = localite;
        this.tel = tel;
    }
    /**
     * getter identifiant
     * @return identifiant
     */
    public int getIdform() {
        return idform;
    }
    /**
     * setter idcours
     * @param idcours identifiant du client
     */

    public void setIdform(int idform) {
        this.idform = idform;
    }
    /**
     * getter numero
     * @return numero
     */
    public int getNumber() {
        return number;
    }
    /**
     * setter numero
     * @param numero dadresse du client
     */

    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * getter  matricule
     * @return  matricule
     */
    public String getMatricule() {
        return matricule;
    }
    /**
     * setter matricule
     * @param matricule du client
     */

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    /**
     * getter nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     * @param nom du client
     */

    public void setNom(String nom) {
        this.nom = nom;
    }
     /**
     * getter  prenom
     * @return  prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter prenom
     * @param prenom du client
     */

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
     /**
     * getter rue
     * @return rue
     */
    public String getRue() {
        return rue;
    }
    /**
     * setter rue
     * @param rue
     */

    public void setRue(String rue) {
        this.rue = rue;
    }
     /**
     * getter  localite
     * @return localite
     */
    public String getLocalite() {
        return localite;
    }
    /**
     * setter localite
     * @param localite 
     */

    public void setLocalite(String localite) {
        this.localite = localite;
    }
    /**
     * getter telephone
     * @return  telephone
     */
    public String getTel() {
        return tel;
    }
    /**
     * setter tel
     * @param tel telephone du client
     */

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "API_FORMATEUR1{" + "idform=" + idform + ", number=" + number + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", localite=" + localite + ", tel=" + tel + '}';
    }
    
    
}
