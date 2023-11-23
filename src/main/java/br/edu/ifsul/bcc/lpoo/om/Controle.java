
package br.edu.ifsul.bcc.lpoo.om;

import br.edu.ifsul.bcc.lpoo.om.gui.JFramePrincipal;
import br.edu.ifsul.bcc.lpoo.om.gui.JMenuBarHome;
import br.edu.ifsul.bcc.lpoo.om.gui.JPanelHome;
import br.edu.ifsul.bcc.lpoo.om.gui.autenticacao.JPanelAutenticacao;
import br.edu.ifsul.bcc.lpoo.om.gui.funcionario.JPanelAFuncionario;
import br.edu.ifsul.bcc.lpoo.om.model.Funcionario;
import br.edu.ifsul.bcc.lpoo.om.model.dao.PersistenciaJDBC;
import javax.swing.JOptionPane;

public class Controle {
    
    private JFramePrincipal jframe;
    private PersistenciaJDBC conexaoJDBC;
    private JPanelAutenticacao telaAutenticacao;
    private JMenuBarHome menuBar;
    private JPanelHome telaHome;
    private JPanelAFuncionario telaFuncionario;
    
    public Controle(){
        
    }
    
    public boolean conectarBD() throws Exception {
        conexaoJDBC = new PersistenciaJDBC();
        if(getConexaoJDBC() != null){
            return getConexaoJDBC().conexaoAberta();
        }
        
        return false;
        
    }
    
    protected void initComponents(){
        
        jframe = new JFramePrincipal();
        
        telaAutenticacao = new JPanelAutenticacao(this);
        
        menuBar = new JMenuBarHome(this);
        
        telaHome = new JPanelHome(this);
        
        telaFuncionario = new JPanelAFuncionario(this);
        
        jframe.addTela(telaAutenticacao, "tela_autenticacao");
        
        jframe.addTela(telaHome, "tela_home"); //adiciona tela home (só mostra se aprova login)
        
        jframe.addTela(telaFuncionario, "tela_funcionario");
        
        jframe.showTela("tela_autenticacao");
        
      
        
      
        
        jframe.setVisible(true); //mostrando o JFrame
    }

    public PersistenciaJDBC getConexaoJDBC() {
        return conexaoJDBC;
    }
    
      public void autenticar(String cpf, String senha) {
       
        try{

            Funcionario f =  conexaoJDBC.doLogin(cpf, senha);
            
            if(f != null){

                JOptionPane.showMessageDialog(telaAutenticacao, "Funcionario "+f.getCpf()+" autenticado com sucesso!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);

                jframe.setJMenuBar(menuBar);//adiciona o menu de barra no frame
                jframe.showTela("tela_home");//muda a tela para o painel de boas vindas (home)

            }else{

                JOptionPane.showMessageDialog(telaAutenticacao, "Dados inválidos!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(telaAutenticacao, "Erro ao executar a autenticação no Banco de Dados!", "Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    public void showTela(String nomeTela){
         
        //para cada nova tela de CRUD adicionar um elseif
        //chama esse metodo pois em funcionarios tem 3 telas, entao precisa fazer um novo controle 
        // escolhe tela, escolhe qual das 3 vai chamar e chama metodos para escolher telas que estao dentro da primeira escolhida
        
         if(nomeTela.equals("tela_funcionario")){
             
            telaFuncionario.showTela("tela_funcionario_listagem");               
         }
         
         jframe.showTela(nomeTela);   
    }
    
}
