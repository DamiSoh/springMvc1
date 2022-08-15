package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberServiceControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// urlPatterns에 : * 아스테릭 붙이면  ~v1 하위에 어떤게 들어와도 이 서블릿 호출먼저된다.

@WebServlet(name="frontControllerV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerV1(Map<String, ControllerV1> controllerV1Map) {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save",     new MemberServiceControllerV1());
        controllerMap.put("/front-controller/v1/members",          new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = req.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI);
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }

        controller.process(req, resp);
    }
}
