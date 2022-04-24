package Operations;

import Model.Model;

/**
 *
 * @author Barth
 */
public abstract class Operation {

    private Model modelo;
    private boolean sucess = true;
    private String[] args;
    protected String[] errorMsg;
    protected String[] sucessMsg;

    public abstract void execute();

    public abstract Model getInstanceModelo(String[] args);

    public String[] getMessage() {
        if (sucess){
            return getSucessMsg();
        }
        return getErrorMsg();
    }

    public String[] getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String[] errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String[] getSucessMsg() {
        return sucessMsg;
    }

    public void setSucessMsg(String[] sucessMsg) {
        this.sucessMsg = sucessMsg;
    }

    public Model getModelo() {
        if (modelo == null) {
            modelo = getInstanceModelo(getArgs());
        }
        return modelo;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
    
    public void setSucess(boolean sucess){
        this.sucess = sucess;
    }
    
}
