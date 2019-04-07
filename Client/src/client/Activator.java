package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import driverService.DriverService;
import driverService.DriverServiceImpl;
import client.GUIBuilder;

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
		System.out.println("Starting Driver Service...");
		serviceReference = bundleContext.getServiceReference(DriverService.class.getName());
		DriverService driverService = (DriverService) bundleContext.getService(serviceReference);
		
		GUIBuilder.ReserveDriver(driverService.displayReservedDrivers(), driverService);
		
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
