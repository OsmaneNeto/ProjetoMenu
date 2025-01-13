package classe;

public class Funcionario {
//entradas
public String nome;
public float salario;
public int identificacao;
//construtor
public Funcionario(String nome, float salario_atual, int identificacao) {
	super();
	this.nome = nome;
	this.salario = salario_atual;
	this.identificacao = identificacao;
}
//metodo
public float calcularReajusteSalario() {
	if (this.salario >500) {
		if (this.salario<=1000) {
			this.salario = (float) (this.salario * 1.10);
		} else {
			this.salario = (float) (this.salario * 1.05);
		}
	} else {
		this.salario = (float) (this.salario * 1.15);
	}
	return this.salario;
}
public String mostrarDados() {
	return "Nome do Funcionário: "+this.nome
			+ "\nNúmero de Identificação: "+this.identificacao
			+ "\nSalário atual: "+this.salario+ "Reais";
}
}
