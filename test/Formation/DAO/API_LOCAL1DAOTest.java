/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formation.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import Formation.metier.API_LOCAL1;
import Myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sandrine
 */
public class API_LOCAL1DAOTest {
      static Connection dbConnect;
    public API_LOCAL1DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         dbConnect = Myconnections.DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
        
          
    }
    
    @AfterClass
    public static void tearDownClass() {
         Myconnections.DBConnection.closeConnection();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class API_LOCAL1tDAO.
     */
     @Test
    public void testCreate() throws Exception {
        System.out.println("create");
       
        API_LOCAL1 obj = new API_LOCAL1(0,5,"TestSigle","TestDescription");
       API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        API_LOCAL1 expResult = new API_LOCAL1(0,10,"TestSigle","TestDescription");
        API_LOCAL1 result = instance.create(obj);
        
        assertEquals("sigles différents",expResult.getSigle(), result.getSigle());
        
        //etc
        assertNotEquals("id non généré",expResult.getIdlocal(),result.getIdlocal());
        int idlocal=result.getIdlocal();
        obj=new API_LOCAL1(0,10,"TestSigle2","TestDescription2");
        try{
            API_LOCAL1 result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        }
        catch(SQLException e){}
        instance.delete(result);
        
          obj=new API_LOCAL1(0,15,"TestSigle3","TestDescription3");
        try{
            API_LOCAL1 result3 = instance.create(obj);
            fail("exception de code postal non déclenchée");
            instance.delete(result3);
        }
        catch(SQLException e){}  
       
    }

    /**
     * Test of read method, of class API_LOCAL1tDAO.
     */
    @Test
    public void testRead1() throws Exception {
        System.out.println("read1");
       String sigle = "testSigle";
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        API_LOCAL1 expResult = new API_LOCAL1(63,5,"TestSigle","TestDescription");
        //API_LOCAL1 expResult = instance.create(obj);
       // sigle=expResult.getSigle();
        API_LOCAL1 result = instance.read1(sigle);
       assertNotEquals("sigle  différents",expResult.getSigle(), result.getSigle());
        
        
       /* try{
            result=instance.read1("testSigle");
            fail("exception d'id inconnu non générée");
        }
        catch(SQLException e){}
       instance.delete(result);
       }*/
    }

    /**
     * Test of update method, of class API_LOCAL1DAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        API_LOCAL1 obj = new API_LOCAL1(0,5,"TestSigle","TestDescription");
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setPlaces(5);
        //etc
        obj.setDescription("TestDescription");
        //etc
        API_LOCAL1 expResult=obj;
        API_LOCAL1 result = instance.update(obj);
        assertEquals(expResult.getPlaces(), result.getPlaces());
        //etc
        assertEquals(expResult.getDescription(), result.getDescription());
        //etc
        instance.delete(obj);
        //TODO verifier que si met à jour vers un triplet nom-prenom-tel déjà existant, on a une exception
        //TODO verifier que si on met à jour vers un cp non valide, on a une exception
    }

    /**
     * Test of delete method, of class API_LOCAL1DAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        API_LOCAL1 obj = new API_LOCAL1(0,5,"TestSigle","TestDescription");
         API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read1(obj.getSigle());
            fail("exception de record introuvable non générée");
        }
        catch(SQLException e){}
        //TODO vérifier qu'on a bien une exception en cas de record parent de clé étrangère
    }

    /**
     * Test of rechNom method, of class API_LOCAL1DAO.
     */
    @Test
    public void testRechNom() throws Exception {
        System.out.println("rechNom");
        API_LOCAL1 obj1 = new API_LOCAL1(0,5,"TestSigle","TestDescription");
        API_LOCAL1 obj2 =new API_LOCAL1(0,10,"TestSigle","TestDescription2");
        String nomrech = "TestSigle";
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        
      
        List<API_LOCAL1> result = instance.rechNom(nomrech);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
    }
    
     /**
     * Test of rechNom1 method, of class API_LOCAL1DAO.
     */
    @Test
    public void testRechNom1() throws Exception {
        System.out.println("RechNom1");
        API_LOCAL1 obj1 = new API_LOCAL1(0,5,"TestSigle","TestDescription");
        API_LOCAL1 obj2 =new API_LOCAL1(0,10,"TestSigle2","TestDescription");
        String Descr = "TestDescription";
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        
      
        List<API_LOCAL1> result = instance.rechNom1(Descr);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
    }

    
}
