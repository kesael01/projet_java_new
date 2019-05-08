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
    protected int idlocal,places;
    protected String sigle,description;
    /**
 * constructeur paramétré
 * @param idlocal identifiant unique du local
 * @param places nombre de places
 * @param sigle sigle du local
 * @param description description du local
 */

    public API_LOCAL1(){
        
    }
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

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "API_LOCAL1{" + "idlocal=" + idlocal + ", places=" + places + ", sigle=" + sigle + ", description=" + description + '}';
    }
    
    
}
