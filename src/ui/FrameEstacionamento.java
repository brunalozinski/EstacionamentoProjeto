package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.MovimentoDao;
import model.Veiculo;
import util.Util;

public class FrameEstacionamento {

	private JLabel labelPlacaEntrada;
	private JTextField textPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JTextField textModeloEntrada;
	private JButton buttonEntrar;
	private JLabel labelEntrada;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelSaida;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JButton buttonBuscar;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;
	private JLabel labelPlacaSaida;
	private JTextField textPlacaSaida;
	private JLabel labelModeloSaida;
	private JTextField textModeloSaida;
	private JScrollPane scrollTable;
	private JTable tableTabelaVeiculos;
	private JFrame tela;
	private JLabel labelValorPagar;
	private JTextField textValorPagar;
	private JButton buttonEfetuarSaida;
	private JButton buttonFecharSistema;

	public void criarTela() {
	
		//Color corEspecial = new Color(230, 230, 250);
		Color corLetra = new Color(103, 185, 79);
		Color corButton = new Color(57, 118, 230);
		Color corButtonFechar = new Color(237, 28, 36);
		
		tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Cadastro de automóveis");
		tela.setSize(690, 590);
		//tela.getContentPane().setBackground(corEspecial);
		tela.getContentPane();
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		
		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setBounds(30, 10, 130, 30);
        labelEntrada.setFont(new Font("Arial", Font.BOLD, 16));
		labelEntrada.setForeground(corLetra);

		
		labelPlacaEntrada = new JLabel ("PLACA: ");
	    labelPlacaEntrada.setBounds(30, 40, 130, 30);
        //labelPlaca.setFont(new Font("Arial", Font.BOLD, 16));
		textPlacaEntrada = new JTextField();
		textPlacaEntrada.setBounds(25, 75, 215, 30);
		textPlacaEntrada.setForeground(corLetra);
		textPlacaEntrada.setFont(new Font("Arial", Font.BOLD, 18));

		labelModeloEntrada = new JLabel ("MODELO: ");
		labelModeloEntrada.setBounds(260, 40, 130, 30);
        //labelModelo.setFont(new Font("Arial", Font.BOLD, 16));
		textModeloEntrada = new JTextField();
		textModeloEntrada.setBounds(253, 75, 215, 30);
		textModeloEntrada.setForeground(corLetra);
		textModeloEntrada.setFont(new Font("Arial", Font.BOLD, 18));

		buttonEntrar = new JButton ("ENTRAR");
		buttonEntrar.setBounds(480, 75, 150, 30);
        //buttonEntrar.setFont(new Font("Arial", Font.BOLD, 18));
		buttonEntrar.setBackground(corButton);
		buttonEntrar.setForeground(Color.WHITE);

        labelSaida = new JLabel ("SAÍDA");
      	labelSaida.setBounds(30, 315, 130, 30);
        labelSaida.setFont(new Font("Arial", Font.BOLD, 16));
        labelSaida.setForeground(corLetra);
      	
      	labelPlacaSaida = new JLabel ("PLACA: ");
	    labelPlacaSaida.setBounds(30, 340, 130, 30);
        //labelPlaca1.setFont(new Font("Arial", Font.BOLD, 15));
		textPlacaSaida = new JTextField();
		textPlacaSaida.setBounds(25, 375, 100, 30);
		textPlacaSaida.setForeground(corLetra);
		textPlacaSaida.setFont(new Font("Arial", Font.BOLD, 18));

		buttonBuscar = new JButton ("BUSCAR");
		buttonBuscar.setBounds(130, 375, 100, 30);
        //buttonBuscar.setFont(new Font("Arial", Font.BOLD, 18));
		buttonBuscar.setBackground(corButton);
		buttonBuscar.setForeground(Color.WHITE);
		
		labelModeloSaida = new JLabel("Modelo: ");
	    labelModeloSaida.setBounds(30, 410, 70, 30);
	    textModeloSaida = new JTextField();
	    textModeloSaida.setBounds(25, 445, 100, 30);
	    textModeloSaida.setForeground(corLetra);
		textModeloSaida.setFont(new Font("Arial", Font.BOLD, 18));

        labelDataEntrada = new JLabel("Data Entrada: ");
        labelDataEntrada.setBounds(130, 410, 150, 30);
        textDataEntrada = new JTextField();
        textDataEntrada.setBounds(135, 445, 100, 30);
        textDataEntrada.setForeground(corLetra);
		textDataEntrada.setFont(new Font("Arial", Font.BOLD, 18));

        labelHoraEntrada = new JLabel("Hora Entrada: ");
        labelHoraEntrada.setBounds(240, 410, 110, 30);
        textHoraEntrada = new JTextField();
        textHoraEntrada.setBounds(245, 445, 100, 30);
        textHoraEntrada.setForeground(corLetra);
		textHoraEntrada.setFont(new Font("Arial", Font.BOLD, 18));
    
        labelDataSaida = new JLabel("Data saída: ");
        labelDataSaida.setBounds(350, 410, 70, 30);
        textDataSaida = new JTextField();
        textDataSaida.setBounds(355, 445, 100, 30);
        textDataSaida.setForeground(corLetra);
		textDataSaida.setFont(new Font("Arial", Font.BOLD, 18));
        
        labelHoraSaida = new JLabel("Hora saída: ");
        labelHoraSaida.setBounds(460, 410, 70, 30);
        textHoraSaida = new JTextField();
        textHoraSaida.setBounds(465, 445, 100, 30);
        textHoraSaida.setForeground(corLetra);
		textHoraSaida.setFont(new Font("Arial", Font.BOLD, 18));

        labelTempo = new JLabel("Tempo: ");
        labelTempo.setBounds(570, 410, 70, 30);
        textTempo = new JTextField();
        textTempo.setBounds(570, 445, 55, 30);
        textTempo.setForeground(corLetra);
		textTempo.setFont(new Font("Arial", Font.BOLD, 18));

        labelValorPagar = new JLabel("VALOR A PAGAR: ");
        labelValorPagar.setBounds(30, 500, 100, 30);
        textValorPagar = new JTextField();
        textValorPagar.setBounds(140, 495, 150, 45);
        textValorPagar.setForeground(corLetra);
		textValorPagar.setFont(new Font("Arial", Font.BOLD, 26));
        
        buttonEfetuarSaida = new JButton ("EFETUAR SAÍDA");
		buttonEfetuarSaida.setBounds(310, 495, 130, 45);
		buttonEfetuarSaida.setBackground(corButton);
		//buttonEfetuarSaida.setFont(new Font("Arial", Font.BOLD, 18));
		buttonEfetuarSaida.setForeground(Color.WHITE);

		
		buttonFecharSistema = new JButton ("FECHAR SISTEMA");
		buttonFecharSistema.setBounds(460, 495, 160, 45);
		buttonFecharSistema.setBackground(corButtonFechar);
		buttonFecharSistema.setForeground(Color.WHITE);
		
		
        tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlacaEntrada);
		tela.getContentPane().add(textPlacaEntrada);
		tela.getContentPane().add(labelModeloEntrada);
		tela.getContentPane().add(textModeloEntrada);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
        tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(buttonEntrar);
        tela.getContentPane().add(labelTempo);
        tela.getContentPane().add(textTempo);
        tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(textPlacaSaida);
		tela.getContentPane().add(labelModeloSaida);
		tela.getContentPane().add(textModeloSaida);
		tela.getContentPane().add(labelValorPagar);
		tela.getContentPane().add(textValorPagar);
		tela.getContentPane().add(buttonEfetuarSaida);
		tela.getContentPane().add(buttonFecharSistema);
		
		criarTabela();

		tela.setVisible(true);
		
		buttonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarFormulario()) {
					Veiculo movimento = new Veiculo();
					movimento.setCodigo(Util.gerarCodigo());
					movimento.setPlaca(textPlacaEntrada.getText());
					movimento.setModelo(textModeloEntrada.getText());
					movimento.setDataEntrada(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					movimento.setHoraEntrada(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
					
					
					MovimentoDao dao = new MovimentoDao(movimento);
					dao.salvar();

					JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!!");

					validarFormulario();
					
					limparFormulario();
					
				} else {
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		
		
		
		tableTabelaVeiculos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				String codigo;
				int linha = tableTabelaVeiculos.getSelectedRow();
				
				codigo = tableTabelaVeiculos.getModel().getValueAt(linha, 0).toString();
				
				MovimentoDao dao = new MovimentoDao();
				Veiculo cliente = dao.buscarMovimento(codigo);
				
				textPlacaEntrada.setText(cliente.getPlaca());
				textModeloEntrada.setText(cliente.getModelo());				
				
			}
		});
		
	}	
		
	private void criarTabela() {
			
			// Passo 1 - Criar o modelo da tabela
            
			DefaultTableModel tabelaEstacionamentoModelo = new DefaultTableModel();
			tabelaEstacionamentoModelo.addColumn("Código");
			tabelaEstacionamentoModelo.addColumn("Placa");
			tabelaEstacionamentoModelo.addColumn("Modelo");
			tabelaEstacionamentoModelo.addColumn("Data Entrada");
			            
			// Vetor que representa cada linha da tabela
			            
			MovimentoDao veiculosDao = new MovimentoDao();
			ArrayList<Veiculo> veiculos = veiculosDao.listarMovimentos();

			for (Veiculo veiculo : veiculos) {
			String[] vetorMovimento = { veiculo.getCodigo(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getDataEntrada() };
		    tabelaEstacionamentoModelo.addRow(vetorMovimento);         
			}
			            
			// Passo 2 - Criar a Tabela
			            
			JTable tableTabelaVeiculos = new JTable(tabelaEstacionamentoModelo);
			            
			// Determinar a largura das colunas 
			            
			tableTabelaVeiculos.getColumnModel().getColumn(0).setPreferredWidth(90);
			tableTabelaVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
			tableTabelaVeiculos.getColumnModel().getColumn(2).setPreferredWidth(110);
			            
		    tableTabelaVeiculos.getColumnModel().getColumn(0).setResizable(false);
			tableTabelaVeiculos.getTableHeader().setReorderingAllowed(false);
			            
			// Passo 3 - Colocar painel de rolagem na tabela (Scroll)
			            
			scrollTable = new JScrollPane (tableTabelaVeiculos);
			scrollTable.setBounds(25, 120, 609, 190);
			
			tela.getContentPane().add(scrollTable);
			
	}
	
	
	private void limparFormulario() {
		textPlacaEntrada.setText("");
		textModeloEntrada.setText("");
		
		textPlacaEntrada.requestFocus();
	}
	
	private boolean validarFormulario() {

		boolean valido = true;

		if (textPlacaEntrada.getText().trim().length() == 0) {
			labelPlacaEntrada.setForeground(Color.RED);
			valido = false;
		} else if (textModeloEntrada.getText().trim().length() == 0) {
			labelModeloEntrada.setForeground(Color.RED);
			valido = false;
		}

		return valido;

	}
	
}	
	