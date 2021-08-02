package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Cidade;
import view.TelaBuscaCidade;
import view.TelaCadastroCidade;
import service.CidadeService;
import utils.ControllerUtils;

public class ControllerCidade implements ActionListener {

    TelaCadastroCidade telaCidade = new TelaCadastroCidade();
    public static int codigo;
    
    public ControllerCidade(TelaCadastroCidade telaCid) {
        this.telaCidade = telaCid;
        
        codigo = 0;
        
        this.telaCidade.getjBotaoNovo().addActionListener(this);
        this.telaCidade.getjBotaoCancelar().addActionListener(this);
        this.telaCidade.getjBotaoGravar().addActionListener(this);
        this.telaCidade.getjBotaoBuscar().addActionListener(this);
        this.telaCidade.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaCidade.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaCidade.getjPanelDados().getComponents());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCidade.getjBotaoNovo()) {
            ControllerUtils.Ativa(false, this.telaCidade.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaCidade.getjPanelDados().getComponents());
            this.telaCidade.getjTextFieldID().setEnabled(false);
        }
        
        if(e.getSource() == this.telaCidade.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaCidade.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaCidade.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaCidade.getjBotaoGravar()) {
            
            Cidade cidade = new Cidade();
            cidade.setDescricao(this.telaCidade.getjTextFieldDesc().getText());
            
            if(codigo == 0) {
                CidadeService.Incluir(cidade);
            } else {
                cidade.setIdCidade(Integer.parseInt(this.telaCidade.getjTextFieldID().getText()));
                CidadeService.Atualizar(cidade);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaCidade.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaCidade.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaCidade.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaCidade telaCidade = new TelaBuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(telaCidade);
            telaCidade.setVisible(true);
            
            if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaCidade.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaCidade.getjPanelDados().getComponents());
                Cidade cidade = CidadeService.Buscar(codigo);
                this.telaCidade.getjTextFieldID().setText(cidade.getIdCidade()+"");
                this.telaCidade.getjTextFieldDesc().setText(cidade.getDescricao()+"");

                this.telaCidade.getjTextFieldID().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaCidade.getjBotaoSair()) {
            this.telaCidade.dispose();
        }
    }
}
