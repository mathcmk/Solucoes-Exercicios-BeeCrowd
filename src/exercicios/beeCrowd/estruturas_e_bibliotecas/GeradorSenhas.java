package exercicios.beeCrowd.estruturas_e_bibliotecas;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class GeradorSenhas extends JFrame {

    private JTextField originField;
    private JTextField lengthField;
    private JTextField resultField;

    private JButton generateButton;
    private JButton saveButton;

    private DefaultListModel<String> listModel;
    private JList<String> passwordList;

    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz" +
                    "0123456789" +
                    "!@#$%^&*()-_=+[]{}<>?/";

    private SecureRandom random = new SecureRandom();

    public GeradorSenhas() {
        setTitle("Password Manager 🔐");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new GridLayout(5, 1));

        originField = new JTextField();
        lengthField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        generateButton = new JButton("Gerar Senha");
        saveButton = new JButton("Salvar Senha");

        topPanel.add(new JLabel("Origem (ex: Google, Supabase):"));
        topPanel.add(originField);

        topPanel.add(new JLabel("Tamanho da senha:"));
        topPanel.add(lengthField);

        topPanel.add(generateButton);

        // ===== CENTER LIST =====
        listModel = new DefaultListModel<>();
        passwordList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(passwordList);

        // ===== BOTTOM PANEL =====
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(resultField);
        bottomPanel.add(saveButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // ===== EVENTS =====
        generateButton.addActionListener(e -> generatePassword());
        saveButton.addActionListener(e -> savePassword());
    }

    private void generatePassword() {
        try {
            int length = Integer.parseInt(lengthField.getText());

            if (length <= 0) {
                resultField.setText("Tamanho inválido!");
                return;
            }

            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(CHARACTERS.length());
                password.append(CHARACTERS.charAt(index));
            }

            resultField.setText(password.toString());

        } catch (NumberFormatException e) {
            resultField.setText("Digite um número válido!");
        }
    }

    private void savePassword() {
        String origin = originField.getText();
        String password = resultField.getText();

        if (origin.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Preencha origem e gere uma senha primeiro!");
            return;
        }

        String entry = origin + " - " + password;
        listModel.addElement(entry);

        // limpa só a senha gerada
        resultField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GeradorSenhas().setVisible(true);
        });
    }
}