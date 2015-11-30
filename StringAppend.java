import java.io.*;

class StringAppend{
  public static void main(String[] args)throws IOException{
     String content = readFile("c:\\java\\vacation.htm");
    long time= System.currentTimeMillis();


  }

  static String readFile(String fileName) throws IOException{
    	StringBuilder sb = new StringBuilder("");
	int c1;
	FileInputStream f1= new FileInputStream(fileName);		
	InputStreamReader in = new InputStreamReader(f1, "UTF-8");

	while ((c1 = in.read()) != -1) {
	  sb.append((char) c1);
	}        
        return sb.toString();
  }
}


