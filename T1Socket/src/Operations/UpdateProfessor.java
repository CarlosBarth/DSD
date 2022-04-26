package Operations;

import Model.Professor;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class UpdateProfessor extends Operation {

    @Override
    public void execute() {
        try {
            Professor professor = (Professor)getInstanceModelo(getArgs());
            updateAluno(professor);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[] {ex.getMessage()});
        }
    }
    
    public void updateAluno(Professor professor) {
        professor.setNome((getArgs()[3] != null) ? getArgs()[3] : professor.getNome());
        professor.setEndereco((getArgs()[4] != null) ? getArgs()[4] : professor.getEndereco());
        professor.setNivelGraduacao((getArgs()[5] != null) ? getArgs()[5] : professor.getNivelGraduacao());
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            return Dao.getInstance().getPessoa(args[2]);
        } catch (Exception ex) {
            setSucess(false);
            setErrorMsg(new String[] {ex.getMessage()});
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Professor atualizado com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Possivel atualizar o Professor."};
        }
        return errorMsg;
    }

}