package facts.rest.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;

import facts.rest.controller.FactsController;

import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class Utility {

	public static final Logger logger = LoggerFactory.getLogger(FactsController.class);
	private static final String sourceLanguage = "en";
 	
	private static final String UTF = StandardCharsets.UTF_8.name();
	private static final String ISO = StandardCharsets.ISO_8859_1.name();
	 

	public static String translateText(String originalText, String targetLanguage) {
		logger.debug("originalText : "+originalText +" - targetLanguage: " + targetLanguage);
		// Do the translation.
		Translate translate = TranslateOptions.getDefaultInstance().getService();
		Translation translation = translate.translate(originalText, TranslateOption.sourceLanguage(sourceLanguage),
																	TranslateOption.targetLanguage(targetLanguage));
		String translatedText = translation.getTranslatedText();
		
		logger.debug("translatedText : "+translatedText +" - targetLanguage: " + targetLanguage);
		return translatedText;
	}

	public static String textDecode(String originalText) throws UnsupportedEncodingException {

		// Do the decode.
		String decodedValue = URLDecoder.decode(originalText,ISO);
		return decodedValue;
	}

	public static String textEncode(String originalText) throws UnsupportedEncodingException {

		// Do the encode.
		String ecodedValue = URLEncoder.encode(originalText, ISO);
		return ecodedValue;
	}

}
