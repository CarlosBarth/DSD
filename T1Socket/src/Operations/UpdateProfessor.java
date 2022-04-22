package Operations;

import Model.Professor;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class UpdateProfessor extends Operation {

    @Override
    public void execute() {
        try {
            Professor professor = (Professor)getInstanceModelo(getArgs());
            updateAluno(professor);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[] {ex.getMessage()});
        }
    }
    
    public void updateAluno(Professor professor) {
        professor.setNome((getArgs()[3] != null) ? getArgs()[3] : professor.getNome());
        professor.setEndereco((getArgs()[4] != null) ? getArgs()[4] : professor.getEndereco());
        professor.setNivelGraduacao((getArgs()[5] != null) ? getArgs()[5] : professor.getNivelGraduacao());
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            return Dao.getInstance().getPessoa(args[2]);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[] {ex.getMessage()});
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Professor alterado com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Possivel alterar o Professor."};
        }
        return errorMsg;
    }

}

//String dadosStr = "INSERT;Professor;cpf;nome;endereco;Matricula";
//String dadosStr = "INSERT;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Turma;nome";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;matricula;";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "UPDATE;Turma;id;descricao";
//String dadosStr = "GET;Pessoa;cpf";
//String dadosStr = "GET;Turma;id";
//String dadosStr = "DELETE;Pessoa;cpf";
//String dadosStr = "DELETE;Turma;id";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "LIST;Professor;
//String dadosStr = "LIST;Professors;
//String dadosStr = "LIST;Turma;