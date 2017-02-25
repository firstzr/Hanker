import java.util.Scanner;

public class passWordChecker {
	private String password, secondpassword;
	private int [] charCount= new int [5];
	private int passwordLength=0;
	private Scanner myScan;
	private boolean Loop=true;
	public passWordChecker (){
		constructor ();
		displySucess();
	}
	public void constructor (){
		boolean loop = true; 
		while(loop){
			resetArrycounter();
			displyRules();
			
				myScan =new Scanner (System.in);
				password = myScan.nextLine();
			
			passwordLength = password.length();
			if (passwordLength < 17 && passwordLength > 7) {
				for (int i = 0; i < passwordLength; i++) {
					charCount[checkChar(password.charAt(i))]++;
				}
				if (checker()) {
					System.out.println( "Please confirm password :");
					myScan = new Scanner (System.in);
					secondpassword = myScan.nextLine();
					loop = !matching(password, secondpassword);
				}
			}
		}
	}
	public void displyRules(){
		System.out.println("1) The password length: 8-16 characters");
		System.out.println("2) At least one numerical, i.e., 0, 1, 2,..");
		System.out.println("3) At least one upper case letter, i.e., A, B, C, ...");
		System.out.println("4) At least one lower case letter, i.e., a, b, c, ...");
		System.out.println("5) At least one of the special characters, but it must be within the set:{ $ ^ & #  ( ) } at total of six (6).no other special characters is allowed.");
	}
	public void displySucess (){
		System.out.println("your password will be updated in 2 minuties");
	}	
	private int checkChar(char in){
		if(in > 47 && in < 58)return 1;
		else if(in > 96 && in < 123)return 2;
		else if(in > 64 && in < 91)return 3;
		else if(in ==36 ||in ==94 ||in ==38 ||in ==35 ||in ==40 ||in ==41)return 4;
		else return 0 ;
	}
	private boolean checker (){
		if (charCount[0] == 0) {
			//System.out.println(charCount[0]);
			for (int i = 1; i < 5; i++) {
				if (charCount[i] == 0) return false;
				//System.out.println(charCount[i]);
			}
			return true;
		}else{
			return false;
		}
	}
	void resetArrycounter() {
		for (int i = 0; i < 5; i++) {
			charCount[i] = 0;
		}
	}
	private boolean matching (String s1,String s2){
		return s1.equals(s2) ;
	}
}
