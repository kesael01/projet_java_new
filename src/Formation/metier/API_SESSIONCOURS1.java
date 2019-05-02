
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
   * identifiant unique du client
   */
   protected int idcours;
   protected int nbreinscrits;
   protected Date datedebut,datefin;

    public API_SESSIONCOURS1(int idsesscours, int idlocal, int idcours, int nbreinscrits, Date datedebut, Date datefin) {
        this.idsesscours = idsesscours;
        this.idlocal = idlocal;
        this.idcours = idcours;
        this.nbreinscrits = nbreinscrits;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public int getNbreinscrits() {
        return nbreinscrits;
    }

    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "API_SESSIONCOURS1{" + "idsesscours=" + idsesscours + ", idlocal=" + idlocal + ", idcours=" + idcours + ", nbreinscrits=" + nbreinscrits + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }
   
    
}
