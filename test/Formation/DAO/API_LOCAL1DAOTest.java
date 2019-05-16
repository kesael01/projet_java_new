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
       
        API_LOCAL1 obj = new API_LOCAL1(0,6,"TestSigle","TestDescription");
       API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        API_LOCAL1 expResult = new API_LOCAL1(0,6,"TestSigle","TestDescription");
        API_LOCAL1 result = instance.create(obj);
        
        assertEquals("Places différents", expResult.getPlaces(), result.getPlaces());
        assertEquals("sigles différents", expResult.getSigle(), result.getSigle());
        assertEquals("Description différents", expResult.getDescription(), result.getDescription());
        
        //etc
        assertNotEquals("id non généré", expResult.getIdlocal(), result.getIdlocal());
       // int idlocal =result.getIdlocal();
        obj =new API_LOCAL1(0,5,"TestSigle2","TestDescription");
        try{
            
            API_LOCAL1 result2=instance.create(obj);
            //API_LOCAL1 result2 = instance.create(obj);
            //fail("exception de doublon non déclenchée");
            instance.delete(result2);
        }
        catch(SQLException e){
        instance.delete(result);
        }
        
        
          obj=new API_LOCAL1(0,15,"TestSigle3","TestDescription3");
        try{
            API_LOCAL1 result3 = instance.create(obj);
            //fail("exception de code postal non déclenchée");
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
       String sigle = "";
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        API_LOCAL1 obj = new API_LOCAL1(0,15,"testsigl","description");
       // API_LOCAL1 expResult = new API_LOCAL1(63,5,"TestSigle","TestDescription");
        API_LOCAL1 expResult = instance.create(obj);
        sigle=expResult.getSigle();
        API_LOCAL1 result = instance.read1(sigle);
       assertEquals("sigle  différents",expResult.getSigle(), result.getSigle());
        
        
       try{
            result=instance.read(0);
            fail("exception d'id inconnu non générée");
        }
        catch(SQLException e){}
       instance.delete(result);
       }
    /**
     * Test of read method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
       
        System.out.println("read");
        int idlocal = 0;
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        API_LOCAL1 obj = new API_LOCAL1(0,10,"tesS","TestDescription");
        API_LOCAL1 expResult = instance.create(obj);
        idlocal = expResult.getIdlocal();
        API_LOCAL1 result = instance.read(idlocal);
        assertEquals("Sigle différents", expResult.getSigle(), result.getSigle());
        assertEquals("Places différents", expResult.getPlaces(), result.getPlaces());
        assertEquals("Description différents", expResult.getDescription(), result.getDescription());
        //etc
        assertEquals("id différents", expResult.getIdlocal(), result.getIdlocal());
        try {
            result = instance.read(0); //0 est la seule valeur dans la bdd qui n'est pas donné dans la bdd car l'auto incrément commence à 1
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }
 

    /**
     * Test of update method, of class API_LOCAL1DAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        API_LOCAL1 obj = new API_LOCAL1(0,5,"Tes","TestDescription");
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setPlaces(10);
        
        API_LOCAL1 expResult=obj;
        API_LOCAL1 result = instance.update(obj);
        assertEquals(expResult.getPlaces(), result.getPlaces());
        //etc
       // assertEquals(expResult.getDescription(), result.getDescription());
        //etc
        instance.delete(obj);
        
    }

    /**
     * Test of delete method, of class API_LOCAL1DAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        API_LOCAL1 obj = new API_LOCAL1(0,10,"TestSigle","TestDescription");
         API_LOCAL1DAO instance = new API_LOCAL1DAO();
         //instance.setConnection(dbConnect);
        /* obj = instance.create(obj);
        int idlocal=obj.getIdlocal();
        
        instance.delete(obj);
         
        
        try {
            instance.read(idlocal);
            fail("exception de record introuvable non générée");
            
        }
        catch(SQLException e){}
     
       
       
        
       // assertEquals(expResult.getSigle(), result.getSigle());
 
       //instance.delete(obj);
        */
  
    }
    /**
     * Test of rechNom method, of class API_LOCAL1DAO.
     */
    @Test
    public void testRechNom() throws Exception {
        System.out.println("rechNom");
        String nomrech="";
        
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        /*instance.setConnection(dbConnect);
        API_LOCAL1 obj1 = new API_LOCAL1(0,5,"TestSigle","TestDescription");
        API_LOCAL1 obj2 =new API_LOCAL1(0,10,"TestSigle","TestDescription2");
       nomrech = "TestSigle";
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        
      
        List<API_LOCAL1> result = instance.rechNom(nomrech);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
        */
    }
    
     /**
     * Test of rechNom1 method, of class API_LOCAL1DAO.
     */
    @Test
    public void testRechNom1() throws Exception {
        System.out.println("RechNom1");
        String Descr = "description";
        API_LOCAL1DAO instance = new API_LOCAL1DAO();
        
       /* API_LOCAL1 obj1 = new API_LOCAL1(0,5,"TestSigle","TestDescription");
        API_LOCAL1 obj2 =new API_LOCAL1(0,10,"TestSigle2","TestDescription");
        Descr="testDescription";
        A
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        
      
        List<API_LOCAL1> result = instance.rechNom1(Descr);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
*/
    }

    
}
