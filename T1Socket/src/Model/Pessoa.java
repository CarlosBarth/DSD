package Model;

/**
 *
 * @author Barth
 */
public class Pessoa extends Model{
    
    private int idPessoa;
    private String nome;
    private String endereco;
    private String cpf;
    
    public Pessoa(String nome, String cpf, String endereco) {
        this.nome       = nome;
        this.cpf        = cpf;
        this.endereco   = endereco;
    }

    public static Model getInstance(String[] args) {
        return new Pessoa(args[3], args[2], args[4]);
    }
    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return    "         Nome: "  + getNome() + "\n"
                + "          CPF: " + getCpf() + "\n"
                + "     Endereço: " + getEndereco()+ "\n";
    }

    @Override
    public int requiredArgs() {
        return 5;
    }
    
      
    public StringBuilder getVirtualInfo() {
        StringBuilder str = new StringBuilder();
        str.append("Dados Pessoais: \n " + toString());
        if (Dao.getInstance().getTurmas().size() > 0) {
            for (Turma turma : Dao.getInstance().getTurmas()) {
                if (turma == null) {
                    continue;
                }
                if (turma.getProfessor().getCpf().equals(getCpf())) {
                    str.append("Professor da Turmna: " + turma.getDescricao() + "\n");
                }
                for (Aluno aluno : turma.getAlunos()) {
                    if (aluno.getCpf().equals(getCpf())) {
                        str.append("Matriculado na Turma: " + turma.getDescricao() + "\n");
                    }
                }
            }
        }
        return str;
    }
}
