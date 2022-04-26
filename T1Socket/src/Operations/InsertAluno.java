package Operations;

import Model.Aluno;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class InsertAluno extends Operation {

    @Override
    public void execute() {
        try {
            if (getArgs().length == 6) {
                Dao.getInstance().getPessoas().add((Aluno) getModelo());
            } else {
                getModelo();
            }
        } catch (Exception ex) {
            setSucess(false);
        }
    }

    @Override
    public Model getInstanceModelo(String[] args) {
        try {
            if (args.length == 4) {
                    Aluno aluno = (Aluno)Dao.getInstance().getPessoa(args[2]);
                    Dao.getInstance().getTurma(Integer.parseInt(args[3])).addAluno(aluno);

            } else {
                return Aluno.getNewInstance(args);
            }
        } catch (Exception ex) {
            setSucess(false);
        }
        return null;
    }

    @Override
    public String[] getSucessMsg() {
        return new String[]{"Aluno incluido com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        return new String[]{"Não foi Possivel Inserir o Aluno."};
    }

}
