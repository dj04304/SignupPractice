package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class CharacterEncodingFilter extends HttpFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("전 처리");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		if(!httpRequest.getMethod().equalsIgnoreCase("get")) {
			request.setCharacterEncoding("UTF-8");
			System.out.println("인코딩 되었습니다!");
		}
		
		chain.doFilter(request, response);
		
//		System.out.println("후 처리");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
