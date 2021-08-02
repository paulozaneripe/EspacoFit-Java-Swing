package model.bo;
import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String compleEndereco;  
    private String fone1;
    private String fone2;
    private String email;
    private String observacao;
    private boolean status;
    private int Cep_idCep;

    public Pessoa() {
    }

    public Pessoa(String nome, String compleEndereco, String fone1, String fone2, String email, String observacao, boolean status, int Cep_idCep) {
        this.nome = nome;
        this.compleEndereco = compleEndereco;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.email = email;
        this.observacao = observacao;
        this.status = status;
        this.Cep_idCep = Cep_idCep;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        this.compleEndereco = compleEndereco;
    }

    public String getFone1() {
        return fone1.replaceAll("[^0-9]", "");
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2.replaceAll("[^0-9]", "");
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getCep_idCep() {
        return Cep_idCep;
    }

    public void setCep_idCep(int Cep_idCep) {
        this.Cep_idCep = Cep_idCep;
    }
    
    
    @Override
    public String toString() {
        return this.getNome() + " " + this.getFone1() + " " + 
               this.getFone2() + " " + this.getCep_idCep() + " " +
               this.getCompleEndereco() + " " + this.getEmail() + " " + 
               this.getObservacao() + " " + this.isStatus();
    }
}