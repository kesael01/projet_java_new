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
    protected int idform,number;
    protected String matricule,nom,prenom,rue,localite,tel;

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

    @Override
    public String toString() {
        return "API_FORMATEUR1{" + "idform=" + idform + ", number=" + number + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", localite=" + localite + ", tel=" + tel + '}';
    }
    
    
}
