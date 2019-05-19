package util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class sendSMS {
    public static String username="";
    public static String password="";
    public static String number="";
	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "YGtI4YEH4mo-9jRiKykkBafkZ23k6AKxJfecqibRTR";
			String message = "&message=" + "Hello, "+username+
                                "\n"+
                                "You sent a request to remember your password. Your password is "
                                +password+"\n\nBest regards, Smart roots";
			String sender = "&sender=" + "Smart Roots";
			String numbers = "&numbers=" + number;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}