package com.cyt.music.impl.service.pv;

import Constants.ZztConstants;
import com.cyt.music.impl.mapper.pv.PvInfoMapper;
import com.cyt.music.impl.util.DateUtil;
import com.cyt.music.impl.util.HttpUtil;
import com.cyt.music.impl.util.JsonUtils;
import com.cyt.music.interfaces.pojo.Pv.PvInfo;
import com.cyt.music.interfaces.pojo.Pv.PvInfoDto;
import com.cyt.music.interfaces.pojo.Pv.PvInfoExample;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.pv.PvService;

import java.util.List;

/**
 * @author yantao.chen
 * @date 2017/10/9.
 */
@Service
public class PvServiceImpl implements PvService{
    @Autowired
    private PvInfoMapper pvInfoMapper;

    @Override
    public void recordPv(String ip,String pageType) throws Exception {
        PvInfoExample example = new PvInfoExample();
        example.or().andIpEqualTo(ip);
        List<PvInfo> pvInfoList = pvInfoMapper.selectByExample(example);
        String today = DateUtil.getNowDate();
        String nowTime = DateUtil.getNowTime();
        for (PvInfo pvInfo : pvInfoList) {
            if(pvInfo.getDate().equals(today)){
                if(pageType.equals(ZztConstants.MAIN_PAGE_TYPE)){
                    pvInfo.setMainPageCount(pvInfo.getMainPageCount()+1);
                }else if(pageType.equals(ZztConstants.CONTACT_PAGE_TYPE)){
                    pvInfo.setContactPageCount(pvInfo.getContactPageCount()+1);
                }else if(pageType.equals(ZztConstants.MORE_PAGE_TYPE)){
                    pvInfo.setMorePageCount(pvInfo.getMorePageCount()+1);
                }else{
                    pvInfo.setPayPageCount(pvInfo.getPayPageCount()+1);
                }
                pvInfoMapper.updateByPrimaryKey(pvInfo);
                return;
            }
        }
        PvInfo newPv = new PvInfo();
        newPv.setIp(ip);
        if(pageType.equals(ZztConstants.MAIN_PAGE_TYPE)){
            newPv.setMainPageCount(1);
        }else if(pageType.equals(ZztConstants.CONTACT_PAGE_TYPE)){
            newPv.setContactPageCount(1);
        }else if(pageType.equals(ZztConstants.MORE_PAGE_TYPE)){
            newPv.setMorePageCount(1);
        }else{
            newPv.setPayPageCount(1);
        }
        newPv.setDate(today);
        newPv.setCountry(getCountry(ip));
        newPv.setRemark(nowTime);
        pvInfoMapper.insert(newPv);
    }

    public List<PvInfo> queryPvInfo(PvInfoDto dto) throws Exception{
        List<PvInfo> resultList = pvInfoMapper.queryPvInfo(dto);
        return resultList;
    }

    public int queryPvInfoCount(PvInfo dto) throws Exception{
        int count = pvInfoMapper.queryPvInfoCount(dto);
        return count;
    }

    private String getCountry(String ip){
        String url=ZztConstants.PV_COUNT_URL;
        String result = HttpUtil.sendGet(url,"ip="+ip);
        JSONObject object = JsonUtils.jsonStrToJsonObj(result);
        JSONObject data = (JSONObject)object.get("data");
        return data.getString("country");
    }

    public String judgeCountry(String ip) throws Exception{
        return getCountry(ip);
    }
}
