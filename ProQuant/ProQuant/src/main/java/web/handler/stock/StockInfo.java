package web.handler.stock;

import VO.StockVO;
import blservice.StockInfoBlService.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LENOVO on 2017/6/6.
 */

@Controller
@RequestMapping("/StockInfo")
public class StockInfo extends HttpServlet{

    @Autowired
    private StockInfoService stockInfoService;

    @RequestMapping(value = "/toStockInfo",method = RequestMethod.GET)
    public String toStockInfo(Model model){
        StockVO stockVO = stockInfoService.getStockVO("603998");
        model.addAttribute("stockVO",stockVO);
        return "StockInfo";
    }
}
