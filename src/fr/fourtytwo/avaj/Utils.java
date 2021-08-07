package fr.fourtytwo.avaj;

public class Utils {

	public static int parseInt(String value, String name) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(
				"Can't cast " + name + "value = '" + value + "' to Integer");
		}
	}

}
