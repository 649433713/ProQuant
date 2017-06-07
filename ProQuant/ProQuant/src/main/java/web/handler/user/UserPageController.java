package web.handler.user;

import VO.RequestResult;
import VO.UserVO.AccountPageTotalVO;
import blservice.userDataBlService.UserDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import net.sf.json.JSONArray;


/**
 * Created by xiezhenyu on 2017/6/6.
 */
@Controller
@RequestMapping("/user")
public class UserPageController {
    private Logger logger = LoggerFactory.getLogger(UserPageController.class);

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/list.do", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAvailableProperty(HttpServletRequest request, HttpServletResponse response){
//        String pro = "1,000,000,000";
//        String result = "[{\"username\": \"your name\", \"user_json\": {\"username\": \"your name\", \"nickname\": \"your nickname\"}}]";
        String result = "aaa";
        PrintWriter out;
        try{
            System.out.println("bbbb");
            response.setContentType("application/json");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
//            out.print(JSONUtil.toJSONString(jsonMap));
//            JSONArray json = new JSONArray(pro);

//            JSONArray array = new JSONArray(result);
//            array.
            System.out.println(JSONArray.fromObject(result).toString());
            out.print(JSONArray.fromObject(result).toString());

            out.flush();
            out.close();
        }catch (IOException e){
//            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }finally {
//            if (null != out) {
//                out.flush();
//                out.close();
//            }
        }

        System.out.println("1000");
        return "1,000,000";
    }


    @RequestMapping(value = "toUserCenter", method = RequestMethod.GET)
    public String toUserCenter(Model model){
        return "UserCenterPage";
    }


    //ajax json
    @RequestMapping(value = "/{userName}/accountPageTotalVO", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody//有这个注释，springMVC会试图把返回的数据封装成json
    public RequestResult<AccountPageTotalVO> getAccountPageTotalVO(@PathVariable String username){
        RequestResult<AccountPageTotalVO> result = null;
        if(username == null){
            result = new RequestResult<AccountPageTotalVO>(false, "跳转到用户中心界面时获取用户名错误！");
            return result;
        }
        try {
            AccountPageTotalVO accountPageTotalVO = userDataService.getUserAccountData(username);
            result = new RequestResult<AccountPageTotalVO>(true, accountPageTotalVO);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            System.out.println("获得用户中心界面账户数据时抛出异常，请检查UserPageController.java");
        }
        return result;
    }
}
