
package br.edu.ifsul.bcc.lpoo.om.gui.funcionario;

import br.edu.ifsul.bcc.lpoo.om.Controle;
import br.edu.ifsul.bcc.lpoo.om.model.Cargo;
import br.edu.ifsul.bcc.lpoo.om.model.Funcionario;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JPanelAFuncionarioFormulario extends JPanel implements ActionListener{

    private JPanelAFuncionario pnlAFuncionario;
    private Controle controle;
    
    private BorderLayout borderLayout;
    private JTabbedPane tbpAbas;
    
    private JPanel pnlDadosCadastrais;    
    private JPanel pnlCentroDadosCadastrais;
    
    private GridBagLayout gridBagLayoutDadosCadastrais;
    private JLabel lblCPF;
    private JTextField txfCPF;
    
    private JLabel lblNome;
    private JTextField txfNome;

    private JLabel lblSenha;
    private JPasswordField txfSenha;
    
    private JLabel lblCargo;
    private JComboBox cbxCargo;
            
    private JLabel lblDataAdmissao;
    private JTextField txfDataAdmissao;
    
    
    private JLabel lblCTPS;
    private JTextField txfCTPS;
     
    
    private Funcionario funcionario;
    private SimpleDateFormat format;
    
    private JPanel pnlSul;
    private JButton btnGravar;
    private JButton btnCancelar;
    
    
      public JPanelAFuncionarioFormulario(JPanelAFuncionario pnlAFuncionario, Controle controle){
        
        this.pnlAFuncionario = pnlAFuncionario;
        this.controle = controle;
        
        initComponents();
        
    }    
    
     
    private void initComponents(){
        
        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        
        tbpAbas = new JTabbedPane();
        this.add(tbpAbas, BorderLayout.CENTER);
        
        pnlDadosCadastrais = new JPanel();
        gridBagLayoutDadosCadastrais = new GridBagLayout();
        pnlDadosCadastrais.setLayout(gridBagLayoutDadosCadastrais);
        
        lblCPF = new JLabel("CPF:");
        GridBagConstraints posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        pnlDadosCadastrais.add(lblCPF, posicionador);//o add adiciona o rotulo no painel  
        
        txfCPF = new JTextField(20);        
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        posicionador.anchor = java.awt.GridBagConstraints.LINE_START;//ancoragem a esquerda.
        pnlDadosCadastrais.add(txfCPF, posicionador);//o add adiciona o rotulo no painel  
          
        lblNome = new JLabel("Nome:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        pnlDadosCadastrais.add(lblNome, posicionador);//o add adiciona o rotulo no painel  
        
        txfNome = new JTextField(30);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        posicionador.anchor = java.awt.GridBagConstraints.LINE_START;//ancoragem a esquerda.
        pnlDadosCadastrais.add(txfNome, posicionador);//o add adiciona o rotulo no painel  
             
        lblSenha = new JLabel("Senha:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 3;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        pnlDadosCadastrais.add(lblSenha, posicionador);//o add adiciona o rotulo no painel  
        
        txfSenha = new JPasswordField(10);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 3;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        posicionador.anchor = java.awt.GridBagConstraints.LINE_START;//ancoragem a esquerda.
        pnlDadosCadastrais.add(txfSenha, posicionador);//o add adiciona o rotulo no painel  
     
        lblCTPS = new JLabel("CTPS:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 5;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        pnlDadosCadastrais.add(lblCTPS, posicionador);//o add adiciona o rotulo no painel  
                
        txfCTPS = new JTextField(5);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 5;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        posicionador.anchor = java.awt.GridBagConstraints.LINE_START;//ancoragem a esquerda.
        pnlDadosCadastrais.add(txfCTPS, posicionador);//o add adiciona o rotulo no painel  
     
        
        lblCargo = new JLabel("Cargo:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 6;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        posicionador.anchor = java.awt.GridBagConstraints.LINE_START;//ancoragem a esquerda.
        pnlDadosCadastrais.add(lblCargo, posicionador);//o add adiciona o rotulo no painel  
                
        cbxCargo = new JComboBox();
        posicionador = new GridBagConstraints();
        posicionador.gridy = 6;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        posicionador.anchor = java.awt.GridBagConstraints.LINE_START;//ancoragem a esquerda.
        pnlDadosCadastrais.add(cbxCargo, posicionador);//o add adiciona o rotulo no painel 
                
                            
        lblDataAdmissao = new JLabel("Data de Admissão:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 7;//policao da linha (vertical)
        posicionador.gridx = 0;// posição da coluna (horizontal)
        pnlDadosCadastrais.add(lblDataAdmissao, posicionador);//o add adiciona o rotulo no painel         
        
        txfDataAdmissao = new JTextField(20);
        txfDataAdmissao.setEditable(false);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 7;//policao da linha (vertical)
        posicionador.gridx = 1;// posição da coluna (horizontal)
        pnlDadosCadastrais.add(txfDataAdmissao, posicionador);//o add adiciona o rotulo no painel         
        
        tbpAbas.addTab("Dados Cadastrais", pnlDadosCadastrais);
        
        pnlSul = new JPanel();
        pnlSul.setLayout(new FlowLayout());
        
        btnGravar = new JButton("Gravar");
        btnGravar.addActionListener(this);
        btnGravar.setFocusable(true);    //acessibilidade    
        btnGravar.setToolTipText("btnGravarJogador"); //acessibilidade
        btnGravar.setMnemonic(KeyEvent.VK_G);
        btnGravar.setActionCommand("botao_gravar_formulario_jogador");
        
        pnlSul.add(btnGravar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFocusable(true);    //acessibilidade    
        btnCancelar.setToolTipText("btnCancelarJogador"); //acessibilidade
        btnCancelar.setActionCommand("botao_cancelar_formulario_jogador");
        
        pnlSul.add(btnCancelar);
        
        this.add(pnlSul, BorderLayout.SOUTH);
        
        format = new SimpleDateFormat("dd/MM/yyyy");
        
    }
    
       public void populaComboCargo(){        
        cbxCargo.removeAllItems();//zera o combo
        DefaultComboBoxModel model =  (DefaultComboBoxModel) cbxCargo.getModel();
        model.addElement("Selecione"); //primeiro item    
        try{
            Collection <Cargo> listCargos = controle.getConexaoJDBC().listCargos();
             for (Cargo c : listCargos){
                 model.addElement(c.getDescricao());
             }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Erro ao carregar Cargos -: "+ex.getLocalizedMessage(), "Cargos", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            
           
        }        
        
                                
    }
       
      public Funcionario getFuncionariobyFormulario(){        
        //validacao do formulario
       if(txfCPF.getText().trim().length() == 11 && 
            txfNome.getText().trim().length() > 0 &&
            txfCTPS.getText().trim().length() > 0 &&
            new String(txfSenha.getPassword()).trim().length() > 3 && 
           cbxCargo.getSelectedIndex() > 0
               ){

            Funcionario f = new Funcionario();
                f.setCpf(txfCPF.getText().trim());    
                f.setSenha(new String(txfSenha.getPassword()).trim());
                String descricao = (String) cbxCargo.getSelectedItem();
                try{
                    Collection <Cargo> listaDeCargos = controle.getConexaoJDBC().listCargos();
                     for (Cargo cargo : listaDeCargos) {
                       if (cargo.getDescricao().equals(descricao)){
                           
                            f.setCargo(cargo);
                        }
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao encontrar Cargo -:"+ex.getLocalizedMessage(), "Cargo", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }      
              
                f.setNumero_ctps(txfCTPS.getText().trim());
                f.setNome(txfNome.getText().trim());
                
            if(funcionario != null)
                f.setData_admissao(funcionario.getData_admissao());
                        
            return f;
         }

         return null;
    }
      
         
    public void setFuncionarioFormulario(Funcionario f){
        if(f == null){//se o parametro estiver nullo, limpa o formulario
            txfCPF.setText("");
            txfCPF.setEditable(true);
            txfSenha.setText("");
            cbxCargo.setSelectedIndex(0);
            txfNome.setText("");
            txfDataAdmissao.setText("");
            txfCTPS.setText("");            
            funcionario = null;
        }else{
            funcionario = f;
            txfCPF.setEditable(false);
            txfCPF.setText(funcionario.getCpf());
            txfSenha.setText(funcionario.getSenha());
            cbxCargo.getModel().setSelectedItem(funcionario.getCargo().getDescricao());//aqui chama o método equals do classe Endereco
            txfNome.setText(funcionario.getNome()); 
            txfCTPS.setText(funcionario.getNumero_ctps());
            txfDataAdmissao.setText(format.format(f.getData_admissao().getTime()));                                 
        }

    }
    
  
    @Override
    public void actionPerformed(ActionEvent arg0) {
          if(arg0.getActionCommand().equals(btnGravar.getActionCommand())){
            
            Funcionario f = getFuncionariobyFormulario();//recupera os dados do formulario
            
            if(f != null){

                try {
                    
                    pnlAFuncionario.getControle().getConexaoJDBC().persist(f);
                    
                    JOptionPane.showMessageDialog(this, "Funcionario armazenado!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
                    
                    pnlAFuncionario.showTela("tela_funcionario_listagem");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar Funcionario! : "+ex.getMessage(), "Salvar", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }else{

                JOptionPane.showMessageDialog(this, "Preencha o formulário!", "Edição", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }else if(arg0.getActionCommand().equals(btnCancelar.getActionCommand())){
            
            
                pnlAFuncionario.showTela("tela_funcionario_listagem");
            
        }
    }
    
}
