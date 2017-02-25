import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class bucketSort {
	int BucketAry[];
	int min, max ;
	int lastIndex;
	File infile;
	
	bucketSort(String filename, String outname){
		infile = new File(filename);
		findMinMax(infile);
		constructor(min,max);
		printSortData(outname);
	}
	private void findMinMax(File in) {
		int temp; 
		Scanner myScanner;
		try {
			myScanner = new Scanner (in);
			if (myScanner.hasNext()==false) {
				myScanner.close();
				throw new IllegalArgumentException("Input Empty");
			}
			temp = myScanner.nextInt();
			if (temp < 0) {
				myScanner.close();
				throw new IllegalArgumentException("Negative input in File");
			}
			max =temp;
			min =temp;
			while(myScanner.hasNextInt()){
				temp = myScanner.nextInt();
				if (temp < 0) {
					myScanner.close();
					throw new IllegalArgumentException("Negative input in File");
				}
				if (temp > max) max = temp;
				if (temp < min) min = temp;
			}
			myScanner.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
	}
	private void constructor(int min2, int max2) {
		BucketAry = new int[max2-min2+1];
		lastIndex = max2-min2+1;
		try {
			Scanner myScanner = new Scanner (infile);
			int tempData; 
			//counting
			while(myScanner.hasNextInt()){
				tempData = myScanner.nextInt();
				BucketAry[getIndex(tempData)]++;
			}
			myScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int getIndex (int data){
		return data-min;
	}
	public void printSortData(String outfile){
		try{
			FileWriter myWriter = new FileWriter(new File (outfile));
			for (int i =0; i < lastIndex;i++){
				if (BucketAry[i]!=0){
					for (int j=0 ;j<BucketAry[i];j++){
						myWriter.write((i+min)+"\r\n");
					}
				}
			}
			myWriter.flush();
			myWriter.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
