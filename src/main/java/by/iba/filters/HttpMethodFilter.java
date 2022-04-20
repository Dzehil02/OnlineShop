package by.iba.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(filterName = "httpMethodFilter", urlPatterns = { "/catalog" })
public class HttpMethodFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(wrapRequest((HttpServletRequest) request), response);
	}

	@Override
	public void destroy() {
	}

	private static HttpServletRequestWrapper wrapRequest(HttpServletRequest request) {
		String requestMethod = request.getMethod();
		return new HttpServletRequestWrapper(request) {
			@Override
			public String getMethod() {
				return "PUT".equals(requestMethod) || "DELETE".equals(requestMethod) ? "GET" : requestMethod;
			}
		};
	}

}
