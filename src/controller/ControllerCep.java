package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.bo.Bairro;
import model.bo.Cep;
import model.bo.Cidade;
import model.ComboItem;
import service.BairroService;
import service.CidadeService;
import service.CepService;
import view.TelaBuscaCep;
import view.TelaCadastroCep;
import utils.ControllerUtils;

public class ControllerCep implements ActionListener {

    TelaCadastroCep telaCep = new TelaCadastroCep();
    public static int codigo;

    public ControllerCep(TelaCadastroCep telaCep) {
        this.telaCep = telaCep;
        
        codigo = 0;
    
        this.telaCep.getjBotaoNovo().addActionListener(this);
        this.telaCep.getjBotaoCancelar().addActionListener(this);
        this.telaCep.getjBotaoGravar().addActionListener(this);
        this.telaCep.getjBotaoBuscar().addActionListener(this);
        this.telaCep.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaCep.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaCep.getjPanelDados().getComponents());
        
        this.telaCep.getjComboBoxCidade().removeAll();
        List<Cidade> listaCidades = new ArrayList<>();
        listaCidades = CidadeService.Buscar();
        
        for (Cidade cidadeAtual : listaCidades){
            this.telaCep.getjComboBoxCidade().addItem(new ComboItem(cidadeAtual.getIdCidade(),cidadeAtual.getDescricao()));
        }
        
        this.telaCep.getjComboBoxBairro().removeAll();
        List<Bairro> listaBairros = new ArrayList<>();
        listaBairros = BairroService.Buscar();
        
        for (Bairro bairroAtual : listaBairros) {
            this.telaCep.getjComboBoxBairro().addItem(new ComboItem(bairroAtual.getIdBairro(),bairroAtual.getDescricao()));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCep.getjBotaoNovo()) {
            ControllerUtils.Ativa(false, this.telaCep.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaCep.getjPanelDados().getComponents());
            this.telaCep.getjTextFieldID().setEnabled(false);
            codigo = 0;
        }
        
        if(e.getSource() == this.telaCep.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaCep.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaCep.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaCep.getjBotaoGravar()) {
            
            Cep cep = new Cep();
            
            cep.setCep(this.telaCep.getjFormattedTextFieldCEP().getText());
            cep.setLogradouro(this.telaCep.getjTextFieldLogradouro().getText());
            
            ComboItem cidadeSelecionada = (ComboItem) this.telaCep.getjComboBoxCidade().getSelectedItem();
            cep.setIdCidade(cidadeSelecionada.getId());
            
            ComboItem bairroSelecionado = (ComboItem) this.telaCep.getjComboBoxBairro().getSelectedItem();
            cep.setIdBairro(bairroSelecionado.getId());
            
            cep.setObservacao(this.telaCep.getjTextFieldObservacao().getText());
            cep.setStatus(true);
            
            if(codigo == 0) {
                CepService.Incluir(cep);
            } else {
                cep.setIdCep(Integer.parseInt(this.telaCep.getjTextFieldID().getText()));
                CepService.Atualizar(cep);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaCep.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaCep.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaCep.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaCep buscaCep = new TelaBuscaCep(null, true);
            ControllerBuscaCep controllerBuscaCep = new ControllerBuscaCep(buscaCep);
            buscaCep.setVisible(true);
            
             if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaCep.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaCep.getjPanelDados().getComponents());
                Cep cep = CepService.Buscar(codigo);
                this.telaCep.getjTextFieldID().setText(cep.getIdCep() + "");
                this.telaCep.getjFormattedTextFieldCEP().setText(cep.getCep());
                this.telaCep.getjTextFieldLogradouro().setText(cep.getLogradouro());
                
                Cidade cidade = new Cidade();
                cidade = CidadeService.Buscar(cep.getIdCidade());
                
                JComboBox<ComboItem> CbCidade = this.telaCep.getjComboBoxCidade();

                for (int i=0; i < CbCidade.getItemCount(); i++) {
                    
                    ComboItem cidadeSelecionada = (ComboItem) CbCidade.getItemAt(i);
                    
                    if (cidadeSelecionada.getId() == cidade.getIdCidade()) {
                      CbCidade.setSelectedIndex(i);
                      break;
                    }
                }
                
                Bairro bairro = new Bairro();
                bairro = BairroService.Buscar(cep.getIdBairro());
                
                JComboBox<ComboItem> CbBairro = this.telaCep.getjComboBoxBairro();
                
                for (int i=0; i < CbBairro.getItemCount(); i++) {
                    
                    ComboItem bairroSelecionado = (ComboItem) CbBairro.getItemAt(i);
                    
                    if (bairroSelecionado.getId() == bairro.getIdBairro()) {
                      CbBairro.setSelectedIndex(i);
                      break;
                    }
                }
                
                this.telaCep.getjTextFieldObservacao().setText(cep.getObservacao());
                
                this.telaCep.getjTextFieldID().setEnabled(false);
            }
        }

        if(e.getSource() == this.telaCep.getjBotaoSair()) {
            this.telaCep.dispose();
        }
    }
}
