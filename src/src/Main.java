package src;

import java.util.*;
import chatbot.*;


public class Main{

	private static Scanner sc;

	public static void main(String[] args)
	{
		Map<String, Chatbot> bots = new HashMap<String, Chatbot>();

		bots.put("@hello", new Hello());
		bots.put("@time", new Time());
		bots.put("@icndb", new Icndb());
		bots.put("@quiz", new Quiz());
		bots.put("@meteo", new Meteo());
		bots.put("@help", new Help());
		

		if (args.length==2 && args[0].equals("-p"))
		{
			User user=new User(args[1]);
			System.out.println("Bienvenue "+user.nickUser+"! Veuillez écrire @help pour voir l'ensemble des bots!");
			while(true){
				sc = new Scanner(System.in);

				System.out.print("["+user.nickUser+"] ");

				String str = sc.nextLine();
				String[] str2 = str.split(" ");
				if (str2[0].equals("++"))
				{
					break;
				}
				else if(str2[0].substring(0, 1).equals("@"))
				{
					Chatbot.selectionChatbot(bots,str2,user);
				}
			}
		}
		else
		{
			System.out.println("Erreur au niveau du nombre d'arguments, veuillez ecrire -p et votre pseudo.");
		}
	}
}
