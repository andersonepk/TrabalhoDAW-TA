
package br.edu.ifsul.modelo;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {
    @CNPJ(message = "O CNPJ deve ser válido")
    @NotBlank(message = "O CNPJ deve ser informado")
    @Length(max = 18, message = "O CNPJ não deve ultrapassar {max} caracteres")
    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;
    @NotBlank(message = "O IE deve ser informado")
    @Length(max = 10, message = "O IE não deve ultrapassar {max} caracteres")
    @Column(name = "ie", nullable = false, length = 10)
    private String ie;   
 


    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

   


}
