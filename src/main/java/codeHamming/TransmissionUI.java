package codeHamming;

import javax.swing.*;
import java.awt.*;

public class TransmissionUI extends JFrame {
    private JTextField inputField;
    private JTextArea messageArea;

    public TransmissionUI() {
        super("Transmission");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        inputField = new JTextField();
        JButton transmitButton = new JButton("Transmettre");
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        transmitButton.addActionListener(e -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                Transmission transmission = new Transmission(input);
                transmission.setMsgToSend();
                messageArea.setText("Message à transmettre : " + transmission.toString());
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(transmitButton, BorderLayout.EAST);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TransmissionUI::new);
    }
}
