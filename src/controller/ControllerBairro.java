package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Bairro;
import view.TelaBuscaBairro;
import view.TelaCadastroBairro;
import service.BairroService;
import utils.ControllerUtils;

public class ControllerBairro implements ActionListener {

    TelaCadastroBairro telaBairro = new TelaCadastroBairro();
    public static int codigo;
    
    public ControllerBairro(TelaCadastroBairro telaBar) {
        this.telaBairro = telaBar;
        
        codigo = 0;
        
        this.telaBairro.getjBotaoNovo().addActionListener(this);
        this.telaBairro.getjBotaoCancelar().addActionListener(this);
        this.telaBairro.getjBotaoGravar().addActionListener(this);
        this.telaBairro.getjBotaoBuscar().addActionListener(this);
        this.telaBairro.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaBairro.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaBairro.getjPanelDados().getComponents());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBairro.getjBotaoNovo()) {
            ControllerUtils.Ativa(false, this.telaBairro.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaBairro.getjPanelDados().getComponents());
            this.telaBairro.getjTextFieldID().setEnabled(false);
            codigo = 0;
        }
        
        if(e.getSource() == this.telaBairro.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaBairro.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaBairro.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaBairro.getjBotaoGravar()) {
            
            Bairro bairro = new Bairro();
            bairro.setDescricao(this.telaBairro.getjTextFieldDesc().getText());
            
            if(codigo == 0) {
                BairroService.Incluir(bairro);
            } else {
                bairro.setIdBairro(Integer.parseInt(this.telaBairro.getjTextFieldID().getText()));
                BairroService.Atualizar(bairro);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaBairro.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaBairro.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaBairro.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaBairro telaBairro = new TelaBuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(telaBairro);
            telaBairro.setVisible(true);
            
            if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaBairro.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaBairro.getjPanelDados().getComponents());
                Bairro bairro = BairroService.Buscar(codigo);
                this.telaBairro.getjTextFieldID().setText(bairro.getIdBairro()+"");
                this.telaBairro.getjTextFieldDesc().setText(bairro.getDescricao()+"");
                this.telaBairro.getjTextFieldID().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaBairro.getjBotaoSair()) {
            this.telaBairro.dispose();
        }
    }
}
