package com.example.exampleSecon;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;

public class JAXBUtil {
    public static String convertirAJson(Object obj) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException("Error en JAXB", e);
        }
    }
}
