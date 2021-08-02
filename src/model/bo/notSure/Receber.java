package model.bo.notSure;
import java.util.Date;

public class Receber {
    private int id;
    private Date dataEmissao;
    private float valorEmitido;
    private Date dataVencimento;
    private Date dataPagamento;
    private float valorDesconto;
    private float valorAcrescimo;
    private float valorPago;
    private String observacao;
    private boolean status;
    
    public Receber() {
    }

    public Receber(int id, Date dataEmissao, float valorEmitido, Date dataVencimento, Date dataPagamento, float valorDesconto, float valorAcrescimo, float valorPago, String observacao, boolean status) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.valorEmitido = valorEmitido;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valorDesconto = valorDesconto;
        this.valorAcrescimo = valorAcrescimo;
        this.valorPago = valorPago;
        this.observacao = observacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public float getValorEmitido() {
        return valorEmitido;
    }

    public void setValorEmitido(float valorEmitido) {
        this.valorEmitido = valorEmitido;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(float valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
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
        return this.getId() + " " + this.getDataEmissao() + " " + this.getValorEmitido() + " " + this.getDataVencimento() + " " + this.getDataPagamento() + " " + this.getValorDesconto() + " " + this.getValorAcrescimo() + " " + this.getValorPago() + " " + this.getObservacao() + " " + this.isStatus();
    }
}
