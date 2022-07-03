package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=kim&age=21
 */

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println();
        System.out.println("[전체파라미터조회] - start");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체파라미터조회] - end");
        System.out.println();

        System.out.println("[단일파라미터조회] - start");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("age"));
        System.out.println("[단일파라미터조회] - end");

        System.out.println();
        System.out.println("[이름이 같은 복수의 파라미터조회] - start");
        // 이럴때는 getParameterValues()로 꺼내면 된다.
        // 상기 1번으로 하면(getParameter(paramName))
        // 설정된 우선순위에 의해 출력값이 바뀔 수 있다.
        // 디폴트는 request.getParameterValues()의 첫번째 값이 반환된다.
        String[] userNames = request.getParameterValues("username");
        for(String name : userNames){
            System.out.println(name);
        }
        System.out.println("[이름이 같은 복수의 파라미터조회] - end");
        System.out.println();

        response.getWriter().write("ok");
    }

}
