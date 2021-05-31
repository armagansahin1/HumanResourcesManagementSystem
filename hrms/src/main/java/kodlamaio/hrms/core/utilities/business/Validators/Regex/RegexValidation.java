package kodlamaio.hrms.core.utilities.business.Validators.Regex;

import java.util.regex.Pattern;

public class RegexValidation {
	
	public static boolean emailValidate(String email) {
		String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern patternEmail = Pattern.compile(regexEmail);
		
		return patternEmail.matcher(email).matches();
	}
	
	 public static boolean passwordValidate(int minValue, int maxValue, String password) {
		 
		 String regexPassword = "(.{"+minValue+","+maxValue+"})";
		 Pattern patternPassword = Pattern.compile(regexPassword);
		 return patternPassword.matcher(password).matches();
	 }
	 
	 public static boolean characterLengthValidate(int minCharacter, int maxCharacter,String text) {
		 
		 return text.length()>=minCharacter && text.length()<=maxCharacter;
	 }
}
