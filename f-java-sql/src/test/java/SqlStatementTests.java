import static org.testng.Assert.assertEquals;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class SqlStatementTests {
	@Test
	public void sqlStatementTest1() throws SQLException {
		String sql = "SELECT city FROM city ORDER BY city DESC LIMIT 10;";

		String actualResult[] = { "Ziguinchor", "Zhoushan", "Zhezqazghan", "Zeleznogorsk", "Zaria", "Zapopan", "Zaoyang",
				"Zanzibar", "Zalantun", "Yuzhou" };

		ArrayList<String> expectedResult = new ExecuteSql().selectSql(sql);

		assertEquals(actualResult, expectedResult.toArray());
	}

	@Test
	public void sqlStatementTest2() throws SQLException {
		String sql = "SELECT * FROM film_list WHERE actors LIKE '%BOB FAWCETT%';";

		String actualResult[] = { "2", "3", "144", "152", "182", "208", "212", "217", "266", "404", "428", "473", "490", "510",
				"513", "644", "670", "673", "711", "750", "752", "756", "771", "785", "877" };

		ArrayList<String> expectedResult = new ExecuteSql().selectSql(sql);

		assertEquals(actualResult, expectedResult.toArray());
	}

	@Test
	public void sqlStatementTest3() throws SQLException {
		String sql = "CALL film_in_stock(15, 2, @filmCount)";

		String actualResult[] = { "73", "74", "75", "76" };

		ArrayList<String> expectedResult = new ExecuteSql().selectSql(sql);

		assertEquals(actualResult, expectedResult.toArray());
	}

	@Test
	public void sqlStatementTest4() throws SQLException {
		String sql = "UPDATE store SET last_update = CURRENT_TIMESTAMP WHERE store_id = 2;";

		int isExecute = new ExecuteSql().updateSql(sql);

		assertEquals(isExecute, 1);
	}
}
