package com.ustb.ssjgl.common.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 势数据管理工具类
 * SsjglUtils
 * @author linych
 * @version 1.0
 *
 */
public class JsonUtils {
    /**
     * 获得json中的key对应的value
     * @param json json字符串
     * @param key json中的键
     * @return String
     */
    public static String getStrFromJson(JSONObject json, String key) {
        if(json == null) {
            return null;
        }
        if (json.containsKey(key)) {
            return json.getString(key);
        }
        return null;
    }

    /**
     * 获得json中的key对应的value
     * @param json json字符串
     * @param key json中的键
     * @return JSONObject
     */
    public static JSONObject getJSONObjectFromJson(JSONObject json, String key) {
        if (json.containsKey(key)) {
            return json.getJSONObject(key);
        }
        return null;
    }

    /**
     * 获得json中的key对应的value
     * @param json JSONObject
     * @param key String
     * @return String[]
     */
    public static String[] getStrArrayFromJson(JSONObject json, String key) {
        if (json.containsKey(key)) {
            JSONArray jsonArray = json.getJSONArray(key);
            String[] str = new String[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                str[i] = jsonArray.getString(i);
            }
            return str;
        }
        return null;
    }

    /**
     * 获得json中的key对应的value
     * @param json JSONObject
     * @param key String
     * @return Integer
     */
    public static Integer getIntegerFromJson(JSONObject json, String key) {
        if (json.containsKey(key)) {
            return json.getInteger(key);
        }
        return null;
    }

    /**
     * list转换为string
     * @param list
     * @return
     */
    public static String getStringFromList(List<Map<String, Object>> list) {
        JSONArray json = new JSONArray();
        for (Map<String, Object> map : list) {
           JSONObject jo = new JSONObject(map);
            json.add(jo);
        }
        return json.toString();
    }

    /**
     * 获得json中的key对应的value
     * @param json
     * @param key
     * @return JSONObject
     */
    public static JSONArray getJSONArrayFromJson(JSONObject json, String key) {
        if (json.containsKey(key)) {
            if(StringUtils.isNotBlank(json.getString(key))) {
                return json.getJSONArray(key);
            }
        }
        return null;
    }
}
