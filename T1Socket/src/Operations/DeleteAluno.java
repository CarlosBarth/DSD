package Operations;

import Model.Aluno;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class DeleteAluno extends Operation {

    @Override
    public void execute() {
        try {
            Aluno pes = (Aluno) getModelo();
            Dao.getInstance().removePessoaDaTurma(pes, Integer.parseInt(getArgs()[3]));
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args[2] != null) {
                return Dao.getInstance().getAluno(getArgs()[2], Integer.parseInt(getArgs()[3]));
            } 
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        if (sucessMsg == null) {
            return new String[]{"Aluno removido com sucesso!"};
        }
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Aluno não encontrado"};
        }
        return errorMsg;
    }

}