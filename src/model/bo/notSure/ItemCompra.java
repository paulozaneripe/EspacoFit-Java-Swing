package model.bo.notSure;
import java.util.Date;

public class ItemCompra {
    private int id;
    private int qtdProduto;
    private float valorUniProduto;
    private boolean status;
    
    public ItemCompra() {
    }

    public ItemCompra(int id, int qtdProduto, float valorUniProduto, boolean status) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.valorUniProduto = valorUniProduto;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getValorUniProduto() {
        return valorUniProduto;
    }

    public void setValorUniProduto(float valorUniProduto) {
        this.valorUniProduto = valorUniProduto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getQtdProduto() + " " + this.getValorUniProduto() + " " + this.isStatus();
    }
}
