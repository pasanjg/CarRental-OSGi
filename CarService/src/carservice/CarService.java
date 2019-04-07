package carservice;

import java.util.ArrayList;
import java.util.HashMap;

public interface CarService {
	public boolean reserveCar(String regNo);
	public boolean addAvailableCar(String regNo);
	/*
	 * add new car into csv
	 */
	public boolean addNewCar(String model,String regNo,String brand,String type,double price);
	public boolean removeCar(String regNo);
	public ArrayList<String> displayAvailableCars();
	public ArrayList<String> displayReservedCars();
	public boolean removeReservation(String regNo);
	public ArrayList<String> displayAllCars();
	public ArrayList<String[]> getAllCars();
	public ArrayList<String[]> getReservedCars();
	public ArrayList<String[]> getAvailableCars();
}