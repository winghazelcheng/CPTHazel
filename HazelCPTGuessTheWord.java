/*---------------------------------------------------------------------------------------
 * Name: Guess the Word
 * Purpose: The program prompts the user to select a theme and unscramble the given words 
            related to the theme. Points accumulate if the user guesses correctly. Users 
            can choose to leave game after every round. 
 * Author: Hazel Cheng
 * Date created: 17 - 1 - 2025
 * V2. 5. 0
-----------------------------------------------------------------------------------------
*/

import arc.*;
import java.awt.*;
import java.awt.image.*;

public class HazelCPTGuessTheWord{
	public static void main(String[] args){
		Console con = new Console("Guess the Word", 1280, 720);
		
		//Variables
		char chrMainMenu;
		char chrReturn;
		String strName;
		String strTheme;
		String strChooseTheme;
		boolean binInvalid;
		int intScore;
		int intLength;
	
		//Initialize
		binInvalid = true;
		chrMainMenu = ' ';
		
		//Loop main menu options
		while(binInvalid == true){
			//Reset return variable to read again
			chrReturn = ' ';
			
			//Press p for play
			if(chrMainMenu == 'p' || chrMainMenu == 'P'){
				binInvalid = false;
				
				//Set name limit to 12 characters
				intLength = 13;
				strName = "";
				//Reprint screen to ask for user name as long as entered name is more than 12 letters
				while(intLength > 12){
					strName = hazelCPTtools.Name(con);
					con.clear();
					intLength = strName.length();
				}
				//Check for name taken into variable
				System.out.println("Username = " + strName);
				
				//Theme screen
				intScore = 0;
				strTheme = "";
				strChooseTheme = hazelCPTtools.Theme(con);
				//Check for corresponding theme file
				strTheme = hazelCPTtools.FindTheme(strTheme, strChooseTheme);
				//Loop if entered theme is invalid
				while(!strChooseTheme.equalsIgnoreCase(strTheme)){
					con.clear();
					System.out.println("INVALID THEME");
					strChooseTheme = hazelCPTtools.Theme(con);
					strTheme = hazelCPTtools.FindTheme(strTheme, strChooseTheme);
				}
				//Check for last read of theme
				System.out.println("VALID THEME: " + strTheme);
				
				//Gameplay
				chrMainMenu = hazelCPTtools.Play(con, strTheme, strChooseTheme, chrReturn, strName, intScore, chrMainMenu);
				binInvalid = true;		
								
			//Press v for View High Score
			}else if(chrMainMenu == 'v' || chrMainMenu == 'V'){
				binInvalid = false;
				//High Score Screen method
				hazelCPTtools.Highscores(con);
				//Loop for invalid input
				while(chrReturn != 'r' && chrReturn != 'R'){
				chrReturn = con.getChar();
					//Correct input return to main menu
					if(chrReturn == 'r' || chrReturn == 'R'){
						con.clear(); 
						con.setBackgroundColor(Color.black);
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.setBackgroundColor(Color.black);
						con.clear();
						binInvalid = true;
					}
				}
				
			//Press q for Quit
			}else if(chrMainMenu == 'q' || chrMainMenu == 'Q'){
				binInvalid = false;
				con.closeConsole();
				
			//Press h for Help
			}else if(chrMainMenu == 'h' || chrMainMenu == 'H'){
				binInvalid = false;
				//Help screen method
				hazelCPTtools.Help(con);
				//Loop for invalid input
				while(chrReturn != 'r' && chrReturn != 'R'){ 
				chrReturn = con.getChar();
					//Correct input return to main menu
					if(chrReturn == 'r' || chrReturn == 'R'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.setBackgroundColor(Color.black);
						con.clear();
						binInvalid = true;
					}
				}
				
			//Press s for Secret Menu
			}else if(chrMainMenu == 's' || chrMainMenu == 'S'){
				binInvalid=false;
				//Secret Menu method
				hazelCPTtools.Secret(con);
				//Loop for invalid input
				while(chrReturn != 'r' && chrReturn != 'R'){
				chrReturn = con.getChar();
					//Correct input return to main menu
					if(chrReturn == 'r' || chrReturn == 'R'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.clear();
						con.setBackgroundColor(Color.black);
						binInvalid = true;
					}
				}
				
			//Invalid Input
			}else{
				chrMainMenu = hazelCPTtools.MainMenu(con);
				con.setBackgroundColor(Color.black);
				con.clear();
			}
		}
	}
}
