package com.quicktutorialz.nio.servlets;

import com.quicktutorialz.nio.services.MyService;
import com.quicktutorialz.nio.services.MyServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* let's test with: http://localhost:8589/to/uppercase?param=ciao%20belli */
public class MyServletOne extends HttpServlet {

    MyService myService = MyServiceImpl.getIntance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("param");

        String uppercaseParam = myService.doSomethingString(param);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{ \"uppercase-param\": \"" + uppercaseParam + "\"}");
    }

}