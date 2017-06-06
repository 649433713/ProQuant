package web.handler.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LENOVO on 2017/6/6.
 */

@Controller
public class StockInfo extends HttpServlet{
    @RequestMapping("/StockInfo.do")
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
//     */
//    protected void doGet(HttpServletRequest request,HttpServletResponse response){
//        request.getSession().setAttribute("StockName","杭州园林");
//    }

    public String toStockInfo(){

        return "StockInfo";
    }
}
