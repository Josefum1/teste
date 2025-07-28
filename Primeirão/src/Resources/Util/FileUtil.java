package Resources.Util;

import java.io.File;

/**
 * Classe FileUtil, feita para armazenar os métodos necessários para a manipulação de arquivos
 * 
 *
 */
public class FileUtil {
    File f = new File("C:\\JAVA\\teste\\Primeirão\\accounts");

    String[] files = f.list();

    /**
     * Método compararNomes, compara o número de uma conta gerado com o nome de todos os arquivos para evitar duplicidade
     * @param numeroConta número a ser comparado ao nome dos arquivos
     * @return retorna um booleano baseado nessa informação (true se houver duplicidade)
     */
    public boolean compararNomes(int numeroConta) {
        for (String file : files) {
            while (file.contains(String.valueOf(numeroConta))) {
                return true;
            }

        }
        return false;
    }
}
