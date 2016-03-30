
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
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {
    @NotBlank(message = "O RG deve ser informado")
    @Length(max = 11, message = "O RG não deve ultrapassar {max} caracteres")
    @Column(name = "rg", nullable = false, length = 11)
    private String rg;
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não deve ultrapassar {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    @NotNull(message = "O nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;


    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }



}
