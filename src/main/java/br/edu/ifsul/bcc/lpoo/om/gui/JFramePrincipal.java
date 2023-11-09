
package br.edu.ifsul.bcc.lpoo.om.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFramePrincipal extends JFrame {
    
    public CardLayout cardLayout;
    public JPanel painel;
    
    public JFramePrincipal(){
        
        initComponents();
        
    }
    
    private void initComponents(){
        //customização do JFrame
        //definindo / setando o titulo do Jframe
        this.setTitle("Sistema para CRUD - Oficina Mecânica"); 
        
        //definindo o tamanho mínimo
        this.setMinimumSize(new Dimension(600,600));
        
        //configuranco a abertura em modo maximizado por padrão
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //definindo o comportamento de fechar/finalizar o quando o jframe é fechado
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        cardLayout = new CardLayout(); //iniciando o gerenciador de layout para esta JFrame
        painel = new JPanel(); //inicializacao
                
        painel.setLayout(cardLayout);//definindo o cardLayout para o paineldeFundo
                
        this.add(painel);  //adiciona no JFrame o paineldeFundo
    }
    
    public void addTela(JPanel p, String nome){   
        
            painel.add(p, nome); //adiciona uma "carta no baralho".
    }

    public void showTela(String nome){
        
            cardLayout.show(painel, nome); //localiza a "carta no baralho" e mostra.
    }
    
}
