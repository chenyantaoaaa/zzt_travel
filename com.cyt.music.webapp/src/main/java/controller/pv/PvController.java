package controller.pv;

import com.cyt.music.impl.util.StringUtil;
import com.cyt.music.interfaces.pojo.Pv.PvInfo;
import com.cyt.music.interfaces.pojo.Pv.PvInfoDto;
import com.cyt.music.interfaces.pojo.Pv.PvRes;
import com.cyt.music.interfaces.pojo.common.PageInfo;
import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.pv.PvService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        if(StringUtil.isEmpty(pagetype)){
            return;
        }
        pvService.recordPv(ip,pagetype);
    }

    @RequestMapping({"/judgeCountry"})
    public @ResponseBody PvRes judgeCountry(HttpServletRequest req) throws Exception {
        String ip = StringUtil.getRemoteAddress(req);
        String country = this.pvService.judgeCountry(ip);
        PvRes pvRes = new PvRes();
        pvRes.setInfo(country);
        return pvRes;
    }

    @RequestMapping(value = "/queryPvInfo")
    public @ResponseBody
    PageResultForBootstrap queryPvInfo(PvInfo pvInfo,Integer pageSize, Integer pageNumber,HttpServletRequest req) throws Exception {
        if(pageSize==null){
            pageSize=10;
        }
        if(pageNumber==null){
            pageNumber=1;
        }
        int total = pvService.queryPvInfoCount(pvInfo);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageParams(total, pageSize, pageNumber);
        PvInfoDto pvInfoDto = new PvInfoDto();
        pvInfoDto.setPageInfo(pageInfo);
        pvInfoDto.setCountry(pvInfo.getCountry());
        pvInfoDto.setDate(pvInfo.getDate());
        List<PvInfo> list=pvService.queryPvInfo(pvInfoDto);

        PageResultForBootstrap pageResultForBootstrap = new PageResultForBootstrap();
        pageResultForBootstrap.setRows(list);
        pageResultForBootstrap.setTotal(total);
        return pageResultForBootstrap;
    }
}
