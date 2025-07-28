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

        while (x <= 0 || x > 2) {
            System.out.println("Bem vindo ao TestBank! \nPara começar, insira a opção desejada: ");
            System.out.println("1 - Criar uma nova conta \n2 - Acessar uma conta existente ");
            x = sc.nextInt();
            sc.nextLine();

        }

        switch (x) {

            case 1:
                System.out.print("Por favor insira os seus dados. \nNome: ");
                String nome = sc.nextLine();
                System.out.print("CPF (sem os pontos e linhas): ");
                String CPF = sc.nextLine();
                while (TestConta.checarCPF(CPF) == false) {
                    System.out.println("Número inválido! O CPF deve conter exatamente 11 caracteres.");
                    System.out.print("CPF (sem os pontos e linhas): ");
                    CPF = sc.nextLine();
                }
                int numeroConta = random.nextInt(999999);
                while (f.compararNomes(numeroConta)) {
                    System.out.println("Tentando novamente....");
                    numeroConta = random.nextInt(999999);
                }

                File account = new File("C:\\JAVA\\teste\\Primeirão\\accounts\\" + numeroConta + ".txt");
                FileWriter ex = new FileWriter("C:\\JAVA\\teste\\Primeirão\\accounts\\" + numeroConta + ".txt");
                TestConta conta1 = new TestConta(nome, CPF, numeroConta);

                ex.write(conta1.toString());
                ex.close();

                System.out.println("Conta criada com sucesso!" + conta1);
                break;

            case 2:
                System.out.println("Opção indisponível! Tente novamente mais tarde");
                break;

            default:
                System.out.println("Opção inválida!");
                x = 0;
        }
        sc.close();
    }

}
