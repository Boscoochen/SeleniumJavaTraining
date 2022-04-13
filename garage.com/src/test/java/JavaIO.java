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

@SuppressWarnings({"all"})
public class JavaIO {
 @Test
 public void openCSVFile() throws IOException, CsvValidationException {
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
    hashmap.put(nextString[i + 1],nextString[i]);
   }
  }
  
  //printout elements
  Set entrySet = hashmap.entrySet();
  for (Object object : entrySet) {
   String key = ((Map.Entry<String, String>) object).getKey();
   String value = ((Map.Entry<String, String>) object).getValue();
   System.out.println(value + " " + key);
  }
  
  Assert.assertEquals(hashmap.get("Streamer"), "Warwick");
  Assert.assertEquals(hashmap.get("Jazz"), "Fender");
  Assert.assertEquals(hashmap.get("Precision"), "Fender");
  Assert.assertEquals(hashmap.get("BB500"), "Yamaha");
  Assert.assertEquals(hashmap.get("Thumb"), "Warwick");
  Assert.assertEquals(hashmap.get("Corvette"), "Warwick");
 }
}