package model.bo;

public class Cidade {
    private int idCidade;
    private String descricao;

    public Cidade() {
    }
    
    public Cidade(int idCidade, String descricao) {
        this.idCidade = idCidade;
        this.descricao = descricao;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    @Override
    public String toString() {
        return this.getIdCidade() + " " + this.getDescricao();
    }
}
