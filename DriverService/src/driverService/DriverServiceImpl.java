package driverService;

import java.util.ArrayList;
import java.util.Scanner;

import fileoperator.CSVFile;

public class DriverServiceImpl implements DriverService {

	private CSVFile csvFile;
	
	public DriverServiceImpl(CSVFile csv) {
		csvFile = csv;
		csvFile.createFirestCSV(Driver.getAvailabledriverscsv(), "NIC,FirstName,LastName,PhoneNumber,Age");
		csvFile.createFirestCSV(Driver.getDriverlistcsv(), "NIC,FirstName,LastName,PhoneNumber,Age");
		csvFile.createFirestCSV(Driver.getReserveddrivercsv(), "NIC,FirstName,LastName,PhoneNumber,Age");
	}
	
	
	@Override
	public boolean reserveDriver(String regNo) {
		if(csvFile.findline(regNo, Driver.getAvailabledriverscsv()) != null) {
			String details = csvFile.modifyCSV(regNo, Driver.getAvailabledriverscsv());
			csvFile.writeCSV(details, Driver.getReserveddrivercsv());
			System.out.println("Reserved a driver");
			return true;
		}else {
			System.out.println("Not Available");
			return false;
		}
	}

	@Override
	public boolean addAvailableDriver(String regNo) {
		if(csvFile.findline(regNo, Driver.getReserveddrivercsv())!= null) {
			String details = csvFile.modifyCSV(regNo, Driver.getReserveddrivercsv());
			csvFile.writeCSV(details, Driver.getAvailabledriverscsv());
			System.out.println("Add available driver");
			return true;
		}else {
			System.out.println("Not Available");
			return false;
		}
	}

	@Override
	public boolean addNewDriver(String firstName,String lastName,String nic,String phoneNumber,int age) {

		Driver driver = new Driver(firstName, lastName, nic, phoneNumber, age);
		
		csvFile.writeCSV(driver.toString(), driver.getDriverlistcsv());
		csvFile.writeCSV(driver.toString(), driver.getAvailabledriverscsv());
		System.out.println("New Driver Added");
		return true;
	}


	@Override
	public boolean removeDriver(String regNo) {
		if(csvFile.findline(regNo, Driver.getDriverlistcsv()) != null) {
			csvFile.modifyCSV(regNo, Driver.getAvailabledriverscsv());
			csvFile.modifyCSV(regNo, Driver.getDriverlistcsv());
			csvFile.modifyCSV(regNo, Driver.getReserveddrivercsv());
			System.out.println("Remove Driver");
			return true;
		}else {
			System.out.println("Not Available");
			return false;
		}
	}


	@Override
	public ArrayList<String> displayAvailableDrivers() {
		ArrayList<String[]> driverlist = getAvailableDrivers();
		ArrayList<String> driverList = new ArrayList<String>();
		

		System.out.println("---Displaying Available Drivers---");
		
		for(int i=0; i<driverlist.size(); i++) {
//			System.out.println("NIC Number: " + driverlist.get(i)[0] + ", First Name: " + driverlist.get(i)[1] + ", Last Name: " + driverlist.get(i)[2]
//					+ ",  Phone Number: " + driverlist.get(i)[3] + ", Age: " + driverlist.get(i)[4]);
			driverList.add(driverlist.get(i)[0]);
		}
		
		return driverList;
		
	}

	@Override
	public ArrayList<String> displayReservedDrivers() {
		
		ArrayList<String[]> driverlist = getReservedDrivers();
		ArrayList<String> driverList = new ArrayList<String>();
		
		System.out.println("---Displaying Reserved Drivers");
		
		for(int i=0; i<driverlist.size(); i++) {
			System.out.println("NIC Number: " + driverlist.get(i)[0] + ", First Name: " + driverlist.get(i)[1] + ", Last Name: " + driverlist.get(i)[2]
					+ ",  Phone Number: " + driverlist.get(i)[3] + ", Age: " + driverlist.get(i)[4]);
			driverList.add(driverlist.get(i)[0]);
		}
		
		return driverList;
		
	}
	
	@Override
	public boolean removeReservation(String regNo) {
		String line = csvFile.findline(regNo, Driver.getReserveddrivercsv());
		if(line != null) {
			csvFile.modifyCSV(regNo, Driver.getReserveddrivercsv());
			csvFile.writeCSV(line, Driver.getAvailabledriverscsv());
			System.out.println("Removed Reservation");
			return true;
		}else {
			System.out.println("Not Available");
			return false;
		}
		
	}
	
	@Override
	public ArrayList<String> displayAllDrivers() {
		ArrayList<String[]> driverlist = getAllDrivers();
		ArrayList<String> driverList = new ArrayList<String>();

		System.out.println("---Displaying all Drivers---");
		
		for(int i=0; i<driverlist.size(); i++) {
			System.out.println("NIC Number: " + driverlist.get(i)[0] + ", First Name: " + driverlist.get(i)[1] + ", Last Name: " + driverlist.get(i)[2]
					+ ",  Phone Number: " + driverlist.get(i)[3] + ", Age: " + driverlist.get(i)[4]);
			driverList.add(driverlist.get(i)[0]);
		}

		return driverList;
	}
	
	@Override
	public ArrayList<String[]> getAllDrivers() {
		return csvFile.readCSV(Driver.getDriverlistcsv());
	}


	@Override
	public ArrayList<String[]> getReservedDrivers() {
		// TODO Auto-generated method stub
		return csvFile.readCSV(Driver.getReserveddrivercsv());		
	}

	@Override
	public ArrayList<String[]> getAvailableDrivers() {
		return csvFile.readCSV(Driver.getAvailabledriverscsv());
	}


	

}
