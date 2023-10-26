
package br.edu.ifsul.bcc.lpoo.om;

import br.edu.ifsul.bcc.lpoo.om.gui.JFramePrincipal;
import br.edu.ifsul.bcc.lpoo.om.model.dao.PersistenciaJDBC;

public class Controle {
    
    private JFramePrincipal jframe;
    private PersistenciaJDBC conexaoJDBC;
    
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
        
        jframe.setVisible(true); //mostrando o JFrame
    }

    public PersistenciaJDBC getConexaoJDBC() {
        return conexaoJDBC;
    }

}
