package driverService;

public class Driver {
	/*
	 * car model,car brand, registration number of the car,price per km and also type(petrol,diesel)
	 */
	private final String firstName;
	private final String lastName;
	private final String nic;
	private final String phoneNumber;
	private int age;
	private final static String DRIVERLISTCSV= "D:/csv/driver/listDrivers.csv"; 
	private final static String AVAILABLEDRIVERSCSV= "D:/csv/driver/availableDrivers.csv"; 
	private final static String RESERVEDDRIVERCSV = "D:/csv/driver/reservedDrivers.csv"; 

	
	public Driver(String firstName, String lastName, String nic, String phoneNumber, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	
	

	public String getFirstName() {
		return firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public String getNic() {
		return nic;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public double getAge() {
		return age;
	}




	public static String getDriverlistcsv() {
		return DRIVERLISTCSV;
	}

	public static String getAvailabledriverscsv() {
		return AVAILABLEDRIVERSCSV;
	}

	public static String getReserveddrivercsv() {
		return RESERVEDDRIVERCSV;
	}

	@Override
	public String toString() {
		return nic + "," + firstName + "," + lastName + "," + phoneNumber + "," + age;
	}
}
