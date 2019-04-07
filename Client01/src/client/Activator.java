package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import carservice.CarService;
import carservice.CarServiceImpl;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceReference serviceReference;

	static int j=0;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Car Rental Service...");
		serviceReference = bundleContext.getServiceReference(CarService.class.getName());
		CarService carService = (CarService) bundleContext.getService(serviceReference);
		
		GUIBuilder.ReserveCar(carService.displayReservedCars(), carService);
		
		if(j==0) {
			System.out.println("Please re run the bundle");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop client");
		j++;//for fixing console input error
		bundleContext.ungetService(serviceReference);
	}

}
