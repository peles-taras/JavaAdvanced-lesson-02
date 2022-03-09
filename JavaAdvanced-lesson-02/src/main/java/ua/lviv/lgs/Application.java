package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {
	public static void main(String[] args) throws SQLException {

		Connection connection = ConnectionUtils.connect();
		PersonDaoImp pdi = new PersonDaoImp(connection);

		pdi.readAll();
		System.out.println("*** ALL DATA\n");
		
//		pdi.insert(new Person("SomeName", "SomeSurname", 99));
		pdi.readAll();
		System.out.println("*** AFTER CREATING PERSON\n");
		
		System.out.println(pdi.read(3));
		System.out.println("*** READING BY ID\n");

		Person person = pdi.read(3);
		person.setFirst_name("changed_name");
		pdi.update(person);
		pdi.readAll();
		System.out.println("*** AFTER CHANGING AND UPDATING NAME\n");
		
		pdi.delete(6);
		pdi.readAll();
		System.out.println("*** AFTER REMOVING PERSON\n");
	}
}
