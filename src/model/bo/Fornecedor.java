package model.bo;
import java.util.Date;

public class Fornecedor extends Pessoa {
    private int id;
    private String cnpj;
    private String razaoSocial;
    private String inscEstadual;

    public Fornecedor() {
    }

    public Fornecedor(int id, String cnpj, String razaoSocial, String inscEstadual, String nome, String compleEndereco, String fone1, String fone2, String email, String observacao, boolean status, int Cep_idCep) {
        super(nome, compleEndereco, fone1, fone2, email, observacao, status, Cep_idCep);
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscEstadual = inscEstadual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj.replaceAll("[^0-9]", "");
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscEstadual() {
        return inscEstadual.replaceAll("[^0-9]", "");
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    @Override
    public String toString() {
        return this.getId() + " " + super.toString() + " " + this.getCnpj() + " " + this.getRazaoSocial() + " " + this.getInscEstadual();
    }
    
    
}
