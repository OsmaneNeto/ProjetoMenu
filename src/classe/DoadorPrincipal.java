package classe;

import javax.swing.JOptionPane;

public class DoadorPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//criando as opções de menu
		String [] menu= {"Cadastrar", "Pesquisar", "Mostrar", "Sair"};//matriz Estatica
		String opcao;
		Doador doador= null;

		//dowhile
		do {
			opcao= (String) JOptionPane.showInputDialog(null, "Escolha uma opção", " Doação ", JOptionPane.INFORMATION_MESSAGE, null, menu, "Cadastrar");
			switch (opcao) {
		case "Cadastrar":
			//declarar variaveis
			String nome, genero;
			float peso;
			int idade;
			//entradas
			nome= JOptionPane.showInputDialog("Entre com o nome do Doador");
			idade= Integer.parseInt(JOptionPane.showInputDialog("Entre com a idade do doador"));
			peso= Float.parseFloat(JOptionPane.showInputDialog("Entrar com o peso do doador"));
			genero= JOptionPane.showInputDialog("Entre com o genero do Doador").toUpperCase();
			//objeto
			doador = new Doador(nome, peso, idade, genero);
			//processamento
			doador.mostrarDados();
			doador.mostrarQuantidadedeSangue();
			break;
		case "Pesquisar":
			if (doador != null) {
				String nomepesquisa= JOptionPane.showInputDialog("Entre com o nome a ser pesquisado");
				if (doador.nome.equals(nomepesquisa)) {
					JOptionPane.showMessageDialog(null, doador.mostrarDados()+"\n" +doador.mostrarQuantidadedeSangue());//maracutaia
				} else {
					JOptionPane.showMessageDialog(null, "Nome de Doador não cadastrado", "Doação", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Não há  Doadores cadastrados ", "Doação", JOptionPane.WARNING_MESSAGE);

			}

			
			break;
		case "Mostrar":
			if (doador != null) {//primeira validação
				JOptionPane.showMessageDialog(null, doador.mostrarDados()+"\n" +doador.mostrarQuantidadedeSangue());
			} else {
				JOptionPane.showMessageDialog(null, "nenhum doador cadastrado" , "Doação", JOptionPane.WARNING_MESSAGE);
			}break;
			

		default:break;
		}//fim do switch
		
		} while (!opcao.equals( "Sair"));
	}
	}



