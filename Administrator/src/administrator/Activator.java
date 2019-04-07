package administrator;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import carservice.CarService;
import carservice.CarServiceImpl;
import driverService.DriverService;
import driverService.DriverServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	ServiceReference serviceReference,serviceReference1;

	static int j=0;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Welcome to Adminpanel...");
		serviceReference = bundleContext.getServiceReference(CarService.class.getName());
		CarService carService = (CarService) bundleContext.getService(serviceReference);
		
		serviceReference1 = bundleContext.getServiceReference(DriverService.class.getName());
		DriverService driverService = (DriverService) bundleContext.getService(serviceReference1);
		
		GUIBuilder.chooser(carService.displayAllCars(), driverService.displayAllDrivers(), carService, driverService );
//
//		int num = 0;
//		Scanner sc = new Scanner(System.in);
//
//		if(j==0) {
//			System.out.println("Please re run the bundle");
//		}
//		String regNo = null;
//		
//		while (j!=0) {
//			do {
//				System.out.println("--------------------------------");
//				System.out.println("Main Menu");
//				System.out.println("1.Add a Car");
//				System.out.println("2.Remove a Car from System");
//				System.out.println("3.Add Driver");
//				System.out.println("4.Remove Driver from Reserved List");
//				System.out.println("99.Exit");
//				System.out.println("--------------------------------");
//				System.out.print("Please select a Number: ");
//				num = sc.nextInt();
//			} while (num != 1 && num != 2 && num !=3 && num !=4 && num !=99);
//
//			
//			if(num == 99)
//				break;
//			
//			
//			switch (num) {
//			case 1:
//				carService.addNewCar();
//				break;
//			case 2:
//				System.out.println();
//				carService.displayAllCars();
//				System.out.print("Please Enter Registration Number: ");
//				regNo = sc.next();
//				carService.removeCar(regNo);
//				break;
//			case 3:
//				driverService.addNewDriver();
//				break;
//			case 4:
//				System.out.println();
//				driverService.displayAvailableDrivers();
//				System.out.print("Please Enter Registration Number: ");
//				regNo = sc.next();
//				driverService.removeDriver(regNo);
//				break;
//			}
//			
//		}
//		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good bye");
		j++;//for fixing console input error
		bundleContext.ungetService(serviceReference);
		bundleContext.ungetService(serviceReference1);
	}

}
