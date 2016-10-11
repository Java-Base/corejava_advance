package com.core.java.TextFileTest;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Test Text File
 *
 * @auth 	Lian
 * @date 	2016/10/10
 * @since 	1.0
 */
public class TextFileTest {

	public static void main(String[] args) {

		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		try {
			// save all employee records to the file employee.dat
			PrintWriter out = new PrintWriter("employee.dat");
			writeData(staff, out);
			out.close();

			// retrieve all records into a new array
			Scanner in = new Scanner(new FileReader("employee.dat"));
			Employee[] newStaff = readData(in);
			in.close();

			// print the newly read employee records
			for (Employee e : newStaff)
				System.out.println(e);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}


	/**
	 * Write all employees in an array to a print writer
	 *
	 * @param employees	an array of employee
	 * @param out		a print writer
	 */
	private static void writeData(Employee[] employees, PrintWriter out) {
		out.println(employees.length);
		for (Employee e : employees) {
			e.writeData(out);
		}
	}

	/**
	 * Reads an array of employees from a scanner
	 *
	 * @param in	the scanner
	 * @return		the array of employees
	 */
	private static Employee[] readData(Scanner in) {
		// retrieve the array size
		int n = in.nextInt();
		// consume new line
		in.nextLine();

		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i] = new Employee();
			employees[i].readData(in);
		}

		return employees;
	}

}
