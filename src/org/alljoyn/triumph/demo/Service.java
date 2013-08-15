package org.alljoyn.triumph.demo;

import org.alljoyn.bus.BusAttachment;
import org.alljoyn.bus.Mutable;
import org.alljoyn.bus.SessionOpts;
import org.alljoyn.bus.SessionPortListener;
import org.alljoyn.bus.Status;
import org.alljoyn.triumph.demo.objects.MethodObject;
import org.alljoyn.triumph.demo.objects.MySignalHandler;
import org.alljoyn.triumph.demo.objects.PropertyObject;
import org.alljoyn.triumph.demo.objects.SignalObject;
import org.alljoyn.triumph.util.loader.NativeLoader;

public class Service {

	private static final String SERVICE_NAME = Service.class.getName();

	static boolean sessionEstablished = false;
	static {
		new NativeLoader().loadLibrary("alljoyn_java");
	}

	private static final short CONTACT_PORT = 52;

	public static void main(String[] args) {

		BusAttachment bus = new BusAttachment("TriumphDemo", BusAttachment.RemoteMessage.Receive);
		Status status;

		MethodObject methodObj =  new MethodObject();
		PropertyObject propObj = new PropertyObject();
		SignalObject sigObj =  new SignalObject();
		MySignalHandler handler = new MySignalHandler();

		status = bus.registerBusObject(methodObj, "/method/Service");
		if (status != Status.OK) {    
			System.err.println("Unable to register " + methodObj.getClass().getSimpleName());
			return;
		}
		status = bus.registerBusObject(propObj, "/properties/service");
		if (status != Status.OK) {            
			System.err.println("Unable to register " + propObj.getClass().getSimpleName());
			return;
		}
		status = bus.registerBusObject(sigObj, "/signal/service");
		if (status != Status.OK) {            
			System.err.println("Unable to register " + sigObj.getClass().getSimpleName());
			return;
		}
		System.out.println("BusAttachment.registerBusObject successful");

		// Connect the bus
		status = bus.connect();
		if (status != Status.OK) {
			System.err.println("Unable to connect bus");
			return;
		}
		System.out.println("BusAttachment.connect Bus Global UID: " 
				+ bus.getGlobalGUIDString() + " and Unique name: " + bus.getUniqueName());        

		// Register Signal Handler
		status = bus.registerSignalHandlers(handler);
		if (status != Status.OK) {            
			System.err.println("Unable to register signal handler " + handler.getClass().getSimpleName() + " Status " + status);
			return;
		}
		System.out.println("BusAttachment.registerSignalHandlers successful");
		

		Mutable.ShortValue contactPort = new Mutable.ShortValue(CONTACT_PORT);
		SessionOpts sessionOpts = new SessionOpts();

		status = bus.bindSessionPort(contactPort, sessionOpts, 
				new SessionPortListener() {

			@Override
			public boolean acceptSessionJoiner(short sessionPort, String joiner, SessionOpts sessionOpts) {
				System.out.println("SessionPortListener.acceptSessionJoiner called");
				if (sessionPort == CONTACT_PORT) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public void sessionJoined(short sessionPort, int id, String joiner) {
				System.out.println(String.format("SessionPortListener.sessionJoined(%d, %d, %s)", sessionPort, id, joiner));
				sessionEstablished = true;
			}
		});

		if (status != Status.OK) {
			System.err.println("Unable to bind session port");
			return;
		}

		System.out.println("BusAttachment.bindSessionPort successful");

		int flags = 0; //do not use any request name flags
		status = bus.requestName(SERVICE_NAME, flags);
		if (status != Status.OK) {
			System.err.println("Unable to Reqest name");
			return;
		}
		System.out.println("BusAttachment.request '" + SERVICE_NAME + "' successful");

		status = bus.advertiseName(SERVICE_NAME, SessionOpts.TRANSPORT_ANY);
		if (status != Status.OK) {
			System.err.println("Unable to advertise name Status = " + status);
			bus.releaseName(SERVICE_NAME);
			return;
		}
		System.out.println("BusAttachment.advertiseName '" + SERVICE_NAME + "' successful");

		while (!sessionEstablished) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Thead Exception caught");
				e.printStackTrace();
			}
		}
		System.out.println("BusAttachment session established");

		boolean interupted = false;
		while (!interupted) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				interupted = true;
				System.out.println("Thead Exception caught");
				e.printStackTrace();
			}
		}

		bus.disconnect();
	}

}
