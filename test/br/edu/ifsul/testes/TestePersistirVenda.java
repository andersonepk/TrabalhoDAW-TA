package br.edu.ifsul.testes;



import br.edu.ifsul.modelo.Livros;
import br.edu.ifsul.modelo.PessoaFisica;

import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaID;
import br.edu.ifsul.modelo.VendaItem;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirVenda {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVenda() {
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
            Venda v = new Venda();
            VendaID id = new VendaID();
            id.setNumeroNota(1654459989);
            id.setPessoa(em.find(PessoaFisica.class,2));
            v.setId(id);
            v.setData(Calendar.getInstance());
            //p.setValorTotal(500.00);
            VendaItem item = new VendaItem();
            item.setLivros(em.find(Livros.class, 2));
            item.setQuantidade(3.0);
            item.setValorUnitario(item.getLivros().getValorUnitario());
            item.setValorTotal(item.getQuantidade()*item.getValorUnitario());
            v.adicionarItem(item);
            em.getTransaction().begin();
            em.persist(v);
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
