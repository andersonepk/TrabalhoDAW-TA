package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Genero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirGenero {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirGenero() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        // o teste não deve gerar exceção se tudo estiver correto
        boolean exception = false;
        try {
            Genero g = new Genero();
            g.setDescricao("Romance");           
            em.getTransaction().begin();
            em.persist(g);
            em.getTransaction().commit();
        }catch (Exception e){
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }
    
}
