package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;

import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        Boolean exception = false;
        try {
            PessoaFisica pf = new PessoaFisica();
            pf.setBairro("Centro");
            pf.setCep("99999-999");        
            pf.setComplemento("AP 333");
            pf.setCpf("555.725.426-95");
            pf.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
            pf.setEndereco("Rua xxxx");
            pf.setNascimento(new GregorianCalendar(2000, Calendar.JANUARY, 12));
            pf.setNome("João");
            pf.setRg("8746647389");
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
