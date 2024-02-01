package codeHamming;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HammingGUI extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public HammingGUI() {
        // Configurer la fenêtre
        setTitle("Hamming Code");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Créer les composants de l'interface
        JLabel inputLabel = new JLabel("Entrer votre trame:");
        inputField = new JTextField(20);
        JButton processButton = new JButton("Traiter");
        outputArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Configurer le gestionnaire de disposition
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Ajouter les composants à la fenêtre
        add(inputLabel);
        add(inputField);
        add(processButton);
        add(scrollPane);

        // Ajouter un écouteur d'événements au bouton
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });
    }

    private void processInput() {
        String trame = inputField.getText();

        // Votre logique Hamming ici
        // ...

        // Afficher les résultats dans la zone de texte
        outputArea.setText("La trame: " + trame + "\nRésultats Hamming:\n");

        // Exemple : outputArea.append("C0 = " + valeurC0 + "\n");
        // Exemple : outputArea.append("C1 = " + valeurC1 + "\n");

        // Ajouter votre logique Hamming pour afficher les résultats dans la fenêtre
        // ...

        // Rafraîchir l'interface graphique
        validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HammingGUI().setVisible(true);
            }
        });
    }
}
