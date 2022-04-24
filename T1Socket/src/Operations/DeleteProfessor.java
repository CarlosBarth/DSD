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

