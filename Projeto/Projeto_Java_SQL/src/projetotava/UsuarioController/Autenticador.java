/*Servlet responsavel por autenticar os dados vindo da tela de login
 * 
 */

package projetotava.UsuarioController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projetotava.entidades.Usuario;
import projetotava.jdbc.UsuarioDAO;

@WebServlet(name = "AutenticadorController", urlPatterns = { "/autcontroller.do" })
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Autenticador() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession(false);
		
		if(sessao != null){
			sessao.invalidate();
			
		}
		response.sendRedirect("login.html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Captura de dados da tela
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Constroi Objeto usaurio para consulta
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		//Busca no bancol
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuRetorno =  usuarioDAO.autencicar(usuario);
		if(usuRetorno != null){
			
			//criando sessão
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(3000);
			sessao.setAttribute("usuLogado", usuRetorno);
			
			//Encaminhando ao index
			request.getRequestDispatcher("index.jsp").forward(request, response);;
			
			
			
		}else{
			
			response.sendRedirect("login.html");
		}
		
		
		
	}

}
