package com.ustb.ssjgl.test;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.ustb.ssjgl.common.utils.mail.MailUtil;

public class MailTest {
	public static void main(String[] args) {
		try {
			MailUtil.sendMail("403215845@qq.com", "test", "美女你好！");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
