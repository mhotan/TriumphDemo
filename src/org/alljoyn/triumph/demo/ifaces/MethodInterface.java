package org.alljoyn.triumph.demo.ifaces;

import java.util.Map;

import org.alljoyn.bus.annotation.BusInterface;
import org.alljoyn.bus.annotation.BusMethod;

@BusInterface
public interface MethodInterface {

	@BusMethod
	public String echoString(String s);
	
	@BusMethod
	public int echoInt(int i);
	
	@BusMethod
	public String[] echoStringArray(String[] s);
	
	@BusMethod
	public String printMapAttributes(Map<String, Integer> map);
	
	@BusMethod
	public Struct echoStruct(Struct s);
}
