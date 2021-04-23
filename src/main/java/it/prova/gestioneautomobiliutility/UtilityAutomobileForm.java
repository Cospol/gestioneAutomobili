package it.prova.gestioneautomobiliutility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

 public class UtilityAutomobileForm {

	public static boolean validateInput(String marcaInputParam, String modelloInputParam,
			String cilindrataInputParam, String dataImmatricolazioneParam) {
		// prima controlliamo che non siano vuoti
		if (StringUtils.isBlank(marcaInputParam) || StringUtils.isBlank(modelloInputParam)
				|| !NumberUtils.isCreatable(cilindrataInputParam) || StringUtils.isBlank(dataImmatricolazioneParam)) {
			return false;
		}
		return true;
	}
	
	public static boolean areAllEmptyFields(String marcaInputParam, String modelloInputParam,
			String cilindrataInputParam, String dataImmatricolazioneParam) {
		
 		if (StringUtils.isBlank(marcaInputParam) && StringUtils.isBlank(modelloInputParam)
				&& !NumberUtils.isCreatable(cilindrataInputParam) && StringUtils.isBlank(dataImmatricolazioneParam)) {
			return true;
		}
		return false;
	}
	
	public static boolean validateIdInput(String idInputParam ) {
 		if (StringUtils.isBlank(idInputParam) ) {
			return false;
		}
		return true;
	}

	public static Date parseDateImmatricolazioneFromString(String dataImmatricolazioneStringParam) {
		if (StringUtils.isBlank(dataImmatricolazioneStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataImmatricolazioneStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
