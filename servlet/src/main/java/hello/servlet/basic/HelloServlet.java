package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello") // name 이나 url매핑은 겹치면 안된다.
public class HelloServlet extends HttpServlet {

    // /hello로 서블릿 호출되면 service 메소드가 호출된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); //soutm 클래스.매소드 명 출력된다.
        // 한번 req, res객체를 찍어보자.
        System.out.println("request = " + request); //soutv 
        System.out.println("response = " + response); //soutv 미친 단축키

        // request 가져오기
        String username = request.getParameter("username");
        System.out.println("get parameter: "+username);

        // response 설정하기
        // header에 들어가는 친구들
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // body에 데이터 담기
        response.getWriter().write("Hello " + username);

    }
}
