package chatbot;
import java.util.*;
import src.*;

public class Chatbot{

	public void call(User user, String [] arg)
	{
	}

	public static void selectionChatbot(Map<String, Chatbot> bots, String [] arg, User user)
	{
		if (bots.containsKey(arg[0]))
		{
			bots.get(arg[0]).call(user,arg);
		}
		else
		{
			System.out.println("Je ne connais pas ce chatbot");
		}
	}
}
