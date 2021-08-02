package model.bo;

public class Bairro {
    private int idBairro;
    private String descricao;

    public Bairro() {
    }
    
    public Bairro(int idBairro, String descricao) {
        this.idBairro = idBairro;
        this.descricao = descricao;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    @Override
    public String toString() {
        return this.getIdBairro() + " " + this.getDescricao();
    }
}
