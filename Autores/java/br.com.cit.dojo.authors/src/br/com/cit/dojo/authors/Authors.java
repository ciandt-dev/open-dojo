package br.com.cit.dojo.authors;

import java.lang.reflect.Array;

/**
 * 
 * @author Dojo
 * 
 *         Quando se lista o nome de autores de livros, artigos e outras
 *         publica��es � comum que se apresente o nome do autor ou dos autores
 *         da seguinte forma: sobrenome do autor em letras mai�sculas, seguido
 *         de uma v�rgula e da primeira parte do nome apenas com as iniciais
 *         mai�sculas.
 * 
 *         Por exemplo:
 * 
 *         SILVA, Joao COELHO, Paulo ARAUJO, Celso de
 * 
 *         Seu desafio � fazer um programa que leia um n�mero inteiro
 *         correspondendo ao n�mero de nomes que ser� fornecido, e, a seguir,
 *         leia estes nomes (que podem estar em qualquer tipo de letra) e
 *         imprima a vers�o formatada no estilo exemplificado acima.
 * 
 *         As seguintes regras devem ser seguidas nesta formata��o: o sobrenome
 *         ser� igual a �ltima parte do nome e deve ser apresentado em letras
 *         mai�sculas;
 * 
 *         se houver apenas uma parte no nome, ela deve ser apresentada em
 *         letras mai�sculas (sem v�rgula): se a entrada for � Guimaraes� , a
 *         sa�da deve ser � GUIMARAES�;
 * 
 *         se a �ltima parte do nome for igual a "FILHO", "FILHA", "NETO",
 *         "NETA", "SOBRINHO", "SOBRINHA" ou "JUNIOR" e houver duas ou mais
 *         partes antes, a pen�ltima parte far� parte do sobrenome.
 * 
 *         Assim: se a entrada for "Joao Silva Neto", a sa�da deve ser
 *         "SILVA NETO, Joao" ; se a entrada for "Joao Neto" , a sa�da deve ser
 *         "NETO, Joao"; as partes do nome que n�o fazem parte do sobrenome
 *         devem ser impressas com a inicial mai�scula e com as demais letras
 *         min�sculas; "da", "de", "do", "das", "dos" n�o fazem parte do
 *         sobrenome e n�o iniciam por letra mai�scula.
 * 
 */
public class Authors {

	/**
	 * @param args
	 */

	private String[] names;

	/**
	 * @return the names
	 */
	public String[] getNames() {
		return names;
	}

	/**
	 * @param names
	 *            the names to set
	 */
	public void setNames(String[] names) {
		this.names = names;
	}

	public Authors(String[] names) {
		this.names = names;

		if (!isValid())
			throw new IllegalArgumentException("par�metro names");
		else {
			formatName();
		}

	}

	private boolean isValid() {

		for (int i = 0; i < this.names.length; i++) {
			if ("".equals(names[i])) {
				return false;
			}
		}
		return true;
	}

	private String camelCase(String name) {
		name = name.toLowerCase();
		char[] arrayName = name.toCharArray();
		arrayName[0] = name.toUpperCase().toCharArray()[0];

		return String.valueOf(arrayName);

	}

	private String formatWithThe(String name) {
		String exception[] = { "de", "da", "do", "das", "dos" };
		String[] littleBrokenName = name.split(" ");

		return "";
	}

	private void formatName() {
		String[] arraySplit;

		for (int i = 0; i < this.names.length; i++) {
			arraySplit = this.names[i].split(" ");

			if (arraySplit.length == 1) {
				this.names[i] = this.names[i].toUpperCase();
			} else if (arraySplit.length == 2) {
				this.names[i] = arraySplit[arraySplit.length - 1].toUpperCase()
						.concat(", ").concat(camelCase(arraySplit[0]));
			} else if (arraySplit.length == 3) {

				String withoutLastName = new String();
				for (int j = 0; j < arraySplit.length - 2; j++) {
					if (arraySplit[j].toLowerCase().equals("de")) {
						withoutLastName += arraySplit[j];
					} else {
						withoutLastName += " " + camelCase(arraySplit[j]);
					}
				}
				this.names[i] = arraySplit[arraySplit.length-1].toUpperCase().concat(", ").concat(withoutLastName);
			}
		}
	}

}
