package br.edu.ifsul.bcc.lpoo.om.test;

import br.edu.ifsul.bcc.lpoo.om.model.Cargo;
import br.edu.ifsul.bcc.lpoo.om.model.Curso;
import br.edu.ifsul.bcc.lpoo.om.model.Funcionario;
import br.edu.ifsul.bcc.lpoo.om.model.Veiculo;
import br.edu.ifsul.bcc.lpoo.om.model.dao.PersistenciaJPA;
import java.util.Calendar;
import java.util.Collection;
import org.junit.Test;

/**
 *
 * @author telmo
 */
public class TestPersistenciaJPA {

    //@Test
    public void testConexaoJPA() {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("conectou no BD via jpa ...");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    }

    //@Test
    public void testPersistenciaCargoJPA() throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {

            //Passo 1: encontrar o cargo id = 1
            Cargo cg = (Cargo) jpa.find(Cargo.class, new Integer("1"));
            if (cg != null) {
                //Passo 2: caso encontre, imprimir o id e a descricao, alterar e remover.
                System.out.println("Encontrou o cargo id=" + cg.getId() + " - " + cg.getDescricao());
                cg.setDescricao("descricao do cargo alterada");
                jpa.persist(cg);
                System.out.println("\tDescricao alterada: " + cg.getDescricao());
                jpa.remover(cg);
                System.out.println("\tRemoveu o cargo id:" + cg.getId());
            } else {
                //Passo 3: caso não encontre persistir um novo cargo.
                System.out.println("Não encontro o cargo, criando um novo");
                cg = new Cargo();
                cg.setDescricao("Cargo de teste");
                jpa.persist(cg);

            }

            System.out.println("testPersistenciaCargoJPA:: conectou no BD via jpa ...");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    }

    //@Test
    public void testPersistenciaListCargoJPA() throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            //Passo 1: recuperar a coleção de cargos.
            //Passo 2: caso a coleção não esteja vazia - imprimir, alterar e remover cada item.
            //Passo 3: caso a coleção esteja vazia, criar dois cargos.          
            System.out.println("testPersistenciaListCargoJPA:: conectou no BD via jpa ...");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");
        }
    }

    //@Test
    public void testPersistenciaListaFuncionarios() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();
        
        if(jpa.conexaoAberta()){
           
            Collection <Funcionario> lista = jpa.listFuncionarios();
           
           if (!lista.isEmpty()){
               
                for (Funcionario funcionario : lista){
                   System.out.println("Funcionário ID: " + funcionario.getCpf() + " Nome: " +
                           funcionario.getNome() + " Cursos: " + funcionario.getCursos() + "\n");
                   
                    funcionario.setNome("Joao");
                    jpa.persist(funcionario);
                    System.out.println("Nome funcionário alterados para: " + funcionario.getNome());
                    jpa.remover(funcionario);
                    System.out.println("Cargo: " + funcionario.getCpf() + " removido.");
               }
           } else {
               
               Curso curso1 = new Curso();
               curso1.setCargaHoraria(3500);
               curso1.setDescricao("Engenharia Meânica");
               Calendar conclusao = Calendar.getInstance();
               conclusao.set(2018, Calendar.DECEMBER, 18);
               jpa.persist(curso1);
               
               Curso curso2 = new Curso();
               curso2.setCargaHoraria(3000);
               curso2.setDescricao("Técnico em elétrica");
               Calendar conclusao2 = Calendar.getInstance();
               conclusao2.set(2023, Calendar.JULY, 25);
               jpa.persist(curso2);
               
               
                Funcionario funcionario1 = new Funcionario();
                funcionario1.setNumero_ctps("12345");
                Calendar admissao = Calendar.getInstance();
                admissao.set(2019, Calendar.MARCH, 19);
                funcionario1.setData_admissao(admissao);
                funcionario1.setNome("Mauricio");
                funcionario1.setCpf("85669325510");
                Calendar nasc = Calendar.getInstance();
                nasc.set(1990, Calendar.APRIL, 20);
                funcionario1.setSenha("xyz789");
                funcionario1.setData_nascimento(nasc);
                funcionario1.getCursos().add(curso1);
                jpa.persist(funcionario1);
                 System.out.println("Funcionário CPF: " + funcionario1.getCpf() + 
                        " Nome: " + funcionario1.getNome() + " Cursos: " + funcionario1.getCursos().toString() + 
                        " CTPS: " + funcionario1.getNumero_ctps() + " cadastrado com sucesso.");
              
                Funcionario funcionario2 = new Funcionario();
                funcionario2.setNumero_ctps("54321");
                Calendar admissao2 = Calendar.getInstance();
                admissao2.set(2023, Calendar.JANUARY, 23);
                funcionario2.setData_admissao(admissao2);
                funcionario2.setNome("Rafael");
                funcionario2.setCpf("96356244489");
                funcionario2.setSenha("abc123");
                Calendar nasc2 = Calendar.getInstance();
                nasc.set(1996, Calendar.AUGUST, 29);
                funcionario2.setData_nascimento(nasc);
                funcionario2.getCursos().add(curso2);
                jpa.persist(funcionario2);
                System.out.println("Funcionário CPF: " + funcionario2.getCpf() + 
                        " Nome: " + funcionario2.getNome() + " Cursos: " + funcionario2.getCursos().toString() + 
                        " CTPS: " + funcionario2.getNumero_ctps() + " cadastrado com sucesso.");
               
           }
           
        }
    }
    
 // @Test
    public void testInsereVeiculos() throws Exception {

        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("testPersistenciaListCargoJPA:: conectou no BD via jpa ...");

                Veiculo v = new Veiculo();
                v.setPlaca("ABC1234");
                v.setModelo("KÁ");
                jpa.persist(v);

                v = new Veiculo();
                v.setPlaca("XYZ6789");
                v.setModelo("PALIO WEEKEND");
                jpa.persist(v);

                v = new Veiculo();
                v.setPlaca("HIJ5648");
                v.setModelo("FIESTA");
                jpa.persist(v);
                
                v = new Veiculo();
                v.setPlaca("KLM5863");
                v.setModelo("KWID");
                jpa.persist(v);
                
            System.out.println("VEICULOS ADICIONADOS COM SUCESSO");
     

            jpa.fecharConexao();
        } else {
            System.out.println("Não conectou no BD...");
        }
    }

}
