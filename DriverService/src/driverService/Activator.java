package driverService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import fileoperator.CSVFile;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Driver Service...");
		
		serviceReference = bundleContext.getServiceReference(CSVFile.class.getName());
		CSVFile csv = (CSVFile) bundleContext.getService(serviceReference);
		
		
		DriverService driverService = new DriverServiceImpl(csv);
		
		publishServiceRegistration = bundleContext.registerService(
				DriverService.class.getName(), driverService, null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Driver Service...");
		publishServiceRegistration.unregister();
		bundleContext.ungetService(serviceReference);
	}
}