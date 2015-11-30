import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class CharCounter{
	private char c;
	private int count;
	public int getCount() {
		return count;
	}

	public CharCounter(char c) {
		this.c = c;
		count = 1;
	}
	public void countAddbyOne(){
		count++;
	}
	@Override
	public String toString() {
		return c + " " + count;
	}
}
public class StringTest2{
  static List<CharCounter> charCounters = new ArrayList<CharCounter>();
  public static void main(String[] args)throws IOException{
     String content = readFile("poem.txt");
	 content = content.replaceAll("[^\\u4e00-\\u9fa5]", ""); //正则表达式替换非中文字符
     char charArr[] = content.toCharArray(); //将字符串转换为字符数组
     Arrays.sort(charArr); //将字符数组排序，使得相同的字符放在一起
     int len = charArr.length; 
     char pre = charArr[0];
     CharCounter charCounter = new CharCounter(pre);
     charCounters.add(charCounter);
     for(int i = 1;i<len;i++){
    	 if(charArr[i]!=pre){
    		 pre = charArr[i];
    		 charCounter = new CharCounter(pre);
    	     charCounters.add(charCounter);
    	 }else{
    		 charCounter.countAddbyOne();
    	 }
     }
     Collections.sort(charCounters,new Comparator<CharCounter>() {
		@Override
		public int compare(CharCounter o1, CharCounter o2) {
			if(o1.getCount() < o2.getCount()){
				return 1;
			}else if(o1.getCount() == o2.getCount()){
				return 0;
			}
			return -1;
		}
	});
    int i = 0;
    for (CharCounter cc : charCounters) {
    	System.out.println(cc);
		i++;
		if(i == 20){
			break;
		}
	}
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

