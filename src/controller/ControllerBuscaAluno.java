package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaAluno;
import model.bo.Aluno;
import model.bo.Cep;
import service.AlunoService;
import service.CepService;
import utils.ControllerUtils;

public class ControllerBuscaAluno implements ActionListener {
    
    TelaBuscaAluno buscaAluno = new TelaBuscaAluno(null, true);
    
    public ControllerBuscaAluno(TelaBuscaAluno buscaAluno){
        this.buscaAluno = buscaAluno;
        
        this.buscaAluno.getjBotaoCarregar().addActionListener(this);
        this.buscaAluno.getjBotaoDeletar().addActionListener(this);
        this.buscaAluno.getjBotaoSair().addActionListener(this);
        
        List<Aluno> listaAlunos = new ArrayList<>();
        
        listaAlunos = AlunoService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaAluno.getjTable1().getModel();
        
        for(Aluno alunoDaLista : listaAlunos){
            Cep cep = new Cep();
            cep = CepService.Buscar(alunoDaLista.getCep_idCep());
            
            tabela.addRow(new Object[]{
                alunoDaLista.getId(),
                alunoDaLista.getNome(),
                ControllerUtils.formatString(alunoDaLista.getRg(),"##.###.###-#"),
                ControllerUtils.formatString(alunoDaLista.getCpf(),"###.###.###-##"),
                ControllerUtils.filtrarData(alunoDaLista.getDtNascimento()),
                ControllerUtils.formatString(cep.getCep(),"#####-###"),
                alunoDaLista.getCompleEndereco(),
                alunoDaLista.getEmail(),
                ControllerUtils.formatString(alunoDaLista.getFone1(),"(##) #####-####"),
                ControllerUtils.formatString(alunoDaLista.getFone2(),"(##) #####-####"),
                alunoDaLista.getObservacao()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaAluno.getjBotaoCarregar()){
            ControllerAluno.codigo = (int) this.buscaAluno.getjTable1().getValueAt(this.buscaAluno.getjTable1().getSelectedRow(), 0);
            ControllerFaturamento.codigo = (int) this.buscaAluno.getjTable1().getValueAt(this.buscaAluno.getjTable1().getSelectedRow(), 0);
            this.buscaAluno.dispose();
        }
        
        if(e.getSource() == this.buscaAluno.getjBotaoDeletar()){
            int id = (int) this.buscaAluno.getjTable1().getValueAt(this.buscaAluno.getjTable1().getSelectedRow(), 0);
            AlunoService.Deletar(id);
            
            List<Aluno> listaAlunos = new ArrayList<>();
            
            listaAlunos = service.AlunoService.Buscar();
        
            DefaultTableModel tabela = (DefaultTableModel) this.buscaAluno.getjTable1().getModel();
            
            tabela.setRowCount(0);
        
            for(Aluno alunoDaLista : listaAlunos){
                Cep cep = new Cep();
                cep = CepService.Buscar(alunoDaLista.getCep_idCep());

                tabela.addRow(new Object[]{
                    alunoDaLista.getId(),
                    alunoDaLista.getNome(),
                    ControllerUtils.formatString(alunoDaLista.getRg(),"##.###.###-#"),
                    ControllerUtils.formatString(alunoDaLista.getCpf(),"###.###.###-##"),
                    ControllerUtils.filtrarData(alunoDaLista.getDtNascimento()),
                    ControllerUtils.formatString(cep.getCep(),"#####-###"),
                    alunoDaLista.getCompleEndereco(),
                    alunoDaLista.getEmail(),
                    ControllerUtils.formatString(alunoDaLista.getFone1(),"(##) #####-####"),
                    ControllerUtils.formatString(alunoDaLista.getFone2(),"(##) #####-####"),
                    alunoDaLista.getObservacao()
                });
            }
        }
        
        if(e.getSource() == this.buscaAluno.getjBotaoSair()){
            this.buscaAluno.dispose();
        }
    }
}
