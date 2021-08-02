package model.bo;
import java.util.Date;

public class Aluno extends Pessoa {
    private int id;
    private String rg;
    private String cpf;
    private Date dtNascimento;

    public Aluno() {
    }

    public Aluno(int id, String rg, String cpf, String nome, String compleEndereco, String fone1, String fone2, String email, String observacao, Date dtNascimento, boolean status, int Cep_idCep) {
        super(nome, compleEndereco, fone1, fone2, email, observacao, status, Cep_idCep);
        this.id = id;
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg.replaceAll("[^0-9]", "");
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf.replaceAll("[^0-9]", "");
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return this.getId() + " " + super.toString() + " " + this.getCpf() + " " + this.getRg() + " " + this.getDtNascimento();
    }
}
