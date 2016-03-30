package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livros;
import br.edu.ifsul.modelo.Promocao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirPromocao {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPromocao() {
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
            Promocao p = new Promocao();
            Livros l = em.find(Livros.class, 1);
            p.setDescricao("Livro: "+l.getTitulo()+" Com 50% de desconto");
            p.setValor(l.getValorUnitario()/2);
            p.setLivros(l);
            em.getTransaction().begin();
            em.persist(p);
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
