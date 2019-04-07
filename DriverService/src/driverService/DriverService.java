package driverService;

import java.util.ArrayList;
import java.util.HashMap;

public interface DriverService {
	public boolean reserveDriver(String regNo);
	public boolean addAvailableDriver(String regNo);
	/*
	 * add new car into csv
	 */
	public boolean addNewDriver(String firstName,String lastName,String nic,String phoneNumber,int age);
	public boolean removeDriver(String regNo);
	public ArrayList<String> displayAvailableDrivers();
	public ArrayList<String> displayReservedDrivers();
	public boolean removeReservation(String regNo);
	public ArrayList<String> displayAllDrivers();
	public ArrayList<String[]> getAllDrivers();
	public ArrayList<String[]> getReservedDrivers();
	public ArrayList<String[]> getAvailableDrivers();
}