package Resources.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Resources.TestConta;

/**
 * Classe FileUtil, feita para armazenar os métodos necessários para a
 * manipulação de arquivos
 * 
 *
 */
public class FileUtil {
    File f = new File("C:\\JAVA\\teste\\Primeirão\\accounts\\");

    TestConta t = new TestConta();
    String[] files = f.list();
    List<TestConta> contas = new ArrayList<>();

    public List<TestConta> getContas() {
        return contas;
    }

    public void setContas(List<TestConta> contas) {
        this.contas = contas;
    }

    /**
     * Método compararNomes, compara o número de uma conta gerado com o nome de
     * todos os arquivos para evitar duplicidade
     * 
     * @param numeroConta número a ser comparado ao nome dos arquivos
     * @return retorna um booleano baseado nessa informação (true se houver
     *         duplicidade)
     */
    public boolean compararNomeDuplo(int numeroConta) {
        for (String file : files) {
            while (file.contains(String.valueOf(numeroConta))) {
                return true;
            }

        }
        return false;
    }
<<<<<<< HEAD

    public TestConta pesquisa(int numeroConta) {
=======
/**
 * Método pesquisa, lê o atributo numeroConta e compara com o nome de todos os arquivos na pasta
 com isso, caso a conta exista, ele cria um array com as informações contidas no arquivo, usando o BufferedReader e as separa pela ,
 Cada parte sendo uma informação da conta. E adiciona a conta numa lista contas do tipo TestConta e imprime a lista
 @return retorna um valor booleano baseado se a informação foi achada ou não
    */
    public boolean pesquisa(int numeroConta) {
>>>>>>> 004e5e9684e24223e04ec73d09d90238a417f789
        try (BufferedReader br = new BufferedReader(new FileReader(f + "\\" + String.valueOf(numeroConta) + ".txt"))) {
            String line;
            File c = new File(f + "\\" + String.valueOf(numeroConta) + ".txt");
            if (c.exists()) {
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ");
                    int numeroC = Integer.parseInt(parts[0].trim());
                    String nomeC = parts[1].trim();
                    String cpfC = parts[2].trim();
                    double saldoC = Double.parseDouble(parts[3].trim());
                    TestConta resultado = new TestConta(nomeC, cpfC, numeroC, saldoC);
                    return resultado;
                    }
                }
                 
            else {
                return null;
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }
}
