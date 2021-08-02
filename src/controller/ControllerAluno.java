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
import model.bo.Aluno;
import model.bo.Cep;
import view.TelaBuscaAluno;
import view.TelaCadastroAluno;
import service.CepService;
import service.AlunoService;
import utils.ControllerUtils;

public class ControllerAluno implements ActionListener, DocumentListener {

    TelaCadastroAluno telaAluno = new TelaCadastroAluno();
    public static int codigo;
    
    public ControllerAluno(TelaCadastroAluno telaCid) {
        this.telaAluno = telaCid;
        
        codigo = 0;
        
        Document doc = this.telaAluno.getjFormattedTextFieldCEP().getDocument();
        doc.addDocumentListener(this);
        
        this.telaAluno.getjBotaoNovo().addActionListener(this);
        this.telaAluno.getjBotaoCancelar().addActionListener(this);
        this.telaAluno.getjBotaoGravar().addActionListener(this);
        this.telaAluno.getjBotaoBuscar().addActionListener(this);
        this.telaAluno.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaAluno.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaAluno.getjPanelDados().getComponents());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaAluno.getjBotaoNovo()) {
            codigo = 0;
            ControllerUtils.Ativa(false, this.telaAluno.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaAluno.getjPanelDados().getComponents());
            this.telaAluno.getjTextFieldID().setEnabled(false);
            this.telaAluno.getjTextFieldCidade().setEnabled(false);
            this.telaAluno.getjTextFieldBairro().setEnabled(false);
        }
        
        if(e.getSource() == this.telaAluno.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaAluno.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaAluno.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaAluno.getjBotaoGravar()) {
            
            Aluno aluno = new Aluno();
            aluno.setNome(this.telaAluno.getjTextFieldNome().getText());
            aluno.setRg(this.telaAluno.getjFormattedTextFieldRG().getText());
            aluno.setCpf(this.telaAluno.getjFormattedTextFieldCPF().getText());
            
            String data = this.telaAluno.getjFormattedTextFieldDataNascimento().getText();
            
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
                java.sql.Date dataSQL = new java.sql.Date(fmt.parse(data).getTime());
                aluno.setDtNascimento(dataSQL);
            } catch (ParseException ex) {
                 ex.printStackTrace();
            }
            
            List<Cep> listaCeps = new ArrayList<>();
        
            listaCeps = CepService.Buscar();
            
            String cep = this.telaAluno.getjFormattedTextFieldCEP().getText();
            
            for(Cep cepDaLista : listaCeps){
                cep = cep.replaceAll("[^0-9]", "");
                if(cepDaLista.getCep().equals(cep)) {
                    aluno.setCep_idCep(cepDaLista.getIdCep());
                }
            }
            
            aluno.setCompleEndereco(this.telaAluno.getjTextFieldComplemento().getText());
            aluno.setEmail(this.telaAluno.getjTextFieldEmail().getText());
            aluno.setFone1(this.telaAluno.getjFormattedTextFieldTelefone1().getText());
            aluno.setFone2(this.telaAluno.getjFormattedTextFieldTelefone2().getText());
            aluno.setObservacao(this.telaAluno.getjTextFieldObservacao().getText());
            
            
            if(codigo == 0) {
                AlunoService.Incluir(aluno);
            } else {
                aluno.setId(Integer.parseInt(this.telaAluno.getjTextFieldID().getText()));
                AlunoService.Atualizar(aluno);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaAluno.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaAluno.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaAluno.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaAluno buscaAluno = new TelaBuscaAluno(null, true);
            ControllerBuscaAluno controllerBuscaAluno = new ControllerBuscaAluno(buscaAluno);
            buscaAluno.setVisible(true);
            
             if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaAluno.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaAluno.getjPanelDados().getComponents());
                Aluno aluno = AlunoService.Buscar(codigo);
                this.telaAluno.getjTextFieldID().setText(aluno.getId() + "");
                this.telaAluno.getjTextFieldNome().setText(aluno.getNome());
                this.telaAluno.getjFormattedTextFieldRG().setText(aluno.getRg());
                this.telaAluno.getjFormattedTextFieldCPF().setText(aluno.getCpf());
                this.telaAluno.getjFormattedTextFieldDataNascimento().setText(ControllerUtils.filtrarData(aluno.getDtNascimento()));
                
                Cep cep = CepService.Buscar(aluno.getCep_idCep());
                this.telaAluno.getjFormattedTextFieldCEP().setText(cep.getCep());
                
                this.telaAluno.getjTextFieldComplemento().setText(aluno.getCompleEndereco());
                this.telaAluno.getjTextFieldEmail().setText(aluno.getEmail());
                this.telaAluno.getjFormattedTextFieldTelefone1().setText(aluno.getFone1());
                this.telaAluno.getjFormattedTextFieldTelefone2().setText(aluno.getFone2());
                this.telaAluno.getjTextFieldObservacao().setText(aluno.getObservacao());
                
                this.telaAluno.getjTextFieldID().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaAluno.getjBotaoSair()) {
            this.telaAluno.dispose();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent d) {
       ControllerUtils.checarCEP(
            this.telaAluno.getjFormattedTextFieldCEP().getText(),
            this.telaAluno.getjFormattedTextFieldCEP(),
            this.telaAluno.getjTextFieldCidade(),
            this.telaAluno.getjTextFieldBairro(),
            this.telaAluno.getjTextFieldLogradouro()
       );
    }

    @Override
    public void removeUpdate(DocumentEvent d) {
        ControllerUtils.checarCEP(
            this.telaAluno.getjFormattedTextFieldCEP().getText(),
            this.telaAluno.getjFormattedTextFieldCEP(),
            this.telaAluno.getjTextFieldCidade(),
            this.telaAluno.getjTextFieldBairro(),
            this.telaAluno.getjTextFieldLogradouro()
        );
    }

    @Override
    public void changedUpdate(DocumentEvent d) {}
}
