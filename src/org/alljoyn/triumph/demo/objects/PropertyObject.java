package org.alljoyn.triumph.demo.objects;

import org.alljoyn.bus.BusException;
import org.alljoyn.bus.BusObject;
import org.alljoyn.bus.annotation.BusProperty;
import org.alljoyn.triumph.demo.ifaces.PropertiesInterface;

public class PropertyObject extends DemoObject implements PropertiesInterface, BusObject {

	private int mInt;
	private String[] mWords;
	
	public PropertyObject() {
		mInt = 0;
		mWords = new String[] {"banana", "coca", "cabana"};
	}
	
	@Override
	@BusProperty
	public int getMagicInt() throws BusException {
		print("Get Magic Int");
		return mInt;
	}

	@Override
	@BusProperty
	public void setMagicInt(int i) throws BusException {
		print("Set Magic Int " + i);
		mInt = i;
	}

	@Override
	@BusProperty
	public String getOS() throws BusException {
		print("Get OS");
		return System.getProperty("os.name");
	}

	@Override
	@BusProperty
	public String getOSArchitecture() throws BusException {
		print("Get OS Architecture");
		return System.getProperty("os.arch");
	}

	@Override
	@BusProperty
	public String[] getFunnyWords() throws BusException {
		print("Get Funny words");
		return mWords;
	}

	@Override
	@BusProperty
	public void setFunnyWords(String[] words) throws BusException {
		print("Set Funny words " + words);
		mWords = words;
	}

	@Override
	protected String getType() {
		return "Property";
	}

}
