package mysql.duplicate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Duplicate {
	public static void main(String[] a) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connectionMaster = DriverManager.getConnection("jdbc:mysql://192.168.100.223/rcms2", "phoenixgetter", "phoenixgetter");
		Connection connectionSlave215 = DriverManager.getConnection("jdbc:mysql://192.168.100.215/rcms2", "phoenixgetter", "phoenixgetter");
		Connection connectionSlave216 = DriverManager.getConnection("jdbc:mysql://192.168.100.216/rcms2", "phoenixgetter", "phoenixgetter");
		connectionMaster.setAutoCommit(false);
		connectionMaster.createStatement().execute("delete from test");
		connectionMaster.commit();
		for (int i = 0; i < 1000; i++) {
			connectionMaster
					.createStatement()
					.execute(
							"insert into test(content) values('1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890');");
		}
		connectionMaster.commit();
		Thread.sleep(70);
		ResultSet result = connectionSlave215.createStatement().executeQuery("select count(*) from test");
		while (result.next()) {
			System.out.println(result.getInt(1));
		}

		result = connectionSlave216.createStatement().executeQuery("select count(*) from test");
		while (result.next()) {
			System.out.println(result.getInt(1));
		}
		connectionMaster.close();
		connectionSlave215.close();
		connectionSlave216.close();

	}
}
