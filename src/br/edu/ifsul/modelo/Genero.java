
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "genero")
public class Genero implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_genero", sequenceName = "seq_genero_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_genero", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descricao deve ser informado")
    @Length(max = 40, message = "A descricao não deve ter mais que {max} caracteres")
    @Column(name = "descricao",length = 40, nullable = false)
    private String descricao;
    
    public Genero(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    


    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genero other = (Genero) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
    
}
