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
            String[] retorno = new String[] {Dao.getInstance().listTurmas()};
            if (retorno.toString() == "") {
                setSucess(false);
                return;
            }
            setSucessMsg(retorno);
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

