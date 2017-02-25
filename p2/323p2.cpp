#include <iostream>
#include <string>
using namespace std;
class passWordChecker {
	private:
		string password;
		string secondPassword;
		int charCount[5];
		int passwordLength=0;
		void displyRules(){
		cout<<"1) The password length: 8-16 characters"<<endl
		<<"2) At least one numerical, i.e., 0, 1, 2,.."<<endl
		<<"3) At least one upper case letter, i.e., A, B, C, ..."<<endl
		<<"4) At least one lower case letter, i.e., a, b, c, ..."<<endl
		<<"5) At least one of the special characters, but it must be"
		<<" within the set:{ $ ^ & #  ( ) } at total of six (6).no other "
		<<"special characters is allowed."<<endl;
		}
		void displySucess (){
			cout << "your password will be updated in 2 minuties" << endl;
		}
		int checkChar(char in){
			//cout << "Test3";
			if (in>47 && in<58)return 1;//0-9
			else if (in>96 && in<123)return 2;//a-z
			else if (in> 64 && in <91)return 3;//A-Z
			else if (in==36 ||in==94||in==38||in==35||in==40||in==41)return 4;//$ ^ & #  ( )
			else return 0;
		}
		bool checker() {
			if (charCount[0] == 0) {
				for (int i = 1; i < 5; i++) {
					if (charCount[i] == 0) return false;
				}
				return true;
			}
			else {
				return false;
			}
		}
		bool matching(string s1 , string s2){
			if (s1==s2) return true;
			return false;
		}
		void resetArrycounter() {
			for (int i = 0; i < 5; i++) {
				charCount[i] = 0;
			}
		}
	public:
	passWordChecker(){
		constructor ();
		displySucess();
	}
	void constructor (){
			bool loop = true; 
			while(loop){
				resetArrycounter();
				displyRules();
				cin>> password;
				passwordLength = password.length();
				if (passwordLength < 17 && passwordLength > 7) {
					for (int i = 0; i < passwordLength; i++) {
						charCount[checkChar(password[i])]++;
					}
					if (checker()) {
						cout << "Please confirm password :"<<endl;
						cin >> secondPassword;
						if (matching(password, secondPassword)) {
							loop = false;
						}
					}
				}
			}
	}
};
int main (){
passWordChecker x;
return 0;
}
