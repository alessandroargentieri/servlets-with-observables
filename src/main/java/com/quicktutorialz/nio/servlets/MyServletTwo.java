package com.quicktutorialz.nio.servlets;

import com.quicktutorialz.nio.services.MyService;
import com.quicktutorialz.nio.services.MyServiceImpl;
import io.reactivex.Observable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* test with: http://localhost:8589/to/uppercase/reactive/hsjs?param=ciao%20belli */
public class MyServletTwo  extends HttpServlet {

    MyService myService = MyServiceImpl.getIntance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Observable.fromCallable(() -> request)
                .map(req -> request.getParameter("param"))
                .map(param -> myService.doSomethingString(param))
                .subscribe(uppercaseParam -> printResponse(response, uppercaseParam));

    }

    private void printResponse(HttpServletResponse response, String uppercaseParam) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{ \"uppercase-param\": \"" + uppercaseParam + "\"}");
    }
}