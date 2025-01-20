import arc.*;
import java.awt.*;
import java.awt.image.*;

public class hazelCPTtools{
	
	//Main Menu
	public static char MainMenu(Console con){
		//Vairables
		char chrMainMenu;
		
		//Print
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
		
		//Get char for next screen
		chrMainMenu = con.getChar();
			
		return chrMainMenu;
	}
	
	//105 = spaces in a line
	//Print Word in the middle of screen
	public static void Center(int intLength, Console con, int intWhole){
		//Variables
		int intSpace;
		int intCount;
		
		//Space needed = n number of spaces to the middle - half of the word that wants to be centered
		intSpace = intWhole - (intLength/2);
		
		for(intCount = 0; intCount <= intSpace; intCount++){
			con.print(" ");
		}
	}
	
	//Enter Username
	public static String Name(Console con){
		//Variables
		String strName;
		
		//Print
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
		
		//Read entered username
		strName = con.readLine();
				
		return strName;
	}
	
	//Print + Enter themes
	public static String Theme(Console con){
		//Variables
		int intThemecount;
		intThemecount = 0;
		String strTheme;
		String strChooseTheme;
		
		//Print
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		con.println("                                      ----------- Themes -----------");
		con.println();
		//Read and print from opened theme file
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
		con.println("                                               Choose Theme:");
		con.println("                                      ------------------------------");
		con.print("                                            ");
		
		//Read entered theme
		strChooseTheme = con.readLine();
				
		return strChooseTheme;
	}
	
	//Secret Menu
	public static void Secret(Console con){
		//Print
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
		//Print
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
		con.println("                  1. To start gameplay, type 'p' in main menu. ");
		con.println("                  2. Enter your username and select your theme. ");
		con.println("                  3. You have a limited amount of tries to guess the scrambled word. ");
		con.println("                  4. If you guess correctly, you gain a point. ");
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
		//Varaibles
		char chrReturn;
		chrReturn = ' ';
		
		//Only run when username is "statitan"
		if(strName.equalsIgnoreCase("statitan")){
			//Print			
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
			
			//Loop untill entered c for continue
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
		//Check if sorted successfully 
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
		//Only top 20
		//different space for single character and two characters
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
		//Print Top line
		con.println();
		con.println("  Theme:");
		con.println();
		con.println("  " + strTheme);
		con.println();
		con.println();
		con.println();
		con.println();
		con.println();
		
		//Variables				
		int intLength;
		int intHalf;
		
		//Win Scenario				
		if(strGuess.equalsIgnoreCase(strSecret)){
			//Score goes up
			intScore = intScore + 1;
			
			//Print
			//17 - half of line
			//Centering
			intLength = strName.length();
			intHalf = intLength+17;
			hazelCPTtools.Center(intHalf, con, 53);
			con.println("Congratulations " + strName + "!");
			con.println();
			//24 - half of line
			//CEntering
			intLength = strSecret.length();
			intHalf = intLength+24;
			hazelCPTtools.Center(intHalf,con, 53);
			con.println("The correct answer is '" + strSecret + "'");
			con.println("                                            It took you " + intTries + " tries");
			con.println("                                         Your current score is: " + intScore);
								
			BufferedImage imgWinLeft = con.loadImage("winleft.jpg");
			con.drawImage(imgWinLeft,150,210);
			BufferedImage imgWinRight = con.loadImage("winright.jpg");
			con.drawImage(imgWinRight,950,210);
			
		//Lose Scenario
		}else{
			//9 - Half of line
			//Center
			intLength = strName.length();
			intHalf = intLength+9;
			hazelCPTtools.Center(intHalf, con, 53);
			con.println("Too Bad, " + strName + "!");
			con.println();
			//24 - Half of line
			//Center
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
		
		//Variables					
		char chrReturn;
		chrReturn = ' ';
		
		//Print					
		con.println();
		con.println("                             -------------------------------------------------");
		con.println("                                 Continue(C)        Return to Main Menu(R)");
		con.println("                             -------------------------------------------------");
		
		//Loop for inalid input
		while(chrReturn != 'c' && chrReturn != 'C' && chrReturn != 'r' && chrReturn != 'R'){
			chrReturn = con.getChar();
		}
		
		return chrReturn;
	}
							
	//Complete whole array screen
	public static char Clear(int intAmount, Console con, String strTheme, int intScore, char chrReturn){
		//Variables						
		int intLength;
		int intHalf;
		
		//Check if finished whole themes file
		if(intAmount == 0){
			con.clear();
			
			//Print
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
			
			//42 - Half of line
			//Center
			intLength = strTheme.length();
			intHalf = intLength + 42;
			hazelCPTtools.Center(intHalf, con, 53);
			
			con.println("Wow! You reached the end of the " + strTheme + " category!");
			con.println("                                         Your final score is " + intScore + "!" );
			con.println("                              Return to main menu (R) to choose another theme!");
			con.println("                        -----------------------------------------------------------");
			
			//Loop for invalid input
			while(chrReturn != 'r' && chrReturn != 'R'){
				chrReturn = con.getChar();
			}
		}
		
		return chrReturn;
	}
	
	//Correspond theme from file to entered theme
	public static String FindTheme(String strTheme, String strChooseTheme){
		//Loop untill found theme or end of file(will reset)
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
		//Check if entered theme equals theme took from file
		if(strChooseTheme.equalsIgnoreCase(strTheme)){
			con.clear();
			//Show if player gained boost from cheat method
			chrReturn = hazelCPTtools.StatitanScreen(strName, con);
			con.clear();
						
			//Open themes file
			TextInputFile chosentheme = new TextInputFile(strTheme+".txt");
			
			//Variable to count no. of words in file
			int intAmount;
			intAmount = 0;
			
			//Count no. of words
			while(chosentheme.eof() == false){
				String strWord;
				strWord = chosentheme.readLine();
				intAmount = intAmount + 1;
				System.out.println(strWord);
				System.out.println(intAmount);
			}
			chosentheme.close();
			
			//Make array
			String strWords[][];
			strWords = new String[intAmount][2];
			
			//Put words and random numbers in
			chosentheme = new TextInputFile(strTheme+".txt");
			int intRow;
			for(intRow = 0; intRow < intAmount; intRow++){
				String strNumber;
				strWords[intRow][0] = chosentheme.readLine();
				int intRandom = (int)(Math.random()*100 + 1);
				strWords[intRow][1] = Integer.toString(intRandom);
			}
			
			//Bubble sort- scramble order
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
			
			//Check for sorted array
			System.out.println("AFTER");
			for(intRow = 0; intRow < intAmount; intRow++){
				System.out.println(strWords[intRow][0] + " | " + strWords[intRow][1]);
			}	
			
			//Variable for grabbing next word
			int intRow3;
			intRow3 = 0;
			int intLength;
			
	
			con.clear();
			
			//Loop untill user chooses return or array reaches end
			while(chrReturn != 'r' && chrReturn != 'R' && intAmount != 0){
				chrReturn = ' ';
				
				//Count down no. or words in array
				intAmount = intAmount -1;
				
				//Grab next word from array
				String strSecret;
				strSecret = strWords[intRow3][0];
				intRow3 = intRow3 + 1;
				
				//Make array			
				intLength = strSecret.length();
				String strLetter[][];
				strLetter = new String[intLength][2];
				
				//Variable for grabbing next letter			
				int intCount;
				intCount = 1;
				
				//Put in array with random numbers
				for(intRow = 0; intRow < intLength; intRow++){		
					strLetter[intRow][0] = strSecret.substring(intCount-1, intCount);
					intCount = intCount + 1;
					int intRandom = (int)(Math.random()*100 + 1);
					strLetter[intRow][1] = Integer.toString(intRandom);
				}
				
				//Bubble Sort - scramble	
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
							
				//Variables + Inilialize	
				String strGuess;
				strGuess = "";		
				int intRemTries;
				intRemTries = intLength - 4;
				int intTries;
				intTries = 0;
				
				//Cheat
				if(strName.equalsIgnoreCase("statitan")){
					intRemTries = intRemTries + 1;
				}
									
				//Gameplay Screen
				while(!strGuess.equalsIgnoreCase(strSecret)&& intRemTries != 0){
					//Print
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
					
					//Center Scrambled word			
					int intHalf;
					intHalf = intLength*2;
					hazelCPTtools.Center(intHalf,con, 53);
					for(intRow = 0; intRow < intLength; intRow++){
						System.out.println(strLetter[intRow][0] + " | " + strLetter[intRow][1]);
						con.print(strLetter[intRow][0] + " ");
					}
					
					con.println();
					con.println();
					con.println();
					con.println();
					con.println("                                          **Do Not Enter Spaces**");			
					con.println("                                       ------------------------------");
					con.println("                                                Guess Word:");
					con.println("                                       ------------------------------");
					con.print("                                         ");
					
					BufferedImage imgCheer = con.loadImage("ganbare suisei.jpg");	
					con.drawImage(imgCheer, 1000, 450);
					
					//Read entered guess
					strGuess = con.readLine();
					
					//Reduce remaining tries, count tries taken
					intRemTries = intRemTries - 1;		
					intTries = intTries + 1;
					System.out.println("intTries = " + intTries);
								
					con.setBackgroundColor(Color.black);
					con.clear();
				}		
							
				//Win or Lose screen method
				intScore = hazelCPTtools.WinLose(con, strName, intScore, strTheme, strGuess, strSecret, intTries);
				chrReturn = hazelCPTtools.CorR(con);
							
				con.setBackgroundColor(Color.black);
				con.clear();
							
				//Clear whole theme screen method
				chrReturn = hazelCPTtools.Clear(intAmount, con, strTheme, intScore, chrReturn);
							
				con.setBackgroundColor(Color.black);
				con.clear();
			}
				
				//Output to highscores file after end loop			
				TextOutputFile highscores = new TextOutputFile("highscores.txt",true);
				highscores.println(strName);
				highscores.println(intScore);
				highscores.close();
				System.out.println("PUT IN HIGHSCORES FILE");
				
				//Return to main menu
				chrMainMenu = hazelCPTtools.MainMenu(con);
				con.setBackgroundColor(Color.black);
				con.clear();	
							
		}
		
		return chrMainMenu;
	}				
}
