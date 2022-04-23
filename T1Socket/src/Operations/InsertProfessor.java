package Operations;

import Model.Professor;
import Model.Dao;
import Model.Model;
import Model.Professor;

/**
 *
 * @author Barth
 */
public class InsertProfessor extends Operation{

    @Override
    public void execute() {
        try {
            Dao.getInstance().getPessoas().add((Professor) getModelo());
        } catch (Exception ex) {
            setSucess(false);
        }
            
    }

     @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args.length == 4) {
                    Professor professor = (Professor)Dao.getInstance().getPessoa(args[2]);
                    findTurma().setProfessor(professor);
                    return professor;

            } else {
                return Professor.getInstance(args);
            }
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[] {"Professor inserido com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        return new String[] {"Não foi possivel inserir o Professor"};
    }
    
}

//String dadosStr = "INSERT;Professor;cpf;idTurma";
//String dadosStr = "INSERT;Professor;cpf;idTurma";


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