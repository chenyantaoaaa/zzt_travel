package com.cyt.music.impl.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtil {

    /**
     * 通过GET方式发起http请求
     */
    public void requestByGetMethod(){
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = getHttpClient();
        try {
            //用get方法发送http请求
            HttpGet get = new HttpGet("http://localhost:8080/order/queryOrderInfo.action");
            System.out.println("执行get请求:...."+get.getURI());
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            try{
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                    System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("响应内容:" + EntityUtils.toString(entity));
                    System.out.println("-------------------------------------------------");
                }
            }
            finally{
                httpResponse.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }


    /**
     * POST方式发起http请求
     */
    public static String requestByPostMethod(String url,List<NameValuePair> params){
        CloseableHttpClient httpClient = getHttpClient();
        try {
            HttpPost post = new HttpPost(url);
            //创建参数列表
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            list.add(new BasicNameValuePair("amt", "0.10"));
//            list.add(new BasicNameValuePair("cc", "EUR"));
//            list.add(new BasicNameValuePair("item_name", null));
//            list.add(new BasicNameValuePair("st", "Completed"));
//            list.add(new BasicNameValuePair("tx", "2N5899090P519690W"));
//            list.add(new BasicNameValuePair("at", "CCs8kTCxktMBax3Oy3KvhNzzujMtBEZdyiYPxjhuKtn1SQMQvddpyt0Lgr0"));
//            list.add(new BasicNameValuePair("cmd", "_notify-synch"));
            //url格式编码
            post.setHeader("Content-type","application/x-www-form-urlencoded");
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params,"UTF-8");
            post.setEntity(uefEntity);
            System.out.println("POST 请求...." + post.getURI());
            //执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            try{
                HttpEntity entity = httpResponse.getEntity();
                String returnStr =  EntityUtils.toString(entity);
                if (null != entity){
                    System.out.println("-------------------------------------------------------");
                    System.out.println(returnStr.substring(0,4));
                    System.out.println("-------------------------------------------------------");
                }
                return returnStr;
            } finally{
                httpResponse.close();
            }
        } catch( UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    private static CloseableHttpClient  getHttpClient(){
        return HttpClients.createDefault();
    }

    private static void closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }

    public static void main(String[] args) {
        String url="https://www.paypal.com/cgi-bin/webscr";
        HttpUtil httpUtil=new HttpUtil();
        httpUtil.requestByPostMethod(url,null);
    }
}