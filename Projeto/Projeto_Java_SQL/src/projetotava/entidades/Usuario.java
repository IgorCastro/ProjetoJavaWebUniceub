/* Classe do usuario, 
 * Nela contem todos os dados que será salvo no Banco
 * 
 * Reprensata a tabela do Banco de dados
 * Para cada tabela, cliase um crasse com o mesmo nome e mesmo atribuos e tipos
 * 
 * 
 */

package projetotava.entidades;

public class Usuario {
	
	private Integer id;//Cria as classes variaveis
	private String nome;
	private String login;
	private String senha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
