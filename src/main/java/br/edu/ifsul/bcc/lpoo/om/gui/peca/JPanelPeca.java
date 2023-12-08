/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo.om.gui.peca;

import br.edu.ifsul.bcc.lpoo.om.Controle;
import java.awt.CardLayout;

/**
 *
 * @author Carol
 */
public class JPanelPeca extends javax.swing.JPanel {
    
    //CHAMANDO TELAS E CONTROLE

    private JPanelPecaFormulario formulario;
    private JPanelPecaListagem listagem;
    private Controle controle;
    
    //AJUSTE CONSTRUTOR
    public JPanelPeca(Controle controle) {
        this.controle = controle;
        initComponents();
        formulario = new JPanelPecaFormulario(this, controle);
        listagem = new JPanelPecaListagem(this, controle);
        
        //ADICIONANDO TELAS SECUNDARIAS
        this.add(listagem, "tela_peca_listagem");
        this.add(formulario, "tela_peca_formulario");
        
        //CHAMANDO TELA LISTAGEM
        
        showTela("tela_peca_listagem");
        
    }
    //CRIADO METODO SHOWTELA E FUNCOES QUE FARA EM CADA UMA
    public void showTela(String nomeTela){
        
        if(nomeTela.equals("tela_peca_listagem")){
            
          //  listagem.populaTable();
            
        }else if(nomeTela.equals("tela_peca_formulario")){
            
           // getFormulario().populaComboCargo();
            
        }
        
       ((CardLayout) this.getLayout()).show(this, nomeTela);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
