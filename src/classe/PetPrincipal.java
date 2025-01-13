package classe;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PetPrincipal {

	public static void main(String[] args) {
		//criando as opções de menu
		String [] menu= {"Cadastrar", "Pesquisar", "Mostrar", "Sair"};//matriz Estatica
		String opcao;
		CadastroPet cadastroPet= null;
				

		//DoWhile
		do {opcao= (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "PetShop",  JOptionPane.INFORMATION_MESSAGE, null, menu, "Cadastrar");
			switch (opcao) {
			case "Cadastrar":
				//Declarações
				String nomeCliente;
				String nomePet;
				String tipodePet;
				int telefone;
				String endereco;
				
				//entradas
				nomeCliente= JOptionPane.showInputDialog("Entre com o Nome do Cliente");
				nomePet= JOptionPane.showInputDialog("Entre com o nome do Pet do Cliente");
				tipodePet= JOptionPane.showInputDialog("Entre com o Tipo do animal");
				endereco= JOptionPane.showInputDialog("Entre com o endereço do Cliente");
				telefone= Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de contato do Cliente"));
				
				//Objeto
				cadastroPet= new CadastroPet(nomeCliente, nomePet, tipodePet, telefone, endereco);
				//Processament
				cadastroPet.mostrarDadosCliente();
				cadastroPet.mostrarDadosPet();
				
				break;
			case "Pesquisar":
				if (cadastroPet!= null) {
					String nomepesquisa= JOptionPane.showInputDialog("Entre com o nome a ser pesquisado");
					
					if (cadastroPet.nomeCliente.equals(nomepesquisa)) {
						
						JOptionPane.showInternalMessageDialog(null,cadastroPet.mostrarDadosCliente() +"\n" +"\nDados do Animal" +"\n" +cadastroPet.mostrarDadosPet(), "PetShop", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imagens/iconePata.png"));
						
					} else {
						
						JOptionPane.showInternalMessageDialog(null, cadastroPet.mostrarDadosPet(),"PetShop", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imagens/iconePata.png"));
					}
				} else {
					
					JOptionPane.showInternalMessageDialog(null, "Não cadastrado" , "PetShop", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imagens/iconePata.png"));
				}
				break;
			
			case "Mostrar":
				if (cadastroPet != null) {//primeira validação
					JOptionPane.showInternalMessageDialog(null,cadastroPet.mostrarDadosCliente() +"\n" +"\nDados do Animal" +"\n" +cadastroPet.mostrarDadosPet(), "PetShop", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imagens/iconePata.png"));
				} else {
					
					JOptionPane.showInternalMessageDialog(null, "Não cadastrado" , "PetShop", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imagens/iconePata.png"));
				}
				break;

			
			default:break;
			}
		} while (!opcao.equals( "Sair"));
		
	}

}
