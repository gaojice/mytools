package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JavaDb {
	public static void main(String[] a) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		System.out.println("Load the embedded driver");
		Connection conn = null;
		Properties props = new Properties();
		props.put("user", "user1");
		props.put("password", "user1");
		//create and connect the database named helloDB 
		conn = DriverManager.getConnection("jdbc:derby:helloDB;create=false", props);
		System.out.println("create and connect to helloDB");
		conn.setAutoCommit(false);

		// create a table and insert two records 
		Statement s = conn.createStatement();
		//		s.execute("create table hellotable(name varchar(40), score int)");
		System.out.println("Created table hellotable");
		//		s.execute("insert into hellotable values('Ruth Cao', 86)");
		//		s.execute("insert into hellotable values ('Flora Shi', 92)");
		// list the two records 
		ResultSet rs = s.executeQuery("SELECT name, score FROM hellotable ORDER BY score");
		System.out.println("namettscore");
		while (rs.next()) {
			StringBuilder builder = new StringBuilder(rs.getString(1));
			builder.append("t");
			builder.append(rs.getInt(2));
			System.out.println(builder.toString());
		}
	}
}
