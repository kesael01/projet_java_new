/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Set; 
/**
 *
 * @author sandrine
 */
public class Cours {
   private int idcours;
   /**
   * nombre d'heures de cours
   */
    private int heures;
   /**
   *  matiere
   */
    private String matiere;
    private Set<SessionsCours> sess=new HashSet<>();
    
    public Cours(int idcours, int heures, String matiere){
        this.idcours = idcours;
        this.heures = heures;
        this.matiere = matiere;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Set<SessionsCours> getSess() {
        return sess;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idcours;
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
        final Cours other = (Cours) obj;
        if (this.idcours != other.idcours) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cours{" + "idcours=" + idcours + ", heures=" + heures + ", matiere=" + matiere + ", sess=" + sess + '}';
    }

    
    
}
