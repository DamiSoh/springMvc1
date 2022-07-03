package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Step1:  Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // Step2:  Object 만들어 주기
        HelloData helloData = new HelloData();
        helloData.setUsername("DAM");
        helloData.setAge(30);

        // Step3:  object -> JSON 으로 변환하기
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
