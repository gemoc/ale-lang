package services;

import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class LogService {
  public static void log(final Object o) {
    String _string = o.toString();
    InputOutput.<String>println(_string);
  }
}
