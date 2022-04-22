package Model;

import org.eclipse.persistence.internal.libraries.asm.commons.Method;

/**
 *
 * @author Barth
 */
public abstract class Model{
    
    private String[] args;

//    public Model(String[] args) {
//        this.args = args;
//    }
    
    public static Model getInstance(String[] args){
        return null;
    }
    
    public abstract int requiredArgs();

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
    
     protected void validaArgs() throws Exception {
        if (args.length < requiredArgs()) {
            throw new Exception("Argumentos insuficientes para criação do Modelo");
        }
    }
}
