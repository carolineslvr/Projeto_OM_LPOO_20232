
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
      
    }
}
