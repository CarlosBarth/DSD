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
            getInstanceModelo(getArgs());
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            return Dao.getInstance().newInstanceTurma(args[2]);
        } catch (Exception ex) {
            setSucess(false);
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
