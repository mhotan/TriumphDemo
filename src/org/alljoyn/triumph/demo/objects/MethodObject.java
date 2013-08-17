package org.alljoyn.triumph.demo.objects;

import java.util.Map;

import org.alljoyn.bus.BusObject;
import org.alljoyn.bus.Variant;
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
    public byte echoByte(byte value) {
        return value;
    }

    @Override
    @BusMethod
    public boolean echoBoolean(boolean value) {
        return value;
    }

    @Override
    @BusMethod
    public short echoShort(short value) {
        return value;
    }

    @Override
    @BusMethod
    public long echoLong(long value) {
        return value;
    }

    @Override
    @BusMethod
    public double echoDouble(Double value) {
        return value;
    }

    @Override
    @BusMethod(signature = "g", replySignature = "s")
    public String echoSignature(String value) {
        return value;
    }

    @Override
    @BusMethod(signature = "o", replySignature = "s")
    public String echoObjectPath(String value) {
        return value;
    }

    @Override
    @BusMethod
    public Map<String, Integer> echoDictionary(Map<String, Integer> value) {
        return value;
    }

    @Override
    @BusMethod
    public byte[] echoArrayByte(byte[] value) {
        return value;
    }

    @Override
    @BusMethod
    public boolean[] echoArrayBoolean(boolean[] value) {
        return value;
    }

    @Override
    @BusMethod
    public short[] echoArrayShort(short[] value) {
        return value;
    }

    @Override
    @BusMethod
    public int[] echoArrayInt(int[] value) {
        return value;
    }

    @Override
    @BusMethod
    public long[] echoArrayLong(long[] value) {
        return value;
    }

    @Override
    @BusMethod
    public double[] echoArrayDouble(double[] value) {
        return value;
    }

    @Override
    @BusMethod
    public String[] echoArrayString(String[] value) {
        return value;
    }

    @Override
    @BusMethod
    public Variant echoVariant(Variant value) {
        return value;
    }



}
