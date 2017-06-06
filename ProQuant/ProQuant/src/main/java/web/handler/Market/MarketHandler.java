package web.handler.Market;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoJun on 2017/6/6.
 */

@Controller
public class MarketHandler {
    @RequestMapping("/MarketPage.do")
    public String toMarketPage(){
        return "MarketPage";
    }
}
