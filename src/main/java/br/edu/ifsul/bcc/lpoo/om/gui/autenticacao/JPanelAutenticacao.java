
package br.edu.ifsul.bcc.lpoo.om.gui.autenticacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JPanelAutenticacao  extends JPanel{
    
    private JLabel lblCPF;
    private JLabel lblSenha;
    private JTextField txfCPF;
    private JPasswordField psfSenha;
    private JButton btnLogar;
    private Border defaultBorder;
    
    public JPanelAutenticacao(){
        initComponents();
    }
    
    private void initComponents(){
        
    }
    
}
