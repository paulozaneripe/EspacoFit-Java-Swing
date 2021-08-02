package controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Float.parseFloat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Aluno;
import model.bo.Bairro;
import model.bo.Cep;
import model.bo.Cidade;
import model.bo.ItemVenda;
import model.bo.Personal;
import model.bo.Produto;
import model.bo.Receber;
import model.bo.Venda;
import service.AlunoService;
import service.BairroService;
import service.CepService;
import service.PersonalService;
import service.ProdutoService;
import service.CidadeService;
import service.ItemVendaService;
import service.ReceberService;
import service.VendaService;
import view.TelaVendas;
import utils.ControllerUtils;
import view.TelaBuscaAluno;
import view.TelaBuscaPersonal;
import view.TelaBuscaProduto;

public class ControllerFaturamento implements ActionListener {

    TelaVendas telaVendas = new TelaVendas(null, true);
    public static int codigo;
    float total = 0;

    TelaBuscaAluno buscaAluno = new TelaBuscaAluno(null, true);

    public ControllerFaturamento(TelaVendas telaCid) {
        this.telaVendas = telaCid;

        codigo = 0;

        this.telaVendas.getjBotaoCodigoBarra().addActionListener(this);
        this.telaVendas.getjBotaoAluno().addActionListener(this);
        this.telaVendas.getjBotaoPersonal().addActionListener(this);

        ControllerUtils.LimpaEstadoComponentes(false, this.telaVendas.getjPanelCodigoBarra().getComponents());
        ControllerUtils.Ativa(false, this.telaVendas.getjPanelCodigoBarra().getComponents());
        ControllerUtils.Ativa(false, this.telaVendas.getjPanelInfo().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaVendas.getjPanelUsuario().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaVendas.getjPanelInfo().getComponents());

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (KeyEvent.KEY_PRESSED == e.getID()) {
                    if (e.getKeyCode() == KeyEvent.VK_F1) {
                        InserirItem();
                    } else if (e.getKeyCode() == KeyEvent.VK_F2) {
                        novoFaturamento();
                    } else if (e.getKeyCode() == KeyEvent.VK_F3) {
                        cancelarFaturamento();
                    } else if (e.getKeyCode() == KeyEvent.VK_F4) {
                        encerrarFaturamento();
                    } else if (e.getKeyCode() == KeyEvent.VK_F5) {
                        cancelarItemFaturado();
                    }
                }
                return false;
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.telaVendas.getjBotaoCodigoBarra()) {
            codigo = 0;
            TelaBuscaProduto buscaProduto = new TelaBuscaProduto(null, true);
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
            buscaProduto.setVisible(true);

            if (codigo != 0) {
                Produto produto = ProdutoService.Buscar(codigo);
                this.telaVendas.getjFormattedTextFieldCodigoBarra().setText(1 + produto.getBarra() + "");
            }
        }

        if (e.getSource() == this.telaVendas.getjBotaoAluno()) {
            codigo = 0;
            TelaBuscaAluno buscaAluno = new TelaBuscaAluno(null, true);
            ControllerBuscaAluno controllerBuscaAluno = new ControllerBuscaAluno(buscaAluno);
            buscaAluno.setVisible(true);

            if (codigo != 0) {
                Aluno aluno = AlunoService.Buscar(codigo);
                this.telaVendas.getjTextFieldIdAluno().setText(aluno.getId() + "");
                this.telaVendas.getjTextFieldIdAluno().setEnabled(false);
                this.telaVendas.getjTextFieldNome().setText(aluno.getNome());
                this.telaVendas.getjTextFieldNome().setEnabled(true);
                this.telaVendas.getjTextFieldEmail().setText(aluno.getEmail());
                this.telaVendas.getjTextFieldEmail().setEnabled(true);
                this.telaVendas.getjFormattedTextFieldFone().setText(aluno.getFone1());
                this.telaVendas.getjFormattedTextFieldFone().setEnabled(true);
                Cep cep = CepService.Buscar(aluno.getCep_idCep());
                Cidade cidade = CidadeService.Buscar(cep.getIdCidade());
                Bairro bairro = BairroService.Buscar(cep.getIdBairro());
                this.telaVendas.getjTextFieldCidade().setText(cidade.getDescricao());
                this.telaVendas.getjTextFieldCidade().setEnabled(true);
                this.telaVendas.getjTextFieldBairro().setText(bairro.getDescricao());
                this.telaVendas.getjTextFieldBairro().setEnabled(true);

                if (!this.telaVendas.getjTextFieldIdPersonal().getText().equals("")) {
                    this.telaVendas.getjBotaoCodigoBarra().setEnabled(true);
                }
            }

        }

        if (e.getSource() == this.telaVendas.getjBotaoPersonal()) {
            codigo = 0;
            TelaBuscaPersonal buscaPersonal = new TelaBuscaPersonal(null, true);
            ControllerBuscaPersonal controllerBuscaPersonal = new ControllerBuscaPersonal(buscaPersonal);
            buscaPersonal.setVisible(true);

            if (codigo != 0) {
                Personal personal = PersonalService.Buscar(codigo);

                this.telaVendas.getjTextFieldIdPersonal().setText(personal.getId() + "");
                this.telaVendas.getjTextFieldIdPersonal().setEnabled(false);
                this.telaVendas.getjTextFieldNomePersonal().setText(personal.getNome());
                this.telaVendas.getjTextFieldNomePersonal().setEnabled(true);

                if (!this.telaVendas.getjTextFieldIdAluno().getText().equals("")) {
                    this.telaVendas.getjBotaoCodigoBarra().setEnabled(true);
                }
            }
        }
    }

    public void InserirItem() {

            if (this.telaVendas.getjFormattedTextFieldCodigoBarra().getText().length() >= 12) {
                String[] result = this.telaVendas.getjFormattedTextFieldCodigoBarra().getText().split("x");
                String codigoBarra = result[1].replaceAll("\\s+", "");
                Produto produto;
                produto = ProdutoService.Buscar(codigoBarra);

                DefaultTableModel tabelaItens = (DefaultTableModel) this.telaVendas.getjTableVenda().getModel();
                int quantidade = Integer.parseInt(result[0].replaceAll("\\s+", ""));
                tabelaItens.addRow(new Object[]{tabelaItens.getRowCount() + 1, produto.getId(), produto.getDescricao(), result[0], produto.getValor(), produto.getValor() * quantidade});

                total = total + (produto.getValor() * quantidade);
                this.telaVendas.getjLabelPrecoTotal().setText(total + "");

            } else {
                JOptionPane.showMessageDialog(null, "Código de barras invalido");
            }
    }

    public void buscarProdutos() {

    }

    public void novoFaturamento() {
        if(this.telaVendas.getjFormattedTextFieldData().getText().equals("")) {
            ControllerUtils.LimpaEstadoComponentes(true, this.telaVendas.getjPanelCodigoBarra().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaVendas.getjPanelUsuario().getComponents());
            ControllerUtils.Ativa(true, this.telaVendas.getjPanelCodigoBarra().getComponents());
            ControllerUtils.Ativa(true, this.telaVendas.getjPanelInfo().getComponents());

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            this.telaVendas.getjFormattedTextFieldData().setText(ControllerUtils.filtrarData(date) + "");
            this.telaVendas.getjFormattedTextFieldHora().setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
        }
    }

    public void cancelarFaturamento() {
        DefaultTableModel tabelaItens = (DefaultTableModel) this.telaVendas.getjTableVenda().getModel();

        ControllerUtils.LimpaEstadoComponentes(false, this.telaVendas.getjPanelCodigoBarra().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaVendas.getjPanelInfo().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaVendas.getjPanelUsuario().getComponents());
        ControllerUtils.Ativa(false, this.telaVendas.getjPanelCodigoBarra().getComponents());

        ControllerUtils.Ativa(false, this.telaVendas.getjPanelInfo().getComponents());

        this.telaVendas.getjLabelPrecoTotal().setText("00000");

        int rowCount = tabelaItens.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelaItens.removeRow(i);
        }
    }

    public void encerrarFaturamento() {
        if (this.telaVendas.getjTextFieldIdAluno().getText().equals("") || this.telaVendas.getjTextFieldIdPersonal().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            codigo = 0;
            
            Venda venda = new Venda();
            ItemVenda itemVenda = new ItemVenda();
            Receber receber = new Receber();
            
            String[] result = this.telaVendas.getjFormattedTextFieldCodigoBarra().getText().split("x");
            String codigoBarra = result[1].replaceAll("\\s+", "");
            
            System.out.println(this.telaVendas.getjTableVenda().getRowCount());
            
            //Atualizando informações na tabela Venda
            venda.setIdAluno(Integer.parseInt(this.telaVendas.getjTextFieldIdAluno().getText()));
            venda.setIdPersonal(Integer.parseInt(this.telaVendas.getjTextFieldIdPersonal().getText()));
            venda.setValorTotal(parseFloat(this.telaVendas.getjLabelPrecoTotal().getText()));
            venda.setBairroAluno(this.telaVendas.getjTextFieldBairro().getText());
            venda.setCidadeAluno(this.telaVendas.getjTextFieldCidade().getText());
            venda.setEmailAluno(this.telaVendas.getjTextFieldEmail().getText());
            VendaService.Incluir(venda);
            
            //Atualizando estoque na tabela Produto
            Produto produto;
            produto = ProdutoService.Buscar(codigoBarra);
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - Integer.parseInt(result[0].replaceAll("\\s+", "")));
            ProdutoService.Atualizar(produto);

            //Gravando informações na tabela itemVenda
            itemVenda.setIdVenda(venda.getId());
            itemVenda.setQtdItemVenda(Integer.parseInt(result[0].replaceAll("\\s+", "")));
            itemVenda.setIdProduto(produto.getId());
            itemVenda.setValorUnitario(produto.getValor());   
            ItemVendaService.Incluir(itemVenda);

            //Gravando informações na tabela Receber
            receber.setIdVenda(venda.getId());
            receber.setValorEmitido(parseFloat(this.telaVendas.getjLabelPrecoTotal().getText()));
            receber.setValorDesconto(0); //???
            receber.setValorAcrescimo(0); //???
            receber.setValorPago(0); //???
            ReceberService.Incluir(receber);
            cancelarFaturamento();
        }

    }

    public void cancelarItemFaturado() {
        DefaultTableModel tabelaItens = (DefaultTableModel) this.telaVendas.getjTableVenda().getModel();

        int row = this.telaVendas.getjTableVenda().getRowCount() - 1;
        float value = parseFloat(this.telaVendas.getjTableVenda().getModel().getValueAt(row, 5).toString());
        total = total - value;
        this.telaVendas.getjLabelPrecoTotal().setText(total + "");

        tabelaItens.removeRow(tabelaItens.getRowCount() - 1);
    }
}
