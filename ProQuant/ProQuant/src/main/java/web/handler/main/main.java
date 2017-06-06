package web.handler.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LENOVO on 2017/6/5.
 */

@Controller
public class main extends HttpServlet{
    @RequestMapping("/HomePage.do")
    public String toHomePage(){
        return "HomePage";
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
