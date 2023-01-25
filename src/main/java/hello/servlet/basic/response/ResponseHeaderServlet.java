package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK); // 전송 상태 확인

        //[response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8"); // 텍스트 타입
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello"); // 내가 만든 헤더

        //[Header 편의 메서드]
        content(response);

        PrintWriter writer = response.getWriter();
        writer.println("안녕하세요");
    }

    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }
}
