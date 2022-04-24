package Operations;

import Model.Turma;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class UpdateTurma extends Operation {

    @Override
    public void execute() {
        try {
            Turma turma = (Turma)getInstanceModelo(getArgs());
            updateTurma(turma);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[] {ex.getMessage()});
        }
    }
    
    public void updateTurma(Turma turma) {
        turma.setDescricao((getArgs()[3]) != null ? getArgs()[3] : turma.getDescricao());
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            return Dao.getInstance().getTurma(Integer.parseInt(args[2]));
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Turma alterada com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Possivel alterar a Turma."};
        }
        return errorMsg;
    }

}
