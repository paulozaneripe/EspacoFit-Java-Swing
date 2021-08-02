package model.bo.notSure;
import java.util.Date;

public class ItemVenda {
    private int id;
    private int quantidade;
    private float valorUnitario;
    private String observacao;
    private boolean status;
    
    public ItemVenda() {
    }

    public ItemVenda(int id, int quantidade, float valorUnitario, String observacao, boolean status) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.observacao = observacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return this.getId() + " " + this.getQuantidade() + " " + this.getValorUnitario() + " " + this.getObservacao() + " " + this.isStatus();
    }
}
