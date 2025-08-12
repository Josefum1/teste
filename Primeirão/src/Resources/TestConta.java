package Resources;

/**
 * Classe com todos campos necessário para criar a conta
 * também inclui todos os métodos envolvendo esses campos
 * 
 * @see formatarCPF
 * @see checarCPF
 */
public class TestConta {

    private String nome;
    private String cpf;
    private int numeroConta;
    public String cpfFormatado;
    private double saldoInicial;

    public TestConta() {
    }

    public TestConta(String nome, String cpf, int numeroConta, double saldoInicial) {
        this.nome = nome;
        this.cpfFormatado = formatarCPF(cpf);
        this.numeroConta = numeroConta;
        this.saldoInicial = saldoInicial;
    }

    /**
     * 
     * Método para coletar o String CPF e formatá-lo para ficar nos conformes da
     * lesgislação brasileira
     * Primeiro apaga todos os elementos do String que não são números, verifica se
     * sobraram exatamente 11 números.
     * Se houver menos números, ou mais números ele anula o campo CPF,
     * se estiver correto, ele formata os elementos de acordo com o molde
     * 123.456.789-10
     * 
     * @param cpf
     *
     * @return cpf formatado
     * @see src.Application
     */
    public static String formatarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos
        if (cpf.length() != 11) {
            return cpf = null;
        } else {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
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
    /**
     * To String normal padrão, inclui o CPF formatado
     */
    public String toString() {
        return " Conta " + numeroConta + "\nTitular: " + nome + "\nCPF: " + cpfFormatado + "\nSaldo: " + saldoInicial;

    }

    /**
     * Método para checar se o CPF tem 11 caracteres, para a formatação não dar erro
     * 
     * @deprecated mantido somente para testes futuros
     * @param cpf
     * @return
     */
    public boolean checarCPF(String cpf) {
        if (cpf.length() == 11) {
            return true;
        } else {
            return false;
        }
    }

    public String fileWriter(TestConta conta) {
        return String.valueOf(numeroConta) + " " + nome + " " + cpfFormatado + " " + saldoInicial;
    }

    public String getCpfFormatado() {
        return cpfFormatado;
    }

    public void setCpfFormatado(String cpfFormatado) {
        this.cpfFormatado = cpfFormatado;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    

}
