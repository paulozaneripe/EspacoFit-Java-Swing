
package model.bo;


public class Venda {
    private int id;
    private String data;
    private String hora;
    private float valorTotal;
    private String observacao;
    private String bairroAluno;
    private String cidadeAluno;
    private String emailAluno;
    private String usuario;
    private int idAluno;
    private int idPersonal;
    private int idProduto;
    
    public Venda(){
        
    }

    public Venda(int id, String data, String hora, float valorTotal, String observacao, String bairroAluno, String cidadeAluno, String emailAluno, String usuario, int idAluno, int idPersonal, int idProduto) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
        this.bairroAluno = bairroAluno;
        this.cidadeAluno = cidadeAluno;
        this.emailAluno = emailAluno;
        this.usuario = usuario;
        this.idAluno = idAluno;
        this.idPersonal = idPersonal;
        this.idProduto = idProduto;
    }

    public String getBairroAluno() {
        return bairroAluno;
    }

    public void setBairroAluno(String BairroAluno) {
        this.bairroAluno = BairroAluno;
    }

    public String getCidadeAluno() {
        return cidadeAluno;
    }

    public void setCidadeAluno(String cidadeAluno) {
        this.cidadeAluno = cidadeAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String Obs) {
        this.observacao = observacao;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + this.getId() + ", data=" + this.getData() + ", hora=" + this.getHora() + ", valorTotal=" + this.getValorTotal() + ", observacao=" + this.getObservacao() + "Aluno:" + this.getIdAluno() + "Personal: " + this.getIdPersonal();
    }  
    
}
