package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Produto;


/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet("/produto")
public class ListarProdutoPorCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProdutoDAO dao = new ProdutoDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listaPorCategoria(request, response);					
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
    private void listaPorCategoria(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));
		List<Produto> lista = dao.porCategoria(categoria);
		request.setAttribute("listaProduto", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarProdutos.jsp");
		dispatcher.forward(request, response);
	}
}
