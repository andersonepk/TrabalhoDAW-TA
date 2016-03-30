
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "livros")
public class Livros implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_livros", sequenceName = "seq_livros_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_livros", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "O titulo deve ser informado")
    @Length(max = 50,message = "O titulo não deve ter mais de {max} caracteres")    
    @Column(name = "titulo", length = 50, nullable = false)    
    private String titulo;
    @NotBlank(message = "O autor deve ser informado")
    @Length(max = 50,message = "O autor não deve ter mais de {max} caracteres")    
    @Column(name = "autor", length = 50, nullable = false)  
    private String autor;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valorUnitario;
    @Min(message = "O quantidade do estoque não pode ser negativo", value = 0)
    @NotNull(message = "A quantidade em estoque deve ser informada")
    @Column(name = "quantidade", nullable = false, 
            columnDefinition = "decimal(12,2)")    
    private Double quantidade;
    @NotNull(message = "O genero deve ser informada")
    @ManyToOne
    @JoinColumn(name = "genero", referencedColumnName = "id", nullable = false)
    private Genero genero;
   
    @ManyToMany
    @JoinTable(name = "reservas",
            joinColumns = 
            @JoinColumn(name = "livros", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "id"))    
    private List<Pessoa> reservados = new ArrayList<>();

    public Livros() {
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public List<Pessoa> getReservados() {
        return reservados;
    }

    public void setReservados(List<Pessoa> reservados) {
        this.reservados = reservados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Livros other = (Livros) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
