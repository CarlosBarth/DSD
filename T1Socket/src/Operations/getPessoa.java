package Operations;

import Model.Dao;
import Model.Model;
import Model.Pessoa;

/**
 *
 * @author Barth
 */
public class GetPessoa extends Operation {

    @Override
    public void execute() {
        try {
            Pessoa pes = (Pessoa) getModelo();
            
            setSucessMsg(new String[]{pes.toString()});
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args[2] != null) {
                    return Dao.getInstance().getPessoa(getArgs()[2]);
            } 
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return sucessMsg;
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Pessoa não encontrada"};
        }
        return errorMsg;
    }

}
