package Operations;

import Model.Turma;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class UpdateTurma extends Operation {

    @Override
    public void execute() {
        try {
            Turma turma = (Turma)getInstanceModelo(getArgs());
            updateTurma(turma);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[] {ex.getMessage()});
        }
    }
    
    public void updateTurma(Turma turma) {
        turma.setDescricao((getArgs()[3]) != null ? getArgs()[3] : turma.getDescricao());
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            return Dao.getInstance().getTurma(Integer.parseInt(args[2]));
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Turma alterada com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Possivel alterar a Turma."};
        }
        return errorMsg;
    }

}

//String dadosStr = "INSERT;Turma;cpf;nome;endereco;Matricula";
//String dadosStr = "INSERT;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "INSERT;Turma;nome";
//String dadosStr = "UPDATE;Professor;cpf;nome;endereco;graduacao;";
//String dadosStr = "UPDATE;Turma;id;descricao";
//String dadosStr = "GET;Pessoa;cpf";
//String dadosStr = "GET;Turma;id";
//String dadosStr = "DELETE;Pessoa;cpf";
//String dadosStr = "DELETE;Professor;cpf;idTurma";
//String dadosStr = "DELETE;Turma;id";
//String dadosStr = "LIST;Professor;
//String dadosStr = "LIST;Turmas;
//String dadosStr = "LIST;Turma;