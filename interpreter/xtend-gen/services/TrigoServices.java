package services;

@SuppressWarnings("all")
public class TrigoServices {
  public static double cosinus(final Double angle) {
    final double t = Math.cos(((((angle).doubleValue() / 360.0) * Math.PI) * 2));
    return Math.cos(((((angle).doubleValue() / 360.0) * Math.PI) * 2));
  }
  
  public static double sinus(final Double angle) {
    return Math.sin(((((angle).doubleValue() / 360.0) * Math.PI) * 2));
  }
  
  public static double tan(final Double angle) {
    return Math.tan(((((angle).doubleValue() / 360.0) * Math.PI) * 2));
  }
}
