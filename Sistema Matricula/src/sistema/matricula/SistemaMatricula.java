package sistema.matricula;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SistemaMatricula {
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    
 // Adicionando cursos com vagas, carga horária e preço
    public SistemaMatricula() {
        cursos.add(new Curso("Engenharia de Software", 30, 890, 1745.74));
        cursos.add(new Curso("Ciências da Computação", 30, 890, 1549.79));
        cursos.add(new Curso("Análise e Desenvolvimento de Sistemas", 30, 250, 1051.01));
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    		//avisos caso tenha algum problema na matricula
    public boolean matricularAluno(Aluno aluno, Curso curso) {
        if (!aluno.validarIdade()) {
            JOptionPane.showMessageDialog(null, "Aluno deve ter mais de 16 anos para se matricular.", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!aluno.validarMatricula()) {
            JOptionPane.showMessageDialog(null, "O número de matrícula deve conter pelo menos 10 caracteres.", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!curso.temVagas()) {
            JOptionPane.showMessageDialog(null, "Não há vagas disponíveis no curso escolhido.", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        alunos.add(aluno);
        curso.matricularAluno();
        return true;
    }
}
