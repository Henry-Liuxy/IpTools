package com.example.unil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class JsonTools
{
  public static Map<String, Object> setJson(boolean success, String message, Object entity)
  {
    Map json = new HashMap();
    json.put("state", Boolean.valueOf(success));
    json.put("message", message);
    json.put("entity", entity);
    return json;
  }

  public static String setExceptionRequest(HttpServletRequest request, Exception e)
  {
    StackTraceElement[] messages = e.getStackTrace();
    if ((messages != null) && (messages.length > 0)) {
      StringBuffer buffer = new StringBuffer();
      buffer.append(e.toString()).append("<br/>");
      for (int i = 0; i < messages.length; i++) {
        buffer.append(messages[i].toString()).append("<br/>");
      }
      request.setAttribute("myexception", buffer.toString());
    }
    return "/common/error";
  }

  public Map<String, Object> setAjaxException(Map<String, Object> map)
  {
    map.put("state", Boolean.valueOf(false));
    map.put("message", "系统繁忙，请稍后再操作！");
    map.put("entity", null);
    return map;
  }
}