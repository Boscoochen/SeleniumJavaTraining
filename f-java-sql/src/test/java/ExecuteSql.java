import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.JDBCUtils;

public class ExecuteSql {
	public ArrayList<String> selectSql(String sql) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				list.add(set.getString(1));
			}
			connection.commit();
		} catch (Exception e) {
			System.out.println("exception occur, rollback dismissed changes");
			connection.rollback();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(preparedStatement, connection);
		}
		return list;
	}

	public int updateSql(String sql) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int isExecute;
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			isExecute = preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			System.out.println("exception occur, rollback dismissed changes");
			connection.rollback();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(preparedStatement, connection);
		}
		return isExecute;
	}
}
