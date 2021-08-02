package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import model.bo.Produto;
import view.TelaBuscaProduto;
import view.TelaCadastroProduto;
import utils.ControllerUtils;
import service.ProdutoService;

public class ControllerProduto implements ActionListener {
    TelaCadastroProduto telaProduto = new TelaCadastroProduto();
    public static int codigo;
    
    public ControllerProduto(TelaCadastroProduto telaCid) {
        this.telaProduto = telaCid;
        
        codigo = 0;
        
        
        this.telaProduto.getjBotaoNovo().addActionListener(this);
        this.telaProduto.getjBotaoCancelar().addActionListener(this);
        this.telaProduto.getjBotaoGravar().addActionListener(this);
        this.telaProduto.getjBotaoBuscar().addActionListener(this);
        this.telaProduto.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaProduto.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaProduto.getjPanelDados().getComponents());
        System.out.println(this.telaProduto.getjPanelDados().getComponents());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaProduto.getjBotaoNovo()) {
            codigo = 0;
            ControllerUtils.Ativa(false, this.telaProduto.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaProduto.getjPanelDados().getComponents());
            this.telaProduto.getjTextFieldID().setEnabled(false);
        }
        
        if(e.getSource() == this.telaProduto.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaProduto.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaProduto.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaProduto.getjBotaoGravar()) {
            
            Produto produto = new Produto();
            
            //NOME DO PRODUTO
            produto.setDescricao(this.telaProduto.getjTextFieldNome().getText());
            //CODIGO DE BARRA
            produto.setBarra(this.telaProduto.getjFormattedTextFieldBarra().getText().replaceAll("\\s+", ""));
            //QUANTIDADE DE ESTOQUE
            produto.setQuantidadeEstoque(Integer.parseInt(this.telaProduto.getjFormattedTextFieldQuantidade().getText()));
            //VALOR
            String valor = this.telaProduto.getjFormattedTextFieldValor().getText().replaceAll("[^\\.0123456789]","");
            produto.setValor(Float.parseFloat(valor));
            //OBSERVACAO
            produto.setObservacao(this.telaProduto.getjTextAreaObservacao().getText());
            
            if(codigo == 0) {
                ProdutoService.Incluir(produto);
            } else {
                produto.setId(Integer.parseInt(this.telaProduto.getjTextFieldID().getText()));
                ProdutoService.Atualizar(produto);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaProduto.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaProduto.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaProduto.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaProduto buscaProduto = new TelaBuscaProduto(null, true);
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
            buscaProduto.setVisible(true);
            
             if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaProduto.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaProduto.getjPanelDados().getComponents());
                Produto produto = ProdutoService.Buscar(codigo);
                this.telaProduto.getjTextFieldID().setText(produto.getId() + "");
                this.telaProduto.getjTextFieldNome().setText(produto.getDescricao());
                this.telaProduto.getjFormattedTextFieldBarra().setText(produto.getBarra());
                this.telaProduto.getjFormattedTextFieldQuantidade().setText(produto.getQuantidadeEstoque() + "");
                this.telaProduto.getjFormattedTextFieldValor().setText(produto.getValor() + "");
                this.telaProduto.getjTextAreaObservacao().setText(produto.getObservacao());
                
                this.telaProduto.getjTextFieldID().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaProduto.getjBotaoSair()) {
            this.telaProduto.dispose();
        }
    }
}
