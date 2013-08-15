package org.alljoyn.triumph.demo.objects;

import java.util.Map;

import org.alljoyn.bus.BusObject;
import org.alljoyn.bus.annotation.BusMethod;
import org.alljoyn.triumph.demo.ifaces.MethodInterface;
import org.alljoyn.triumph.demo.ifaces.Struct;

public class MethodObject extends DemoObject implements BusObject, MethodInterface {

	@Override
	@BusMethod
	public String echoString(String s) {
		print(s);
		return s;
	}

	@Override
	@BusMethod
	public int echoInt(int i) {
		print(new Integer(i));
		return i;
	}

	@Override
	@BusMethod
	public String[] echoStringArray(String[] s) {
		print(s);
		return s;
	}

	@Override
	@BusMethod
	public Struct echoStruct(Struct s) {
		print(s);
		return s;
	}

	@Override
	protected String getType() {
		return "Method";
	}

	@Override
	@BusMethod
	public String printMapAttributes(Map<String, Integer> map) {
		return "Map has " + map.keySet().size() + " Keys and " + map.values() + " Values";
	}



}
