import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaExercisesTest {

	@Test
	public void compareTwoValueTypes() {
		int number1 = 1000;
		int number2 = 1000;
		boolean isEqual = number1 == number2;

		Assert.assertEquals(isEqual, true, "These two numbers are not equal~");
	}

	@Test
	public void compareTwoReferenceTypes() {
		String str1String = new String("abc");
		String str2String = new String("abc");

		boolean isEqual = false;

		str1String = str1String.intern();
		str2String = str2String.intern();

		if (str1String == str2String) {
			isEqual = true;
		}

		Assert.assertEquals(isEqual, true, "These two Strings are not equal~");
	}

	@Test
	public void compareTwoReferenceTypesUseEquals() {
		String str1String = new String("abc");
		String str2String = new String("abc");

		boolean isEqual = false;

		if (str1String.equals(str2String)) {
			isEqual = true;
		}
		Assert.assertEquals(isEqual, true, "These two Strirgs are not equal~");
	}

	@Test
	public void logicalAndOperator() {
		int number1 = 1000;
		int number2 = 1000;

		String str1String = new String("abc");
		String str2String = new String("abc");

		boolean isEqual = false;

		if (number1 == number2 && str1String.equals(str2String)) {
			isEqual = true;
		}
		Assert.assertEquals(isEqual, true, "logicalAndOperator case fail~");
	}

	@Test
	public void logicalOrOperator() {
		int number1 = 1000;
		int number2 = 1000;

		String str1String = new String("ab");
		String str2String = new String("abc");

		boolean isEqual = false;

		if (number1 == number2 || str1String.equals(str2String)) {
			isEqual = true;
		}

		Assert.assertEquals(isEqual, true, "logicalOrOperator case fail~");
	}

	@Test
	public void incrementAndDecrementOperators() {
		int number1 = 1000;
		int number2 = 1000;

		number1++;
		--number2;

		Assert.assertEquals(number1, 1001, "post-increment case fail");
		Assert.assertEquals(number2, 999, "pre-decrement case fail");
	}

	@Test
	public void booleanVariable() {
		boolean isTrue = true;
		Assert.assertEquals(!isTrue, false, "change true to false using ! case fail");
	}

	@Test
	public void ifStatements() {
		boolean isTrue = true;
		boolean check = false;

		if (isTrue) {
			check = true;
		}

		if (!isTrue) {
			check = false;
		}

		Assert.assertEquals(true, check, "ifStatementsFail");
	}

	@Test
	public void ifElseStatements() {
		boolean isTrue = false;
		boolean check = true;

		if (isTrue) {
			check = false;
		} else {
			check = true;
		}

		assertEquals(true, check, "ifElseStatementsFail");
	}

	@Test
	public void nestedForLoop() {
		int[] unSortedArr = { 3, -1, -2, 0, 5 };
		for (int i = 0; i < unSortedArr.length; i++) {
			for (int j = 0; j < unSortedArr.length - i - 1; j++) {
				if (unSortedArr[j] > unSortedArr[j + 1]) {
					int temp = unSortedArr[j];
					unSortedArr[j] = unSortedArr[j + 1];
					unSortedArr[j + 1] = temp;
				}
			}
		}

		int[] sortedArr = { -2, -1, 0, 3, 5 };
		Assert.assertEquals(sortedArr, unSortedArr, "nestedForLoopFail");
	}

	@Test
	public void tryCatchCase() {
		boolean check = false;
		int result = 0;
		int num1 = 3;
		int num2 = 0;

		try {
			result = num1 / num2;
			check = true;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		assertEquals(false, check, "tryCatchCaseFail");
	}

	@Test
	public void forEachLoopCase() {
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("Hello");
		arraylist.add("World");
		arraylist.add("!!");

		String[] actualStringArray = { "Hello", "World", "!!" };

		int i = 0;
		for (String string : arraylist) {
			System.out.println(string);
			Assert.assertEquals(actualStringArray[i++], string, "forEachLoopCaseFail");
		}
	}

}
