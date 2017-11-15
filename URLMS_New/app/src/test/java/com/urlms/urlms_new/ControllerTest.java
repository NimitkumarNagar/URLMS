package com.urlms.urlms_new;

import android.content.res.Resources;

import static org.junit.Assert.*;

import org.junit.*;

import ca.mcgill.ecse321.P6.URLMS.desktop.controller.InvalidInputException;
import ca.mcgill.ecse321.P6.URLMS.desktop.controller.URLMSController;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.LabManagement;

public class ControllerTest {

	private LabManagement lm;	
	private URLMSController controller;

	@Before
	public void setUp() throws Exception {
		Persistence.initialize(Resources.getSystem().getResourceName(R.raw.urlms_json), "test_data_persistence.json");
		lm = LabManagement.getInstance();
		controller = new URLMSController(lm.getDirector(0));
	}

	@After
	public void tearDown() throws Exception {
		lm.delete();
	}

	@Test
	public void testGetStaff() {
		try {
			assertEquals(controller.getStaff("A"),lm.getDirector(0).getLab().getStaff(0));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testGetStaffNull(){
		try {
			controller.getStaff("");
		} catch (InvalidInputException e) {
			assertEquals("Name cannot be empty.", e.getMessage());
		}
	}

	@Test
	public void testGetStaffSpace(){
		try {
			controller.getStaff(" ");
		} catch (InvalidInputException e) {
			assertEquals("Name cannot be empty.", e.getMessage());
		}
	}
}
