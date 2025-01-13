package classe;

public class CadastroPet {
public String nomeCliente;
public String nomePet;
public String tipodePet;
public int telefone;
public String endereco;

//construtor
public CadastroPet(String nomeCliente, String nomePet, String tipodePet, int telefone, String endereco) {
	super();
	this.nomeCliente = nomeCliente;
	this.nomePet = nomePet;
	this.tipodePet = tipodePet;
	this.telefone = telefone;
	this.endereco = endereco;
}
//metodo mostrar
public String mostrarDadosCliente() {
	return "Nome do Cliente: "+this.nomeCliente
			 + "\nNome do pet: "+this.nomePet
			+ "\nTipo de pet: " + this.tipodePet
			+ "\ntelefone do Cliente: " + this.telefone
			+ "\nendereço do cliente: " + this.endereco;
}
//mostrar dados Pet
	public String mostrarDadosPet() {
		return "\nNome do Cliente: "+this.nomeCliente
				 +"\nNome do pet: "+this.nomePet
				+ "\nTipo de pet: " + this.tipodePet;
				
}

	
}