package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDaoImp {

	private Connection connection;
	private PreparedStatement prepStatement;
	private Statement statement;

	public PersonDaoImp(Connection connection) {
		this.connection = connection;
	}

	String create = "INSERT INTO Person(`first_name`,`last_name`,`age`) VALUES (?,?,?)";
	String read = "SELECT * FROM Person WHERE id =?";
	String update = "UPDATE Person SET first_name =?, last_name =?, age =? WHERE id=?";
	String delete = "DELETE FROM Person WHERE id =?";
	String readAll = "SELECT * FROM Person";

	public void readAll() throws SQLException {
		statement = connection.createStatement();
		ResultSet result = statement.executeQuery(readAll);

		while (result.next()) {
			int id = result.getInt("id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			int age = result.getInt("age");

			Person person = new Person(id, first_name, last_name, age);
			System.out.println(person);
		}

	}

	public void insert(Person person) throws SQLException {
		prepStatement = connection.prepareStatement(create);
		prepStatement.setString(1, person.getFirst_name());
		prepStatement.setString(2, person.getLast_name());
		prepStatement.setInt(3, person.getAge());
		prepStatement.executeUpdate();
	}

	public Person read(int id) throws SQLException {
		prepStatement = connection.prepareStatement(read);
		prepStatement.setInt(1, id);
		ResultSet result = prepStatement.executeQuery();
		result.next();
		return PersonMapper.map(result);
	}

	public void update(Person person) throws SQLException {
		prepStatement = connection.prepareStatement(update);
		prepStatement.setString(1, person.getFirst_name());
		prepStatement.setString(2, person.getLast_name());
		prepStatement.setInt(3, person.getAge());
		prepStatement.setInt(4, person.id);
		prepStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		prepStatement = connection.prepareStatement(delete);
		prepStatement.setInt(1, id);
		prepStatement.executeUpdate();
	}

}
