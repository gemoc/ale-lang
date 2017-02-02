package services;

public class TrigoServices {
	
	public static double cosinus(Double angle) {
		return Math.cos((angle/360.0)*Math.PI*2);
	}
	
	public static double sinus(Double angle) {
		return Math.sin((angle/360.0)*Math.PI*2);
	}
	
	public static double tan(Double angle) {
		return Math.tan((angle/360.0)*Math.PI*2);
	}
	
}