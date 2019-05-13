
package Formation.metier;
/**
 * classe métier de gestion d'une session de cours
 * @author sandrine kemayou
 * @version 1.0
 * 
 */

import java.util.Date;


public class API_SESSIONCOURS1 {
   /**
   * identifiant unique de la session
   */
   protected int idsesscours;
   /**
   * local de la session
   */
   protected int idlocal;
   /**
   * identifiant unique du cours
   */
   protected int idcours;
   /**
   * nombre dinscrits
   */
   protected int nbreinscrits;
   /**
   * date debut
   */
   protected Date datedebut;
   /**
   * date fin
   */
    protected Date datefin;
    /**
   * constructeur par defaut
   */
    public API_SESSIONCOURS1(){
        
    }
    /**
   * constructeur parametré
   * @param idsesscours identifiant de la session
   * @param idlocal identifiant du local
   * @param idcours identifiant de cours
   * @param nbreinscrits nombre dinscrits
   * @param datedebut date de debut
   * @param datefin date de fin
   */

    public API_SESSIONCOURS1(int idsesscours, int idlocal, int idcours, int nbreinscrits, Date datedebut, Date datefin) {
        this.idsesscours = idsesscours;
        this.idlocal = idlocal;
        this.idcours = idcours;
        this.nbreinscrits = nbreinscrits;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }
    /**
    * getter idsession
    * @return idsesscours lidentifiant de la session
    */

    public int getIdsesscours() {
        return idsesscours;
    }
    /**
     * setter lidentifiant de la session
     * @param idsesscours lidentifiant de la session
     */

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }
    /**
    * getter idlocal
    * @return l'id du local
    */

    public int getIdlocal() {
        return idlocal;
    }
    /**
     * setter id  du local
     * @param idlocal l'id du local
     */

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }
    /**
    * getter id cours
    * @return L'id du cours
    */

    public int getIdcours() {
        return idcours;
    }
    /**
     * setter idcours
     * @param idcours l'id du cours
     */

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }
    /**
    * getter nbre dinscrits
    * @return nbreinscrits le nombre dinscrits
    */

    public int getNbreinscrits() {
        return nbreinscrits;
    }
    /**
     * setter nombre dinscrits
     * @param nbreinscrits
     */

    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }
    /**
    * getter datedebut
    * @return date de dbut
    */

    public Date getDatedebut() {
        return datedebut;
    }
    /**
     * setter date de debut
     * @param datedebut
     */

    public void setDatedebut(Date datedebut) {
      
      this.datedebut = datedebut;
    }
      /**
    * getter date de fin
    * @return datefin
    */

    public Date getDatefin() {
        return datefin;
    }
    /**
     * setter date de fin
     * @param datefin date de fin
     */

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
     /**
    * méthode toString
    * @return informations complètes
    */

    @Override
    public String toString() {
        return "API_SESSIONCOURS1{" + "idsesscours=" + idsesscours + ", idlocal=" + idlocal + ", idcours=" + idcours + ", nbreinscrits=" + nbreinscrits + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }
   
    
}
