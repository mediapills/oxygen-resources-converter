package com.oxygenxml.resources.batch.converter.converters;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;

import javax.xml.transform.TransformerException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.oxygenxml.resources.batch.converter.trasformer.TransformerFactoryCreator;

public class XmlToJsonConverter implements Converter {

	@Override
	public String convert(URL originalFileLocation, Reader contentReader, TransformerFactoryCreator transformerCreator)
			throws TransformerException {

		// Get the content to parse.
		String contentToParse;
		try {
			contentToParse = ConverterUtils.getUrlContents(originalFileLocation);
			JSONObject jsonObj = XML.toJSONObject(contentToParse);

			return jsonObj.toString(4, false);

		}
		catch (JSONException e) {
			throw new TransformerException(e.getMessage());
		}		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
