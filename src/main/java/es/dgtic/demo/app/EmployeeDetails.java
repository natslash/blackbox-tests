package es.dgtic.demo.app;

public class EmployeeDetails {

	private String name;
	private double monthlySalary;
	private int age;

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            el nombre de empleado
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the monthlySalary
	 */

	public double getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * @param monthlySalary
	 *            the nomina mensual a setear
	 */

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            la edad a setear
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
