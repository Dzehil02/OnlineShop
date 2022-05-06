package by.iba.resources;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.iba.services.CatalogService;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/catalog")
@Deprecated
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
		String catalogJson = new Gson().toJson(service.getCatalog());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(catalogJson);
		out.flush();

	}

}
