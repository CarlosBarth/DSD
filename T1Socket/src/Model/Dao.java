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

    public Professor getProfessor(Pessoa pes, int idTurma) throws Exception {
        Turma turma = getTurma(idTurma);
        if (turma.getProfessor().getCpf().equals(pes.getCpf())) {
            return (Professor) turma.getProfessor();
        }
        return null;
    }

    public Pessoa getPessoa(String cpf) throws Exception {
        for (Pessoa pessoa : getPessoas()) {
            if (pessoa.getCpf().equals(cpf)) {
                if (pessoa == null) {
                    continue;
                }
                if (pessoa instanceof Aluno) {
                    return (Aluno) pessoa;
                }
                return (Professor) pessoa;
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
        newTurma.resetAlunos();
        newTurma.setIdTurma(idTurma);
        getTurmas().add(newTurma);
        idTurma++;
        return newTurma;
    }

    public void removePessoa(Pessoa pes) {
        getPessoas().remove(pes);
        for (Turma turma : getTurmas()) {
            turma.getAlunos().remove(pes);
            if (turma.getProfessor() != null && turma.getProfessor().getCpf().equals(pes.getCpf())) {
                turma.setProfessor(null);
            }
        }
    }

    public void addPessoaNaTurma(Pessoa pes, int idTurma) {
        Turma oTurma = getTurma(idTurma);
        if (pes instanceof Aluno) {
            oTurma.addAluno((Aluno) pes);
        }
    }

    public void removePessoaDaTurma(Pessoa pes, int idTurma) throws Exception {
        Turma turma = getTurma(idTurma);
        if (pes instanceof Aluno) {
            turma.getAlunos().remove((Aluno) pes);
        } else if (turma.getProfessor().getCpf().equals(pes.getCpf())) {
            turma.setProfessor(null);
        } else {
            throw new Exception("Pessoa Não Encontrada");
        }
    }

    public String listProfessores() {
        StringBuilder str = new StringBuilder();
        int qtd = 0;
        for (Pessoa pes : getPessoas()) {
            if (pes instanceof Professor) {
                qtd++;
                str.append(((Professor) pes).toString() + "\n");
            }
        }
        return "0" + String.valueOf(qtd)+ "\n" + str.toString();
    }

    public String listAlunos() {
        StringBuilder str = new StringBuilder();
        int qtd = 0;
        for (Pessoa pes : getPessoas()) {
            if (pes instanceof Aluno) {
                qtd++;
                str.append(((Aluno) pes).toString() + "\n");
            }
        }
        return "0" + String.valueOf(qtd)+ "\n" + str.toString();
    }

    public String listTurmas() {
        StringBuilder str = new StringBuilder();
        int qtd = getTurmas().size();
        for (Turma turma : getTurmas()) {
            if (turma == null) {
                qtd--;
                continue;
            }
            str.append(turma.toString() + "\n");
        }
        return "0" + String.valueOf(qtd)+ "\n" + str.toString();
    }

}
