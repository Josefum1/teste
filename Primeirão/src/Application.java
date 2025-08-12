import java.util.Scanner;

import Resources.TestConta;
import Resources.Util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Aplicação principal
 * 
 * Implementa o java.util.Random para gerar o número das contas aleatóriamente
 * e implementa o java.io.File para criar um arquivo com as informações da conta
 * o nome escolhido é o número da conta em si, para facilitar a procura.
 * Usando o while para criar um menu mais interativo e que não finaliza o
 * programa após 1 erro
 *
 * Usa a variável x para o menu e aproveita e já implementa alguns métodos da
 * TestConta
 * 
 * @see Resouces.TestConta
 * 
 */
public class Application {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        FileUtil f = new FileUtil();

        int x = 0;

        while (x != 3) {
            System.out.println("Bem vindo ao TestBank! \nPara começar, insira a opção desejada: ");
            System.out.println("1 - Criar uma nova conta \n2 - Acessar uma conta existente ");
            x = sc.nextInt();
            sc.nextLine();

            switch (x) {

                case 1:
                    System.out.print("Por favor insira os seus dados. \nNome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF (sem os pontos e linhas): ");
                    String CPF = sc.nextLine();

                    while (TestConta.formatarCPF(CPF) == null) {// Verifica se o CPF foi anulado pelo método formatarCPF
                        System.out.println("Número inválido! O CPF deve conter exatamente 11 caracteres.");

                        System.out.print("CPF (sem os pontos e linhas): ");
                        CPF = sc.nextLine();
                    }
                    System.out.print("Insira o valor do depósito inicial: ");
                    double saldoInicial = sc.nextDouble();
                    int numeroConta = random.nextInt(999999); // Usa o java.util.random para gerar um número de 1 a
                                                              // 999999
                    while (f.compararNomeDuplo(numeroConta)) {// Compara o número gerado com a lista de arquivos já
                                                              // existente, se houver duplicidade, gera outro número
                        System.out.println("Tentando novamente....");
                        numeroConta = random.nextInt(999999);
                    }

                    @SuppressWarnings("unused")
                    File account = new File("C:\\JAVA\\teste\\Primeirão\\accounts\\" + numeroConta + ".txt");
                    FileWriter ex = new FileWriter("C:\\JAVA\\teste\\Primeirão\\accounts\\" + numeroConta + ".txt");
                    TestConta conta1 = new TestConta(nome, CPF, numeroConta, saldoInicial);

                    ex.write(conta1.fileWriter(conta1));// Escreve as informações da conta com o FileWriter
                    ex.close();

                    System.out.println("Conta criada com sucesso!" + conta1);
                    continue;

                /**
                 * TODO: #2 Adicionar um sistema de verificação e acesso das contas já criadas,
                 * para a opção 2
                 */
                case 2:
                    System.out.println("Insira o número da sua conta: ");
                    int conta = sc.nextInt();

                    while (f.pesquisa(conta) == null) {

                        System.out.println("Conta não encontrada! \nInsira o número da sua conta: ");
                        conta = sc.nextInt();
                    }
                    TestConta resultado = new TestConta(f.pesquisa(conta).getNome(),
                            f.pesquisa(conta).getCpfFormatado(), f.pesquisa(conta).getNumeroConta(),
                            f.pesquisa(conta).getSaldoInicial());
                    System.out.println(resultado.toString());
                    continue;

                case 3:
                    break;

                default:
                    System.out.println("Opção inválida!");
                    x = 0;
            }

        }
        sc.close();
    }

}
