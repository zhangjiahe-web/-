package com.kgc.zhang.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderCodeUtil {
	/**
	 * ��ȡ����ʱ��
	 * 
	 * @return�����ַ�����ʽyyyyMMddHHmmss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * ��������ʱ����+3λ����� ������ˮ��
	 * 
	 * @return
	 * */
	public static String GetCode() {
		String t = getStringDate();
		int x = (int) (Math.random() * 900) + 100;
		String serial = t + x;
		return serial;
	}
	
}
