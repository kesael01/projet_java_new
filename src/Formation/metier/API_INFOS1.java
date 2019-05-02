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
    protected int nh,idform,idsesscours;
     

    public API_INFOS1(int nh, int idform, int idsesscours) {
        this.nh = nh;
        this.idform = idform;
        this.idsesscours = idsesscours;
    }

    public int getNh() {
        return nh;
    }

    public void setNh(int nh) {
        this.nh = nh;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    @Override
    public String toString() {
        return "API_INFOS1{" + "nh=" + nh + ", idform=" + idform + ", idsesscours=" + idsesscours + '}';
    }
    
    
}
