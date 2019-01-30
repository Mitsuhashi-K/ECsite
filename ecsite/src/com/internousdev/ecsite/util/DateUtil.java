package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate(){
		/* Dateクラスをインスタンス化
		dateインスタンスには現在の日時が返される */
		Date date = new Date();

		/* 日時の表示形式を指定 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		/* 指定した表示形式で現在の日時を返す */
		return simpleDateFormat.format(date);
	}

}
