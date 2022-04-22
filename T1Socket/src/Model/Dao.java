/**
 *
 * @author Barth
 */
package Model;

import java.util.ArrayList;

public class Dao {

    final static String tipoAluno = "1";
    final static String tipoProfessor = "2";
    private static Dao instance;

    protected ArrayList<Pessoa> pessoas;
    protected ArrayList<Turma> turmas;
    protected int idTurma = 1;

    public Dao() {
        this.pessoas = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public static Dao getInstance() {
        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public Aluno getAluno(String cpf, int idTurma) throws Exception {
       Turma oTurma = getTurma(idTurma);
       if (oTurma == null) {
            throw new Exception("Nenhuma Turma encontrado para o Id: " + idTurma);
       }
       for (Pessoa pessoa : oTurma.getAlunos()) {
            if (pessoa instanceof Aluno && pessoa.getCpf().equals(cpf)) {
                return (Aluno) pessoa;
            }
        }
        throw new Exception("Nenhum Aluno encontrado para o CPF: " + cpf);
    }

    public Professor getProfessor(String cpf, String turma) throws Exception {
        for (Pessoa pessoa : getPessoas()) {
            if (pessoa instanceof Professor && pessoa.getCpf().equals(cpf)) {
                return (Professor) pessoa;
            }
        }
        throw new Exception("Nenhum Aluno encontrado para o CPF: " + cpf);
    }

    public Pessoa getPessoa(String cpf) throws Exception {
        for (Pessoa pessoa : getPessoas()) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        throw new Exception("Nenhuma Pessoa encontrada para o CPF: " + cpf);
    }

    public Turma getTurma(int id) {
        for (Turma turma : getTurmas()) {
            if (turma.getIdTurma() == id) {
                return turma;
            }
        }
        return null;
    }

    public Turma newInstanceTurma(String nome) {
        Turma newTurma = new Turma(nome);
        newTurma.setIdTurma(idTurma);
        getTurmas().add(newTurma);
        idTurma ++;
        return newTurma;
    }

//    public Pessoa newInstancePessoa(String[] args) throws Exception {
//        validaArgs(args);
//        if (tipoAluno.equals(args[5])) {
//            Aluno aluno = new Aluno(args[3], args[2], args[4], args[6]);
//            aluno.setMatricula(args[6]);
//            return aluno;
//        } else if (tipoProfessor.equals(args[5])) {
//            Professor prof = new Professor(args[3], args[2], args[4], args[6]);
//            prof.setNivelGraduacao(args[6]);
//            return prof;
//        }
//        return null;
//    }
//    public void validaArgs(String[] args) throws Exception{
//        if (args.length < 7) {
//            throw new Exception("Argumentos inválidos para a requisição");
//        }
//    } 
//    public boolean inserePessoa(String[] args) throws Exception {
//        Pessoa pes  = newInstancePessoa(args);
//        Turma turma = getTurma(args[7]);
//
//        if (tipoAluno.equals(args[5])) {
//            turma.addAluno((Aluno) pes);
//            return true;
//        } else if (tipoProfessor.equals(args[5])) {
//            turma.setProfessor((Professor)pes);
//            return true;
//        }
//        return false;
//    }
    public void addPessoaNaTurma(Pessoa pes, int idTurma) {
        Turma oTurma = getTurma(idTurma);
        if (pes instanceof Aluno) {
            oTurma.addAluno((Aluno) pes);
        }
    }
}
