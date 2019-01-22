package src;
import java.text.*;
import java.util.*;
public class User{

  public String nickUser;
  public String jourPremiereConnexion;
  public String heurePremiereConnexion;

  Date actuelle = new Date();

  DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
  String jour = dateFormat.format(actuelle);

  DateFormat dateFormat4 = new SimpleDateFormat("HH:mm");
  String heure = dateFormat4.format(actuelle);

  public User(String nick)
  {
    nickUser=nick;
    jourPremiereConnexion=jour;
    heurePremiereConnexion=heure;

  }
}
