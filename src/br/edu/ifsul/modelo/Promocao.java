package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "promocao")
public class Promocao implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_promocao", sequenceName = "seq_promocao_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_promocao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O descricao deve ser informado")
    @Length(max = 100, message = "O descricao não deve ter mais de {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    @NotNull(message = "O livro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "livros", referencedColumnName = "id", nullable = false)
    private Livros livros;

    public Promocao() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Promocao other = (Promocao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    


}
