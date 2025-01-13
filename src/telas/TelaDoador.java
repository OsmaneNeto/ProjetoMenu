
package telas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classe.Doador;

public class TelaDoador extends JFrame {
private JLabel jlNome, jlPeso, jlIdade, jlGenero;
private JTextField jtfNome, jtfPeso, jtfIdade;
private JButton jbCadastrar, jbMostrar;
private Doador doador=null;
private JRadioButton jrbMasculino, jrbFeminino;
private ButtonGroup bgGenero; //agrupa os radios buttons que somente um eja selecionado



		public TelaDoador(String title) throws HeadlessException {
			super(title);
			setSize(400, 400);
			setLayout(null);
			getContentPane().setBackground(Color.RED);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			iniciarComponentes();
			criarEventos();
			
	  }

		private void iniciarComponentes() {
			//Objeto
			jlNome= new JLabel("Nome");
			jtfNome= new JTextField();
			
			jlPeso= new JLabel("Peso");
			jtfPeso= new JTextField();
			
			jlIdade= new JLabel("Idade");
			jtfIdade= new JTextField();
			
			jbCadastrar= new JButton("Cadastrar");
			
			jbMostrar= new JButton("Mostrar");
			
			jrbMasculino= new JRadioButton("Masculino", true);
			jrbMasculino.setOpaque(false);;
			
			jrbFeminino= new JRadioButton("Feminino");
			jrbFeminino.setOpaque(false);;
			
			bgGenero= new ButtonGroup();
			jlGenero= new JLabel("Gênero");
			
			//adicionar
			add(jlNome);
			add(jtfNome);
			
			add(jlPeso);
			add(jtfPeso);
			
			add(jlIdade);
			add(jtfIdade);
			
			add(jbCadastrar);
			
			add(jbMostrar);
			
			add(jrbFeminino);
			add(jrbMasculino);
			
			
			add(jlGenero);
			bgGenero.add(jrbMasculino);
			bgGenero.add(jrbFeminino);
			
			
			//Dimensionamento 
		               	//Coluna, Linha, Comprimento e Largura.
			jlNome.setBounds(10, 20, 50, 20);//texto nome
			jtfNome.setBounds(10, 40, 200, 20);//quadrado nome

			jlPeso.setBounds(10, 60, 50, 20);
			jtfPeso.setBounds(10, 80, 50, 20);
			
			jlIdade.setBounds(160, 60, 50, 20);
			jtfIdade.setBounds(160, 80, 50, 20);
			
			jbCadastrar.setBounds(110, 120,100, 20);
			
			jbMostrar.setBounds(110, 150, 100, 20);
			jlGenero.setBounds(10, 110, 50, 20);
			
			jrbMasculino.setBounds(10, 130, 100, 20);
			jrbFeminino.setBounds(10, 150, 100, 20);
			
			
		}

		private void criarEventos() {
			//Criar exemplo do espaço do botão cadastrar
			jbCadastrar.addActionListener(new ActionListener() {//addActionListener Toda a interface cria metodos secretos
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// Declarar Variaveis
					 String nome;
					 float peso;
					 int idade;
					 String genero = null;
					 //validação do campo em vazio
					 if (!jtfNome.getText().isEmpty()&&!jtfPeso.getText().isEmpty()&&!jtfIdade.getText().isEmpty()) {
						 
						 //entradas
						 nome = jtfNome.getText();						
						 peso= Float.parseFloat(jtfPeso.getText());
						 idade= Integer.parseInt(jtfIdade.getText());
						 if (jrbMasculino.isSelected()){
							 genero = "Masculino";
						 }
						 else
						 {
							 genero = "Feminino";
						 }
						 //genero= jrbMasculino.isSelected()? "Masculino":"Feminino";
						 
						 //Objeto
						 doador= new Doador(nome, peso, idade, genero);
						 
						//Processamento
						doador.mostrarQuantidadedeSangue();
						 
						 //Apagar os campos
						 jtfNome.setText("");
						 jtfPeso.setText("");
						 jtfIdade.setText("");
			
					} else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Doação", JOptionPane.WARNING_MESSAGE);
					}//fim do If Else
				}
			});//Fim de eventos
			
			//Crar Evento do Botão Mostrar
			jbMostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//Validação do Objeto Nulo
					if (doador!=null) {
						JOptionPane.showMessageDialog(null, doador.mostrarDados()  + "\n" +doador.mostrarQuantidadedeSangue());
					} else {
						JOptionPane.showMessageDialog(null, "Não a doadores cadastrados ", "Doação", JOptionPane.WARNING_MESSAGE);
					}
				}
			});;
		}



}
