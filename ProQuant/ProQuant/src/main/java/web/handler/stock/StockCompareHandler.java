package web.handler.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LENOVO on 2017/6/6.
 */

@Controller
public class StockCompareHandler {
    @RequestMapping("/StockCompare.do")
    public String toStockCompare(){
        return "StockCompare";
    }
}
