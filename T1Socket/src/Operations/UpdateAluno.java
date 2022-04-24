package Operations;

import Model.Aluno;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class UpdateAluno extends Operation {

    @Override
    public void execute() {
        try {
            Aluno aluno = (Aluno)getInstanceModelo(getArgs());
            aluno.setNome(getArgs()[3]);
            aluno.setEndereco(getArgs()[4]);
            aluno.setMatricula(getArgs()[5]);
        } catch (Exception ex) {
            setSucess(false);
        }
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
        return new String[]{"Aluno alterado com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Possivel alterar o Aluno."};
        }
        return errorMsg;
    }

}

//String dadosStr = "INSERT;Aluno;cpf;nome;endereco;Matricula";
//String dadosStr = "INSERT;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Turma;nome";
//String dadosStr = "UPDATE;Aluno;cpf;nome;endereco;matricula;";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "UPDATE;Turma;id;descricao";
//String dadosStr = "GET;Pessoa;cpf";
//String dadosStr = "GET;Turma;id";
//String dadosStr = "DELETE;Pessoa;cpf";
//String dadosStr = "DELETE;Turma;id";
//String dadosStr = "DELETE;Aluno;cpf;idTurma";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "LIST;Professor;
//String dadosStr = "LIST;Alunos;
//String dadosStr = "LIST;Turma;