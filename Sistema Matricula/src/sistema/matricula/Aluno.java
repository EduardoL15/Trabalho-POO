package sistema.matricula;

public class Aluno {
    private String nome;
    private String matricula;
    private int idade;

    // Métodos Getters e Setters
    public Aluno(String nome, String matricula, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }
    
    public String getNome() {
    	return nome;
    }

    public void setNome(String nome) {
    	this.nome = nome;
    }

    public String getMatricula() {
    	return matricula;
    }

    public void setMatricula(String matricula) {
    	this.matricula = matricula;
    }

    public int getIdade() {
    	return idade;
    }

    public void setIdade(int idade) {
    	this.idade = idade;
    }

    // Método para validar se o aluno tem 16 anos ou mais
    public boolean validarIdade() {
        return idade >= 16;
    }

    // Método para validar o tamanho da matrícula de mínimo 10 caracteres
    public boolean validarMatricula() {
        return matricula.length() >= 10;
    }
}
