package web.handler.main;

import blservice.StockInfoBlService.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LENOVO on 2017/6/5.
 */

@Controller
@RequestMapping("/HomePage")
public class main{

    @RequestMapping(value = "/ToHomePage")
    public String toHomePage(){
        return "HomePage";
    }

}
