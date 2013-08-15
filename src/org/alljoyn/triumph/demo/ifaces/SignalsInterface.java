package org.alljoyn.triumph.demo.ifaces;

import org.alljoyn.bus.annotation.BusInterface;
import org.alljoyn.bus.annotation.BusSignal;

@BusInterface
public interface SignalsInterface {

	@BusSignal
	public void signalString(String s);
	
	@BusSignal
	public void signalInt(int i);
	
	@BusSignal
	public void signalStringArray(String[] s);
	
	@BusSignal
	public void signalStruct(Struct s);
	
}
