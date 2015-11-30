import java.io.*;
import java.util.Arrays;

public class StringTest{
  public static void main(String[] args)throws IOException{
     String content = readFile("c:\\java\\poem.txt");

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

