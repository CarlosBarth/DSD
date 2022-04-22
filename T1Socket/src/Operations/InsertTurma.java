package Operations;

import Model.Aluno;
import Model.Dao;
import Model.Model;
import Model.Pessoa;
import Model.Turma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barth
 */
public class InsertTurma extends Operation {

    @Override
    public void execute() {
        try {
            Dao.getInstance().getTurmas().add((Turma)getModelo());
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            Dao.getInstance().newInstanceTurma(args[2]);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[]{ex.getMessage()});
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Turma inserida com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        return new String[]{"Não foi Possivel Inserir a Turma."};
    }

}

//String dadosStr = "INSERT;Aluno;cpf;idTurma";
//String dadosStr = "INSERT;Professor;cpf;idTurma";


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