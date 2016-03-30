package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;

import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.PessoaJuridica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirPessoaJuridica {
    
    EntityManager em;
    
    public TestePersistirPessoaJuridica() {
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
            PessoaJuridica pj = new PessoaJuridica();
            pj.setBairro("Centro");
            pj.setCep("99999-999");        
            pj.setComplemento("AP 333");
            pj.setCnpj("02.978.444/0001-21");
            pj.setEmail("Empresa@passofundo.ifsul.edu.br");
            pj.setEndereco("Rua xxxx");            
            pj.setNome("Empresa LTDA xxx yyyy");
            pj.setIe("8746647389");
            em.getTransaction().begin();
            em.persist(pj);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
