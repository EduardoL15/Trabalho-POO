package sistema.matricula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe Main, extensão da classe JFrame para criar uma janela gráfica no Java Swing
public class Main extends JFrame {
    private SistemaMatricula sistemaMatricula; // instância do sistema de matrículas
    private JComboBox<String> cursoComboBox; // selecionar os cursos disponíveis
    private JTextField nomeAlunoField, matriculaAlunoField, idadeAlunoField; // usuário inserir as informações 
    private JButton matricularButton; // botão matricular

    public Main() {
        sistemaMatricula = new SistemaMatricula();
        setTitle("Sistema de Matrícula"); // título da janela
        setSize(400, 300); // tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerra o programa quando a janela for fechada
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // layout do Java Swing
        gbc.insets = new Insets(10, 10, 10, 10); // espaçamento do GridBagLayout
        gbc.fill = GridBagConstraints.HORIZONTAL; // expandir a página horizontalmente

        JLabel cursoLabel = new JLabel("Curso:"); // exibe o texto na interface
        cursoComboBox = new JComboBox<>(); // exibe a lista de cursos disponíveis
        for (Curso curso : sistemaMatricula.getCursos()) { 
            cursoComboBox.addItem(curso.getNome());
        }

        JLabel nomeLabel = new JLabel("Nome do Aluno:"); 
        nomeAlunoField = new JTextField(20); // tamanho do campo de texto

        JLabel matriculaLabel = new JLabel("Matrícula:");
        matriculaAlunoField = new JTextField(20);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeAlunoField = new JTextField(5);

        matricularButton = new JButton("Matricular"); // botão para matricular
        matricularButton.addActionListener(new MatricularAlunoListener());

        gbc.gridx = 0; // posição do layout
        gbc.gridy = 0;
        add(cursoLabel, gbc);

        gbc.gridx = 1;
        add(cursoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nomeLabel, gbc);

        gbc.gridx = 1;
        add(nomeAlunoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(matriculaLabel, gbc);

        gbc.gridx = 1;
        add(matriculaAlunoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(idadeLabel, gbc);

        gbc.gridx = 1;
        add(idadeAlunoField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(matricularButton, gbc);
    }

    // Classe com a interface ActionListener
    private class MatricularAlunoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {    // inserir os dados do aluno
                String nome = nomeAlunoField.getText();
                String matricula = matriculaAlunoField.getText();
                int idade = Integer.parseInt(idadeAlunoField.getText());

                Aluno aluno = new Aluno(nome, matricula, idade);
                String cursoNome = (String) cursoComboBox.getSelectedItem();
                Curso cursoSelecionado = null; 
                for (Curso curso : sistemaMatricula.getCursos()) {
                    if (curso.getNome().equals(cursoNome)) { // comparar as strings
                        cursoSelecionado = curso;
                        break;
                    }
                }

                if(sistemaMatricula.matricularAluno(aluno, cursoSelecionado)) {
                JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
                }
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Idade inválida, deve ser um número.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main sistema = new Main();
            sistema.setVisible(true); // exibir a janela principal
        });
    }
}
