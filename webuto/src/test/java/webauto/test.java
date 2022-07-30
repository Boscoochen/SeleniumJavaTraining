package webauto;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(11);
		arrayList.add(12);
		for(int i =0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}
}
