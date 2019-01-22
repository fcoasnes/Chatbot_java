package chatbot;


import src.User;

public class Help extends Chatbot{
	public void call(User user, String [] arg)

	{
		String help="Bonjour et bienvenue dans le système de chat créé par Florian COASNES & Anas AHOUZI. Pour faire appel à un chatbot il suffit d'écrire @<nom_du_chatbot>\n" + 
				"Les chatbots disponibles sont les suivants:\n" + 
				"	-@hello: il vous salue.\n" + 
				"	-@time: il vous l'heure et la date.\n" + 
				"	-@icndb <x>: il vous donne x Chuck Norris fact.\n" + 
				"	-@quiz <x>: il vous pose x questions.\n" + 
				"	-@meteo <ville>: il vous donne la météo actuelle dans la ville souhaitée.\n" + 
				"	-@help: il vous redonne la liste des chatbots.\n" + 
				"	\n" + 
				"Pour quitter le chatbot veuillez inscrire ++.";
		System.out.println(help);
	}
}
