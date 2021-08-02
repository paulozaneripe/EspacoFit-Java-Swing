package model.bo;

public class Cep {
    private int idCep;
    private String cep;
    private String logradouro;
    private String observacao;
    private boolean status;
    private int idCidade;
    private int idBairro;
    
    public Cep() {
    }

    public Cep(int idCep, String cep, String logradouro, String observacao, boolean status, int idCidade, int idBairro) {
        this.idCep = idCep;
        this.cep = cep;
        this.logradouro = logradouro;
        this.observacao = observacao;
        this.status = status;
        this.idCidade = idCidade;
        this.idBairro = idBairro;
    }
    
     public int getIdCep() {
        return idCep;
    }
     
     public void setIdCep(int idCep) {
         this.idCep = idCep;
     }

    public String getCep() {
        return cep.replaceAll("[^0-9]", "");
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
    
    public int getIdCidade() {
        return idCidade;
    }
    
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
    
    public int getIdBairro() {
        return idBairro;
    }
    
    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    @Override
    public String toString() {
        return this.getIdCep() + " " + this.getCep() + " " +
               this.getLogradouro() + " " + this.getIdBairro() + " " +
               this.getIdCidade() + " " +
               this.isStatus();
    }
}
