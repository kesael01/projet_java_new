/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.util.Date;
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Set;

/**
 *
 * @author sandrine
 */
public class gestion {
    public static void main(String[] args) {
     Cours c= new Cours(05,05,"java");
     Local l=new Local(5,5,"abc","bien");
     Formateur f = new Formateur(10,10,"abd","dupont","jan","mons","mons","56897452");
     SessionsCours s=new SessionsCours(8,8,);
    }
    
}
