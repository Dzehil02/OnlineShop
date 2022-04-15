package by.iba.resources;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.iba.entities.Catalog;
import by.iba.utils.FileUtils;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    	Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
//    	String catalogJsonString = new Gson().toJson(catalog);
    	request.setAttribute("productList", catalog.getProductList());
    	request.getRequestDispatcher("catalog.jsp").forward(request, response);
//    	PrintWriter out = resp.getWriter();
//    	resp.setContentType("application/json");
//    	out.print(catalogJsonString);
//    	out.flush();    	
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        super.doPost(req, resp);
    }

}
