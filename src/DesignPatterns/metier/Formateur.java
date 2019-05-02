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
public class Formateur {
    private int idform;
    private int number;
    private String matricule,nom,prenom,rue,localite,tel;
    private Set<Infos> info=new HashSet<>();
    
    public Formateur(int idform, int number, String matricule, String nom, String prenom, String rue, String localite, String tel) {
        this.idform = idform;
        this.number = number;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.localite = localite;
        this.tel = tel;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idform;
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
        final Formateur other = (Formateur) obj;
        if (this.idform != other.idform) {
            return false;
        }
        return true;
    }

   
    
}
