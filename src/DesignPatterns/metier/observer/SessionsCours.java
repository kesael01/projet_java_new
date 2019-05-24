/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;

import DesignPatterns.metier.*;
import java.util.Date;
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Set;

/**
 *
 * @author sandrine
 */
public class SessionsCours extends Subject {
   private int idsesscours;
    private int nbreinscrits;
   private Date datedebut,datefin;
    private Set<Infos> info=new HashSet<>();
    private Local sigle;
    private Cours cours;
    
    /*public SessionsCours(Local sigle,Cours cours){
        this.sigle=sigle;
        this.cours=cours;
        
    }*/
    public SessionsCours(int idsesscours, int nbreinscrits, Date datedebut, Date datefin)
    {
        this.idsesscours = idsesscours;
        
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

    public Set<Infos> getInfo() {
        return info;
    }

  

    public Local getSigle() {
        return sigle;
    }

    public void setSigle(Local sigle) {
        this.sigle = sigle;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.sigle);
        hash = 53 * hash + Objects.hashCode(this.cours);
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
        final SessionsCours other = (SessionsCours) obj;
        if (!Objects.equals(this.sigle, other.sigle)) {
            return false;
        }
        if (!Objects.equals(this.cours, other.cours)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessionsCours{" + "idsesscours=" + idsesscours + ", nbreinscrits=" + nbreinscrits + ", datedebut=" + datedebut + ", datefin=" + datefin + ", info=" + info + ", sigle=" + sigle + ", cours=" + cours + '}';
    }
    
     @Override
    public String getNotification() {
        return "nouveau local de "+idsesscours+" = "+sigle;
    }
    
    
}
