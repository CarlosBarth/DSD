package Operations;

import Model.Aluno;
import Model.Dao;
import Model.Model;
import Model.Pessoa;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barth
 */
public class GetPessoa extends Operation {

    @Override
    public void execute() {
        try {
            Pessoa pes = (Pessoa) getModelo();
            setSucessMsg(new String[]{pes.getVirtualInfo().toString()});
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args[2] != null) {
                    return Dao.getInstance().getPessoa(getArgs()[2]);
            } 
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Econtrar a Pessoa do CPF " + getArgs()[2]};
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