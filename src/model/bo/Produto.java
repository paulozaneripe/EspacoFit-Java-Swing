package model.bo;

public class Produto {
    private int id;
    private String descricao;
    private String undCompra;
    private String undVenda;
    private int correlacaoUnd;
    private float valor;
    private int quantidadeEstoque;
    private String barra;
    private String observacao;
    private boolean status;
    
    public Produto() {
    }

    public Produto(int id, String descricao, String undCompra, String undVenda, int correlacaoUnd, float valor, int quantidadeEstoque, String barra, String observacao, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.undCompra = undCompra;
        this.undVenda = undVenda;
        this.correlacaoUnd = correlacaoUnd;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.barra = barra;
        this.observacao = observacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUndCompra() {
        return undCompra;
    }

    public void setUndCompra(String undCompra) {
        this.undCompra = undCompra;
    }

    public String getUndVenda() {
        return undVenda;
    }

    public void setUndVenda(String undVenda) {
        this.undVenda = undVenda;
    }

    public int getCorrelacaoUnd() {
        return correlacaoUnd;
    }

    public void setCorrelacaoUnd(int correlacaoUnd) {
        this.correlacaoUnd = correlacaoUnd;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
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
        return this.getId() + " " + this.getDescricao() + " " + this.getUndCompra() + " " + this.getUndVenda() + " " + this.getCorrelacaoUnd() + " " + this.getValor() + " " + this.getQuantidadeEstoque() + " " + this.getBarra() + " " + this.getObservacao() + " " + this.isStatus();
    }
}
