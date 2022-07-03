package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        // response.setStatus(200);
        response.setStatus(HttpServletResponse.SC_OK); //이렇게 적는게 더 좋다

        // [response-header]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        // [1- header 편의 메소드로 대체 가능]
        content(response);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "dami header");  // 커스텀헤더도 생성된다.

        // [2-header 편의 메소드 Cookie]
        cookie(response);

        response.getWriter().println("안녕 OK");
        redirect(response); // 앞에서 200 던져줘도 밑에서 다른 애 실행되면 위에거 덮어버린다.

    }


    // [header 편의 메소드]
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //line19 를 하기처럼 대체할 수 있다.

        // 방법1
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        // 방법2
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600; 600초 동안 유효한 쿠키 설정하기

        // 방법1
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        // 방법2
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html

//         response.setStatus(HttpServletResponse.SC_FOUND); //302
//         response.setHeader("Location", "/basic/hello-form.html");
         response.sendRedirect("/basic/hello-form.html");
    }

}


