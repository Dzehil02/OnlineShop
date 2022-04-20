package by.iba.resources;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.services.CatalogService;

import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 2264498497546081400L;

	private CatalogService service;

	public CatalogServlet() {
		super();
		service = new CatalogService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("productList", service.getCatalog());
		request.getRequestDispatcher("catalog.jsp").forward(request, response);
	}

}
