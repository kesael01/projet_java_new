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
public class API_LOCAL1 {
   /**
   * identifiant du local
   */
    protected int idlocal;
    /**
   * nombre de places
   */
    protected int places;
    /**
   * sigle du local
   */
    protected String sigle;
    /**
   * description du local
   */
    protected String description;

    /**
     * constructeur par défaut
     */ 
   
    public API_LOCAL1(){
        
    }
    /**
   * constructeur paramétré
   * @param idlocal identifiant unique du local
   * @param places nombre de places
   * @param sigle sigle du local
   * @param description description du local
   */

    public API_LOCAL1(int idlocal, int places, String sigle, String description) {
        this.idlocal = idlocal;
        this.places = places;
        this.sigle = sigle;
        this.description = description;
    }
/**
    * getter idlocal
    * @return identifiant du local
    */
    public int getIdlocal() {
        return idlocal;
    }
    /**
     * setter idlocal
     * @param idlocal lidentifiant du local
     */

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }
    /**
    * getter places
    * @return nombre de places
    */
    public int getPlaces() {
        return places;
    }
    /**
     * setter places
     * @param places du local
     */

    public void setPlaces(int places) {
        this.places = places;
    }
   /**
    * getter sigle
    * @return sigle du local
    */
    public String getSigle() {
        return sigle;
    }
    /**
     * setter sigle
     * @param sigle sigle du local
     */

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
    /**
    * getter description
    * @return description du local
    */
    public String getDescription() {
        return description;
    }
    /**
     * setter description
     * @param description description du loacl
     */

    public void setDescription(String description) {
        this.description = description;
    }
     /**
     * méthode toString
     * @return informations complètes
     */

    @Override
    public String toString() {
        return "API_LOCAL1{" + "idlocal=" + idlocal + ", places=" + places + ", sigle=" + sigle + ", description=" + description + '}';
    }
    
    
}
