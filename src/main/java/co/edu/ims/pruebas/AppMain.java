
package co.edu.ims.pruebas;

import co.edu.ims.modelo.Rol;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppMain {
     public static void main (String[] args){
         
     EntityManagerFactory emf;
     EntityManager em; 
     
     emf = Persistence.createEntityManagerFactory("controlAccesoPU");        
     em = emf.createEntityManager();
     
                  
     }
    
     
     
     
}
