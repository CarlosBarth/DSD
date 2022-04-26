package Operations;

import Model.Dao;
import Model.Model;
import Model.Turma;

/**
 *
 * @author Barth
 */
public class InsertTurma extends Operation {

    @Override
    public void execute() {
        try {
            Dao.getInstance().getTurmas().add((Turma)getModelo());
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            Dao.getInstance().newInstanceTurma(args[2]);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[]{ex.getMessage()});
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Turma incluida com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        return new String[]{"Não foi Possivel incluir a Turma."};
    }
}
