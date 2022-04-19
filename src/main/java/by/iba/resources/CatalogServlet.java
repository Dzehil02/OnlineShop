package by.iba.resources;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.entities.Catalog;
import by.iba.utils.FileUtils;

import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 2264498497546081400L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		request.setAttribute("productList", catalog.getProductList());
		request.getRequestDispatcher("catalog.jsp").forward(request, response);
	}

}
