package com.oxygenxml.resources.batch.converter.doctype;

import com.oxygenxml.resources.batch.converter.ConverterTypes;
import com.oxygenxml.resources.batch.converter.converters.ConversionResult;

/**
 * Getter for document type.
 * @author Cosmin Duna
 *
 */
public class DoctypeGetter {

	/**
	 * Private constructor.
	 */
  private DoctypeGetter() {
    throw new IllegalStateException("Utility class");
  }
	
	/**
	 * Get the public document type according to given converter type.
	 * @param converterType The converter type.
	 * @return The public document type or a empty String if isn't declared a doctype for given converter type.
	 */
	private static String getPublicDoctype(String converterType) {

		if(ConverterTypes.HTML_TO_DITA.equals(converterType) ||
				ConverterTypes.MD_TO_DITA.equals(converterType) ||
				ConverterTypes.EXCEL_TO_DITA.equals(converterType) ||
				ConverterTypes.WORD_TO_DITA.equals(converterType)){
			return Doctypes.DOCTYPE_PUBLIC_DITA;

		} else if (ConverterTypes.MD_TO_DB4.equals(converterType) 
				|| ConverterTypes.HTML_TO_DB4.equals(converterType)
				|| ConverterTypes.WORD_TO_DB4.equals(converterType)){
	      return Doctypes.DOCTYPE_PUBLIC_DB4;
	   }
			return "";
	}
		
	
	/**
	 * Get the System document type according to given converter type.
	 * @param converterType The converter type.
	 * @return The system document type or a empty String if isn't declared a doctype for given converter type.
	 */
	private static String getSystemDoctype(String converterType){
		
		if(ConverterTypes.HTML_TO_DITA.equals(converterType) 
				|| ConverterTypes.MD_TO_DITA.equals(converterType)
				|| ConverterTypes.EXCEL_TO_DITA.equals(converterType)
				|| ConverterTypes.WORD_TO_DITA.equals(converterType)){
			return Doctypes.DOCTYPE_SYSTEM_DITA;
		
		} else if (ConverterTypes.HTML_TO_XHTML.equals(converterType) 
				|| ConverterTypes.MD_TO_XHTML.equals(converterType)
				|| ConverterTypes.WORD_TO_XHTML.equals(converterType)){
		  return Doctypes.DOCTYPE_SYSTEM_XHTML;
		
		} else if (ConverterTypes.MD_TO_DB4.equals(converterType) 
				|| ConverterTypes.HTML_TO_DB4.equals(converterType)
				|| ConverterTypes.WORD_TO_DB4.equals(converterType)){
      return Doctypes.DOCTYPE_SYSTEM_DB4;
		}
			return "";
	}
	
	/**
	 * Get the document type according to given converter type.
	 * @param converterType The converter type.
	 * @return The  document type or a empty String if isn't declared a doctype for given converter type.
	 */
	public static String getDoctype(String converterType) {
		String toReturn = "";
		if(ConverterTypes.HTML_TO_DITA.equals(converterType) 
				|| ConverterTypes.MD_TO_DITA.equals(converterType)
				|| ConverterTypes.EXCEL_TO_DITA.equals(converterType)	
				|| ConverterTypes.WORD_TO_DITA.equals(converterType)){
			toReturn = Doctypes.DOCTYPE_DITA;
		
		}	else if (ConverterTypes.HTML_TO_XHTML.equals(converterType) 
				|| ConverterTypes.MD_TO_XHTML.equals(converterType)
				|| ConverterTypes.WORD_TO_XHTML.equals(converterType)){
			toReturn = Doctypes.DOCTYPE_XHTML;
		
		} else if (ConverterTypes.MD_TO_DB4.equals(converterType) 
				|| ConverterTypes.HTML_TO_DB4.equals(converterType)
				|| ConverterTypes.WORD_TO_DB4.equals(converterType)){
			toReturn = Doctypes.DOCTYPE_DB4;
		}
		return toReturn;
	}
	
	/**
	 * Get the public document type according to the conversion result and the conversion type.
	 * 
	 * @param result The result of the conversion.
	 * @param converterType The converter type.
	 * @return The public document type or a empty String if isn't declared a doctype for given converter type.
	 */
	public static String getPublicDoctype(ConversionResult result, String converterType) {
		final String doctype;
		if (result.getImposedPublicDoctype() != null) {
			doctype = result.getImposedPublicDoctype();
		} else {
			doctype = getPublicDoctype(converterType);
		}
		return doctype;
	}
	
	/**
	 * Get the system document type according to the conversion result and the conversion type.
	 * 
	 * @param result The result of the conversion.
	 * @param converterType The converter type.
	 * @return The public document type or a empty String if isn't declared a doctype for given converter type.
	 */
	public static String getSystemDoctype(ConversionResult result, String converterType) {
		final String doctype;
		if (result.getImposedSystemDoctype() != null) {
			doctype = result.getImposedSystemDoctype();
		} else {
			doctype = getSystemDoctype(converterType);
		}
		return doctype;
	}
	
}
