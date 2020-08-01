package com.example.unil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Ip工具类 henry 2019-11-28
public class IpTools {
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    /*
    获取当前网络的局域网IP
     */
    public static String getLocalAddress() {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ip;
    }

    /*
    获取当前网络的外网IP
     */
    public static Map<String, Object> getV4IP() {
        Map<String, Object> jsonStr = new HashMap<String, Object>();
        String ip = "";
        String chinaz = "http://ip.chinaz.com";

        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(15000);
            urlConnection.setReadTimeout(15000);
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            if(in!=null){
                while ((read = in.readLine()) != null) {
                    inputLine.append(read + "\r\n");
                }
//                System.out.println("inutLine:"+inputLine.toString());
            }
            else{
             //   System.err.println("in is null");
                logger.warn("in is null");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            jsonStr=JsonTools.setJson(false,e.getMessage(),ip);
           // System.err.println("getV4IP失败MalformedURLException: " + LocalDateTime.now());
            logger.error("getV4IP失败MalformedURLException: " + LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
            jsonStr=JsonTools.setJson(false,e.getMessage(),ip);
            //System.err.println("getV4IP失败IOException: " + LocalDateTime.now());
            logger.error("getV4IP失败IOException: " + LocalDateTime.now());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    jsonStr=JsonTools.setJson(false,e.getMessage(),ip);
                    //System.err.println("getV4IP失败finally_IOException: " + LocalDateTime.now());
                    logger.error("getV4IP失败finally_IOException: " + LocalDateTime.now());
                }
            }
        }

        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if (m.find()) {
            String ipstr = m.group(1);
            ip = ipstr;
            jsonStr=JsonTools.setJson(true, LocalDateTime.now().toString()+"  获取IP成功",ip);
        }
       // System.out.println("success: " +ip);
        logger.info("success: " +ip);
        return jsonStr;
    }
}
