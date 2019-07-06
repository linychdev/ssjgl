package com.ustb.ssjgl.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.mail.MessagingException;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;
import com.ustb.ssjgl.common.utils.MailUtils;

public class MailTest {
	public static void main(String[] args) throws IOException {
//		try {
//			MailUtils.sendMail("403215845@qq.com", "test", "美女你好！");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    String gs = "\\width{500} \\dpi{80} \\LARGE  \\o \\left ( R \\right )= D_{0}exp\\left [ y^{\\left ( 1-\\frac{R}{R_{0}} \\right )} \\right ]+\\frac{a_{1}}{b_{1}^{(1+e)}\\left ( R-c_{2} \\right )}";
	    gs = gs.replaceAll(" ", "");
	    String url = URLEncoder.encode(gs,"utf-8");
	    System.out.println("http://latex.codecogs.com/png.latex?" + url);
	    
	    String json = "{'functionName':'Ionic Function i-i','functionFormula':'\\o \\left ( R \\right )= D_{0}exp\\left [ y^{\\left ( 1-\\frac{R}{R_{0}} \\right )} \\right ]+\\frac{a_{1}}{b_{1}^{(1+e)}\\left ( R-c_{2} \\right )}+\\frac{a_{1}}{b_{1}^{(1+e)}\\left ( R-c_{2} \\right )}+\\frac{a_{1}}{b_{1}^{(1+e)}\\left ( R-c_{2} \\right )}','functionDesc':'离子化合物对势'}";
	    JSONObject potenFunctionJson = JSONObject.parseObject(string2Json(json));
	    System.out.println(potenFunctionJson);
	}
	
	public static String string2Json(String s) {     
	    StringBuffer sb = new StringBuffer();     
	    for (int i=0; i<s.length(); i++) {     
	        char c = s.charAt(i);     
	        switch (c) {     
	        case '\"':     
	            sb.append("\\\"");     
	            break;     
	        case '\\':     
	            sb.append("\\\\");     
	            break;     
	        case '/':     
	            sb.append("\\/");     
	            break;     
	        case '\b':     
	            sb.append("\\b");     
	            break;     
	        case '\f':     
	            sb.append("\\f");     
	            break;     
	        case '\n':     
	            sb.append("\\n");     
	            break;     
	        case '\r':     
	            sb.append("\\r");     
	            break;     
	        case '\t':     
	            sb.append("\\t");     
	            break;     
	        default:     
	            sb.append(c);     
	        }
	   }
	    return sb.toString();     
	 }
}
