package sistema.matricula;

public class Curso {
    private String nome;
    private int cargahoraria;
	private double preco;
    private int vagas;

    public Curso(String nome, int vagas, int cargahoraria, double preco) {
        this.nome = nome;
        this.vagas = vagas;
        this.cargahoraria = cargahoraria;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }

    public int getCargaHoraria() {
    	return cargahoraria;
    }

    public void setCargaHoraria(int cargahoraria) {
    	this.cargahoraria = cargahoraria;
    }

    public double getPreco() {
    	return preco;
    }

    public void setPreco(double preco) {
    	this.preco = preco;
    }

    public boolean temVagas() {
        return vagas > 0;
    }

    public void matricularAluno() {
        if (temVagas()) {
            vagas--;
        }
    }
    
    @Override
    public String toString() {
        return nome + " - Carga Horária: " + cargahoraria + "h - Preço: R$ " + preco;
    }
}
