package com.yodlee.jaxb;

import java.io.StringWriter;
import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public class MyMarshaller {

	public static void main(String[] args) throws JAXBException, DatatypeConfigurationException {
		JAXBContext jaxb = JAXBContext.newInstance(Order.class, Product.class, Customer.class);
		
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Product prod = new Product();
		prod.setId(1L);
		prod.setInventory(new BigInteger("1000"));
		prod.setName("prod1");

		Order order = new Order();
		order.setProduct(prod);
		order.setId(1L);
		order.setOrderDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(order, writer);
		System.out.println(writer.toString());

	}

}
