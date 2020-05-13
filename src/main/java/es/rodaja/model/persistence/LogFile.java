package es.rodaja.model.persistence;

import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.tomcat.jni.File;

public class LogFile {

	private String path;

	public LogFile() {
		path = "log/";
	}

	public void saveLogFile(String fileName, String data) {
		String fileUrl = path + fileName;

		try {
			FileWriter fw = new FileWriter(fileUrl, true);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String collectData(String requestType) {
		String data = "";
		
		Calendar calendar = new GregorianCalendar();
		
		String date = getCurrentDate(calendar);
		
		String time = getCurrentTime(calendar);
		
		data += date + time + requestType;
		return data;

	}

	private String getCurrentTime(Calendar calendar) {
		String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		String minutes = String.valueOf(calendar.get(Calendar.MINUTE));
		String seconds = String.valueOf(calendar.get(Calendar.SECOND));
		String time = hour + ":" + minutes + ":" + seconds;
		return time;
	}

	private String getCurrentDate(Calendar calendar) {
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String date = day +"-"  +month + "-" + year + " ";
		return date;
	}

}
