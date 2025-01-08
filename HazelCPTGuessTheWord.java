import arc.*;

public class HazelCPTGuessTheWord{
	public static void main(String[] args){
		Console con = new Console("Guess the Word", 1280, 720);
		
		char chrMainMenu;
		String strTheme;
		String strHighScores;
		boolean binInvalid;
		
		binInvalid = true;
		chrMainMenu = ' ';
		
		while(binInvalid == true){
			con.clear();
		
			if(chrMainMenu == 'p'){
				binInvalid = false;
				TextInputFile themes = new TextInputFile("theme.txt");
				while(themes.eof() == false){
					strTheme = themes.readLine();
					con.println(strTheme);
				}
			}else if(chrMainMenu == 'v'){
				binInvalid = false;
				con.println("High Scores");
				TextInputFile highscores = new TextInputFile("highscores.txt");
				while(highscores.eof() == false){
					strHighScores = highscores.readLine();
					con.println(strHighScores);
				}
			}else if(chrMainMenu == 'q'){
				binInvalid = false;
				con.closeConsole();
			}else if(chrMainMenu == 'h'){
				binInvalid = false;
				con.println("help");
			}else{
				chrMainMenu = hazelCPTtools.MainMenu(con);
			}
		}
	}
}
