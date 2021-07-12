package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import model.Veiculo;

public class MovimentoDao {

	private Veiculo veiculo;
	private static final String LOCAL_ARQUIVO = "C:/Users/21192920/Documents/movimentacao.ds1";

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public MovimentoDao(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public MovimentoDao() {

	}

	public void salvar() {
		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(veiculo.getCodigo() + ";" + veiculo.getPlaca() + ";" + veiculo.getModelo() + ";"
					+ veiculo.getTempo() + ";" + veiculo.getHoraEntrada() + ";" + veiculo.getDataSaida() + ";"
					+ veiculo.getHoraSaida() + ";" + veiculo.getTempo() + ";" + veiculo.getValorPagar());

			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			System.out.println("NÃO FOI POSSIVEL CADASTAR OS DADOS!");
		}

	}

	public ArrayList<Veiculo> listarMovimentos() {

		// Passo 1 - Obter o caminho do arquivo

		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo

		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			ArrayList<Veiculo> veiculos = new ArrayList<>();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				Veiculo veiculo = new Veiculo();
				veiculo.setCodigo(vetorMovimento[0]);
				veiculo.setPlaca(vetorMovimento[1]);
				veiculo.setModelo(vetorMovimento[2]);
				veiculo.setDataEntrada(vetorMovimento[3]);
				veiculo.setHoraEntrada(vetorMovimento[4]);
				veiculo.setDataSaida(vetorMovimento[5]);
				veiculo.setHoraSaida(vetorMovimento[6]);
				veiculo.setTempo(vetorMovimento[7]);
				// veiculo.setValorPagar(vetorVeiculo[1]);

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

	public Veiculo buscarMovimento(String placa) {

		// Passo 1 - obter o caminho do arquivo

		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo
		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			Veiculo veiculo = new Veiculo();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				if (vetorMovimento[0].equals(placa)) {
					veiculo.setCodigo(vetorMovimento[0]);
					veiculo.setPlaca(vetorMovimento[1]);
					veiculo.setModelo(vetorMovimento[2]);
					veiculo.setDataEntrada(vetorMovimento[3]);
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
	}
}
