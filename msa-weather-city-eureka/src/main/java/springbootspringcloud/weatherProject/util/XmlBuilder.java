package springbootspringcloud.weatherProject.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Xml Builder
 * @author wy
 *
 */
public class XmlBuilder {
	
	/**
	 * 将xml转为指定的POJO
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
		Object xmlObject = null;
		
		try (Reader reader = new StringReader(xmlStr)) {
			JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            xmlObject = unmarshaller.unmarshal(reader);
		}catch (Exception e) {
            throw new RuntimeException("convert xml string to POJO failure!", e);
        }
 
		return xmlObject;
	}
	
}
