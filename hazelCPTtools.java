import arc.*;
import java.awt.*;
import java.awt.image.*;

public class hazelCPTtools{
	
	//Main Menu
	public static char MainMenu(Console con){
		char chrMainMenu;
		
		BufferedImage imgMenu = con.loadImage("confused suichan flipped.jpg");	
		con.drawImage(imgMenu, 0, 134);
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                                                   ----- Guess the Word -----");
		con.println();
		con.println("                                                                        ----------------");
		con.println("                                                                            Play (P)");
		con.println("                                                                        ----------------");
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                                                                      View high scores(V)");
		con.println("                                                                                                  Quit(Q)");
		con.println("                                                                                                  Help(H)");
		chrMainMenu = con.getChar();
			
		return chrMainMenu;
	}
	
	//105 = chars in a line
	//Print Word in the middle of screen
	public static void Center(int intLength, Console con, int intWhole){
		int intSpace;
		int intCount;
		intSpace = intWhole - (intLength/2);
		for(intCount = 0; intCount <= intSpace; intCount++){
			con.print(" ");
		}
	}
	
	//Enter Username
	public static String Name(Console con){
		String strName;
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();  
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                           --------------------");
		con.println("                                              Enter Username: ");
		con.println("                                           --------------------");
		con.println("                                              (0 to 12 char)");
		con.print("                                               ");
		strName = con.readLine();
				
		return strName;
	}
	
	//Print + Enter themes
	public static String Theme(Console con){
		int intThemecount;
		intThemecount = 0;
		String strTheme;
		String strChooseTheme;
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                      ----------- Themes -----------");
		con.println();
		TextInputFile themes = new TextInputFile("theme.txt");
		while(themes.eof() == false){
			intThemecount = intThemecount + 1;
			strTheme = themes.readLine();
			con.println("                                          " + intThemecount + ". " + strTheme);
		}
		themes.close();
		con.println();
		con.println("                                          **Do not enter numbers**");
		con.println("                                      ------------------------------");
		con.println("                                               Enter Choice:");
		con.println("                                      ------------------------------");
		con.print("                                            ");
		strChooseTheme = con.readLine();
				
		return strChooseTheme;
	}
	
	//Secret Menu
	public static void Secret(Console con){
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                          -------------------------------------------------------");
		con.println("                                      Oo, you found the secret menu!");
		con.println("                                            Here is a question:");
		con.println("                             What did the big flower say to the little flower?");
		con.println();
		con.println("                                                  HEY BUD!");
		con.println("                          -------------------------------------------------------");
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                                                                  Return to Main Menu (R)");
	}
	
	//Help screen
	public static void Help(Console con){
		con.println();			
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                                Intructions");
		con.println();
		con.println("               ----------------------------------------------------------------------------");
		con.println("                               1. To start gameplay, type 'p' in main menu. ");
		con.println("                               2. Enter your username and select your theme. ");
		con.println("                    3. You have a limited amount of tries to guess the scrambled word. ");
		con.println("                               4. If you guess correctly, you gain a point. ");
		con.println("                  5. You can choose to continue or return to main menu after each round.");
		con.println();
		con.println("                       TIP: Look for the capitalized letters to indicate the start.");
		con.println("               ----------------------------------------------------------------------------");
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                                                                  Return to Main Menu (R)");
	}
	
	//Cheat screen
	public static char StatitanScreen(String strName, Console con){
		char chrReturn;
		chrReturn = ' ';
		if(strName.equalsIgnoreCase("statitan")){
							
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println("                        -----------------------------------------------------------");
			con.println("                                                STATITAN!");
			con.println("                                   You have unlocked a secret ability!");
			con.println("                          You now have one more try each round to guess the word!");
			con.println("                                       Press (C) to continue game!");
			con.println("                        -----------------------------------------------------------");
			while(chrReturn != 'c' && chrReturn != 'C'){
				chrReturn = con.getChar();
			}
		}
		return chrReturn;
	}
	
	//Highscores screen
	public static void Highscores(Console con){
		//Variables
		String strName;
		int intScore;
		int intRow;
		int intAmount;
		intAmount = 0;
		
		TextInputFile highscores = new TextInputFile("highscores.txt");
		//Read file
		while(highscores.eof() == false){
			strName = highscores.readLine();
			intScore = highscores.readInt();
			System.out.println(strName + intScore);
			intAmount = intAmount + 1;
		}
		highscores.close();
		System.out.println("READ");
		
		//Make array
		String strHighscore[][];
		strHighscore = new String[intAmount][2];
		
		highscores = new TextInputFile("highscores.txt");	
		//Put in array
		for(intRow = 0; intRow < intAmount; intRow++){
			strHighscore[intRow][0] = highscores.readLine();
			strHighscore[intRow][1] = highscores.readLine();
		}
		System.out.println("PUT IN ARRAY");
		
		//Bubblesort
		int intRow2;
		String strTempName;
		String strTempScore;
		for(intRow2 = 0;intRow2 < intAmount-1; intRow2++){
			for(intRow = 0; intRow < intAmount - 1 - intRow2; intRow++){
				//Bubble sort. If left is bigger that right
				if(Integer.parseInt(strHighscore[intRow][1]) < Integer.parseInt(strHighscore[intRow + 1][1])){
					//Take that left item
					strTempName = strHighscore[intRow][0];
					strTempScore = strHighscore[intRow][1];
					//Right item moves to the left
					strHighscore[intRow][0] = strHighscore[intRow + 1][0];
					strHighscore[intRow][1] = strHighscore[intRow + 1][1];
					//Put temporary value on the right
					strHighscore[intRow + 1][0] = strTempName;
					strHighscore[intRow + 1][1] = strTempScore;
						
				}
			}
		}
		for(intRow = 0; intRow < intAmount; intRow++){
			System.out.println(strHighscore[intRow][0] + " | " + strHighscore[intRow][1]);
		}
		System.out.println("SORTED");
		
		//Print Layout
		con.println();
		con.println("                                               Leaderboard");
		con.println();	
		con.println("                                    Name                         Score");
		con.println();	
				
		//Print out highscores
		int intPlace;
		intPlace = 0;
		for(intRow = 0; intRow < 20; intRow++){
			intPlace = intPlace + 1;
			if(intPlace < 10){
				con.print("                                    "+ intPlace +". " + strHighscore[intRow][0]);
			}else{
				con.print("                                   "+ intPlace +". " + strHighscore[intRow][0]);
			}
			
			//Center Names
			strName = strHighscore[intRow][0];
			int intLength;
			intLength = strName.length();
			intLength = intLength*2;
			hazelCPTtools.Center(intLength, con, 12);
			con.println("|            " + strHighscore[intRow][1]);
		}
		con.println();
		con.println();
		con.println();
		con.println("                                                                                   Return to Main Menu(R)");
		
		BufferedImage imgCrown = con.loadImage("crown.jpg");
		con.drawImage(imgCrown, 390, 107);
	}
	
	//Win/Lose Screen
	public static int WinLose(Console con, String strName, int intScore, String strTheme, String strGuess, String strSecret, int intTries){
		con.println();
		con.println("  Theme:");
		con.println();
		con.println("  " + strTheme);
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
							
		int intLength;
		int intHalf;
							
		if(strGuess.equalsIgnoreCase(strSecret)){
			//17
			intLength = strName.length();
			intHalf = intLength+17;
			hazelCPTtools.Center(intHalf, con, 53);
			con.println("Congratulations " + strName + "!");
			con.println();
			//24
			intLength = strSecret.length();
			intHalf = intLength+24;
			hazelCPTtools.Center(intHalf,con, 53);
			con.println("The correct answer is '" + strSecret + "'");
			intScore = intScore + 1;
			con.println("                                            It took you " + intTries + " tries");
			con.println("                                         Your current score is: " + intScore);
								
			BufferedImage imgWinLeft = con.loadImage("winleft.jpg");
			con.drawImage(imgWinLeft,150,210);
			BufferedImage imgWinRight = con.loadImage("winright.jpg");
			con.drawImage(imgWinRight,950,210);
		}else{
			//9
			intLength = strName.length();
			intHalf = intLength+9;
			hazelCPTtools.Center(intHalf, con, 53);
			con.println("Too Bad, " + strName + "!");
			con.println();
			//24
			intLength = strSecret.length();
			intHalf = intLength+24;
			hazelCPTtools.Center(intHalf, con, 53);
			con.println("The correct answer is '" + strSecret + "'");
			con.println("                                          Better luck next time!");
			con.println("                                         Your current score is: " + intScore);
								
			BufferedImage imgLoseLeft = con.loadImage("loseleft.jpg");
			con.drawImage(imgLoseLeft,70,210);
			BufferedImage imgLoseRight = con.loadImage("loseright.jpg");
			con.drawImage(imgLoseRight,950,210);
									
		}
		return intScore;
	}
	
	//Continue or Return
	public static char CorR(Console con){
							
		char chrReturn;
		chrReturn = ' ';
							
		con.println();
		con.println("                             -------------------------------------------------");
		con.println("                                 Continue(C)        Return to Main Menu(R)");
		con.println("                             -------------------------------------------------");
		while(chrReturn != 'c' && chrReturn != 'C' && chrReturn != 'r' && chrReturn != 'R'){
			chrReturn = con.getChar();
		}
		return chrReturn;
	}
							
	//Complete whole array screen
	public static char Clear(int intAmount, Console con, String strTheme, int intScore, char chrReturn){
								
		int intLength;
		int intHalf;
		if(intAmount == 0){
			con.clear();
			//42
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println();
			con.println("                        -----------------------------------------------------------");
			intLength = strTheme.length();
			intHalf = intLength + 42;
			hazelCPTtools.Center(intHalf, con, 53);
			con.println("Wow! You reached the end of the " + strTheme + " category!");
			con.println("                                         Your final score is " + intScore + "!" );
			con.println("                              Return to main menu (R) to choose another theme!");
			con.println("                        -----------------------------------------------------------");
			while(chrReturn != 'r' && chrReturn != 'R'){
				chrReturn = con.getChar();
			}
		}
		return chrReturn;
	}
	public static String FindTheme(String strTheme, String strChooseTheme){
		TextInputFile themes = new TextInputFile("theme.txt");
		while(themes.eof() == false && !strChooseTheme.equalsIgnoreCase(strTheme)){
			strTheme = themes.readLine();
			System.out.println(strTheme);
		}
		themes.close();
		return strTheme;
	}	
	
	//Gameplay 
	public static char Play(Console con, String strTheme, String strChooseTheme, char chrReturn, String strName, int intScore, char chrMainMenu){
					if(strChooseTheme.equalsIgnoreCase(strTheme)){
						TextInputFile chosentheme = new TextInputFile(strTheme+".txt");
						int intAmount;
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
						int intRow;
						for(intRow = 0; intRow < intAmount; intRow++){
							String strNumber;
							strWords[intRow][0] = chosentheme.readLine();
							int intRandom = (int)(Math.random()*100 + 1);
							strWords[intRow][1] = Integer.toString(intRandom);
						}
						int intRow2;
						String strTempWord;
						String strTempNo;
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
						int intLength;
						chrReturn = hazelCPTtools.StatitanScreen(strName, con);
	
						con.clear();
						while(chrReturn != 'r' && chrReturn != 'R' && intAmount != 0){
							intAmount = intAmount -1;
							chrReturn = ' ';
							String strSecret;
							strSecret = strWords[intRow3][0];
							intRow3 = intRow3 + 1;
							
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
							
							
							
							
							//Gameplay Screen
							while(!strGuess.equalsIgnoreCase(strSecret)&& intRemTries != 0){
								con.println();
								con.println("  Theme:                                          ROUND " + intRow3 + "                               Current Score: " + intScore);
								con.println();
								con.println("  " + strTheme);
								con.println("                                                                                      Remaining tries: " + intRemTries);
								con.println();
								con.println();
								con.println();
								con.println();
								con.println();
								con.println();
								
								int intHalf;
								intHalf = intLength*2;
								hazelCPTtools.Center(intHalf,con, 53);
								for(intRow = 0; intRow < intLength; intRow++){
									System.out.println(strLetter[intRow][0] + " | " + strLetter[intRow][1]);
									con.print(strLetter[intRow][0] + " ");
								}
								con.println();
								con.println();
								con.println("                                          **Do Not Enter Spaces**");
								
								intRemTries = intRemTries - 1;
								
								intTries = intTries + 1;
								System.out.println("intTries = " + intTries);
								
								con.println("                                       ------------------------------");
								con.println("                                                Enter Guess:");
								con.println("                                       ------------------------------");
								con.print("                                         ");
								BufferedImage imgCheer = con.loadImage("ganbare suisei.jpg");	
								con.drawImage(imgCheer, 1000, 450);
								strGuess = con.readLine();
								
								con.setBackgroundColor(Color.black);
								con.clear();
							}		
							
							//Win or Lose
							intScore = hazelCPTtools.WinLose(con, strName, intScore, strTheme, strGuess, strSecret, intTries);
							chrReturn = hazelCPTtools.CorR(con);
							
							con.setBackgroundColor(Color.black);
							con.clear();
							
							//Clear screen
							chrReturn = hazelCPTtools.Clear(intAmount, con, strTheme, intScore, chrReturn);
							
							con.setBackgroundColor(Color.black);
							con.clear();
						}
							
							TextOutputFile highscores = new TextOutputFile("highscores.txt",true);
							highscores.println(strName);
							highscores.println(intScore);
							highscores.close();
							System.out.println("PUT IN HIGHSCORES FILE");
							chrMainMenu = hazelCPTtools.MainMenu(con);
							con.setBackgroundColor(Color.black);
							con.clear();	
							
					}
					return chrMainMenu;
				}				
}
