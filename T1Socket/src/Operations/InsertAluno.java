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
public class InsertAluno extends Operation {

    @Override
    public void execute() {
        try {
            Dao.getInstance().getPessoas().add((Aluno) getModelo());
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args.length == 4) {
                    Aluno aluno = (Aluno)Dao.getInstance().getPessoa(args[2]);
                    findTurma().addAluno(aluno);

            } else {
                return Aluno.getInstance(args);
            }
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[]{ex.getMessage()});
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Aluno inserido com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        return new String[]{"Não foi Possivel Inserir o Aluno."};
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