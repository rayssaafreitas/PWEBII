

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")

public class ValidaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Properties passwdFile;
		passwdFile = new Properties();
		String url = response.encodeURL("pagina1.jsp");
		
		try {
			passwdFile.load(this.getServletContext().getResourceAsStream("/WEB-INF/senhas.properties"));
		} catch (IOException e) {
			response.sendError(response.SC_BAD_REQUEST, "Erro!");
			return;
		}
		if (passwdFile.containsKey(login) && senha.equals(passwdFile.get(login))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("logado", login);
			session.setMaxInactiveInterval(10); 
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			request.setAttribute("erro", "Dados inv�lidos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
