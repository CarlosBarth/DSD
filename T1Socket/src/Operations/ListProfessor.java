package Operations;

import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class ListProfessor extends Operation {

    @Override
    public void execute() {
        try {
            String[] str = new String[] {Dao.getInstance().listProfessores()};
            if (str.length == 0) {
                setSucess(false);
            }
            setSucessMsg(str);
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi possivel Econtrar nenhum Professor"};
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