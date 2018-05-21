/**
 * 
 */
package com.arista.cvp.commons.utils;

import java.lang.reflect.Method;

import com.arista.cvp.commons.logging.CVPLogger;

/**
 *  A helper method to find out the method name in any class.
 *
 */
public class MethodNameHelper {

	/**
	 * Logger Initialization
	 */
	private static final CVPLogger LOG = new CVPLogger(MethodNameHelper.class);

	/** The method. */
	private static Method m;

	static {

			try {
				m = Throwable.class.getDeclaredMethod("getStackTraceElement",
						int.class);
				m.setAccessible(true);
			} catch (NoSuchMethodException | SecurityException e) {
				LOG.logRuntimeError(e);
			}
		} 

	/**
	 * private constructor
	 */
	private MethodNameHelper() {
		super();
	}

	/**
	 * Gets the method name.
	 *
	 * @param depth the depth
	 * @return the method name
	 */
	public static String getMethodName(final int depth) {
		try {
			StackTraceElement element = (StackTraceElement) m.invoke(
					new Throwable(), depth + 1);
			return element.getMethodName();
		} catch (Exception e) {
			LOG.logRuntimeError(e);
			return null;
		}
	}

}
