package com.cva_risk.utils;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


@SpringComponent
public class ReadXmlDataIntoDatabase {

    @Autowired
    private SAXHandler saxHandler;

    public void execute() throws Exception {

            String filename = Global.NAME_OF_INPUT_DATA_FILE;
            File inputDataFile = new File("/tmp/" + filename);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(inputDataFile, saxHandler);

    }

}
