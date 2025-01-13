package classe;

import javax.swing.JOptionPane;

public class PrincipalFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//criando as opções de menu
		String [] menu= {"Cadastrar", "Pesquisar", "Mostrar", "Sair"};//matriz Estatica
		String opcao;
		Funcionario funcionario= null;
		//doWhile
		do {
			opcao= (String) JOptionPane.showInputDialog(null, "Escolha uma opção", " A Empresa", JOptionPane.INFORMATION_MESSAGE, null, menu, "Cadastrar");
		switch (opcao) {
		case "Cadastrar":
			//declarar variaveis
			String nome;
			float salario;
			int identificacao;
			//entradas
			nome = JOptionPane.showInputDialog("Entre com o Nome do Funcionário").toUpperCase();;
			salario= Float.parseFloat(JOptionPane.showInputDialog("Entre com o salário do Funcionário"));
			identificacao= Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de identificação do funcionário"));
			//objeto
			funcionario= new Funcionario(nome, salario, identificacao);
			//Processamento
			funcionario.mostrarDados();
			funcionario.calcularReajusteSalario();
			break;
			
		case "Pesquisar":
			if (funcionario != null) {
				String nomepesquisa= JOptionPane.showInputDialog("Entre com o nome a ser pesquisado");
				if (funcionario.nome.equals(nomepesquisa)) {
					JOptionPane.showMessageDialog(null, funcionario.mostrarDados()+"\n reajuste salarial: " +funcionario.calcularReajusteSalario());//maracutaia
				} else {
					JOptionPane.showMessageDialog(null, "Nome do funcionario não cadastrado", "A Empresa", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Não há  funcionarios cadastrados ", "A Empresa", JOptionPane.WARNING_MESSAGE);
}

			break;
		case "Mostrar":
		if (funcionario != null) {
			JOptionPane.showMessageDialog(null, funcionario.mostrarDados()+"\n reajuste salarial: " +funcionario.calcularReajusteSalario());

			} else {
				JOptionPane.showMessageDialog(null, "nenhum Funcionário cadastrado" , "A Empresa", JOptionPane.WARNING_MESSAGE);
		}
		break;
		
		}//fim do switch
		
		} while (!opcao.equals( "Sair"));
	}
	}
		
	
		
	
