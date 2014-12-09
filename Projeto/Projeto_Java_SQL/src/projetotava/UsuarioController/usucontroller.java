/*Obejeto java, responsavel por pegar os dados do banca, e 
 *passar para os objetos responsaveis.
 *Faz o papel do controladorç
 * 
 * 
 */

package projetotava.UsuarioController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetotava.entidades.Usuario;
import projetotava.jdbc.UsuarioDAO;

//Servet, necessario o Uso do ApacheTOmCat(Ou qualquer outro servidor)
//O TomCat capitura os dado da tela e insere no servlet
/*Servlet (servidorzinho em tradução livre) é uma classe Java usada para estender 
 *as funcionalidades de um servidor. Apesar dos servlets poderem responder a 
 *quaisquer tipos de requisições, eles normalmente são usados para estender as 
 *aplicações hospedadas por servidores web, desta forma eles podem ser imaginados 
 *como Applets Java que rodam em servidores em vez de rodarem nos navegadores web. 
 * 
 * Applet é um software aplicativo que é executado no contexto de outro programa (como por exemplo um web browser),
 * uma applet geralmente executa funções bem específicas. 
 * 
 * Uma Applet Java é uma applet enviada ao usuários em formato de bytecode Java. 
 * Applets em Java podem rodar em um web browser usando uma Java Virtual Machine (JVM) ou no AppletViewer da Sun,
 *  uma aplicação standalone para testar applets. As applets java foram introduzidas na primeira versão da linguagem Java, em 1995.
 */
@WebServlet("/usucontroller.do")//Nome pubico, para se acessado do navegador
public class usucontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public usucontroller() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DoGet, feita pela URL
		
		//Captura parametro da tela
		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO(); // Cria um novo objeto
		
		//Exluir
		if(acao != null && acao.equals("exc")){
			//Captura parametro da tela
			String id= request.getParameter("id");	
						
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuarioDAO.exluir(usuario);
			
			//redirecionamento pelo Browser para a lista
			response.sendRedirect("usucontroller.do?acao=lis");
			
		}
		//Alterar
		if(acao != null && acao.equals("alt")){
			//Captura parametro da tela
			String id = request.getParameter("id");		
			//Busca objeto usuario no banco 
			Usuario usuario = usuarioDAO.buscarPorID(Integer.parseInt(id));
			//Seta atributos no request com o objeto usuario
			request.setAttribute("usuario", usuario);
			//Encaminha objeto usuario para a tela
			RequestDispatcher saida =	request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
		}
		//Cadastrar
		if(acao != null && acao.equals("cad")){
			//Cria novo objeto usuario
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			//Seta atributos no request com o objeto usuario
			request.setAttribute("usuario", usuario);
			//Encaminha objeto usuario para a tela
			RequestDispatcher saida =	request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
			
		}
		//Listar
		if(acao != null && acao.equals("lis")){
		//GErar lista de usuarios cadastrados
				//OBter lista
		
		ArrayList<Usuario> lista = usuarioDAO.buscarTodos();
		
		
		
		//Colocar no request
		request.setAttribute("lista", lista);
		
		//Encaminhamento para o JSP
		//JSP é uma especei de Servlet
	RequestDispatcher saida =	request.getRequestDispatcher("listausuarios.jsp");
	saida.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Chamando MEtodo POST");
		//Recebe dados da tela
		String id = request.getParameter("txtid");
		String nome= request.getParameter("txtnome");
		String login= request.getParameter("txtlogin");
		String senha= request.getParameter("txtsenha");
		
		//Cria um objeto usuario e seta os valores vindos da tela
		Usuario usuario = new Usuario();
		
		if(id!=null && id!="" && id!="0" ){
			usuario.setId(Integer.parseInt(id));
		}	
		
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		//Pede para o usuarioDAO cadastrar no banco de dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salva(usuario);
		
		
		//Saida ao nevegador
		//PrintWriter saida= response.getWriter();
		//saida.print("Salvo com sucesso!");
		RequestDispatcher saida =	request.getRequestDispatcher("salvo.jsp");
		saida.forward(request, response);
	}

}
