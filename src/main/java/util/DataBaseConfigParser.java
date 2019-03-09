package util;

import java.net.URL;
import java.util.Properties;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class DataBaseConfigParser {
    private Properties props;

    public Properties getProps(){
        return this.props;
    }

    public void parse(String filename) throws Exception{
        XMLConfigParser handler = new XMLConfigParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        URL confURL = XMLConfigParser.class.getClassLoader().getResource(filename);
        assert confURL != null;
        parser.parse(confURL.toString(), handler);
        props=handler.getProps();
    }
}
