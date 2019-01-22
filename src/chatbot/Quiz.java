package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import org.json.*;


import src.User;


public class Quiz extends Chatbot{

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

	private static String display_question(JSONObject json)
	{
		String question=json.get("question").toString();
		return question;
	}

	private static int display_answers(JSONObject json)
	{
		String correct_ans=json.get("correct_answer").toString();
		JSONArray json3 =json.getJSONArray("incorrect_answers"); 
		ArrayList l = new ArrayList();
		l.add(correct_ans);
		int k=0;
		while(k<4)
			try {
				String ans2 =json3.get(k).toString();
				l.add(ans2);
				k=k+1;
			}
		catch(Exception e) {
			//System.out.println(e);
			break;
		}

		Collections.shuffle(l);

		for(int i = 0;i<l.size();i++) 
		{
			System.out.println("Reponse "+(i+1)+": "+l.get(i));
		}
		int correct=0;
		for(int j = 0;j<l.size();j++) {
			if (l.get(j).equals(correct_ans)) {
				correct=j+1;
				break;
			}
		}

		//System.out.println(correct);
		//System.out.println(correct_ans);
		return correct;
	}

	private int display_score(JSONObject json, int score, int just )
	{
		if (just==0)
		{
			String correct_ans=json.get("correct_answer").toString();
			System.out.println("You have false, the correct answer was: "+correct_ans);
		}
		else {
			System.out.println("You have right! You won one point! ");
			score=score+1;
		}
		return score;
	}
	
	
	public void call(User user, String [] arg)

	{

		try {
			int nombre = Integer.parseInt(arg[1]);
			if (nombre>50){
				System.out.println("Choisissez un nombre de question inferieur à 50.");
			}
			else {
			int score=0;
			JSONObject json = null;
			json = readJsonFromUrl("https://opentdb.com/api.php?amount="+arg[1]);
			int k=0;
			while (k<nombre)
			{
				//System.out.print("[Quiz] ");
				//System.out.println(json);
				int num=k+1;
				JSONArray jsonarr = json.getJSONArray("results");
				JSONObject json2 = (JSONObject) jsonarr.get(k);
				System.out.println("[Quiz] QUESTION "+num+": "+display_question(json2));

				int correct=display_answers(json2);
				try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Your answer: ");
				int result = sc.nextInt();
				if (result==correct) {
					score=display_score(json2,score, 1);
				}
				else {
					score=display_score(json2,score, 0);
				}
				} catch(java.util.InputMismatchException e){
					score=display_score(json2,score, 0);
				}

				k++;


			}
			
			System.out.println("[Quiz] Your final score is " + score+"/"+nombre+".");
			}
		}
		catch (IOException e) {
			System.out.println("[Quiz] Un probleme est survenu lors de la connexion à l'api quiz.");
		}
		catch(NumberFormatException e){
			System.out.println("[Quiz] Je ne sais pas quoi faire avec "+arg[1]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("[Quiz] Veuillez donnez un nombre de question");
		}


	}
}
