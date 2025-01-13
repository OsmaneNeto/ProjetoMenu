package telas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classe.Aluno;

public class TelaAluno extends JFrame {
	private JLabel jlNome, jlNota1, jlNota2;
	private JTextField jtfNome, jtfNota1, jtfNota2;
	private JButton jbCadastrar, jbMostrar;
	private Aluno aluno = null;
	
	public TelaAluno(String title) throws HeadlessException {
		super(title);
		setSize(400, 400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		criarEventos();
		
	}

	private void iniciarComponentes() {
		//Objetos
		jlNome= new JLabel("Nome");
		jtfNome= new JTextField();
		
		jlNota1= new JLabel("Nota1");
		jtfNota1= new JTextField();
		
		jlNota2= new JLabel("Nota2");
		jtfNota2= new JTextField();
		
		jbCadastrar= new JButton("Cadastrar");
		jbMostrar= new JButton("Mostrar");
		
		//Adicionar
		add(jlNome);
		add(jtfNome);
		
		add(jlNota1);
		add(jtfNota1);
		
		add(jlNota2);
		add(jtfNota2);
		
		
		add(jbCadastrar);
		
		add(jbMostrar);
		
		//Dimensionamento
		jlNome.setBounds(10, 20, 50, 20);
		jtfNome.setBounds(10, 40, 200, 20);
		
		jlNota1.setBounds(10, 70, 50, 20);
		jtfNota1.setBounds(10, 90, 50, 20);
		
		jlNota2.setBounds(160, 70, 50, 20);
		jtfNota2.setBounds(160, 90, 50, 20);
		
		jbCadastrar.setBounds(60, 120,100, 20);
		
		jbMostrar.setBounds(60, 150, 100, 20);
		
	}

	private void criarEventos() {
		//Criar exemplo do espaço do botão cadastrar
		jbCadastrar.addActionListener(new ActionListener() {//addActionListener Toda a interface cria metodos secretos
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Declarar as variaveis
				String nome;
				float nota1, nota2;
				
				//a validação do campo em vazio
				if (!jtfNome.getText().isEmpty()&&!jtfNota1.getText().isEmpty()&&!jtfNota2.getText().isEmpty()) {
					
					//entradas
					nome = jtfNome.getText();
					nota1= Float.parseFloat(jtfNota1.getText());
					nota2= Float.parseFloat(jtfNota2.getText());
					
					//Objeto
					aluno = new Aluno(nome, nota1, nota2);
					
					//Processamento
					aluno.calcularMedia();
					
					//Apagar os campos
					jtfNome.setText("");
					jtfNota1.setText("");
					jtfNota2.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos", "A Escola", JOptionPane.WARNING_MESSAGE);
				}//fim do IFELSE
			
			}
		});//fim do evento
		
		//Crar Evento do Botão Mostrar
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Validação do Objeto Nulo
				if (aluno != null) {
					JOptionPane.showMessageDialog(null, aluno.mostrarDados()+"\n"+ aluno.verificarStatusAluno() );
				} else {
					JOptionPane.showMessageDialog(null, 
							"Não a Alunos Cadastrados",
							"A Escola", JOptionPane.WARNING_MESSAGE);//pegar com 4 elementos
				}
			}
		});
	}

}
