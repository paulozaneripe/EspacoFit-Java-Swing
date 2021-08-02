package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import model.bo.Personal;
import model.bo.Cep;
import view.TelaBuscaPersonal;
import view.TelaCadastroPersonal;
import service.CepService;
import service.PersonalService;
import utils.ControllerUtils;

public class ControllerPersonal implements ActionListener, DocumentListener {
    TelaCadastroPersonal telaPersonal = new TelaCadastroPersonal();
    public static int codigo;
    
    public ControllerPersonal(TelaCadastroPersonal telaCid) {
        this.telaPersonal = telaCid;
        
        codigo = 0;
        
        Document doc = this.telaPersonal.getjFormattedTextFieldCEP().getDocument();
        doc.addDocumentListener(this);
        
        this.telaPersonal.getjBotaoNovo().addActionListener(this);
        this.telaPersonal.getjBotaoCancelar().addActionListener(this);
        this.telaPersonal.getjBotaoGravar().addActionListener(this);
        this.telaPersonal.getjBotaoBuscar().addActionListener(this);
        this.telaPersonal.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaPersonal.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaPersonal.getjPanelDados().getComponents());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaPersonal.getjBotaoNovo()) {
            codigo = 0;
            ControllerUtils.Ativa(false, this.telaPersonal.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaPersonal.getjPanelDados().getComponents());
            this.telaPersonal.getjTextFieldID().setEnabled(false);
            this.telaPersonal.getjTextFieldCidade().setEnabled(false);
            this.telaPersonal.getjTextFieldBairro().setEnabled(false);
            this.telaPersonal.getjTextFieldLogradouro().setEnabled(false);
        }
        
        if(e.getSource() == this.telaPersonal.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaPersonal.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaPersonal.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaPersonal.getjBotaoGravar()) {
            
            Personal personal = new Personal();
            personal.setNome(this.telaPersonal.getjTextFieldNome().getText());
            personal.setRg(this.telaPersonal.getjFormattedTextFieldRG().getText());
            personal.setCpf(this.telaPersonal.getjFormattedTextFieldCPF().getText());
            
            String data = this.telaPersonal.getjFormattedTextFieldDataNascimento().getText();
            
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
                java.sql.Date dataSQL = new java.sql.Date(fmt.parse(data).getTime());
                personal.setDtNascimento(dataSQL);
            } catch (ParseException ex) {
                 ex.printStackTrace();
            }
            
            List<Cep> listaCeps = new ArrayList<>();
        
            listaCeps = CepService.Buscar();
            
            String cep = this.telaPersonal.getjFormattedTextFieldCEP().getText();
            
            for(Cep cepDaLista : listaCeps){
                cep = cep.replaceAll("[^0-9]", "");
                if(cepDaLista.getCep().equals(cep)) {
                    personal.setCep_idCep(cepDaLista.getIdCep());
                }
            }
            
            personal.setCompleEndereco(this.telaPersonal.getjTextFieldComplemento().getText());
            personal.setEmail(this.telaPersonal.getjTextFieldEmail().getText());
            personal.setFone1(this.telaPersonal.getjFormattedTextFieldTelefone1().getText());
            personal.setFone2(this.telaPersonal.getjFormattedTextFieldTelefone2().getText());
            personal.setObservacao(this.telaPersonal.getjTextFieldObservacao().getText());
            
            
            if(codigo == 0) {
                PersonalService.Incluir(personal);
            } else {
                personal.setId(Integer.parseInt(this.telaPersonal.getjTextFieldID().getText()));
                PersonalService.Atualizar(personal);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaPersonal.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaPersonal.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaPersonal.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaPersonal buscaPersonal = new TelaBuscaPersonal(null, true);
            ControllerBuscaPersonal controllerBuscaPersonal = new ControllerBuscaPersonal(buscaPersonal);
            buscaPersonal.setVisible(true);
            
             if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaPersonal.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaPersonal.getjPanelDados().getComponents());
                Personal personal = PersonalService.Buscar(codigo);
                this.telaPersonal.getjTextFieldID().setText(personal.getId() + "");
                this.telaPersonal.getjTextFieldNome().setText(personal.getNome());
                this.telaPersonal.getjFormattedTextFieldRG().setText(personal.getRg());
                this.telaPersonal.getjFormattedTextFieldCPF().setText(personal.getCpf());
                this.telaPersonal.getjFormattedTextFieldDataNascimento().setText(ControllerUtils.filtrarData(personal.getDtNascimento()));
                
                Cep cep = CepService.Buscar(personal.getCep_idCep());
                this.telaPersonal.getjFormattedTextFieldCEP().setText(cep.getCep());
                
                this.telaPersonal.getjTextFieldComplemento().setText(personal.getCompleEndereco());
                this.telaPersonal.getjTextFieldEmail().setText(personal.getEmail());
                this.telaPersonal.getjFormattedTextFieldTelefone1().setText(personal.getFone1());
                this.telaPersonal.getjFormattedTextFieldTelefone2().setText(personal.getFone2());
                this.telaPersonal.getjTextFieldObservacao().setText(personal.getObservacao());
                
                this.telaPersonal.getjTextFieldID().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaPersonal.getjBotaoSair()) {
            this.telaPersonal.dispose();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent d) {
        ControllerUtils.checarCEP(
            this.telaPersonal.getjFormattedTextFieldCEP().getText(),
            this.telaPersonal.getjFormattedTextFieldCEP(),
            this.telaPersonal.getjTextFieldCidade(),
            this.telaPersonal.getjTextFieldBairro(),
            this.telaPersonal.getjTextFieldLogradouro()
        );
    }

    @Override
    public void removeUpdate(DocumentEvent d) {
        ControllerUtils.checarCEP(
            this.telaPersonal.getjFormattedTextFieldCEP().getText(),
            this.telaPersonal.getjFormattedTextFieldCEP(),
            this.telaPersonal.getjTextFieldCidade(),
            this.telaPersonal.getjTextFieldBairro(),
            this.telaPersonal.getjTextFieldLogradouro()
        );
    }

    @Override
    public void changedUpdate(DocumentEvent d) {}
}
