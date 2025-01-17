import arc.*;

public class HazelCPTGuessTheWord{
	public static void main(String[] args){
		Console con = new Console("Guess the Word", 1280, 720);
		
		char chrMainMenu;
		char chrReturn;
		String strTheme;
		String strHighScores;
		boolean binInvalid;
		String strChooseTheme;
		int intRow;
		String strTempWord;
		String strTempNo;
		int intRow2;
		int intAmount;
		int intScore;
		String strName;
	
		
		binInvalid = true;
		chrMainMenu = ' ';
		chrReturn = ' ';
		boolean binWrong;
		binWrong = true;
		
		while(binInvalid == true){
			chrReturn = ' ';
			if(chrMainMenu == 'p'){
				binInvalid = false;
				con.clear();
				con.println("Enter Username: ");
				strName = con.readLine();
				con.clear();
				intScore = 0;
				strTheme = "";
				strChooseTheme = "l";
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
						binWrong = false;
						TextInputFile chosentheme = new TextInputFile(strTheme+".txt");
						themes.close();
						con.clear();
						intAmount = 0;
						while(chosentheme.eof() == false){
							String strWord;
							strWord = chosentheme.readLine();
							intAmount = intAmount + 1;
							System.out.println(strWord);
							System.out.println(intAmount);
						}
						chosentheme.close();
						String strWords[][];
						strWords = new String[intAmount][2];
						chosentheme = new TextInputFile(strTheme+".txt");

						for(intRow = 0; intRow < intAmount; intRow++){
							String strNumber;
							strWords[intRow][0] = chosentheme.readLine();
							int intRandom = (int)(Math.random()*100 + 1);
							strWords[intRow][1] = Integer.toString(intRandom);
						}

						for(intRow2 = 0;intRow2 < intAmount-1; intRow2++){
							for(intRow = 0; intRow < intAmount - 1 - intRow2; intRow++){
								//Bubble sort. If left is bigger that right
								if(Integer.parseInt(strWords[intRow][1]) > Integer.parseInt(strWords[intRow + 1][1])){
									//Take that left item
									strTempWord = strWords[intRow][0];
									strTempNo = strWords[intRow][1];
									//Right item moves to the left
									strWords[intRow][0] = strWords[intRow + 1][0];
									strWords[intRow][1] = strWords[intRow + 1][1];
									//Put temporary value on the right
									strWords[intRow + 1][0] = strTempWord;
									strWords[intRow + 1][1] = strTempNo;
						
								}
							}
						}
						System.out.println("AFTER");
						for(intRow = 0; intRow < intAmount; intRow++){
							System.out.println(strWords[intRow][0] + " | " + strWords[intRow][1]);
						}	

						int intRow3;
						intRow3 = 0;
						con.clear();
						while(chrReturn != 'r'&& intAmount != 0){
							intAmount = intAmount -1;
							chrReturn = ' ';
							String strSecret;
							strSecret = strWords[intRow3][0];
							intRow3 = intRow3 + 1;
							int intLength;
							intLength = strSecret.length();
							String strLetter[][];
							strLetter = new String[intLength][2];
							
							int intCount = 1;

							for(intRow = 0; intRow < intLength; intRow++){
								
								strLetter[intRow][0] = strSecret.substring(intCount-1, intCount);
								intCount = intCount + 1;
								int intRandom = (int)(Math.random()*100 + 1);
								strLetter[intRow][1] = Integer.toString(intRandom);
							}
							
							for(intRow2 = 0;intRow2 < intLength-1; intRow2++){
								for(intRow = 0; intRow < intLength - 1 - intRow2; intRow++){
									//Bubble sort. If left is bigger that right
									if(Integer.parseInt(strLetter[intRow][1]) > Integer.parseInt(strLetter[intRow + 1][1])){
										//Take that left item
										strTempWord = strLetter[intRow][0];
										strTempNo = strLetter[intRow][1];
										//Right item moves to the left
										strLetter[intRow][0] = strLetter[intRow + 1][0];
										strLetter[intRow][1] = strLetter[intRow + 1][1];
										//Put temporary value on the right
										strLetter[intRow + 1][0] = strTempWord;
										strLetter[intRow + 1][1] = strTempNo;	
									}
								}
							}
							
							
							String strGuess;
							strGuess = "";
							
							int intRemTries;
							intRemTries = intLength - 4;
							int intTries;
							intTries = 0;
							
							if(strName.equalsIgnoreCase("statitan")){
								intRemTries = intRemTries + 1;
							}
	
							
							
							while(!strGuess.equalsIgnoreCase(strSecret)&& intRemTries != 0){
								for(intRow = 0; intRow < intLength; intRow++){
									System.out.println(strLetter[intRow][0] + " | " + strLetter[intRow][1]);
									con.print(strLetter[intRow][0] + " ");
								}
								
								con.println();
								con.println("Remaing tries: " + intRemTries);
								intRemTries = intRemTries - 1;
								
								intTries = intTries + 1;
								System.out.println("intTries = " + intTries);
								
								con.println("Enter");
								strGuess = con.readLine();
								
								
								con.clear();
							}		
							
							if(strGuess.equalsIgnoreCase(strSecret)){
								con.clear();
								con.println("Win");
								intScore = intScore + 1;
								con.println("It took you " + intTries + " tries");
								con.println(strName + ", your current score is: " + intScore);
							}else{
								con.clear();
								con.println("Lose");
								con.println("The correct answer is " + strSecret);
								con.println(strName + ", your current score is: " + intScore);
								binWrong = false;
									
							}
							con.println("Continue(c) or Return to Main Menu(r)");
							while(chrReturn != 'c' && chrReturn != 'r'){
								chrReturn = con.getChar();
							}
							if(intAmount == 0){
								con.clear();
								con.println("Wow! You reached the end of the " + strTheme + " category!");
								con.println("Your final score is " + intScore );
								con.println("Return to main menu to choose another theme! (r)");
								while(chrReturn != 'r'){
								chrReturn = con.getChar();
								}
							}
							con.clear();
						}
					
							TextOutputFile highscores = new TextOutputFile("highscores.txt",true);
							highscores.println(strName);
							highscores.println(intScore);
							highscores.close();
							chrMainMenu = hazelCPTtools.MainMenu(con);
							con.clear();	
							binInvalid = true;
					}
				
				
					
				}				
			
			}else if(chrMainMenu == 'v'){
				binInvalid = false;
				con.println("High Scores");
				intAmount = 0;
				TextInputFile highscores = new TextInputFile("highscores.txt");
				while(highscores.eof() == false){
					strName = highscores.readLine();
					intScore = highscores.readInt();
					System.out.println(strName + intScore);
					intAmount = intAmount + 1;
				}
				highscores.close();
				String strHighscore[][];
				strHighscore = new String[intAmount][2];
				highscores = new TextInputFile("highscores.txt");
				for(intRow = 0; intRow < intAmount; intRow++){
					strHighscore[intRow][0] = highscores.readLine();
					strHighscore[intRow][1] = highscores.readLine();
				}
				for(intRow2 = 0;intRow2 < intAmount-1; intRow2++){
					for(intRow = 0; intRow < intAmount - 1 - intRow2; intRow++){
						//Bubble sort. If left is bigger that right
						if(Integer.parseInt(strHighscore[intRow][1]) < Integer.parseInt(strHighscore[intRow + 1][1])){
							//Take that left item
							strTempWord = strHighscore[intRow][0];
							strTempNo = strHighscore[intRow][1];
							//Right item moves to the left
							strHighscore[intRow][0] = strHighscore[intRow + 1][0];
							strHighscore[intRow][1] = strHighscore[intRow + 1][1];
							//Put temporary value on the right
							strHighscore[intRow + 1][0] = strTempWord;
							strHighscore[intRow + 1][1] = strTempNo;
						
						}
					}
				}
				System.out.println("AFTER");
				for(intRow = 0; intRow < intAmount; intRow++){
					con.println(strHighscore[intRow][0] + " | " + strHighscore[intRow][1]);
				}
					
				while(chrReturn != 'r'){
				chrReturn = con.getChar();
					if(chrReturn == 'r'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.clear();
						binInvalid = true;
					}
				}
			}else if(chrMainMenu == 'q'){
				binInvalid = false;
				con.closeConsole();
			}else if(chrMainMenu == 'h'){
				binInvalid = false;
				con.println("To start gameplay, type 'p' in main menu. ");
				con.println("Enter your username and select your theme. ");
				con.println("You have a limited amount of tries to guess the scrambled word. ");
				con.println("If you guess correctly, you gain a point. ");
				con.println("You can choose to continue or return to main menu after each round.");
				con.println("TIP: look for the capitalized letter to indicate the start.");
				con.println("Return to Main Menu (R)");
				while(chrReturn != 'r'){
				chrReturn = con.getChar();
					if(chrReturn == 'r'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.clear();
						binInvalid = true;
					}
				}
			}else if(chrMainMenu == 's'){
				con.println("What did the big flower say to the little flower?");
				con.println("HEY BUD!");
				while(chrReturn != 'r'){
				chrReturn = con.getChar();
					if(chrReturn == 'r'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.clear();
						binInvalid = true;
					}
				}
			}else{
				chrMainMenu = hazelCPTtools.MainMenu(con);
				con.clear();
			}
		}
	}
}
