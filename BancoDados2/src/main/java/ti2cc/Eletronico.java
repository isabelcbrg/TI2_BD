package ti2cc;

public class Eletronico {
	private int codigo;            // PK e NOT NULL
	private String nome;           // NOT NULL
	private double valor;
	private int quantidade;

	public Eletronico() {
		this.codigo = -1;
		this.nome = "";
		this.valor = 0.0;
		this.quantidade = 0;
	}

	public Eletronico(int codigo, String nome, double valor, int quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	// Getters e Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Eletronico [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + "]";
	}
}

