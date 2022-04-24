package Operations;

import Model.Dao;
import Model.Model;
import Model.Professor;

/**
 *
 * @author Barth
 */
public class InsertProfessor extends Operation{

    @Override
    public void execute() {
        try {
            Dao.getInstance().getPessoas().add((Professor) getModelo());
        } catch (Exception ex) {
            setSucess(false);
        }
            
    }

     @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args.length == 4) {
                    Professor professor = (Professor)Dao.getInstance().getPessoa(args[2]);
                    Dao.getInstance().getTurma(Integer.parseInt(args[3])).setProfessor(professor);
                    return professor;

            } else {
                return Professor.getNewInstance(args);
            }
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[] {"Professor inserido com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        return new String[] {"Não foi possivel inserir o Professor"};
    }
    
}
