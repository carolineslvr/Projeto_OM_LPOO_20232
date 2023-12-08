/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo.om.gui.cliente;

import br.edu.ifsul.bcc.lpoo.om.Controle;
import br.edu.ifsul.bcc.lpoo.om.model.Cliente;
import br.edu.ifsul.bcc.lpoo.om.model.Funcionario;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carol
 */
public class JPanelClienteListagem extends javax.swing.JPanel {

    private JPanelCliente pnlCliente;
    private Controle controle;
    /**
     * Creates new form JPanelClienteListagm
     */
    public JPanelClienteListagem(JPanelCliente pnlCliente, Controle controle) {
        this.pnlCliente = pnlCliente;
        this.controle = controle;
        initComponents();
        populaTable();
    }
    
     public void populaTable(){
        
        DefaultTableModel model =  (DefaultTableModel) tblListagemCliente.getModel();//recuperacao do modelo da tabela

        model.setRowCount(0);//elimina as linhas existentes (reset na tabela)

        try {

            Collection <Cliente> listClientes =  controle.getConexaoJDBC().listClientes2();
            for(Cliente c : listClientes){
                model.addRow(new Object[]{c, //aqui chamou o to string
                                          c.getNome(), 
                                          c.getSenha()});
                                     

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Erro ao listar Clientes -:"+ex.getLocalizedMessage(), "Clientes", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSul = new javax.swing.JPanel();
        btnRemover = new javax.swing.JButton();
        pnlCentro = new javax.swing.JPanel();
        jspCliente = new javax.swing.JScrollPane();
        tblListagemCliente = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        pnlSul.add(btnRemover);

        add(pnlSul, java.awt.BorderLayout.PAGE_END);

        tblListagemCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspCliente.setViewportView(tblListagemCliente);

        pnlCentro.add(jspCliente);

        add(pnlCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
         
            int indice = tblListagemCliente.getSelectedRow();//recupera a linha selecionada
            if(indice > -1){

                DefaultTableModel model =  (DefaultTableModel) tblListagemCliente.getModel(); //recuperacao do modelo da table

                Vector linha = (Vector) model.getDataVector().get(indice);//recupera o vetor de dados da linha selecionada

                Cliente c = (Cliente) linha.get(0); //model.addRow(new Object[]{u, u.getNome(), ...

                try {
                    controle.getConexaoJDBC().remover(c);
                    JOptionPane.showMessageDialog(this, "Cliente removido!", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    populaTable(); //refresh na tabela

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao remover Cliente -:"+ex.getLocalizedMessage(), "Cliente", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }                        

            }else{
                  JOptionPane.showMessageDialog(this, "Selecione uma linha para remover!", "Remoção", JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspCliente;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlSul;
    private javax.swing.JTable tblListagemCliente;
    // End of variables declaration//GEN-END:variables
}
