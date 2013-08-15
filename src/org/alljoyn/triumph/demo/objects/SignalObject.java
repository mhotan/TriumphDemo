package org.alljoyn.triumph.demo.objects;

import org.alljoyn.bus.BusObject;
import org.alljoyn.bus.annotation.BusSignal;
import org.alljoyn.triumph.demo.ifaces.SignalsInterface;
import org.alljoyn.triumph.demo.ifaces.Struct;

public class SignalObject implements BusObject, SignalsInterface {

	@Override
	@BusSignal
	public void signalString(String s) {/*No code needed here*/}

	@Override
	@BusSignal
	public void signalInt(int i) {/*No code needed here*/}

	@Override
	@BusSignal
	public void signalStringArray(String[] s) {/*No code needed here*/}

	@Override
	@BusSignal
	public void signalStruct(Struct s) {/*No code needed here*/}
}
