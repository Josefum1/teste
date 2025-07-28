package Resources;

/**
 * Classe com todos campos necessário para criar a conta
 * também inclui todos os métodos envolvendo esses campos
 * @see formatarCPF
 * @see checarCPF
 */
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

    /**
     * 
     * Método para coletar o String CPF e formatá-lo para ficar nos conformes da lesgislação brasileira
     * Primeiro apaga todos os elementos do String que não são números, depois formata os elementos de acordo com o molde
     * XXX.XXX.XXX-XX
     * @param cpf
     *
     * @return cpf formatado
     */
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
    /**
     * To String normal padrão, inclui o CPF formatado
     */
    public String toString() {
        return "\nConta " + numeroConta + "\nTitular: " + nome + "\nCPF: " + cpfFormatado;

    }

    /**
     * Método para checar se o CPF tem 11 caracteres, para a formatação não dar erro
     * 
     * TODO: checar o CPF somente APÓS a remoção dos caracteres não-numerais.
     * @param cpf
     * @return
     */
    public static boolean checarCPF(String cpf){
        if (cpf.length() == 11){
            return true;
        }
        else{
            return false;
        }
    }

}
