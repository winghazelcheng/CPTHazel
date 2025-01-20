import arc.*;
import java.awt.*;
import java.awt.image.*;

public class HazelCPTGuessTheWord{
	public static void main(String[] args){
		Console con = new Console("Guess the Word", 1280, 720);
		
		char chrMainMenu;
		char chrReturn;
		String strName;
		String strTheme;
		String strChooseTheme;
		boolean binInvalid;
		int intScore;
		int intLength;
	
		
		binInvalid = true;
		chrMainMenu = ' ';
		chrReturn = ' ';
		
		while(binInvalid == true){
			chrReturn = ' ';
			if(chrMainMenu == 'p' || chrMainMenu == 'P'){
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
				
					
								
			
			}else if(chrMainMenu == 'v' || chrMainMenu == 'V'){
				binInvalid = false;
				hazelCPTtools.Highscores(con);	
				while(chrReturn != 'r' && chrReturn != 'R'){
				chrReturn = con.getChar();
					if(chrReturn == 'r' || chrReturn == 'R'){
						con.clear(); 
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.setBackgroundColor(Color.black);
						con.clear();
						binInvalid = true;
					}
				}
			}else if(chrMainMenu == 'q' || chrMainMenu == 'Q'){
				binInvalid = false;
				con.closeConsole();
			}else if(chrMainMenu == 'h' || chrMainMenu == 'H'){
				binInvalid = false;
				hazelCPTtools.Help(con);
				while(chrReturn != 'r' && chrReturn != 'R'){ 
				chrReturn = con.getChar();
					if(chrReturn == 'r' || chrReturn == 'R'){
						con.clear();
						chrMainMenu = hazelCPTtools.MainMenu(con);
						con.setBackgroundColor(Color.black);
						con.clear();
						binInvalid = true;
					}
				}
			}else if(chrMainMenu == 's' || chrMainMenu == 'S'){
				binInvalid=false;
				hazelCPTtools.Secret(con);
				while(chrReturn != 'r' && chrReturn != 'R'){
				chrReturn = con.getChar();
					if(chrReturn == 'r' || chrReturn == 'R'){
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
