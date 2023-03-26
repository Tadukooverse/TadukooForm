package com.github.tadukoo.view.form.field.testutil.test;

import com.github.tadukoo.util.junit.AssertionFailedErrors;
import com.github.tadukoo.view.form.field.testutil.test.testfields.TestFormField;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BaseFormFieldTestBuilderSettingsTest extends BaseBaseFormFieldTestTest{
	
	/*
	 * Test setting builder values
	 */
	
	@Test
	public void testRightSetKey() throws Throwable{
		goodTest.testSetBuilderKey();
	}
	
	@Test
	public void testWrongSetKey() throws Throwable{
		try{
			badSetTest.testSetBuilderKey();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_KEY, TestFormField.WRONG_KEY), e.getMessage());
		}
	}
	
	@Test
	public void testRightSetDefaultValue() throws Throwable{
		goodTest.testSetBuilderDefaultValue();
	}
	
	@Test
	public void testWrongSetDefaultValue() throws Throwable{
		try{
			badSetTest.testSetBuilderDefaultValue();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_DEFAULT_VALUE, TestFormField.WRONG_DEFAULT_VALUE), e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelType() throws Throwable{
		goodTest.testSetBuilderLabelType();
	}
	
	@Test
	public void testWrongSetLabelType() throws Throwable{
		try{
			badSetTest.testSetBuilderLabelType();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_LABEL_TYPE, TestFormField.WRONG_LABEL_TYPE), e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelForegroundPaint() throws Throwable{
		goodTest.testSetBuilderLabelForegroundPaint();
	}
	
	@Test
	public void testWrongSetLabelForegroundPaint() throws Throwable{
		try{
			badSetTest.testSetBuilderLabelForegroundPaint();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FOREGROUND_PAINT, TestFormField.WRONG_LABEL_FOREGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelBackgroundPaint() throws Throwable{
		goodTest.testSetBuilderLabelBackgroundPaint();
	}
	
	@Test
	public void testWrongSetLabelBackgroundPaint() throws Throwable{
		try{
			badSetTest.testSetBuilderLabelBackgroundPaint();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_BACKGROUND_PAINT, TestFormField.WRONG_LABEL_BACKGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelFont() throws Throwable{
		goodTest.testSetBuilderLabelFont();
	}
	
	@Test
	public void testWrongSetLabelFontFamily() throws Throwable{
		try{
			badSetTest.testSetBuilderLabelFont();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_FAMILY, TestFormField.WRONG_LABEL_FONT_FAMILY),
					e.getMessage());
		}
	}
	
	@Test
	public void testWrongSetLabelFontStyle() throws Throwable{
		try{
			badSetLabelFontStyleTest.testSetBuilderLabelFont();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_STYLE, TestFormField.WRONG_LABEL_FONT_STYLE),
					e.getMessage());
		}
	}
	
	@Test
	public void testWrongSetLabelFontSize() throws Throwable{
		try{
			badSetLabelFontSizeTest.testSetBuilderLabelFont();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_SIZE, TestFormField.WRONG_LABEL_FONT_SIZE),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelShape() throws Throwable{
		goodTest.testSetBuilderLabelShape();
	}
	
	@Test
	public void testWrongSetLabelShape() throws Throwable{
		try{
			badSetTest.testSetBuilderLabelShape();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_SHAPE, TestFormField.WRONG_LABEL_SHAPE),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelBorder() throws Throwable{
		goodTest.testSetBuilderLabelBorder();
	}
	
	@Test
	public void testWrongSetLabelBorder() throws Throwable{
		try{
			badSetTest.testSetBuilderLabelBorder();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_BORDER, TestFormField.WRONG_LABEL_BORDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetRowPos() throws Throwable{
		goodTest.testSetBuilderRowPos();
	}
	
	@Test
	public void testWrongSetRowPos() throws Throwable{
		try{
			badSetTest.testSetBuilderRowPos();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_ROW_POS, TestFormField.WRONG_ROW_POS),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetColPos() throws Throwable{
		goodTest.testSetBuilderColPos();
	}
	
	@Test
	public void testWrongSetColPos() throws Throwable{
		try{
			badSetTest.testSetBuilderColPos();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_COL_POS, TestFormField.WRONG_COL_POS),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetRowSpan() throws Throwable{
		goodTest.testSetBuilderRowSpan();
	}
	
	@Test
	public void testWrongSetRowSpan() throws Throwable{
		try{
			badSetTest.testSetBuilderRowSpan();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_ROW_SPAN, TestFormField.WRONG_ROW_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetColSpan() throws Throwable{
		goodTest.testSetBuilderColSpan();
	}
	
	@Test
	public void testWrongSetColSpan() throws Throwable{
		try{
			badSetTest.testSetBuilderColSpan();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_COL_SPAN, TestFormField.WRONG_COL_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLogFontResourceLoaderWarnings() throws Throwable{
		goodTest.testSetBuilderLogFontResourceLoaderWarnings();
	}
	
	@Test
	public void testWrongSetLogFontResourceLoaderWarnings() throws Throwable{
		try{
			badSetTest.testSetBuilderLogFontResourceLoaderWarnings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LOG_FONT_RESOURCE_LOADER_WARNINGS,
							TestFormField.DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLogger() throws Throwable{
		goodTest.testSetBuilderLogger();
	}
	
	@Test
	public void testWrongSetLogger() throws Throwable{
		try{
			badSetTest.testSetBuilderLogger();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LOGGER,
							TestFormField.WRONG_LOGGER),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetGraphEnv() throws Throwable{
		goodTest.testSetBuilderGraphEnv();
	}
	
	@Test
	public void testWrongSetGraphEnv() throws Throwable{
		try{
			badSetTest.testSetBuilderGraphEnv();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_GRAPH_ENV,
							TestFormField.DEFAULT_GRAPH_ENV),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetFontFolder() throws Throwable{
		goodTest.testSetBuilderFontFolder();
	}
	
	@Test
	public void testWrongSetFontFolder() throws Throwable{
		try{
			badSetTest.testSetBuilderFontFolder();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_FONT_FOLDER,
							TestFormField.WRONG_FONT_FOLDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetFontResourceLoader() throws Throwable{
		goodTest.testSetBuilderFontResourceLoader();
	}
	
	@Test
	public void testWrongSetFontResourceLoader() throws Throwable{
		try{
			badSetTest.testSetBuilderFontResourceLoader();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_FONT_RESOURCE_LOADER,
							TestFormField.WRONG_FONT_RESOURCE_LOADER),
					e.getMessage());
		}
	}
	
	/*
	 * Test All Settings
	 */
	
	@Test
	public void testAllSettingsGood() throws Throwable{
		goodTest.testAllSettings();
	}
	
	@Test
	public void testAllSettingsKeyFail() throws Throwable{
		try{
			badSetTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_KEY,
							TestFormField.WRONG_KEY),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsDefaultValueFail() throws Throwable{
		try{
			badSetDefaultValueTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_DEFAULT_VALUE,
							TestFormField.WRONG_DEFAULT_VALUE),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelTypeFail() throws Throwable{
		try{
			badSetLabelTypeTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_TYPE,
							TestFormField.WRONG_LABEL_TYPE),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelForegroundPaintFail() throws Throwable{
		try{
			badSetLabelForegroundPaintTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FOREGROUND_PAINT,
							TestFormField.WRONG_LABEL_FOREGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelBackgroundPaintFail() throws Throwable{
		try{
			badSetLabelBackgroundPaintTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_BACKGROUND_PAINT,
							TestFormField.WRONG_LABEL_BACKGROUND_PAINT),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelFontFamilyFail() throws Throwable{
		try{
			badSetLabelFontFamilyTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_FAMILY,
							TestFormField.WRONG_LABEL_FONT_FAMILY),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelFontStyleFail() throws Throwable{
		try{
			badSetLabelFontStyleTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_STYLE,
							TestFormField.WRONG_LABEL_FONT_STYLE),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelFontSizeFail() throws Throwable{
		try{
			badSetLabelFontSizeTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_SIZE,
							TestFormField.WRONG_LABEL_FONT_SIZE),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelShapeFail() throws Throwable{
		try{
			badSetLabelShapeTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_SHAPE,
							TestFormField.WRONG_LABEL_SHAPE),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLabelBorderFail() throws Throwable{
		try{
			badSetLabelBorderTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_BORDER,
							TestFormField.WRONG_LABEL_BORDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsRowPosFail() throws Throwable{
		try{
			badSetRowPosTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_ROW_POS,
							TestFormField.WRONG_ROW_POS),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsColPosFail() throws Throwable{
		try{
			badSetColPosTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_COL_POS,
							TestFormField.WRONG_COL_POS),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsRowSpanFail() throws Throwable{
		try{
			badSetRowSpanTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_ROW_SPAN,
							TestFormField.WRONG_ROW_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsColSpanFail() throws Throwable{
		try{
			badSetColSpanTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_COL_SPAN,
							TestFormField.WRONG_COL_SPAN),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLogFontResourceLoaderWarningsFail() throws Throwable{
		try{
			badSetLogFontResourceLoaderWarningsTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LOG_FONT_RESOURCE_LOADER_WARNINGS,
							TestFormField.DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsLoggerFail() throws Throwable{
		try{
			badSetLoggerTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LOGGER,
							TestFormField.WRONG_LOGGER),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsGraphEnvFail() throws Throwable{
		try{
			badSetGraphEnvTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_GRAPH_ENV,
							TestFormField.DEFAULT_GRAPH_ENV),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsFontFolderFail() throws Throwable{
		try{
			badSetFontFolderTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_FONT_FOLDER,
							TestFormField.WRONG_FONT_FOLDER),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsFontResourceLoaderFail() throws Throwable{
		try{
			badSetFontResourceLoaderTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_FONT_RESOURCE_LOADER,
							TestFormField.WRONG_FONT_RESOURCE_LOADER),
					e.getMessage());
		}
	}
	
	@Test
	public void testAllSettingsGoodCustomSettings() throws Throwable{
		goodCustomSettingsTest.testAllSettings();
	}
	
	@Test
	public void testAllSettingsBadCustomSettings() throws Throwable{
		try{
			badCustomSettingsTest.testAllSettings();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_EDITABLE, TestFormField.WRONG_EDITABLE),
					e.getMessage());
		}
	}
}
