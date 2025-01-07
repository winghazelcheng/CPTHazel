import arc.*;

public class HazelCPTGuessTheWord{
	public static void main(String[] args){
		Console con = new Console("Guess the Word", 1280, 720);
		
		char chrMainMenu;
		String strTheme;
		String strHighScores;
		
		con.println("Play game(p)");
		con.println("View high scores(v)");
		con.println("Quit(q)");
		con.println("Help(h)");
		chrMainMenu = con.getChar();
		
		con.clear();
		
		if(chrMainMenu == 'p'){
			TextInputFile themes = new TextInputFile("theme.txt");
			while(themes.eof() == false){
				strTheme = themes.readLine();
				con.println(strTheme);
			}
		}else if(chrMainMenu == 'v'){
			TextInputFile highscores = new TextInputFile("highscores.txt");
			while(highscores.eof() == false){
				strHighScores = highscores.readLine();
				con.println(strHighScores);
			}
		}else if(chrMainMenu == 'q'){
			con.closeConsole();
		}else if(chrMainMenu == 'h'){
			con.println("help");
		}else{
		}
	}
}
