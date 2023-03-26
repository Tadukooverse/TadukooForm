package com.github.tadukoo.view.form.field.testutil.test;

import com.github.tadukoo.util.junit.AssertionFailedErrors;
import com.github.tadukoo.view.form.field.testutil.test.testfields.TestFormField;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BaseFormFieldTestComponentTest extends BaseBaseFormFieldTestTest{
	
	/*
	 * Test Component Methods
	 */
	
	@Test
	public void testGoodGetJustComponent() throws Throwable{
		goodTest.testGetJustComponent();
	}
	
	@Test
	public void testNullGetJustComponent() throws Throwable{
		try{
			badSetTest.testGetJustComponent();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.ASSERT_NOT_NULL_ERROR.toString(), e.getMessage());
		}
	}
	
	@Test
	public void testGoodGetValueFromJustComponentBadComponent(){
		goodTest.testGetValueFromJustComponentBadComponent();
	}
	
	@Test
	public void testFailGetValueFromJustComponentBadComponent(){
		try{
			badSetTest.testGetValueFromJustComponentBadComponent();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(null, TestFormField.WRONG_DEFAULT_VALUE),
					e.getMessage());
		}
	}
	
	@Test
	public void testGoodGetValueFromJustComponent(){
		goodTest.testGetValueFromJustComponent();
	}
	
	@Test
	public void testFailGetValueFromJustComponent(){
		try{
			badSetTest.testGetValueFromJustComponent();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(TestFormField.DEFAULT_VALUE,
							TestFormField.WRONG_DEFAULT_VALUE),
					e.getMessage());
		}
	}
}
