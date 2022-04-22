package Model;

/**
 *
 * @author Barth
 */
public class Aluno extends Pessoa{
    
    private int idAluno;
    private String matricula;

    public Aluno(String nome, String cpf, String endereco, String matricula) {
        super(nome, cpf, endereco);
        this.matricula = matricula;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricvula) {
        this.matricula = matricvula;
    }

    @Override
    public String toString() {
        return super.toString() + "    Matricula: " + getMatricula() + "\n";
    }

    public static Model getInstance(String[] args) {
        return new Aluno(args[3], args[2], args[4],args[5]);
    }

    @Override
    public int requiredArgs() {
        return 7;
    }
    
}
