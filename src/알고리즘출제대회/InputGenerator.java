package 알고리즘출제대회;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Random;

/*
input: a~z palindrome
size: 1 ~ 10,000
 * 
 * **/

public class InputGenerator {

	public static void main(String[] args) {
		Random rand = new Random(System.currentTimeMillis());
		final int bound = 3333;	//3333
		try {
			FileOutputStream f_stream = new FileOutputStream("/Users/eunsong/Documents/SSAFY/알고리즘 출제대회/eval_input.txt");
			BufferedOutputStream inputBs = new BufferedOutputStream(f_stream);
			
			for(int i = 0; i < 45; i++) {
				// 문자열의 길이 
				int length = rand.nextInt(bound);
				while(true) {
					if(length > 0)	break;
					length = rand.nextInt(bound);
				}
				
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < length; j++) {
					char alpha = (char)(rand.nextInt(26) + 97);
					sb.append(alpha);
				}
				StringBuffer rev = new StringBuffer(sb.toString()).reverse();
				boolean odd = rand.nextBoolean();
				// 홀수개 문자열 붙이기  
				if(odd || length == 1) {
					sb.append(rev.substring(1, length));
					length = length * 2 - 1;
				}else {
					// 짝수개 문자열 붙이기 
					sb.append(rev);			
					length = length * 2;
				}
				
				System.out.println(length);
				
				// 방해 문자열 붙이기 
				int bombLen = rand.nextInt(bound);
				for(int j = 0; j < bombLen; j++) {
					char bomb = (char)(rand.nextInt(26) + 97);
					
					int insertIdx = rand.nextInt(sb.length());
					sb.insert(insertIdx, bomb);
				}
	//			System.out.println(length + bombLen);
//				System.out.println(sb.toString());
	//			System.out.println();
				sb.append("\n");
				inputBs.write(sb.toString().getBytes());
			}
			inputBs.close();
			f_stream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
