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
