package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Movimento;

public class MovimentoDao {

	private Movimento veiculo;
	private static final String LOCAL_ARQUIVO = "C:/Users/21192920/Documents/movimentacao.ds1";

	public Movimento getVeiculo() {
		return veiculo;
	}

	public MovimentoDao(Movimento veiculo) {
		this.veiculo = veiculo;
	}

	public MovimentoDao() {

	}

	public void salvar() {
		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(veiculo.toString());

			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			System.out.println("NÃO FOI POSSIVEL CADASTAR OS DADOS!");
		}

	}

	public ArrayList<Movimento> listarMovimentos() {

		// Passo 1 - Obter o caminho do arquivo

		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo

		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			ArrayList<Movimento> veiculos = new ArrayList<>();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				Movimento veiculo = new Movimento();
				veiculo.setCodigo(vetorMovimento[0]);
				veiculo.setPlaca(vetorMovimento[1]);
				veiculo.setModelo(vetorMovimento[2]);
				veiculo.setDataEntrada(vetorMovimento[3]);
				veiculo.setHoraEntrada(vetorMovimento[4]);
//				veiculo.setDataSaida(vetorMovimento[5]);
//				veiculo.setHoraSaida(vetorMovimento[6]);
//				veiculo.setTempo(vetorMovimento[7]);
//				veiculo.setValorPagar(vetorVeiculo[1]);

				veiculos.add(veiculo);
				
				linha = reader.readLine();

			}
			reader.close();
			return veiculos;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace();
			return null;
		}

	}

	public Movimento buscarMovimento(String placa) {

		// Passo 1 - obter o caminho do arquivo

		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo
		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			Movimento veiculo = new Movimento();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				if (vetorMovimento[0].equals(placa)) {
					veiculo.setCodigo(vetorMovimento[0]);
					veiculo.setPlaca(vetorMovimento[1]);
					veiculo.setModelo(vetorMovimento[2]);
					veiculo.setDataEntrada(vetorMovimento[3]);
	                veiculo.setHoraEntrada(vetorMovimento[4]);
	                //veiculo.setDataSaida(vetorMovimento[5]);
	                //veiculo.setHoraSaida(vetorMovimento[6]);

	                veiculo.setDataSaida(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	                veiculo.setHoraSaida(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
//	                veiculo.setTempo(vetorMovimento[7]);
	                break;
				}
				
				linha = reader.readLine();

			}
			reader.close();
			return veiculo;


		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace();
			return null;
		}
		//return veiculo;

	}
	
}
