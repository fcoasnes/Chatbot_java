package chatbot;
import java.text.DateFormat;
import src.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time extends Chatbot{
	private static String day_extract(String jour)
	{
		String jour2="Inconnu";

		switch(jour) {

		case "1":

			jour2="Lundi ";

			break;
		case "2":

			jour2="Mardi ";

			break;
		case "3":

			jour2="Mercredi ";

			break;
		case "4":

			jour2="Jeudi ";

			break;
		case "5":

			jour2="Vendredi ";

			break;
		case "6":

			jour2="Samedi ";

			break;
		case "7":

			jour2="Dimanche ";

			break;
		}
		return jour2;
	}
	private static String month_extract(String jour)
	{
		String month2="Inconnu";

		switch(jour) {

		case "1":

			month2="Janvier ";

			break;
		case "2":

			month2="Février ";

			break;
		case "3":

			month2="Mars ";

			break;
		case "4":

			month2="Avril ";

			break;
		case "5":

			month2="Mai ";

			break;
		case "6":

			month2="Juin ";

			break;
		case "7":

			month2="Juillet ";

			break;
		case "8":

			month2="Août ";

			break;
		case "9":

			month2="Septembre ";

			break;
		case "10":

			month2="Octobre ";

			break;
		case "11":

			month2="Novembre ";

			break;
		case "12":

			month2="Décembre ";

			break;
		}
		return month2;
	}

	public void call(User user, String [] arg)

	{

		Date actuelle = new Date();

		DateFormat dateFormat = new SimpleDateFormat("u");
		String jour = dateFormat.format(actuelle);

		DateFormat dateFormat2 = new SimpleDateFormat("d");
		String date = dateFormat2.format(actuelle);

		DateFormat dateFormat3 = new SimpleDateFormat("M");
		String mois = dateFormat3.format(actuelle);

		DateFormat dateFormat4 = new SimpleDateFormat("HH:mm");
		String heure = dateFormat4.format(actuelle);

		System.out.println("Nous sommes le " + day_extract(jour) +date +" "+ month_extract(mois)+ "et il est " +heure);
	}
}
