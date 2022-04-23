package Operations;

import Model.Dao;
import Model.Model;
import Model.Turma;

/**
 *
 * @author Barth
 */
public class DeleteTurma extends Operation {

    @Override
    public void execute() {
        try {
            Turma turma = (Turma) getModelo();
            Dao.getInstance().getTurmas().remove(turma);
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args[2] != null) {
                return Dao.getInstance().getTurma(Integer.parseInt(getArgs()[2]));
            } 
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        if (sucessMsg == null) {
            sucessMsg = new String[] {"Turma removida com sucesso!"};
        }
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Econtrar a Turma id: " + getArgs()[2]};
        }
        return errorMsg;
    }

}



//String dadosStr = "GET;Pessoa;cpf";
//String dadosStr = "GET;Turma;id";
//String dadosStr = "DELETE;Pessoa;cpf";
//String dadosStr = "DELETE;Turma;id";
//String dadosStr = "DELETE;Aluno;cpf;idTurma";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "LIST;Professor;
//String dadosStr = "LIST;Alunos;
//String dadosStr = "LIST;Turma;


//String dadosStr = "UPDATE;Turma;id;descricao";
//String dadosStr = "UPDATE;Aluno;cpf;nome;endereco;matricula;";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Turma;nome";
//String dadosStr = "INSERT;Aluno;cpf;nome;endereco;Matricula";
//String dadosStr = "INSERT;Aluno;cpf;idTurma";
//String dadosStr = "INSERT;Professor;cpf;idTurma";