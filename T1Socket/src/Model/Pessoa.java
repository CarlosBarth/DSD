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
        return "    Nome: " + getNome() + "\n"
                + "    CPF: " + getCpf() + "\n"
                + "    Endereço: " + getEndereco()+ "\n";
    }

    @Override
    public int requiredArgs() {
        return 5;
    }
}
