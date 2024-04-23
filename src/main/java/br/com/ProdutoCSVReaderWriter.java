package br.com;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoCSVReaderWriter {

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\JoanaDarc\\OneDrive\\ESTUDO\\JAVA\\aulachicout20\\produtos.csv";
        try (Scanner scanner = new Scanner(System.in)) {
            List<String[]> linhas = new ArrayList<>();

            try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
                try {
                    linhas = reader.readAll();
                } catch (Exception e) {

                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Digite o nome do produto que deseja deletar:");
            String nomeProduto = scanner.nextLine();

            boolean produtoEncontrado = false;
            for (int i = 0; i < linhas.size(); i++) {
                if (linhas.get(i)[0].equals(nomeProduto)) {
                    linhas.remove(i);
                    produtoEncontrado = true;
                    break;
                }
            }

            if (produtoEncontrado) {
                try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                    writer.writeAll(linhas);
                    System.out.println("Produto deletado com sucesso!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Produto não encontrado!");
            }
        }
    }
}