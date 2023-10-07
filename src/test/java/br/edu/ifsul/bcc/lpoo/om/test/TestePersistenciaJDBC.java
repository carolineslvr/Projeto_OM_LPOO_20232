package br.edu.ifsul.bcc.lpoo.om.test;

import br.edu.ifsul.bcc.lpoo.om.model.Cargo;
import br.edu.ifsul.bcc.lpoo.om.model.Cliente;
import br.edu.ifsul.bcc.lpoo.om.model.Curso;
import br.edu.ifsul.bcc.lpoo.om.model.Equipe;
import br.edu.ifsul.bcc.lpoo.om.model.Funcionario;
import br.edu.ifsul.bcc.lpoo.om.model.MaoObra;
import br.edu.ifsul.bcc.lpoo.om.model.Orcamento;
import br.edu.ifsul.bcc.lpoo.om.model.Pagamento;
import br.edu.ifsul.bcc.lpoo.om.model.Peca;
import br.edu.ifsul.bcc.lpoo.om.model.Servico;
import br.edu.ifsul.bcc.lpoo.om.model.StatusServico;
import br.edu.ifsul.bcc.lpoo.om.model.Veiculo;
import br.edu.ifsul.bcc.lpoo.om.model.dao.PersistenciaJDBC;
import br.edu.ifsul.bcc.lpoo.om.model.dao.PersistenciaJPA;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author telmo
 */
public class TestePersistenciaJDBC {

    //implementar um metodo de teste para abrir e fechar uma conexao
    //usando apenas o jdbc.
    //@Test
    public void testConexaoJDBC() throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {
            System.out.println("conectou no BD via jdbc ...");
            jdbc.fecharConexao();
        } else {
            System.out.println("nao conectou no BD via jdbc ...");

        }
    }

    /*
        implementar o seguinte teste
        1) recuperar todos os cargos
        2) se existir ao menos um cargo, imprimir, alterar e remover.
        3) se não existir, criar dois cargos e imprimi.
     */
   // @Test
    public void testPersistenciaListCargoJDBC() throws Exception {
        //criar um objeto do tipo PersistenciaJDBC.
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {
            System.out.println("testPersistenciaListCargoJDBC:: conectou no BD via jdbc ...");
            //Passo 1: recuperar a coleção de cargos.
            Collection<Cargo> cll = jdbc.listCargos();
            if (!cll.isEmpty()) {
                //Passo 2: caso a coleção não esteja vazia - imprimir, alterar e remover cada item.
                for (Cargo c : cll) {
                    System.out.println("Cargo : " + c.getDescricao());
                    c.setDescricao("descricao alterada");
                    jdbc.persist(c);//alterar no banco.
                    //remove no bd
                    jdbc.remover(c);
                }
            } else {
                //Passo 3: caso a coleção esteja vazia, criar dois cargos.
                Cargo c = new Cargo();
                c.setDescricao("teste");
                jdbc.persist(c);
                System.out.println("Cadastrou o cargo :" + c.getId() + " : " + c.getDescricao());
            }

            jdbc.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");
        }
    }

    //Exercício 28/09
    /*
       Criar um método de teste para funcionario
         Passo 1: recuperar a coleção de funcionarios.
         Passo 2: caso a coleção não esteja vazia - imprimir (inclusive os cursos), 
                  alterar e remover cada item.
         Passo 3: caso a coleção esteja vazia, criar dois funcionarios com um Curso cada.
     */
    
     @Test
    public void testaPersistenciaListaFuncionario() throws Exception{
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if(jdbc.conexaoAberta()){
            
            Collection <Funcionario> listFuncionarios = jdbc.listFuncionarios();
            
            if(listFuncionarios.isEmpty()){
                  System.out.println("Lista de funcionários vazia, inserindo novo funcionário ...");
                  Curso curso1 = new Curso();
                  curso1.setCargaHoraria(3500);
                  curso1.setDescricao("Engenharia Meânica");
                  Calendar conclusao = Calendar.getInstance();
                  conclusao.set(2018, Calendar.DECEMBER, 18);
                  jdbc.persist(curso1);
               
                  Curso curso2 = new Curso();
                  curso2.setCargaHoraria(3000);
                  curso2.setDescricao("Técnico em elétrica");
                  Calendar conclusao2 = Calendar.getInstance();
                  conclusao2.set(2023, Calendar.JULY, 25);
                  jdbc.persist(curso2);
                  
                  Cargo c = new Cargo();
                  c.setDescricao("CARGO TEMPORARIO");
                  jdbc.persist(c);
               
                  Funcionario funcionario1 = new Funcionario();
                  funcionario1.setNumero_ctps("12345");
                  //Calendar admissao = Calendar.getInstance();
                  //admissao.set(2019, Calendar.MARCH, 19);
                  //funcionario1.setData_admissao(admissao);
                  funcionario1.setNome("Mauricio");
                  funcionario1.setCpf("85669325510");
                  funcionario1.setCargo(c);
                  Calendar nasc = Calendar.getInstance();
                  nasc.set(1990, Calendar.APRIL, 20);
                  funcionario1.setSenha("xyz789");
                  funcionario1.setData_nascimento(nasc);
                  funcionario1.getCursos().add(curso1);
                  jdbc.persist(funcionario1);
                 
                List<String> nomesCursos = new ArrayList<>();
                for (Curso curso : funcionario1.getCursos()) {
                   nomesCursos.add(curso.getDescricao());
                }
                 
                  
                 System.out.println("Funcionário CPF: " + funcionario1.getCpf() + 
                        " Nome: " + funcionario1.getNome() + " Cursos: " + nomesCursos + 
                        " CTPS: " + funcionario1.getNumero_ctps() + " cadastrado com sucesso.");
              
                Funcionario funcionario2 = new Funcionario();
                funcionario2.setNumero_ctps("54321");
                //Calendar admissao2 = Calendar.getInstance();
                //admissao2.set(2023, Calendar.JANUARY, 23);
                //funcionario2.setData_admissao(admissao2);
                funcionario2.setNome("Rafael");
                funcionario2.setCpf("96356244489");
                funcionario2.setSenha("abc123");
                funcionario2.setCargo(c);
                Calendar nasc2 = Calendar.getInstance();
                nasc.set(1996, Calendar.AUGUST, 29);
                funcionario2.setData_nascimento(nasc);
                funcionario2.getCursos().add(curso2);
                jdbc.persist(funcionario2);
                List<String> nomesCursos2 = new ArrayList<>();
                for (Curso curso : funcionario2.getCursos()) {
                   nomesCursos.add(curso.getDescricao());
                }
                 
                System.out.println("Funcionário CPF: " + funcionario2.getCpf() + 
                        " Nome: " + funcionario2.getNome() + " Cursos: " + nomesCursos2 + 
                        " CTPS: " + funcionario2.getNumero_ctps() + " cadastrado com sucesso.");
                  
            } else{
               for (Funcionario f : listFuncionarios){
                   System.out.println("Funcionário ID: " + f.getCpf() + " Nome: " +
                           f.getNome() + " Cursos: " + f.getCursos() + "\n");
                   
                    /*f.setNome("Joao");
                    jdbc.persist(f);
                    System.out.println("Nome funcionário alterados para: " + f.getNome());
                    jdbc.remover(f);
                    System.out.println("Cargo: " + f.getCpf() + " removido."); */
               }
            }
            jdbc.fecharConexao();
        } else {
            System.out.println("Erro ao conectar com banco de dados");
        }
    }
    
    
    //@Test
    public void testPersistenciaCargoJDBC() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            //Passo 1: encontrar o cargo id = 1
            Cargo cg = (Cargo) jdbc.find(Cargo.class, Integer.valueOf("1"));
            if (cg != null) {
                System.out.println("Cargo encontrado! ");
                System.out.println("ID: " + cg.getId() + "\nDescricao: " + cg.getDescricao());
            } else {
                System.out.println("Não encontro o cargo");
            }
        } else {
            System.out.println("nao conectou no BD via jdbc ...");
            //atribuir uma instancia para o cg
            //setar a descricao
            //persistir no banco de dados.
        }
    }

    //@Test
    public void testServico() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            // TESTE EQUIPE
            Equipe e = new Equipe();
            e.setId(1);
            e.setEspecialidades("teste");
            e.setNome("borracharia");
            jdbc.persist(e);

            Servico s = new Servico();
            s.setEquipe(e);

            Orcamento o = new Orcamento();
            o.setObservacoes("teste");

            Cliente cli = new Cliente();
            cli.setCpf("3");
            cli.setNome("Bernardo");
            cli.setSenha("12876");
            jdbc.persist(cli);
            o.setCliente(cli);

            Funcionario func = new Funcionario();
            func.setCpf("1111111111");
            func.setNumero_ctps("1234");
            func.setNome("Andre");
            func.setSenha("123456");
            Cargo cargo = new Cargo();
            cargo.setId(1);
            func.setCargo(cargo);
            jdbc.persist(func);
            o.setFuncionario(func);

            Veiculo v = new Veiculo();
            v.setPlaca("POL5236");
            v.setAno(2010);
            o.setVeiculo(v);
            jdbc.persist(o);

            s.setOrcamento(o);
            s.setValor(1245.0f);
            s.setStatus(StatusServico.ATRASADO);
            jdbc.persist(s);

            System.out.println("SALVO COM SUCESSO");
        } else {
            System.out.println("Não conectou!");
        }
    }

    //@Test
    public void testCurso() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            Curso c = new Curso();
            //c.setId(1);
            c.setDescricao("NOVO CURSO");
            c.setCargaHoraria(300);
            jdbc.persist(c);

            System.out.println("Persistiu");
        } else {
            System.out.println("Não conectou!");
        }
    }

    //@Test
    public void testMaoObra() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            MaoObra m = new MaoObra();
            m.setDescricao("teste");
            m.setValor(100.0f);
            Date dataEspecifica = new Date(123, 0, 1, 14, 30, 0);
            m.setTempo_estimado_execucao(dataEspecifica);
            jdbc.persist(m);

            System.out.println("Persistiu");
        } else {
            System.out.println("Não conectou!");
        }
    }

    //@Test
    public void testOrcamento() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {
            Orcamento o = new Orcamento();
            Cliente cli = new Cliente();
            cli.setCpf("2");
            o.setCliente(cli);
            Funcionario func = new Funcionario();
            func.setCpf("1233");
            o.setFuncionario(func);
            MaoObra m = new MaoObra();
            m.setId("1");
            Collection<MaoObra> maos = new ArrayList();
            maos.add(m);
            o.setMaoobras(maos);
            Peca p = new Peca();
            p.setId(1);
            Collection<Peca> pecas = new ArrayList();
            pecas.add(p);
            o.setPecas(pecas);
            Veiculo v = new Veiculo();
            v.setPlaca("IWI9J98");
            o.setVeiculo(v);
            jdbc.persist(o);

        }
    }

    //@Test
    public void testCargo() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            Cargo c = new Cargo();
            c.setDescricao("teste");
            jdbc.persist(c);

            System.out.println("Persistiu");
        } else {
            System.out.println("Não conectou!");
        }
    }

    //@Test
    public void testPeca() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            Peca p = new Peca();
            //p.setId(1);
            p.setFornecedor("Pirelli");
            p.setNome("Roda aro 12");
            p.setValor(250.0f);
            jdbc.persist(p);

            System.out.println("Persistiu");
        } else {
            System.out.println("Não conectou!");
        }
    }

    //@Test
    public void testPagamento() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {

            Pagamento p = new Pagamento();
            p.setNumero_parcela(5);

            Servico s = new Servico();
            s.setId(1);
            p.setServico(s);
            p.setValor(500.0f);
            p.setId(3);
            jdbc.persist(p);
        } else {
            System.out.println("Não conectou!");
        }
    }

  //@Test
    public void testRecuperaClientesVeiculos() throws Exception {
        Collection<Cliente> clientes = null;
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {
            clientes = jdbc.listClientes();

            if (clientes != null) {
                System.out.println("Encontrou registros!\n\n");
                int i = 0;
                for (Cliente cli : clientes) {
                    i++;
                    System.out.println("-----CLIENTE " + i + "-----");
                    System.out.println("CPF: " + cli.getCpf());
                    System.out.println("Nome: " + cli.getNome());
                    System.out.println("Senha: " + cli.getSenha());

                    Collection<Veiculo> veiculos = null;
                    veiculos = cli.getVeiculo();
                    int j = 0;

                    for (Veiculo v : veiculos) {
                        j++;
                        System.out.println("\n-----VEICULO " + j + "-----");
                        System.out.println("Placa: " + v.getPlaca());
                        System.out.println("Modelo: " + v.getModelo());
                    }
                    jdbc.remover(cli);
                }

            } else {
                System.out.println("NAO ENCONTROU REGISTROS!");
                System.out.println("CRIANDO NOVOS...\n");
                Cliente cli = new Cliente();
                cli.setCpf("12345");
                cli.setNome("Caroline");
                cli.setSenha("12345");

                PersistenciaJPA jpa = new PersistenciaJPA();
                if (jpa.conexaoAberta()) {
                    Collection<Veiculo> veiculos = new ArrayList();
                    Veiculo v = (Veiculo) jpa.find(Veiculo.class, "ABC1234");
                    veiculos.add(v);

                    v = (Veiculo) jpa.find(Veiculo.class, "XYZ6789");
                    veiculos.add(v);
                    cli.setVeiculo(veiculos);
                    jdbc.persist(cli);

                    // SEGUNDO
                    cli = new Cliente();
                    cli.setCpf("00000");
                    cli.setNome("Marcos");
                    cli.setSenha("123456");

                    veiculos = new ArrayList();

                    v = (Veiculo) jpa.find(Veiculo.class, "HIJ5648");
                    veiculos.add(v);

                    v = (Veiculo) jpa.find(Veiculo.class, "KLM5863");
                    veiculos.add(v);

                    cli.setVeiculo(veiculos);
                    jdbc.persist(cli);

                    jpa.fecharConexao();
                } else {
                    System.out.println("NÃO CONECTOU NO BD!");
                }

            }

        }

    }
}
