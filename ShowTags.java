import java.io.*;
import java.util.HashSet;

import javax.swing.text.html.HTML.Tag;

class ShowTags {
	static HashSet<String> tags = new HashSet<String>(); // 用于保存标签

	public static void main(String[] args) throws IOException {
		String content = readFile("vacation.htm");
		int start = 0;
		int end = 0;
		while ((start = content.indexOf("<", start)) != -1) {
			char next = content.charAt(++start);
			// 不能是注释，或结束标签
			if (next != '!' && next != '/') {
				// 去除标签前空格
				while (content.charAt(start) == ' ') {
					start++;
				}
				StringBuilder tagBuilder =  new StringBuilder();
				//查找标签名
				while(!endOfTag(content.charAt(start))){
					tagBuilder.append(content.charAt(start++));
				}
				String newTag = tagBuilder.toString();
				tags.add(newTag);
				// 如果标签是script要忽略sript中的所有标签
				if (newTag.equals("script")) {
					start = content.indexOf("</script", start);
				}
			}
		}
		int i = 1;
		for (String tag : tags) {
			System.out.print(tag+"\t");
			if(i%10==0){
				System.out.println();
			}
			i++;
		}
	}
	//标签结束
    static boolean endOfTag(char c){
    	return c == '/' || c == ' '||c=='>';
    }
	static String readFile(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder("");
		int c1;
		FileInputStream f1 = new FileInputStream(fileName);
		InputStreamReader in = new InputStreamReader(f1, "UTF-8");

		while ((c1 = in.read()) != -1) {
			sb.append((char) c1);
		}
		return sb.toString();
	}
}
