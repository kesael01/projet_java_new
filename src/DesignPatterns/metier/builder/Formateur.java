/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

import DesignPatterns.metier.Infos;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sandrine
 */
public class Formateur {
    protected int idform;
    
    protected int number;
    
    protected String matricule;
    
    protected String nom;
    
    protected String prenom;
    protected String rue;
    protected String localite;
    protected String tel;
  
    protected Set<Infos> info=new HashSet<>();
    
    private Formateur(FormateurBuilder cb) {
        this.idform = cb.idform;
        this.number=cb.number;
        this.matricule=cb.matricule;
        this.nom = cb.nom;
        this.prenom = cb.prenom;
        this.rue = cb.rue;
        this.localite = cb.localite;
        this.tel = cb.tel;
       
    }

    public int getIdform() {
        return idform;
    }

    public int getNumber() {
        return number;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRue() {
        return rue;
    }

    public String getLocalite() {
        return localite;
    }

    public String getTel() {
        return tel;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idform;
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

    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", number=" + number + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", localite=" + localite + ", tel=" + tel + ", info=" + info + '}';
    }
    

    public static class FormateurBuilder {

        private int idform;
        private int number;
        private String matricule;
        private String nom;
        private String prenom;
        private String rue;
        private String localite;
        private String tel;

        public FormateurBuilder setIdform(int idform) {
            this.idform=idform;
            return this;
        }
        public FormateurBuilder setNumber(int number){
            this.number=number;
            return this;
        }

        public FormateurBuilder setMatricule(String matricule) {
            this.matricule=matricule;
            return this;
        }

        public FormateurBuilder setNom(String nom) {
            this.nom=nom;
            return this;
        }

        public FormateurBuilder setPrenom(String prenom) {
            this.prenom=prenom;
            return this;
        }

        public FormateurBuilder setRue(String rue) {
            this.rue=rue;
           return this;
        }

        public FormateurBuilder setLocalite(String localite) {
            this.localite=localite;
              return this;
        }

        public FormateurBuilder setTel(String tel) {
            this.tel=tel;
            return this;
        }
        
        

        public Formateur build() throws Exception {
            if(idform<=0|| nom==null|| prenom==null || matricule==null ) throw new Exception("informations de construction incomplètes");
            return new Formateur(this);
            
        }
    }
}
