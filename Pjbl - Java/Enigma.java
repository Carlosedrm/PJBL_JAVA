import java.io.*;
import java.util.Scanner;

public class Enigma {

    public void enigmas(){
        try {
            Scanner scanner = new Scanner(System.in);
            // O enigma
            String enigma = "V wypzvulpyv I mvp v clykhklpyv tvuzayv!";

            // Criamos o arquivo
            File file = new File("Enigma.txt");

            // Criamos o arquivo
            file.createNewFile();

            // Preparamos para escrever
            FileWriter writer = new FileWriter(file);

            // Escreve o conteúdo
            writer.write("V wypzvulpyv I mvp v clykhklpyv tvuzayv!");
            writer.flush();
            writer.close();

            // Agora o usuario deve resolver a questão
            System.out.println("Parece que um enigma foi entregado a você. Resolva ele para continuar.");
            boolean resolvido = false;

            // LOOP até o usuario resolver o enigma
            while(!resolvido){
                System.out.println("Digite o nome do arquivo .txt com a resposta: ");
                // Pegamos o nomo do arquivo .txt
                String input = scanner.nextLine();
                String output = input + ".txt";

                // Tentamos ver sé o arquivo existe
                try {
                    // Agora vemos o arquivo
                    FileReader arquivo = new FileReader(output);
                    BufferedReader buffer = new BufferedReader(arquivo);

                    // Váriavel para pegar o que há dentro do arquivo
                    String str;
                    String resposta = "";

                    // Pegamos o que há no arquivo
                    while ((str = buffer.readLine()) != null) {
                        resposta += str;
                    }

                    // Agora se a resposta está certa va para o proximo passo.
                    if(resposta.equals("O prisoneiro B foi o verdadeiro monstro!")){
                        System.out.println("O enigma foi resolvido!");
                        resolvido = true;
                    } else{
                        System.out.println("Parece que a resposta está errada. Melhor tentar novamente...");
                    }
                }
                catch (IOException e) {
                    System.out.println("Ocorreu algum erro com o arquivo! Não foi encontrado.");
                    //e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            System.out.println("Ocorreu algum erro com o arquivo!");
            e.printStackTrace();
        }
    }

}
