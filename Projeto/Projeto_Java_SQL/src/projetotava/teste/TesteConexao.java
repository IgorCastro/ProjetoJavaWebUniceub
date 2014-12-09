/*
 * Classe responsavel por testar a conexão com o Banco de dados
 * 
 * 
 */

package projetotava.teste;

import projetotava.jdbc.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
		//Chama o metodo "getConnection" da classe "Conexão"
		Conexao.getConnection();
	}

}
