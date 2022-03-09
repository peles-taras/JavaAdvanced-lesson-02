package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper {

	public static Person map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String first_name = result.getString("first_name");
		String last_name = result.getString("last_name");
		int age = result.getInt("age");

		return new Person(id,first_name, last_name, age);
	}

}
