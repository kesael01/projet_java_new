/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

/**
 *
 * @author sandrine
 */
public class Gestion1 {
     public static void main(String[] args)  {
        
        try {
            Formateur cl1 = new Formateur.FormateurBuilder().
                    setIdform(2).
                    setNom("Durant").
                    setPrenom("Eric").
                    setMatricule("ab456").
                    
                    build();
            System.out.println(cl1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
        
            try {
            Formateur cl2 = new Formateur.FormateurBuilder().
                    setIdform(1).
                    setNom("Durant").
                    setPrenom("Eric").
                  
                    build();
                System.out.println(cl2);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
        
    }
    
}
