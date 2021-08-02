
package model.bo;

public class Receber {
    private int id;
    private String dataEmissao;
    private String dataVencimento;
    private String dataPagamento;
    private float valorEmitido;
    private float valorDesconto;
    private float valorAcrescimo;
    private float valorPago;
    private String observacao;
    private String Status;
    
    private int idVenda;
    
    public Receber(){
        
    }

    public Receber(int id, String dataEmissao, String dataVencimento, String dataPagamento, float valorEmitido, float valorDesconto, float valorAcrescimo, float valorPago, String observacao, String Status, int idVenda) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valorEmitido = valorEmitido;
        this.valorDesconto = valorDesconto;
        this.valorAcrescimo = valorAcrescimo;
        this.valorPago = valorPago;
        this.observacao = observacao;
        this.Status = Status;
        this.idVenda = idVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public float getValorEmitido() {
        return valorEmitido;
    }

    public void setValorEmitido(float valorEmitido) {
        this.valorEmitido = valorEmitido;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public int getIdVenda(){
        return idVenda;
    }
    
    public void setIdVenda(int idVenda){
        this.idVenda = idVenda;
    }
    
    @Override
    public String toString() {
        return "Receber: " + "id=" + this.getId() + ", dataEmissao=" + this.getDataEmissao() + ", valorEmitido=" + this.getValorEmitido() + ", dataVencimento=" + this.getDataVencimento() + ", dataPagamento=" + this.getDataPagamento() + ", valorDesconto=" + this.getValorDesconto() + ", valorAcrescimo=" + this.getValorAcrescimo() + ", valorPago=" + this.getValorPago() + ", observacao=" + this.getObservacao() + ", Status=" + this.getStatus() + "Venda: " + this.getIdVenda();
    }
    
    
}
