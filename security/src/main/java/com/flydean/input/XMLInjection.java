package com.flydean.input;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author wayne
 * @version XMLInjection,  2020/7/27
 */
public class XMLInjection {

    public String createXMLInjection(String quantity){
        String xmlString = "<item>\n<name>Iphone20</name>\n"
                + "<price>5000.0</price>\n" + "<quantity>" + quantity
                + "</quantity></item>";
        return xmlString;
    }

    public String createXML(String quantity){
        int count = Integer.parseUnsignedInt(quantity);
        String xmlString = "<item>\n<name>Iphone20</name>\n"
                + "<price>5000.0</price>\n" + "<quantity>" + count
                + "</quantity></item>";
        return xmlString;
    }

    public String createXMLWithSchema(String quantity) throws SAXException, ParserConfigurationException, IOException {
        String xmlString = "<item>\n<name>Iphone20</name>\n"
                + "<price>5000.0</price>\n" + "<quantity>" + quantity
                + "</quantity></item>";
        InputSource xmlStream = new InputSource(new StringReader(xmlString));
        // Build a validating SAX parser using our schema
        SchemaFactory sf = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        DefaultHandler defHandler = new DefaultHandler() {
            public void warning(SAXParseException s) throws SAXParseException {
                throw s;
            }
            public void error(SAXParseException s) throws SAXParseException {
                throw s;
            }
            public void fatalError(SAXParseException s) throws SAXParseException {
                throw s;
            }
        };
        //XML验证
        StreamSource ss = new StreamSource(new File("schema.xsd"));
            Schema schema = sf.newSchema(ss);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser saxParser = spf.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(defHandler);
            reader.parse(xmlStream);
            //验证完毕，返回数据
        return xmlString;
    }

}
