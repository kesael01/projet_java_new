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
public class API_INFOS1 {
    /**
   * nombre dheures
   */
    protected int nh;
     /**
   * identifiant  du formateur
   */
    protected int idform;
     /**
   * identifiant de la session
   */
    protected int idsesscours;
     

    /**
     * constructeur par défaut
     */
    public API_INFOS1(){
        
    }
    
    /**
     * constructeur parrametré
     * @param nh nombre dheures
     * @param idform identifaiant du formateur
     * @param idsesscours identifiant de la session
     */
    public API_INFOS1(int nh, int idform, int idsesscours) {
        this.nh = nh;
        this.idform = idform;
        this.idsesscours = idsesscours;
    }
    /**
     * getter nombre dheures
     * @return nh
     */

    public int getNh() {
        return nh;
    }
    /**
     * setter nombre dheures
     * @param nh nombre dheures
     */

    public void setNh(int nh) {
        this.nh = nh;
    }
    /**
     * getter idform
     * @return idform
     */

    public int getIdform() {
        return idform;
    }
    /**
     * setter identifiant du formateur
     * @param idform
     */

    public void setIdform(int idform) {
        this.idform = idform;
    }
    /**
     * getter idsesscours
     * @return idsesscours
     */

    public int getIdsesscours() {
        return idsesscours;
    }
    /**
     * setter session de cours
     * @param idsesscours session de cours
     */

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }
      /**
     * méthode toString
     * @return informations complètes
     */

    @Override
    public String toString() {
        return "API_INFOS1{" + "nh=" + nh + ", idform=" + idform + ", idsesscours=" + idsesscours + '}';
    }
    
    
}
