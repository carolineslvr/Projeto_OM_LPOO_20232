
package br.edu.ifsul.bcc.lpoo.om.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author telmo
 */
@Entity
@DiscriminatorValue("F")
@Table(name = "tb_funcionario")
@NamedQueries({@NamedQuery(name="Funcionario.orderbynome", query="select f from Funcionario f order by f.nome asc")})
public class Funcionario extends Pessoa {
    
    
    @Column(nullable = false, length = 11)
    private String numero_ctps;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)  
    private Calendar data_admissao;
      
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)    
    private Calendar data_demissao;
    
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
    
    @ManyToMany
    @JoinTable(name = "tb_funcionario_curso", joinColumns = {@JoinColumn(name = "funcionario_cpf")}, 
                                       inverseJoinColumns = {@JoinColumn(name = "curso_id")})      
  
    private Collection<Curso> cursos;
    

    public Funcionario() {
        cursos = new ArrayList();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Collection<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Collection<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void setCurso(Curso curso) {
        if(this.cursos == null){
            this.cursos = new ArrayList();
        }
        this.cursos.add(curso);
    }

    public String getNumero_ctps() {
        return numero_ctps;
    }

    public void setNumero_ctps(String numero_ctps) {
        this.numero_ctps = numero_ctps;
    }

    public Calendar getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Calendar data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Calendar getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Calendar data_demissao) {
        this.data_demissao = data_demissao;
    }
    
    @Override
    public String toString(){
        return this.getCpf();
    }
    
}
