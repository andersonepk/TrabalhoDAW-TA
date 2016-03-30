package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "venda_item")
public class VendaItem implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_venda_item", sequenceName = "seq_venda_item_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_venda_item", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "numeric(10,2)")
    private Double quantidade;
    @NotNull(message = "O valor unitario deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorUnitario;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    @NotNull(message = "O produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
    private Livros livros;
    @NotNull(message = "A compra deve ser informada")
    @ManyToOne
    private Venda venda;

    public VendaItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

   
}
