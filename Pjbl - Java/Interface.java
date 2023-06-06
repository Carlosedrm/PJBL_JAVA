import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.BoxLayout;

public class Interface {

    public static void main(String[] args) throws IOException {
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
    }

    private static JPanel createClickablePanel(Color color, String text) {
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

    private static JPanel createMarginPanel(JComponent component, int marginSize) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(component, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));

        return panel;
    }
}
