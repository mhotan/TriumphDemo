package org.alljoyn.triumph.demo.objects;

import org.alljoyn.bus.annotation.BusSignalHandler;
import org.alljoyn.triumph.demo.ifaces.Struct;

/**
 * Simple signal handler for handling simple signals from triumph
 * @author mhotan
 */
public class MySignalHandler extends DemoObject {
	
	@BusSignalHandler(iface="org.alljoyn.triumph.demo.ifaces.SignalsInterface", signal="signalString")
	public void signalString(String s) {
		print(s);
	}

	@BusSignalHandler(iface="org.alljoyn.triumph.demo.ifaces.SignalsInterface", signal="signalInt")
	public void signalInt(int i) {
		print(new Integer(i));
	}

	@BusSignalHandler(iface="org.alljoyn.triumph.demo.ifaces.SignalsInterface", signal="signalStringArray")
	public void signalStringArray(String[] s) {
		print(s);
	}

	@BusSignalHandler(iface="org.alljoyn.triumph.demo.ifaces.SignalsInterface", signal="signalStruct")
	public void signalStruct(Struct s) {
		print(s);
	}

	@Override
	protected String getType() {
		return "Signal";
	}

}
