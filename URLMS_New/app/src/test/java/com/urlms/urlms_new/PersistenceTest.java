package com.urlms.urlms_new;
import static org.junit.Assert.*;

import java.io.File;
import org.junit.*;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.*;

public class PersistenceTest {

	private LabManagement lm;
	private final double delta = 0.001;
	String filename = "test_data_persistence.xml";
	
	@Before
	public void setUp() throws Exception{
		lm = LabManagement.getInstance();
		
		// create instance
		Director d = new Director("admin", "admin", lm);
		Lab l = new Lab("testing_name",0,0);
		d.setLab(l);
		Staff staff = new Staff("Staff","A", "research_asistent", 40, 500, 100);
		l.addStaff(staff);
		Supply supply = new Supply("Supply","pen", 10);
		l.addSupply(supply);
		Equipment equip = new Equipment("Equipment", "PC", 100);
		l.addEquipment(equip);
		l.getFundAccount().setExpense(500+100+10+100);
		// manage lab
		lm.addDirector(d);
		lm.getDirector(0).setLab(l);
		
		// clear previous testing data
		File f = new File(filename);
		if(f.exists())
			f.delete();
	}
	
	@Test
	public void test() {
		//initialize model file
		Persistence.initialize(filename);
		
		// save model that is loaded during test setup
		if(!Persistence.saveToXMLwithXStream())
			fail("Could not save file.");
		
		// clear the model in memory
		lm.delete();
		assertEquals(0, lm.getDirectors().size());
		
		// load model
		lm = Persistence.loadFromXMLwithXStream();
		if (lm == null)
			fail("Could not load file.");
		
		assertEquals("admin",lm.getDirector(0).getUsername());
		assertEquals("admin",lm.getDirector(0).getPassword());
		assertEquals("Staff",lm.getDirector(0).getLab().getStaff(0).getType());
		assertEquals("A",lm.getDirector(0).getLab().getStaff(0).getName());
		assertEquals("research_asistent",lm.getDirector(0).getLab().getStaff(0).getRole());
		assertEquals(40,lm.getDirector(0).getLab().getStaff(0).getProgress(),delta);
		assertEquals(500,lm.getDirector(0).getLab().getStaff(0).getPayment(),delta);
		assertEquals(100,lm.getDirector(0).getLab().getStaff(0).getTravelCost(),delta);
		assertEquals("Supply",lm.getDirector(0).getLab().getSupplies().get(0).getType());
		assertEquals("pen",lm.getDirector(0).getLab().getSupplies().get(0).getName());
		assertEquals(10,lm.getDirector(0).getLab().getSupplies().get(0).getSupCost(),delta);
		assertEquals(100,lm.getDirector(0).getLab().getEquipment().get(0).getEquipCost(),0.0001);
	}



	@After
	public void tearDown(){
		lm.delete();
	}
}
