
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {
    @EmbeddedId
    private VendaID id;
    @NotNull(message = "A data da compra deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, 
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<VendaItem> itens = new ArrayList<>();

    public Venda() {
        this.valorTotal = 0.0;
    }

    
    public void adicionarItem(VendaItem obj){
        obj.setVenda(this);
        this.valorTotal += obj.getValorTotal();
        this.itens.add(obj);
    }
    
    public void removerItem(int index){
        VendaItem obj = this.itens.get(index);
        this.valorTotal -= obj.getValorTotal();
        this.itens.remove(obj);
    }    
    public VendaID getId() {
        return id;
    }

    public void setId(VendaID id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }
}
