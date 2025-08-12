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

    public TestConta pesquisa(int numeroConta) {
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
