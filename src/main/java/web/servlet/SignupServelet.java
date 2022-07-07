package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import web.dto.SignupReqDto;


@WebServlet("/signup")
public class SignupServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserService userService;
	
	public SignupServelet() {
		userService = new UserServiceImpl();
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원가입요청");
		
		SignupReqDto signupReqDto = SignupReqDto.builder()
				.name(request.getParameter("name"))
				.email(request.getParameter("email"))
				.username(request.getParameter("username"))
				.password(request.getParameter("password"))
				.build();
		
		try {
			PrintWriter out = response.getWriter();
			
			if(userService.createUser(signupReqDto)) {
				System.out.println("회원가입성공");
				out.print(true);
			}else {
				System.out.println("회원가입실패");
				out.print(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
