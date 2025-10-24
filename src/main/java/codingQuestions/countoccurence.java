package codingQuestions;

import java.util.HashMap;
import java.util.Map;

public class countoccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "Selenium";
		Map<Character,Integer> map = new HashMap<>();
		for(char ch:value.toCharArray()) {
			map.put(ch,map.getOrDefault(ch, 0)+1);
		}
		System.out.println(map);

	}

}
