package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Produto;


/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet("{categoria}/produto/{nome}")
public class FiltrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProdutoDAO dao = new ProdutoDAO();
	protected void doGet(HttpServletRequest request, int categoria, String nome, HttpServletResponse response) 
			  throws ServletException, IOException {
		
		List<Produto> retorno = null;
		try {
			retorno = dao.porNomeLike(nome, categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (retorno.equals("sucesso")) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel inserir o produto!</h2>");
			out.print("<br");
			out.print("<a href = 'index.jsp'> Voltar </a>");
			out.print("</html>");
		}				
	}
}
