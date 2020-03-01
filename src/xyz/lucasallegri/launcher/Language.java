package xyz.lucasallegri.launcher;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import xyz.lucasallegri.launcher.settings.Settings;
import xyz.lucasallegri.logging.KnightLog;

public class Language {
	
	private static Properties prop = new Properties();
	private static InputStream propStream = null;
	
	public static void setup() {
		propStream = Language.class.getResourceAsStream("/lang/lang_" + Settings.lang + ".properties");
	}
	
	public static String getValue(String key) {
		String value = null;
    	try {
			prop.load(propStream);
			value = prop.getProperty(key);
			return value.substring(1, value.length() - 1);
		} catch (IOException e) {
			KnightLog.logException(e);
		}
		return null;
	}
	
	public static String getValue(String key, String arg) {
		String value = null;
    	try {
			prop.load(propStream);
			value = prop.getProperty(key).replaceFirst("/{0}/", arg);
			return value.substring(1, value.length() - 1);
		} catch (IOException e) {
			KnightLog.logException(e);
		}
		return null;
	}
	
	public static String getLangName(String code) {
		switch(code) {
		case "en": return "English";
		case "es": return "Espa�ol";
		}
		return null;
	}
	
	public static String getLangCode(String detailed) {
		switch(detailed) {
		case "English": return "en";
		case "Espa�ol": return "es";
		}
		return null;
	}

}
