package com.quicktutorialz.nio.servlets;

import com.quicktutorialz.nio.entities.ToDo;
import com.quicktutorialz.nio.services.MyService;
import com.quicktutorialz.nio.services.MyServiceImpl;
import com.quicktutorialz.nio.utils.JsonConverter;
import com.quicktutorialz.nio.utils.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
test with: POST http://localhost:8589/transform/uppercase
body:
{
	"title": "hello",
	"description": "hello to everyone"
}
 */
public class MyServletThree  extends HttpServlet {

    private static final String SERVLET_PATH = "/transform/{type}";

    MyService myService = MyServiceImpl.getIntance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = PathUtils.getPathVariables(SERVLET_PATH, request.getRequestURI()).get("type");
        ToDo input = (ToDo) JsonConverter.getInstance().getDataFromBodyRequest(request, ToDo.class);
        ToDo output;
        if("uppercase".equals(param)){
            String uppercaseDescription = myService.doSomethingString(input.getDescription());
            output = new ToDo(input.getTitle(), uppercaseDescription);
        }else{
            output = input;
        }

        String json = JsonConverter.getInstance().getJsonOf(output);

        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().println(json);
    }


}