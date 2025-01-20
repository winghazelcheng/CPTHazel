import arc.*;
import java.awt.*;
import java.awt.image.*;

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
		int intHalf;
		int intLength;
	
		
		binInvalid = true;
		chrMainMenu = ' ';
		chrReturn = ' ';
		
		while(binInvalid == true){
			chrReturn = ' ';
			if(chrMainMenu == 'p'){
				binInvalid = false;
				con.clear();
			
				intLength = 13;
				strName = "";
				while(intLength > 12){
					strName = hazelCPTtools.Name(con);
					con.clear();
					intLength = strName.length();
				}
				
				System.out.println("Username = " + strName);
				
				intScore = 0;
				strTheme = "";
				strChooseTheme = hazelCPTtools.Theme(con);
				strTheme = hazelCPTtools.FindTheme(strTheme, strChooseTheme);
				
				while(!strChooseTheme.equalsIgnoreCase(strTheme)){
					con.clear();
					System.out.println("INVALID THEME");
					strChooseTheme = hazelCPTtools.Theme(con);
					strTheme = hazelCPTtools.FindTheme(strTheme, strChooseTheme);
				}
				
				System.out.println("VALID THEME: " + strTheme);
				
				chrMainMenu = hazelCPTtools.Play(con, strTheme, strChooseTheme, chrReturn, strName, intScore, chrMainMenu);
				binInvalid = true;
				
					
								
			
			}else if(chrMainMenu == 'v'){
				binInvalid = false;
				hazelCPTtools.Highscores(con);	
				while(chrReturn != 'r'){
				chrReturn = con.getChar();
					if(chrReturn == 'r'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.setBackgroundColor(Color.black);
						con.clear();
						binInvalid = true;
					}
				}
			}else if(chrMainMenu == 'q'){
				binInvalid = false;
				con.closeConsole();
			}else if(chrMainMenu == 'h'){
				binInvalid = false;
				hazelCPTtools.Help(con);
				while(chrReturn != 'r'){ 
				chrReturn = con.getChar();
					if(chrReturn == 'r'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.setBackgroundColor(Color.black);
						con.clear();
						binInvalid = true;
					}
				}
			}else if(chrMainMenu == 's'){
				binInvalid=false;
				hazelCPTtools.Secret(con);
				while(chrReturn != 'r'){
				chrReturn = con.getChar();
					if(chrReturn == 'r'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.clear();
						con.setBackgroundColor(Color.black);
						binInvalid = true;
					}
				}
			}else{
				chrMainMenu = hazelCPTtools.MainMenu(con);
				con.setBackgroundColor(Color.black);
				con.clear();
			}
		}
	}
}
