import java.util.Scanner;

import Resources.TestConta;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        ;
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
                System.out.print("CPF (com os pontos e linhas): ");
                String CPF = sc.nextLine();
                int numeroConta = random.nextInt(999999);

                File account = new File("account" + numeroConta + ".txt");
                FileWriter ex = new FileWriter("account" + numeroConta + ".txt");

                TestConta conta1 = new TestConta(nome, CPF, numeroConta);

                ex.write(conta1.toString());
                ex.close();

                System.out.println("Conta criada com sucesso!" + conta1);
                break;

            case 2:
                System.out.println("Opção indisponível! Tente novamente mais tarde");
                break;

            default:
                System.out.println("taporra!!!!");
                x = 0;
        }
        sc.close();
    }

}
