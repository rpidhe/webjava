import java.io.*;
import java.util.HashSet;

import javax.swing.text.html.HTML.Tag;

class ShowTags {
	static HashSet<String> tags = new HashSet<String>(); // ���ڱ����ǩ

	public static void main(String[] args) throws IOException {
		String content = readFile("vacation.htm");
		int start = 0;
		int end = 0;
		while ((start = content.indexOf("<", start)) != -1) {
			char next = content.charAt(++start);
			// ������ע�ͣ��������ǩ
			if (next != '!' && next != '/') {
				// ȥ����ǩǰ�ո�
				while (content.charAt(start) == ' ') {
					start++;
				}
				StringBuilder tagBuilder =  new StringBuilder();
				//���ұ�ǩ��
				while(!endOfTag(content.charAt(start))){
					tagBuilder.append(content.charAt(start++));
				}
				String newTag = tagBuilder.toString();
				tags.add(newTag);
				// �����ǩ��scriptҪ����sript�е����б�ǩ
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
	//��ǩ����
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
