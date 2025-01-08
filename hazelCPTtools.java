import arc.*;

public class hazelCPTtools{
	
	public static char MainMenu(Console con){
			char chrMainMenu;
			
			con.println("Play game(p)");
			con.println("View high scores(v)");
			con.println("Quit(q)");
			con.println("Help(h)");
			chrMainMenu = con.getChar();
			
			return chrMainMenu;
		}
}
