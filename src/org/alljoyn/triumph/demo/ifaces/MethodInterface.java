package org.alljoyn.triumph.demo.ifaces;

import java.util.Map;

import org.alljoyn.bus.Variant;
import org.alljoyn.bus.annotation.BusInterface;
import org.alljoyn.bus.annotation.BusMethod;

@BusInterface
public interface MethodInterface {

    @BusMethod
    public byte echoByte(byte value);
    
    @BusMethod
    public boolean echoBoolean(boolean value);
    
    @BusMethod
    public short echoShort(short value);
    
    @BusMethod
    public long echoLong(long value);
    
    @BusMethod
    public double echoDouble(Double value);
    
	@BusMethod
	public String echoString(String s);
	
	@BusMethod
	public int echoInt(int i);
	
	@BusMethod(signature="g", replySignature="g")
    public String echoSignature(String value);
    
    @BusMethod(signature="o", replySignature="o")
    public String echoObjectPath(String value);
    
    @BusMethod
    public Map<String, Integer> echoDictionary(Map<String, Integer> value);
    
    @BusMethod
    public byte[] echoArrayByte(byte[] value);
    
    @BusMethod
    public boolean[] echoArrayBoolean(boolean[] value);
    
    @BusMethod
    public short[] echoArrayShort(short[] value);
    
    @BusMethod
    public int[] echoArrayInt(int[] value);
    
    @BusMethod
    public long[] echoArrayLong(long[] value);
    
    @BusMethod
    public double[] echoArrayDouble(double[] value);
    
    @BusMethod
    public String[] echoArrayString(String[] value);
    
    @BusMethod
    public Struct echoStruct(Struct value);
    
    @BusMethod
    public Variant echoVariant(Variant value);
}
