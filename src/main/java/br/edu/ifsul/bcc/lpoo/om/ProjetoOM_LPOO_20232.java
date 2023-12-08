
package br.edu.ifsul.bcc.lpoo.om;

import javax.swing.JOptionPane;

public class ProjetoOM_LPOO_20232 {
    
    private Controle controle;
    
    public ProjetoOM_LPOO_20232(){
        
        try{
            
           controle = new Controle();
           
           if (controle.conectarBD()){
                JOptionPane.showMessageDialog(null, "Conectado com sucesso no banco de Dados!", "Banco de dados", 
                       JOptionPane.PLAIN_MESSAGE);
               controle.initComponents();
           } else {
               JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de Dados!", "Banco de dados", 
                       JOptionPane.ERROR_MESSAGE);
           }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados: " + ex.getMessage(), "Banco de Dados", 
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       
    }

    public static void main(String[] args) {
        
        new ProjetoOM_LPOO_20232(); //instanciando a calsse
        
        //dados autenticacao
        //cpf: 12345678912
        //senha: 123456
      
        //primeiro criar tela geral
        //criar tela listagem
        //criar tela formulario
        //chamar telas formulario e listagem na tela geral
        //chamar controle na tela geral
        //ajustar construtor tela geral
        //colocar metodo show tela na tela principal echamar listagem
        
        //NO CONTROLE
        //instanciar tela geral
        //no initcomponents adicionar essa tela geral
        //no show tela colocar se for a tela geral chamar listagem
        
        //no MENU 
        //criar novo item para chamar tela JMenuItem
        //configurar item - criar evento de acao e adicionar ao menu
        //no teste de actionlistener do menu add item novo criado
    }
}
