import java.io.*;
import java.util.Arrays;

public class StringTest{
  public static void main(String[] args)throws IOException{
     String content = readFile("poem.txt");
     int count[] = new int[4];
	 int i = 0;
	 int len = content.length();
     while(i < len){
		 char c = content.charAt(i);
		 if(c == '春'){
			 count[0]++;
		 }else if(c=='天'){
			 count[1]++;
		 }
		 else if(c=='水'){
			 count[2]++;
		 }
		 else if(c=='花'){
			 count[3]++;
		 }
		 i++;
	 }
     System.out.println("春 "+ count[0] + ", 天 "+ count[1]+", 水 "+ count[2] +
	 ", 花 "+ count[3]);
  }
 
  static String readFile(String fileName) throws IOException{
    	StringBuilder sb = new StringBuilder("");
        String s1="";
	int c1;
	FileInputStream f1= new FileInputStream(fileName);		
	InputStreamReader in = new InputStreamReader(f1, "UTF-8");

	while ((c1 = in.read()) != -1) {
	  sb.append((char) c1);
	}        
        return sb.toString();
  }
}

