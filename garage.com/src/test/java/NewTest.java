import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	// 1.Compare two value types using the == operator
	@Test
	public void compareTwoValueTypes() {
		int number1 = 1000;
		int number2 = 1000;
		boolean isEqual = false;
		//if two numbers is equal, set isEqual true
		if (number1 == number2) {
			isEqual = true;
		}
		
		Assert.assertEquals(isEqual, true, "These two numbers are not equal~");
	}
	
	//2.Compare two reference types using the == operator
	@Test
	public void compareTwoReferenceTypes() {
		String str1String = new String("abc");
		String str2String = new String("abc");
		boolean isEqual = false;
		//compare two reference types using == will compare their hashcode
		//even their hashcode are euqals, but they are two different object
//		System.out.println("str1String " + new String("abc").hashCode());
//		System.out.println("str2String " +  new String("abc").hashCode());
		//intern() method will return String constant pool reference
		str1String = str1String.intern();
		str2String = str2String.intern();
		if(str1String == str2String) { 
			isEqual = true;
		}
		
		//isEqual will equal false
		Assert.assertEquals(isEqual, true, "These two Strings are not equal~");
	}
	
	//3. Compare two reference types using .equals()
	@Test
	public void compareTwoReferenceTypesUseEquals() {
		String str1String = new String("abc");
		String str2String = new String("abc");
		boolean isEqual = false;
		//compare strings char by char
		if(str1String.equals(str2String)) { 
			isEqual = true;
		}
		Assert.assertEquals(isEqual, true, "These two Strirgs are not equal~");
	}
	
	
	//4. Demonstrate the logical AND operator
	@Test
	public void logicalAndOperator() {
		int number1 = 1000;
		int number2 = 1000;
		String str1String = new String("abc");
		String str2String = new String("abc");
		boolean isEqual = false;
		//compare strings char by char
		if(number1 == number2 && str1String.equals(str2String)) { 
			isEqual = true;
		}
		Assert.assertEquals(isEqual, true, "logicalAndOperator case fail~");
	}
	
	
	//5. Demonstrate the logical AND operator
	@Test
	public void logicalOrOperator() {
		int number1 = 1000;
		int number2 = 1000;
		String str1String = new String("ab");
		String str2String = new String("abc");
		boolean isEqual = false;
		//either one condition is correct will set isEqual true
		if(number1 == number2 || str1String.equals(str2String)) { 
			isEqual = true;
		}
		Assert.assertEquals(isEqual, true, "logicalOrOperator case fail~");
	}
	
	
	//6. Demonstrate unary post-increment and unary pre-decrement operators
	@Test
	public void incrementAndDecrementOperators() {
		int number1 = 1000;
		int number2 = 1000;
		number1++;
		number2--;
		Assert.assertEquals(number1, 1001, "post-increment case fail");
		Assert.assertEquals(number2, 999, "pre-decrement case fail");
	}
	
	//7. Change a boolean variable with the value of True to False using !
	@Test
	public void booleanVariable() {
		boolean isTrue = true;
		Assert.assertEquals(!isTrue, false, "change true to false using ! case fail");
	}
	
	//8. Use 2 IF statements (no elses)
	@Test
	public void ifStatements() {
		boolean isTrue = true;
		if(isTrue) {
			System.out.println("into first if statement");
		}
		if(!isTrue) {
			System.out.println("into second if statement");
		}
	}
	
	//9. Use IF/Else statements
	@Test
	public void ifElseStatements() {
		boolean isTrue = true;
		if(isTrue) {
			System.out.println("into first if statement");
		}else {
			System.out.println("into else statement");
		}
	}
	
	//10. Use a nested For loop
	@Test
	public void nestedForLoop() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println(i + " " + j);
			}
		}
	}
	
	//11. Demonstrate a try/catch (unsure that you are throwing an exception in the try
	@Test
	public void tryCatchCase() {
		try {
			//let thread sleep 1 second
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//12. Demonstrate a FOREACH loop. first create an arrayList of strings then print each string using a fOREACH loop
	@Test
	public void forEachLoopCase() {
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("Hello");
		arraylist.add("World");
		arraylist.add("!!");
		for (String string : arraylist) {
			System.out.println(string);
		}
	}
	
	
}

