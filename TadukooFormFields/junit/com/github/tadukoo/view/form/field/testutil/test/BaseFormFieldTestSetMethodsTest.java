package com.github.tadukoo.view.form.field.testutil.test;

import com.github.tadukoo.util.junit.AssertionFailedErrors;
import com.github.tadukoo.view.form.field.testutil.test.testfields.*;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BaseFormFieldTestSetMethodsTest extends BaseBaseFormFieldTestTest{
	
	/*
	 * Test Form Field's Set Methods
	 */
	
	@Test
	public void testSetLabelType(){
		goodTest.testSetLabelType();
	}
	
	@Test
	public void testSetLabelTypeFail(){
		try{
			badSetTest.testSetLabelType();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_LABEL_TYPE, TestFormField.WRONG_LABEL_TYPE),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		goodTest.testSetLabelForegroundPaint();
	}
	
	@Test
	public void testSetLabelForegroundPaintFail(){
		try{
			badSetTest.testSetLabelForegroundPaint();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FOREGROUND_PAINT, TestFormField.WRONG_LABEL_FOREGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		goodTest.testSetLabelBackgroundPaint();
	}
	
	@Test
	public void testSetLabelBackgroundPaintFail(){
		try{
			badSetTest.testSetLabelBackgroundPaint();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_BACKGROUND_PAINT, TestFormField.WRONG_LABEL_BACKGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelFontFamily(){
		goodTest.testSetLabelFontFamily();
	}
	
	@Test
	public void testSetLabelFontFamilyFail(){
		try{
			badSetTest.testSetLabelFontFamily();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_FAMILY, TestFormField.WRONG_LABEL_FONT_FAMILY),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelFontStyle(){
		goodTest.testSetLabelFontStyle();
	}
	
	@Test
	public void testSetLabelFontStyleFail(){
		try{
			badSetTest.testSetLabelFontStyle();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_STYLE, TestFormField.WRONG_LABEL_FONT_STYLE),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelFontSize(){
		goodTest.testSetLabelFontSize();
	}
	
	@Test
	public void testSetLabelFontSizeFail(){
		try{
			badSetTest.testSetLabelFontSize();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_SIZE, TestFormField.WRONG_LABEL_FONT_SIZE),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelShape(){
		goodTest.testSetLabelShape();
	}
	
	@Test
	public void testSetLabelShapeFail(){
		try{
			badSetTest.testSetLabelShape();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_SHAPE, TestFormField.WRONG_LABEL_SHAPE),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLabelBorder(){
		goodTest.testSetLabelBorder();
	}
	
	@Test
	public void testSetLabelBorderFail(){
		try{
			badSetTest.testSetLabelBorder();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_BORDER, TestFormField.WRONG_LABEL_BORDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetRowPos(){
		goodTest.testSetRowPos();
	}
	
	@Test
	public void testSetRowPosFail(){
		try{
			badSetTest.testSetRowPos();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_ROW_POS, TestFormField.WRONG_ROW_POS),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetColPos(){
		goodTest.testSetColPos();
	}
	
	@Test
	public void testSetColPosFail(){
		try{
			badSetTest.testSetColPos();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_COL_POS, TestFormField.WRONG_COL_POS),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetRowSpan(){
		goodTest.testSetRowSpan();
	}
	
	@Test
	public void testSetRowSpanFail(){
		try{
			badSetTest.testSetRowSpan();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_ROW_SPAN, TestFormField.WRONG_ROW_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetColSpan(){
		goodTest.testSetColSpan();
	}
	
	@Test
	public void testSetColSpanFail(){
		try{
			badSetTest.testSetColSpan();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_COL_SPAN, TestFormField.WRONG_COL_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLogFontResourceLoaderWarnings(){
		goodTest.testSetLogFontResourceLoaderWarnings();
	}
	
	@Test
	public void testSetLogFontResourceLoaderWarningsFail(){
		try{
			badSetTest.testSetLogFontResourceLoaderWarnings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LOG_FONT_RESOURCE_LOADER_WARNINGS,
							TestFormField.DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetLogger(){
		goodTest.testSetLogger();
	}
	
	@Test
	public void testSetLoggerFail(){
		try{
			badSetTest.testSetLogger();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LOGGER, TestFormField.WRONG_LOGGER),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetGraphEnv(){
		goodTest.testSetGraphEnv();
	}
	
	@Test
	public void testSetGraphEnvFail(){
		try{
			badSetTest.testSetGraphEnv();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_GRAPH_ENV, TestFormField.DEFAULT_GRAPH_ENV),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetFontFolder(){
		goodTest.testSetFontFolder();
	}
	
	@Test
	public void testSetFontFolderFail(){
		try{
			badSetTest.testSetFontFolder();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_FONT_FOLDER, TestFormField.WRONG_FONT_FOLDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testSetFontResourceLoader(){
		goodTest.testSetFontResourceLoader();
	}
	
	@Test
	public void testSetFontResourceLoaderFail(){
		try{
			badSetTest.testSetFontResourceLoader();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_FONT_RESOURCE_LOADER, TestFormField.WRONG_FONT_RESOURCE_LOADER),
					e.getMessage());
		}
	}
}
