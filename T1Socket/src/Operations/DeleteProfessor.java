package Operations;

import Model.Professor;
import Model.Dao;
import Model.Model;
import Model.Pessoa;

/**
 *
 * @author Barth
 */
public class DeleteProfessor extends Operation {

    @Override
    public void execute() {
        try {
            Professor pes = (Professor) getModelo();
            Dao.getInstance().removePessoaDaTurma(pes, Integer.parseInt(getArgs()[3]));
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args[2] != null) {
                Pessoa pes = Dao.getInstance().getPessoa(getArgs()[2]);
                return Dao.getInstance().getProfessor(pes, Integer.parseInt(getArgs()[3]));
            } 
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        if (sucessMsg == null) {
            return new String[]{"Professor removido da turma com sucesso!"};
        }
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi possivel Econtrar o Professor"};
        }
        return errorMsg;
    }

}



//String dadosStr = "GET;Pessoa;cpf";
//String dadosStr = "GET;Turma;id";
//String dadosStr = "DELETE;Pessoa;cpf";
//String dadosStr = "DELETE;Turma;id";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "LIST;Professor;
//String dadosStr = "LIST;Professors;
//String dadosStr = "LIST;Turma;


//String dadosStr = "UPDATE;Turma;id;descricao";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;matricula;";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Turma;nome";
//String dadosStr = "INSERT;Professor;cpf;nome;endereco;Matricula";
//String dadosStr = "INSERT;Professor;cpf;idTurma";
//String dadosStr = "INSERT;Professor;cpf;idTurma";