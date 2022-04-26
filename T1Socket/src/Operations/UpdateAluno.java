package Operations;

import Model.Aluno;
import Model.Dao;
import Model.Model;

/**
 *
 * @author Barth
 */
public class UpdateAluno extends Operation {

    @Override
    public void execute() {
        try {
            Aluno aluno = (Aluno)getInstanceModelo(getArgs());
            aluno.setNome(getArgs()[3]);
            aluno.setEndereco(getArgs()[4]);
            aluno.setMatricula(getArgs()[5]);
        } catch (Exception ex) {
            setSucess(false);
        }
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
        return new String[]{"Aluno atualizado com sucesso!"};
    }

    @Override
    public String[] getErrorMsg() {
        if (errorMsg == null) {
            errorMsg = new String[]{"Não foi Possivel atualizar o Aluno."};
        }
        return errorMsg;
    }

}
