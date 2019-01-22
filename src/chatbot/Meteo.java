package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import src.User;

public class Meteo extends Chatbot{
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	public void call(User user, String [] arg)
	{

		if (arg.length==1)
		{
			System.out.println("Veuillez entrer un nom de ville.");
		}


		else {

			String ville=arg[1];

			JSONObject json = null;
			try {
				json = readJsonFromUrl("http://api.apixu.com/v1/current.json?key=54d2903cacdc45d591b151253182112&q="+ville);
				System.out.println("[Meteo] "+((JSONObject) ((JSONObject) json.get("current")).get("condition")).get("text"));
			} catch (JSONException | IOException e) {
				System.out.println("[Meteo] Je ne connais pas la ville "+arg[1]+", veuillez entrer un nom de ville valide");
			}





		}

	}
}
