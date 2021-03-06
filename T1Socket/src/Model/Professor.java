package Model;

/**
 *
 * @author Barth
 */
public class Professor extends Pessoa {
    public final int GRADUADO = 0;
    public final int MESTRADO = 1;
    public final int DOUTORADO = 2;
    
    private int idProfessor;
    private String nivelGraduacao;
    
    public Professor(String nome, String cpfCnpj, String endereco, String graduacao) {
        super(nome,cpfCnpj, endereco);
        this.nivelGraduacao = graduacao;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNivelGraduacao() {
        return nivelGraduacao;
    }

    public void setNivelGraduacao(String nivelGraduacao) {
        this.nivelGraduacao = nivelGraduacao;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + getListaGraduacao(Integer.parseInt(getNivelGraduacao())) + "\n";
    }
    
    public static Professor getNewInstance(String[] args) {
        return new Professor(args[3], args[2], args[4],args[5]);
    }
    
    public String getListaGraduacao(int grad) {
        String[] array = new String[] {"Graduado","Mestre","Doutor"};
        return array[grad];
    }
}
