package org.alljoyn.triumph.demo.objects;

public abstract class DemoObject {

	protected abstract String getType();
	
	protected void print(Object o) {
		System.out.println(getType() + " " + o.toString());
	}
	
	protected void print(Object[] oarray) {
		StringBuffer buf = new StringBuffer();
		buf.append("{ ");
		boolean isFirst = true;
		for (Object o: oarray) {
			buf.append(o);
			if (!isFirst) {
				buf.append(", ");
				isFirst = false;
			} 
		}
		buf.append(" }");
		print(buf.toString());
	}
	
}
