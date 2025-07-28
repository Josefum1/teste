package Resources;

public class TestConta {

    private String nome;
    private String cpf;
    private int numeroConta;
    public String cpfFormatado;

    public TestConta(String nome, String cpf, int numeroConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.cpfFormatado = formatarCPF(cpf);
        this.numeroConta = numeroConta;
    }

    public static String formatarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public String toString() {
        return "Conta " + numeroConta + "\nTitular: " + nome + "\nCPF: " + cpfFormatado;

    }

}
