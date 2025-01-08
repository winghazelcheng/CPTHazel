import arc.*;

public class HazelCPTGuessTheWord{
	public static void main(String[] args){
		Console con = new Console("Guess the Word", 1280, 720);
		
		char chrMainMenu;
		String strTheme;
		String strHighScores;
		boolean binInvalid;
		String strChooseTheme;
		
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
				themes.close();
				con.println("Enter theme:");
				strChooseTheme = con.readLine();
				strTheme  = "";
				themes = new TextInputFile("theme.txt");
				while(themes.eof() == false && strChooseTheme != strTheme){
					strTheme = themes.readLine();
					if(strChooseTheme.equalsIgnoreCase(strTheme)){
						TextInputFile chosentheme = new TextInputFile(strTheme+".txt");
						themes.close();
						con.clear();
						int intAmount = 0;
						while(chosentheme.eof() == false){
							String strWord;
							strWord = chosentheme.readLine();
							intAmount = intAmount + 1;
							con.println(strWord);
							con.println(intAmount);
						}
						chosentheme.close();
						String strWords[][];
						strWords = new String[intAmount][2];
						chosentheme = new TextInputFile(strTheme+".txt");
						int intRow;
						for(intRow = 0; intRow < intAmount; intRow++){
							String strNumber;
							strWords[intRow][0] = chosentheme.readLine();
							int intRandom = (int)(Math.random());
							strWords[intRow][1] = Integer.toString(intRandom);
						}
						
					}
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
