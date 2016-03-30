package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Genero;
import br.edu.ifsul.modelo.Livros;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirLivros {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirLivros() {
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
            Livros l = new Livros();
            l.setTitulo("Senhor dos aneis - parte 1");             
            l.setAutor("Monteiro Lobato");
            l.setGenero(em.find(Genero.class, 1));
            l.setValorUnitario(150.00);
            l.setQuantidade(100.0);
            em.getTransaction().begin();
            em.persist(l);
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
