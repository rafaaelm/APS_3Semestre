package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CarregaCSV {

	public ArrayList<String> leCSV(String arquivoCSV){
		String linha = "";
		ArrayList<String> listaTotal = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/planilhas/" + arquivoCSV + ".csv"));
			while( (linha = br.readLine()) != null ) {
				String[] lista = linha.split(";");
				for( int i = lista.length; i > 0; i--) {
					String massa =  lista[lista.length-i];
					listaTotal.add(massa);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			criaCSV(arquivoCSV);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return listaTotal;
	}

	public void criaCSV(String arquivoCSV) {
		File arquivoNovo = new File("src/planilhas/" + arquivoCSV + ".csv");
		try {
			arquivoNovo.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escreveCSV(String arquivoCSV, String linha) {
		try {
			FileWriter arq = new FileWriter("src/planilhas/" + arquivoCSV + ".csv", true);
			arq.write(linha + "\n");
			arq.close();

		} catch (FileNotFoundException e) {
			criaCSV(arquivoCSV);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void limpaCSV(String arquivoCSV) {
		try {
			FileWriter arq = new FileWriter("src/planilhas/" + arquivoCSV + ".csv", false);
			arq.write("");
			arq.close();

		} catch (FileNotFoundException e) {
			criaCSV(arquivoCSV);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}