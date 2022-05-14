package org.kuax.lib.http.server.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.kuax.sample.vo.Person;
import org.kuax.sample.vo.SampleVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(name = "SampleServlet", urlPatterns = "/sampleServlet")
public class SampleServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Input Handling
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String buf = "";
        while ((buf = bufferedReader.readLine()) != null) {
            stringBuffer.append(buf);
        }
        System.out.println("LOGGING SERVLET : " + req.getRequestURI() +
                "\nINPUT DATA : \n" + stringBuffer.toString() +
                "\nEND OF LINE *******");

        if ("/exit".equals(req.getRequestURI())) {
            System.exit(0);
        }
        SampleVo sampleVo = gson.fromJson(stringBuffer.toString(), SampleVo.class);

        Person person = new Person();
        person.setName("김춘삼");
        person.setPhone("010-8582-4252");

        SampleVo sampleVo2 = new SampleVo();
        sampleVo2.setCode(999);
        sampleVo2.setMsg("RECEIVE MSG SUCCESSFULLY");
        sampleVo2.setPerson(person);

        // RESPONSE
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(gson.toJson(sampleVo2));
    }
}
