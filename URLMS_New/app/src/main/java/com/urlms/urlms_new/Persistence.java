package com.urlms.urlms_new;

import java.io.*;
import java.util.*;

import com.thoughtworks.xstream.XStream;

import ca.mcgill.ecse321.P6.URLMS.desktop.model.*;

public class Persistence {
	
	private static XStream xstream = new XStream();;
	private static LabManagement labMaFromData;
	private static InputStream in;
	private static OutputStream out;
	private static String filename;
	
	public static void initialize(String filename){
		// setup
		setFilename(filename);
		File file = new File(filename);
		setAlias("director", Director.class);
		setAlias("equip", Equipment.class);
		setAlias("supply", Supply.class);
		setAlias("lab", Lab.class);
		setAlias("staff", Staff.class);
		setAlias("fund", FundAccount.class);
		setAlias("labMa", LabManagement.class);
		if(loadFromXMLwithXStream() == null)
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static LabManagement loadFromXMLwithXStream(){
		try { 
			// check existing data
			in = new FileInputStream(filename);
			labMaFromData = (LabManagement)xstream.fromXML(in);
			List<Director> directors = new ArrayList<Director>();
			List<Lab> labs = new ArrayList<Lab>();
			// store data in buffers
			for (Director d : labMaFromData.getDirectors())
				directors.add(d);
			//copy existing data
			for (Director d : directors)
				LabManagement.getInstance().addDirector(d);
			return LabManagement.getInstance();
		} catch (IOException e){ // no existing data found
			return null;
		}
	}
	
	public static boolean saveToXMLwithXStream(){
		try {
			out = new FileOutputStream(filename);
			xstream.toXML(LabManagement.getInstance(), out);
			
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static void setAlias(String xmlTagName, Class<?> className) {
        xstream.alias(xmlTagName, className);
    }
	
   public static void setFilename(String fn) {

		filename = fn;
   }
   
   public static void close(){
	   try {
		in.close();
		out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
}
