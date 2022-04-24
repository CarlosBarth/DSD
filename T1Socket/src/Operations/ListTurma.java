package Operations;

import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class ListTurma extends Operation {

    @Override
    public void execute() {
        try {
            String[] str = new String[] {Dao.getInstance().listTurmas()};
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
            errorMsg = new String[]{"Não foi possivel Econtrar nenhuma Turma"};
        }
        return errorMsg;
    }

}

