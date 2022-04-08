import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class JavaIO {
	@Test
	public void openCSVFile() throws IOException, CsvValidationException {
		//read file using OpenCSV
		FileInputStream fileInputStream = null;
		ClassLoader classLoader = this.getClass().getClassLoader();
		FileReader filereader = new FileReader(new File(classLoader.getResource("basses.csv").getFile()));
		CSVReader csvReader = new CSVReader(filereader);
		String[] nextString;
//		csvReader.readNext();
		
		//because hashmap will replace value if pass in the same key
		//for outputting the info from csv file, hashmap store two arraylist instead
		HashMap<List<String>, List<String>> hashmap = new HashMap<List<String>, List<String>>();
		ArrayList<String> arraylist1 = new ArrayList<String>();
		ArrayList<String> arraylist2 = new ArrayList<String>();
		while ((nextString = csvReader.readNext()) != null) {
			for (int i = 0; i < nextString.length; i++) {
				if (i == 1 || i == 2) {
					continue;
				}
				arraylist1.add(nextString[i]); //list1 store keys
				arraylist2.add(nextString[i + 1]); //list2 stores values
			}
		}
		
		//hashmap store two lists
		hashmap.put(arraylist1, arraylist2);
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		
		//printout elements
		Set entrySet = hashmap.entrySet();
		for (Object object : entrySet) {
			list1 = ((Map.Entry<List<String>, List<String>>) object).getKey();
			list2 = ((Map.Entry<List<String>, List<String>>) object).getValue();
			for(int i = 0; i < arraylist1.size(); i++) {
				System.out.println(list1.get(i) + " " + list2.get(i));
			}
			System.out.println();
		}
		
		
		Assert.assertEquals(list1.get(0), "Make");
		Assert.assertEquals(list2.get(0), "Model");
		
		Assert.assertEquals(list1.get(1), "Warwick");
		Assert.assertEquals(list2.get(1), "Corvette");
		
		Assert.assertEquals(list1.get(2), "Warwick");
		Assert.assertEquals(list2.get(2), "Thumb");
		
		Assert.assertEquals(list1.get(3), "Warwick");
		Assert.assertEquals(list2.get(3), "Streamer");
		
		Assert.assertEquals(list1.get(4), "Fender");
		Assert.assertEquals(list2.get(4), "Precision");
		
		Assert.assertEquals(list1.get(5), "Fender");
		Assert.assertEquals(list2.get(5), "Jazz");
		
		Assert.assertEquals(list1.get(6), "Yamaha");
		Assert.assertEquals(list2.get(6), "BB500");
		
	
		
		
		
//		Assert.assertEquals(hashmap.get(arraylist1.get(0)), "Model");
		

	}
}


