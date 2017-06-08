package web.handler.stock;

import PO.InfoData;
import PO.kLinePO.KLineDayData;
import VO.StockVO;
import blservice.StockInfoBlService.StockInfoService;
import com.sun.javafx.sg.prism.NGShape;
import dataservice.KLineDataService;
import dataservice.StockDataService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by LENOVO on 2017/6/6.
 */

@Controller
//@RequestMapping("/StockInfo")
public class StockInfo extends HttpServlet{

    @Autowired
    private StockInfoService stockInfoService;

    @Autowired
    private StockDataService stockDataService;

    @Autowired
    private KLineDataService kLineDataService;

    @RequestMapping(value = "/toStockInfo")//,method = RequestMethod.GET)
    public String toStockInfo(Model model){
        StockVO stockVO = stockInfoService.getStockVO("603998");
        model.addAttribute("stockVO",stockVO);
//        int code = stockDataService.getCode("");
        InfoData companyData = stockDataService.getStockInfo("603998");
        model.addAttribute("companyData",companyData);
        return "StockInfo";
    }

    @RequestMapping(value = "/getStockDayKLine",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONArray getDayKLine(){
        ArrayList<KLineDayData> kLineDayDatas = kLineDataService.getdayLine("603998",null,160,false);
        int size = kLineDayDatas.size();
        String result = "[";
        for(int i = 0; i < size; i++){
            result = result + "{"+kLineDayDatas.get(i).getDate()+","
                +kLineDayDatas.get(i).getKline().getOpen()+","
                +kLineDayDatas.get(i).getKline().getClose()+","
                +kLineDayDatas.get(i).getKline().getLow()+","
                +kLineDayDatas.get(i).getKline().getHigh()+"},";
        }
        result = result + "]";
        JSONArray jsonArray;
        jsonArray = JSONArray.fromObject(result);

        return jsonArray;
    }

    @RequestMapping(value = "/getStockScore",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONArray getStockScore(){

//        ArrayList<>
        return null;
    }

}
