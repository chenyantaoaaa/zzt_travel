package controller.pv;

import com.cyt.music.impl.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.pv.PvService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yantao.chen
 * @date 2017/10/9.
 */
@Controller
@RequestMapping("/pv")
public class PvController {
    @Autowired
    private PvService pvService;

    @RequestMapping(value = "/recordPv")
    public void recordPv(HttpServletRequest req,String pagetype) throws Exception {
        String ip = StringUtil.getRemoteAddress(req);
        String country = "";
        if(StringUtil.isEmpty(pagetype)){
            return;
        }
        pvService.recordPv(ip,country,pagetype);
    }
}
