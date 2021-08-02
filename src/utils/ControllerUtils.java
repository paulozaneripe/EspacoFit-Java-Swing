package utils;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.bo.Bairro;
import model.bo.Cep;
import model.bo.Cidade;
import service.BairroService;
import service.CepService;
import service.CidadeService;

public class ControllerUtils {
    
    public static void Ativa(boolean estadoBotoes, Component[] componentes) {
        
        for (Component componente : componentes) {
            if(componente instanceof JButton) {
                if("Novo".equals(((JButton)componente).getText())) {
                    componente.setEnabled(estadoBotoes);
                }
                
                if("Cancelar".equals(((JButton)componente).getText())) {
                    componente.setEnabled(!estadoBotoes);
                }
                
                if("Gravar".equals(((JButton)componente).getText())) {
                    componente.setEnabled(!estadoBotoes);
                }
                                
                if("Buscar".equals(((JButton)componente).getText())) {
                    componente.setEnabled(estadoBotoes);
                }
                                                
                if("Sair".equals(((JButton)componente).getText())) {
                    componente.setEnabled(estadoBotoes);
                }
                
                if("...".equals(((JButton)componente).getText())) {
                    componente.setEnabled(estadoBotoes);
                }
                
                if("Pesquisar Produto".equals(((JButton)componente).getText())) {
                    componente.setEnabled(estadoBotoes);
                }
            }
        }
    }
    
    public static void LimpaEstadoComponentes(boolean estadoCompo, Component[] componentes) {
        
        for (Component componente : componentes) {
            if(componente instanceof JTextField) {
                ((JTextField) componente).setText("");
                componente.setEnabled(estadoCompo);
            }
            
            if(componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
                componente.setEnabled(estadoCompo);
                
                CaretAtStart((JFormattedTextField) componente);
            }
            
            if(componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedItem(0);
                componente.setEnabled(estadoCompo);
            }
            
            if(componente instanceof JTextArea) {
                componente.setEnabled(estadoCompo);
                ((JTextArea) componente).setText("");
                ((JTextArea) componente).setEditable(estadoCompo);
            }
            
            if(componente instanceof JScrollPane) {
                componente.setEnabled(true);
            }
        }
    }
        
    public static void CaretAtStart(JFormattedTextField e) {
        e.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                JFormattedTextField field = ((JFormattedTextField)e.getComponent());
                field.selectAll();
                field.setCaretPosition(0);
            }
        });
    }
        
    public static String filtrarData(Date data) {
        Date dt = new Date();
        dt = data;
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        // Para usar no Windows -> Adiciona mais um dia
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = formatter.format(dt);
        return dataNascimento;
    }

    public static void checarCEP(String cep, JFormattedTextField FieldCEP, JTextField FieldCidade, JTextField FieldBairro, JTextField FieldLogradouro) {
        cep = cep.replaceAll("[^0-9]", "");
        
        FieldCEP.setCaretPosition(0);
        
        if(cep.length() >= 8) {
            
            List<Cep> listaCeps = new ArrayList<>();
        
            listaCeps = CepService.Buscar();
            
            for(Cep cepDaLista : listaCeps){
                if(cepDaLista.getCep().equals(cep)) {
                    
                    int idCidade = cepDaLista.getIdCidade();
                    int idBairro = cepDaLista.getIdBairro();
                    
                    Cidade cidade = CidadeService.Buscar(idCidade);
                    Bairro bairro = BairroService.Buscar(idBairro);
                    
                    FieldCidade.setText(cidade.getDescricao());
                    FieldBairro.setText(bairro.getDescricao());
                    
                    FieldLogradouro.setText(cepDaLista.getLogradouro());
                      
                    FieldCidade.setEnabled(true);
                    FieldBairro.setEnabled(true);
                    FieldLogradouro.setEnabled(true);
                }
            }
        } else {
            FieldCidade.setText("");
            FieldBairro.setText("");
            FieldLogradouro.setText("");
            FieldCidade.setEnabled(false);
            FieldBairro.setEnabled(false);
            FieldLogradouro.setEnabled(false);
        }
    }
    
    public static String formatString(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }
}
