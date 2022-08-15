package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV2 controllerV2 = controllerV2Map.get(requestURI);
        if(controllerV2 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }

        MyView view = controllerV2.process(request, response);
        view.render(request, response);
    }
}
