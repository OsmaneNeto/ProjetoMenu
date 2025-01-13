package classe;

import javax.swing.JOptionPane;

public class AlunoPrincipal {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//criando as opções de menu
		String [] menu= {"Cadastrar", "Pesquisar", "Mostrar", "Sair"};//matriz Estatica
		String opcao;
		Aluno aluno = null;
		//DoWhile
		do {
			opcao= (String) JOptionPane.showInputDialog(null, "Escolha uma opção", " A escola", JOptionPane.INFORMATION_MESSAGE, null, menu, "Cadastrar");
		switch (opcao) {
		case "Cadastrar":
			//declarar variaveis
			String nome;
			float nota1;
			float nota2;
			nome= JOptionPane.showInputDialog("Entre com o nome do Aluno");
			nota1= Float.parseFloat(JOptionPane.showInputDialog("Entrar com a primeira nota"));
			nota2= Float.parseFloat(JOptionPane.showInputDialog("Entrar com a segunda nota"));
			//objeto
			aluno=new Aluno(nome, nota1, nota2);
			//processamento
			aluno.calcularMedia();
			aluno.verificarStatusAluno();
			break;
		case "Pesquisar":
		
			if (aluno != null) {
				String nomepesquisa= JOptionPane.showInputDialog("Entre com o nome a ser pesquisado");
				if (aluno.nome.equals(nomepesquisa)) {
					JOptionPane.showMessageDialog(null, aluno.mostrarDados());
				} else {
					JOptionPane.showMessageDialog(null, "Nome de aluno não cadastrado", "A Escola", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Não há  alunos cadastrados ", "A Escola", JOptionPane.WARNING_MESSAGE);

			}
			
			break;
		case "Mostrar":
			if (aluno != null) {//primeira validação
				JOptionPane.showMessageDialog(null, aluno.mostrarDados());
			} else {
				JOptionPane.showMessageDialog(null, "Não há  alunos cadastrados ", "A Escola", JOptionPane.WARNING_MESSAGE);
			}
			
			
			break;
		
		default:break;
		}//fim do switch
		
		} while (!opcao.equals( "Sair"));
	}

}
