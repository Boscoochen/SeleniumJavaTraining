import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@SuppressWarnings({ "all" })
public class JavaIO {

	@Test
	public void testTwoHashMapAreEqualed() throws CsvValidationException, IOException {
		HashMap<String, String> expectedMap = openCSVFileToReturnHashMap();

		HashMap<String, String> actualMap = new HashMap<String, String>();
		actualMap.put("Streamer", "Warwick");
		actualMap.put("Jazz", "Fender");
		actualMap.put("Precision", "Fender");
		actualMap.put("BB500", "Yamaha");
		actualMap.put("Thumb", "Warwick");
		actualMap.put("Corvette", "Warwick");

		Assert.assertEquals(actualMap, expectedMap, "Case Fail, two hashmaps are different");
	}

	public HashMap<String, String> openCSVFileToReturnHashMap() throws IOException, CsvValidationException {
		ClassLoader classLoader = this.getClass().getClassLoader();
		FileReader filereader = new FileReader(new File(classLoader.getResource("basses.csv").getFile()));
		CSVReader csvReader = new CSVReader(filereader);
		String[] nextString;

		HashMap<String, String> hashmap = new HashMap<String, String>();
		csvReader.readNext();
		while ((nextString = csvReader.readNext()) != null) {
			for (int i = 0; i < nextString.length; i++) {
				if (i == 1 || i == 2) {
					continue;
				}
				hashmap.put(nextString[i + 1], nextString[i]);
			}
		}
		return hashmap;
	}

	public void printHashMap(HashMap<String, String> hashmap) {
		Set entrySet = hashmap.entrySet();
		for (Object object : entrySet) {
			String key = ((Map.Entry<String, String>) object).getKey();
			String value = ((Map.Entry<String, String>) object).getValue();
			System.out.println(value + " " + key);
		}
	}
}