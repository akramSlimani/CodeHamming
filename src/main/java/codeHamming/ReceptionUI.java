package codeHamming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ReceptionUI extends JFrame {
    private Reception reception;
    private JTextArea messageArea;

    public ReceptionUI(String message) {
        super("Reception");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        add(scrollPane, BorderLayout.CENTER);

        Reception reception = new Reception(message);

        messageArea.append("Message reçu : " + reception.toString() + "\n");
        messageArea.append("Message net reçu (Sans bits de controle) : " + reception.toString() + "\n");
        messageArea.append("Error position : " + reception.getErrorPosition() + "\n");
        messageArea.append("Etat : " + (reception.SignalError() ? "Il y a une erreur" : "Signal Correct") + "\n");

        reception.correctMessage();

        messageArea.append("Message net corrigé (Sans bits de controle) : " + reception.toString() + "\n");
        messageArea.append("Error position : " + reception.getErrorPosition() + "\n");
        messageArea.append("Alors : " + (reception.SignalError() ? "Il y a une erreur" : "Signal Correct") + "\n");

        Scanner scanner = new Scanner(System.in);
        String trame = JOptionPane.showInputDialog("Entrez la trame (essayez 101101111011011(juste) ou (101101111011001 erroné)):");
        Reception t2 = new Reception(trame);

        messageArea.append("Message reçu : " + t2.toString() + "\n");
        messageArea.append("Message net reçu (Sans bits de controle) : " + t2.toString() + "\n");
        messageArea.append("Error position : " + t2.getErrorPosition() + "\n");
        messageArea.append("Etat : " + (t2.SignalError() ? "Il y a une erreur" : "Signal Correct") + "\n");

        t2.correctMessage();

        messageArea.append("Message net corrigé (Sans bits de controle) : " + t2.toString() + "\n");
        messageArea.append("Error position : " + t2.getErrorPosition() + "\n");
        messageArea.append("Alors : " + (t2.SignalError() ? "Il y a une erreur" : "Signal Correct") + "\n");

        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReceptionUI("101101111011011"));
    }
}
