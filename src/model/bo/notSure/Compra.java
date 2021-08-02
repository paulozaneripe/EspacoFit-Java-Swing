package model.bo.notSure;
import java.util.Date;

public class Compra {
    private int id;
    private Date data;
    private float valorTotal;
    private float valorDesconto;
    private boolean status;

    public Compra() {
    }

    public Compra(int id, Date data, float valorTotal, float valorDesconto, boolean status) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getData() + " " + this.getValorTotal() + " " + this.getValorDesconto() + " " + this.isStatus();
    }
    
    
}
