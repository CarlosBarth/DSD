package Operations;

import Model.Dao;
import Model.Model;
import Model.Turma;

/**
 *
 * @author Barth
 */
public class GetTurma extends Operation {

    @Override
    public void execute() {
        try {
            Turma turma = (Turma) getModelo();
            setSucessMsg(new String[] {turma.toString()});
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
            sucessMsg = new String[] {getModelo().toString()};
        }
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi possível encontrar a Turma id: " + getArgs()[2]};
        }
        return errorMsg;
    }

}
