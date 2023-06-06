import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Interface2 {
    public static void main(String[] args) {
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        // componente JFrame
        JFrame frame = new JFrame("PJBL");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // componente JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] texts = {"Texto do Bob", "Texto do Rafa", "Texto do Leo"};

        JPanel bob = createClickablePanel(Color.RED, texts[0]);
        JPanel rafa = createClickablePanel(Color.BLUE, texts[1]);
        JPanel leo = createClickablePanel(Color.GREEN, texts[2]);

        panel.add(createMarginPanel(bob, (int) (screenWidth * 0.05))); // Adiciona margem à esquerda de Bob
        panel.add(createMarginPanel(rafa, (int) (screenWidth * 0.05))); // Adiciona margem entre Bob e Rafa
        panel.add(createMarginPanel(leo, (int) (screenWidth * 0.05))); // Adiciona margem à direita de Leo

        // conectar JPanel a JFrame
        frame.add(panel);
        frame.revalidate();

        Scanner scanner = new Scanner(System.in);

        // Pra ver se tudo foi resolvido
        boolean resolvido = false;

        // O arraylist das pistas
        ArrayList<Integer> pistas = new ArrayList<Integer>();

        System.out.println("Bem vindo ao jogo Detetive!");

        while (!resolvido) {
            System.out.println("Escolha o que deseja fazer: 1 - Resolver um enigma 2 - Restaurar uma pista queimada.");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    Enigma m = new Enigma();
                    m.enigmas();
                    break;
                case 2:
                    Queima2 pista = new Queima2("Uma faca danificada com as iniciais B.O.B");
                    pista.exibir();
                    try {
                        pista.salvar("Pista_queimada.ser");
                        System.out.println("Pista Queimada criada e salva com sucesso! Parece que você salvou uma nova pista.\n Agora como recuperar ela...");
                    } catch (IOException e) {
                        System.out.println("Excecao de I/O");
                        e.printStackTrace();
                    }
                    break;
                default:
                    resolvido = true;
                    System.out.println("Algo deu errado!");
                    break;
            }
        }
    }

    public static JPanel createClickablePanel(Color color, String text) {
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, text);
            }
        });

        panel.setPreferredSize(new Dimension((int) (screenWidth * 0.05), (int) (screenHeight * 0.05))); // Define o tamanho desejado para os retângulos

        return panel;
    }

    public static JPanel createMarginPanel(JComponent component, int marginSize) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(component, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));

        return panel;
    }
}

class Interface2 {
    // Você pode adicionar a implementação adicional da classe Interface aqui
}

class Enigma2 {
    public void enigmas() {
        // Lógica para resolver enigmas
    }
}

class Queima2 implements Serializable {
    private String descricao;

    public Queima2(String descricao) {
        this.descricao = descricao;
    }

    public void exibir() {
        System.out.println("Pista Queimada: " + descricao);
    }

    public void salvar(String nomeArquivo) throws IOException {
        // Lógica para salvar a pista queimada em um arquivo
    }
}
