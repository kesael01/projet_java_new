/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;
import DesignPatterns.metier.*;
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Set; 

/**
 *
 * @author sandrine
 */
public class Infos {
    private int nh;
    private SessionsCours sess;
    private Formateur idform;
    
    public Infos (SessionsCours sess,Formateur idform){
        this.sess=sess;
        this.idform=idform;
    }

    public int getNh() {
        return nh;
    }

    public void setNh(int nh) {
        this.nh = nh;
    }

    public SessionsCours getSess() {
        return sess;
    }
      public Formateur getIdform() {
        return idform;
    }

    public void setIdform(Formateur idform) {
        this.idform = idform;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.sess);
        hash = 17 * hash + Objects.hashCode(this.idform);
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
        final Infos other = (Infos) obj;
        if (!Objects.equals(this.sess, other.sess)) {
            return false;
        }
        if (!Objects.equals(this.idform, other.idform)) {
            return false;
        }
        return true;
    }

  
    

    
    
}
