package service.pv;

import com.cyt.music.interfaces.pojo.Pv.PvInfo;
import com.cyt.music.interfaces.pojo.Pv.PvInfoDto;

import java.util.List;

/**
 * @author yantao.chen
 * @date 2017/10/9.
 */
public interface PvService {
    public void recordPv(String ip,String pageType) throws Exception;

    public String judgeCountry(String ip) throws Exception;

    public List<PvInfo> queryPvInfo(PvInfoDto pvInfo) throws Exception;

    public int queryPvInfoCount(PvInfo pvInfo) throws Exception;
}
