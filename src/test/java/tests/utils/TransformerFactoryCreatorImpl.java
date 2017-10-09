package tests.utils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import com.oxygenxml.resources.batch.converter.reporter.OxygenStatusReporter;

public class TransformerFactoryCreatorImpl
		implements com.oxygenxml.resources.batch.converter.trasformer.TransformerFactoryCreator {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger.getLogger(OxygenStatusReporter.class);

	@Override
	public Transformer createTransformer(StreamSource streamSource) {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = null;
		try {
			if (streamSource != null) {
				transformer = transformerFactory.newTransformer(streamSource);
			} else {
				transformer = transformerFactory.newTransformer();
			}
		} catch (TransformerConfigurationException e) {
			logger.debug(e.getMessage(), e);
		}

		return transformer;
	}

}
