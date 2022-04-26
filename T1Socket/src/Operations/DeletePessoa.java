package Operations;

import Model.Dao;
import Model.Model;
import Model.Pessoa;

/**
 *
 * @author Barth
 */
public class DeletePessoa extends Operation {

    @Override
    public void execute() {
        try {
            Pessoa pes = (Pessoa) getModelo();
            Dao.getInstance().removePessoa(pes);
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
        if (sucessMsg == null) {
            return new String[]{"Pessoa removida com sucesso!"};
        }
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
