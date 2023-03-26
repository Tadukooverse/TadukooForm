package com.github.tadukoo.view.form.field.testutil.test;

import com.github.tadukoo.util.junit.AssertionFailedErrors;
import com.github.tadukoo.view.form.field.testutil.test.testfields.TestFormField;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BaseFormFieldTestDefaultBuilderValuesTest extends BaseBaseFormFieldTestTest{
	
	/*
	 * Default Value Tests
	 */
	
	@Test
	public void testRightFieldType(){
		goodTest.testFieldType();
	}
	
	@Test
	public void testWrongFieldType(){
		try{
			badDefaultsTest.testFieldType();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.WRONG_FIELD_TYPE, TestFormField.FIELD_TYPE), e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultDefaultValue(){
		goodTest.testDefaultDefaultValue();
	}
	
	@Test
	public void testWrongDefaultDefaultValue(){
		try{
			badDefaultsTest.testDefaultDefaultValue();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.WRONG_DEFAULT_VALUE, TestFormField.DEFAULT_VALUE), e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelType(){
		goodTest.testDefaultLabelType();
	}
	
	@Test
	public void testWrongDefaultLabelType(){
		try{
			badDefaultsTest.testDefaultLabelType();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.WRONG_LABEL_TYPE, TestFormField.DEFAULT_LABEL_TYPE), e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelForegroundPaint(){
		goodTest.testDefaultLabelForegroundPaint();
	}
	
	@Test
	public void testWrongDefaultLabelForegroundPaint(){
		try{
			badDefaultsTest.testDefaultLabelForegroundPaint();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_FOREGROUND_PAINT, TestFormField.DEFAULT_LABEL_FOREGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelBackgroundPaint(){
		goodTest.testDefaultLabelBackgroundPaint();
	}
	
	@Test
	public void testWrongDefaultLabelBackgroundPaint(){
		try{
			badDefaultsTest.testDefaultLabelBackgroundPaint();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_BACKGROUND_PAINT, TestFormField.DEFAULT_LABEL_BACKGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelFontFamily(){
		goodTest.testDefaultLabelFontFamily();
	}
	
	@Test
	public void testWrongDefaultLabelFontFamily(){
		try{
			badDefaultsTest.testDefaultLabelFontFamily();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_FONT_FAMILY, TestFormField.DEFAULT_LABEL_FONT_FAMILY),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelFontStyle(){
		goodTest.testDefaultLabelFontStyle();
	}
	
	@Test
	public void testWrongDefaultLabelFontStyle(){
		try{
			badDefaultsTest.testDefaultLabelFontStyle();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_FONT_STYLE, TestFormField.DEFAULT_LABEL_FONT_STYLE),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelFontSize(){
		goodTest.testDefaultLabelFontSize();
	}
	
	@Test
	public void testWrongDefaultLabelFontSize(){
		try{
			badDefaultsTest.testDefaultLabelFontSize();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_FONT_SIZE, TestFormField.DEFAULT_LABEL_FONT_SIZE),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelShape(){
		goodTest.testDefaultLabelShape();
	}
	
	@Test
	public void testWrongDefaultLabelShape(){
		try{
			badDefaultsTest.testDefaultLabelShape();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_SHAPE, TestFormField.DEFAULT_LABEL_SHAPE),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLabelBorder(){
		goodTest.testDefaultLabelBorder();
	}
	
	@Test
	public void testWrongDefaultLabelBorder(){
		try{
			badDefaultsTest.testDefaultLabelBorder();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LABEL_BORDER, TestFormField.DEFAULT_LABEL_BORDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultRowSpan(){
		goodTest.testDefaultRowSpan();
	}
	
	@Test
	public void testWrongDefaultRowSpan(){
		try{
			badDefaultsTest.testDefaultRowSpan();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_ROW_SPAN, TestFormField.DEFAULT_ROW_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultColSpan(){
		goodTest.testDefaultColSpan();
	}
	
	@Test
	public void testWrongDefaultColSpan(){
		try{
			badDefaultsTest.testDefaultColSpan();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_COL_SPAN, TestFormField.DEFAULT_COL_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLogFontResourceLoaderWarnings(){
		goodTest.testDefaultLogFontResourceLoaderWarnings();
	}
	
	@Test
	public void testWrongDefaultLogFontResourceLoaderWarnings(){
		try{
			badDefaultsTest.testDefaultLogFontResourceLoaderWarnings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LOG_FONT_RESOURCE_LOADER_WARNINGS,
							TestFormField.DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultLogger(){
		goodTest.testDefaultLogger();
	}
	
	@Test
	public void testWrongDefaultLogger(){
		try{
			badDefaultsTest.testDefaultLogger();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_LOGGER,
							TestFormField.DEFAULT_LOGGER),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultGraphEnv(){
		goodTest.testDefaultGraphEnv();
	}
	
	@Test
	public void testWrongDefaultGraphEnv(){
		try{
			badDefaultsTest.testDefaultGraphEnv();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_GRAPH_ENV,
							TestFormField.DEFAULT_GRAPH_ENV),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultFontFolder(){
		goodTest.testDefaultFontFolder();
	}
	
	@Test
	public void testWrongDefaultFontFolder(){
		try{
			badDefaultsTest.testDefaultFontFolder();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_FONT_FOLDER,
							TestFormField.DEFAULT_FONT_FOLDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightDefaultFontResourceLoader(){
		goodTest.testDefaultFontResourceLoader();
	}
	
	@Test
	public void testWrongDefaultFontResourceLoader(){
		try{
			badDefaultsTest.testDefaultFontResourceLoader();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.WRONG_FONT_RESOURCE_LOADER,
							TestFormField.DEFAULT_FONT_RESOURCE_LOADER),
					e.getMessage());
		}
	}
}
