#include <iostream>
#include <fstream>
using namespace std;
class bucketSort {
public:
	int max =0 ;
	int min =0 ;
	int *bucketAry;
	int lastIndex; 
	ifstream infile;
	string name; 
	bucketSort() {}
	bucketSort(string inputfilename) {
		isEmpty(inputfilename);	
		findMinMax();
		consctructor(max, min);
	}
	~bucketSort(){	
		delete []bucketAry; 
	}
	void isEmpty(string filename) {
		int temp=0;
		infile.open(filename);
		if ((infile >> temp)== false) {
		infile.close();
			cout << "File Empty" << endl;
			exit(1);
		}
		min = temp ; 
		max = temp ; 
		if (temp<0){
			infile.close();
			cout << "Negative Number " << endl;
			exit(1);
		}
		name=filename;
	}
	void findMinMax() {
		int temp; 
		while (infile >> temp) {
			if (temp < 0) {
				infile.close();
				cout << "Find Negative Number" << endl;
				exit(1);
			}
			if (temp > max)  max = temp;
			if (temp < min)  min = temp;
		}
		infile.close();
	}
	void consctructor(int mx, int mn) {
		lastIndex = mx - mn + 1;
		bucketAry = new int[lastIndex];
		for(int i = 0 ; i < lastIndex ; i++){   // reset Array to 0
			bucketAry[i]=0;
		}
		int temp;
		infile.open(name);
		while (infile >> temp) {
			bucketAry[getIndex(temp)]++;
		}
		infile.close();
	} 
	int getIndex(int data){
		return data-min;
	}
	void printSortData(string outfile) {
		ofstream ofile;
		ofile.open(outfile);
		for (int i = 0; i < lastIndex; i++) {
			if (bucketAry[i] != 0) {
				for (int j = 0; j < bucketAry[i]; j++) {
					ofile << i + min << endl;
				}
			}
		}
		ofile.close();
	}
};
int main(int argc, char* argv[]) {
	bucketSort x(argv[1]);
	x.printSortData(argv[2]);
	cout<<"ok"<<endl;
	return 0;
}
