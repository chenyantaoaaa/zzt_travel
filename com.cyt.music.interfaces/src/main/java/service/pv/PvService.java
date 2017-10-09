package service.pv;

/**
 * @author yantao.chen
 * @date 2017/10/9.
 */
public interface PvService {
    public void recordPv(String ip,String country,String pageType) throws Exception;
}
