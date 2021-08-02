package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import model.bo.Produto;
import service.ProdutoService;
import utils.ControllerUtils;
import view.TelaBuscaProduto;

public class ControllerBuscaProduto implements ActionListener {

    TelaBuscaProduto buscaProduto = new TelaBuscaProduto(null, true);
    public static int codigo;
    
    public ControllerBuscaProduto(TelaBuscaProduto telaCid) {
        this.buscaProduto = telaCid;
        
        this.buscaProduto.getjBotaoCarregar().addActionListener(this);
        this.buscaProduto.getjBotaoDeletar().addActionListener(this);
        this.buscaProduto.getjBotaoSair().addActionListener(this);
        
        List<Produto> listaProdutos = new ArrayList<>();
        
        listaProdutos = service.ProdutoService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaProduto.getjTable1().getModel();
        
        for(Produto produtoAtual : listaProdutos) {
            tabela.addRow(new Object[]{
                produtoAtual.getId(),
                produtoAtual.getDescricao(),
                produtoAtual.getUndCompra(),
                produtoAtual.getUndVenda(),
                produtoAtual.getCorrelacaoUnd(),
                produtoAtual.getValor(),
                produtoAtual.getQuantidadeEstoque(),
                ControllerUtils.formatString(produtoAtual.getBarra(),"# ###### ######"),
                produtoAtual.getObservacao()
            });
            
        }
        
        this.buscaProduto.getjTable1().setModel(tabela);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaProduto.getjBotaoCarregar()){
            ControllerProduto.codigo = (int) this.buscaProduto.getjTable1().getValueAt(this.buscaProduto.getjTable1().getSelectedRow(), 0);
            ControllerFaturamento.codigo = (int) this.buscaProduto.getjTable1().getValueAt(this.buscaProduto.getjTable1().getSelectedRow(), 0);
            this.buscaProduto.dispose();
        }
        
        if(e.getSource() == this.buscaProduto.getjBotaoDeletar()){
            int id = (int) this.buscaProduto.getjTable1().getValueAt(this.buscaProduto.getjTable1().getSelectedRow(), 0);
            ProdutoService.Deletar(id);
            
            List<Produto> listaProdutos = new ArrayList<>();
        
            listaProdutos = service.ProdutoService.Buscar();
            
            DefaultTableModel tabela = (DefaultTableModel) this.buscaProduto.getjTable1().getModel();
            
            tabela.setRowCount(0);
            
            for(Produto produtoAtual : listaProdutos) {
                tabela.addRow(new Object[]{produtoAtual.getId(),produtoAtual.getDescricao()});
            }
        }
        
        if(e.getSource() == this.buscaProduto.getjBotaoSair()) {
            this.buscaProduto.dispose();
        }
    }
   
}
