
package DesignPatterns.metier;
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Set; 
/**
 *
 * @author sandrine
 */
public class Local {
     private int idlocal,places;
    private String sigle,description;
    private Set<SessionsCours> session=new HashSet<>();
    /**
 * constructeur paramétré
 * @param idlocal identifiant unique du local
 * @param places nombre de places
 * @param sigle sigle du local
 * @param description description du local
 */
    public Local(int idlocal, int places, String sigle, String description){
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
    public Set<SessionsCours> getSession(){
        return session;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.sigle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Local other = (Local) obj;
        if (!Objects.equals(this.sigle, other.sigle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Local{" + "idlocal=" + idlocal + ", places=" + places + ", sigle=" + sigle + ", description=" + description + ", session=" + session + '}';
    }
    
}

