
package model.bo;

public class ItemVenda {
    private int id;
    private int qtdItemVenda;
    private float valorUnitario;
    private String status;
    private String observacao;
    
    private int idVenda;
    private int idProduto;
    
    public ItemVenda(){
        
    }

    public ItemVenda(int id, int qtdItemVenda, float valorUnitario, String status, String observacao, int idVenda, int idProduto) {
        this.id = id;
        this.qtdItemVenda = qtdItemVenda;
        this.valorUnitario = valorUnitario;
        this.status = status;
        this.observacao = observacao;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdItemVenda() {
        return qtdItemVenda;
    }

    public void setQtdItemVenda(int qtdItemVenda) {
        this.qtdItemVenda = qtdItemVenda;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String obs) {
        this.observacao = observacao;
    }
    

    
    public int getIdVenda(){
        return idVenda;
    }
    
    public void setIdVenda(int idVenda){
        this.idVenda = idVenda;
    }

    public int getIdProduto(){
        return idProduto;   
    }
    
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    
    @Override
    public String toString() {
        return "ItemVenda" + "id=" + this.getId() + ", quantidade=" + this.getQtdItemVenda() + ", valorUnitario=" + this.getValorUnitario() + ", status=" + this.getStatus() + ", observacao=" + this.getObservacao() + '}';
    }
    
    
}
