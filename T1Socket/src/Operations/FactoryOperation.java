package Operations;
/**
 *
 * @author Barth
 */
public class FactoryOperation {
    
    public Operation getOperation(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Operation op = (Operation) Class.forName("Operations." + args[0].substring(0, 1).toUpperCase() + args[0].substring(1).toLowerCase() + args[1]).newInstance();
        op.setArgs(args);
        return op;
    }
    
}