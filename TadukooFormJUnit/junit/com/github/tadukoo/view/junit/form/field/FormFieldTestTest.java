package com.github.tadukoo.view.junit.form.field;

import com.github.tadukoo.util.junit.AssertionFailedErrors;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.junit.form.field.testfields.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FormFieldTestTest{
	private FormFieldTestValues<String> goodFormFieldTestValues;
	private FormFieldTest<String> goodTest, badDefaultsTest, badSetTest;
	private FormFieldTest<String> badSetDefaultValueTest, badSetLabelTypeTest,
			badSetLabelForegroundPaintTest, badSetLabelBackgroundPaintTest,
			badSetLabelFontFamilyTest, badSetLabelFontStyleTest, badSetLabelFontSizeTest,
			badSetLabelShapeTest, badSetLabelBorderTest,
			badSetRowPosTest, badSetColPosTest, badSetRowSpanTest, badSetColSpanTest,
			badSetLogFontResourceLoaderWarningsTest, badSetLoggerTest, badSetGraphEnvTest, badSetFontFolderTest,
			badSetFontResourceLoaderTest,
			goodCustomSettingsTest, badCustomSettingsTest;
	
	@BeforeEach
	public void setup() throws Throwable{
		goodFormFieldTestValues = FormFieldTestValues.<String>builder()
				.fieldType(TestFormField.FIELD_TYPE)
				.testKey(TestFormField.TEST_KEY)
				.defaultValue(TestFormField.DEFAULT_VALUE)
				.testDefaultValue(TestFormField.TEST_DEFAULT_VALUE)
				.defaultLabelType(TestFormField.DEFAULT_LABEL_TYPE)
				.testLabelType(TestFormField.TEST_LABEL_TYPE)
				.defaultLabelForegroundPaint(TestFormField.DEFAULT_LABEL_FOREGROUND_PAINT)
				.testLabelForegroundPaint(TestFormField.TEST_LABEL_FOREGROUND_PAINT)
				.defaultLabelBackgroundPaint(TestFormField.DEFAULT_LABEL_BACKGROUND_PAINT)
				.testLabelBackgroundPaint(TestFormField.TEST_LABEL_BACKGROUND_PAINT)
				.defaultLabelFontFamily(TestFormField.DEFAULT_LABEL_FONT_FAMILY)
				.testLabelFontFamily(TestFormField.TEST_LABEL_FONT_FAMILY)
				.defaultLabelFontStyle(TestFormField.DEFAULT_LABEL_FONT_STYLE)
				.testLabelFontStyle(TestFormField.TEST_LABEL_FONT_STYLE)
				.defaultLabelFontSize(TestFormField.DEFAULT_LABEL_FONT_SIZE)
				.testLabelFontSize(TestFormField.TEST_LABEL_FONT_SIZE)
				.defaultLabelShape(TestFormField.DEFAULT_LABEL_SHAPE)
				.testLabelShape(TestFormField.TEST_LABEL_SHAPE)
				.defaultLabelBorder(TestFormField.DEFAULT_LABEL_BORDER)
				.testLabelBorder(TestFormField.TEST_LABEL_BORDER)
				.testRowPos(TestFormField.TEST_ROW_POS)
				.testColPos(TestFormField.TEST_COL_POS)
				.defaultRowSpan(TestFormField.DEFAULT_ROW_SPAN)
				.testRowSpan(TestFormField.TEST_ROW_SPAN)
				.defaultColSpan(TestFormField.DEFAULT_COL_SPAN)
				.testColSpan(TestFormField.TEST_COL_SPAN)
				.defaultLogFontResourceLoaderWarnings(TestFormField.DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS)
				.testLogFontResourceLoaderWarnings(TestFormField.TEST_LOG_FONT_RESOURCE_LOADER_WARNINGS)
				.defaultLogger(TestFormField.DEFAULT_LOGGER)
				.testLogger(TestFormField.TEST_LOGGER)
				.defaultGraphEnv(TestFormField.DEFAULT_GRAPH_ENV)
				.testGraphEnv(TestFormField.TEST_GRAPH_ENV)
				.defaultFontFolder(TestFormField.DEFAULT_FONT_FOLDER)
				.testFontFolder(TestFormField.TEST_FONT_FOLDER)
				.defaultFontResourceLoader(TestFormField.DEFAULT_FONT_RESOURCE_LOADER)
				.testFontResourceLoader(TestFormField.TEST_FONT_RESOURCE_LOADER)
				.goodComponent(TestFormField.GOOD_COMPONENT)
				.badComponent(TestFormField.BAD_COMPONENT)
				.build();
		goodTest = new FormFieldTest<>(goodFormFieldTestValues, TestFormField::builder){
		};
		badDefaultsTest = new FormFieldTest<>(FormFieldTestValues.<String>builder()
				.fieldType(TestFormField.WRONG_FIELD_TYPE)
				.defaultValue(TestFormField.WRONG_DEFAULT_VALUE)
				.testDefaultValue(TestFormField.TEST_DEFAULT_VALUE)
				.defaultLabelType(TestFormField.WRONG_LABEL_TYPE)
				.defaultLabelForegroundPaint(TestFormField.WRONG_LABEL_FOREGROUND_PAINT)
				.defaultLabelBackgroundPaint(TestFormField.WRONG_LABEL_BACKGROUND_PAINT)
				.defaultLabelFontFamily(TestFormField.WRONG_LABEL_FONT_FAMILY)
				.defaultLabelFontStyle(TestFormField.WRONG_LABEL_FONT_STYLE)
				.defaultLabelFontSize(TestFormField.WRONG_LABEL_FONT_SIZE)
				.defaultLabelShape(TestFormField.WRONG_LABEL_SHAPE)
				.defaultLabelBorder(TestFormField.WRONG_LABEL_BORDER)
				.defaultRowSpan(TestFormField.WRONG_ROW_SPAN)
				.defaultColSpan(TestFormField.WRONG_COL_SPAN)
				.defaultLogFontResourceLoaderWarnings(TestFormField.WRONG_LOG_FONT_RESOURCE_LOADER_WARNINGS)
				.testLogFontResourceLoaderWarnings(TestFormField.DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS)
				.defaultLogger(TestFormField.WRONG_LOGGER)
				.defaultGraphEnv(TestFormField.WRONG_GRAPH_ENV)
				.testGraphEnv(TestFormField.DEFAULT_GRAPH_ENV)
				.defaultFontFolder(TestFormField.WRONG_FONT_FOLDER)
				.defaultFontResourceLoader(TestFormField.WRONG_FONT_RESOURCE_LOADER)
				.goodComponent(TestFormField.GOOD_COMPONENT)
				.badComponent(TestFormField.BAD_COMPONENT)
				.build(), TestFormField::builder){
		};
		badSetTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormField::builder){
		};
		badSetDefaultValueTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadDefaultValue::builder){
		};
		badSetLabelTypeTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLabelType::builder){
		};
		badSetLabelForegroundPaintTest = new FormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLabelForegroundPaint::builder){
		};
		badSetLabelBackgroundPaintTest = new FormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLabelBackgroundPaint::builder){
		};
		badSetLabelFontFamilyTest = new FormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLabelFontFamily::builder){
		};
		badSetLabelFontStyleTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadFontStyle::builder){
		};
		badSetLabelFontSizeTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadFontSize::builder){
		};
		badSetLabelShapeTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLabelShape::builder){
		};
		badSetLabelBorderTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLabelBorder::builder){
		};
		badSetRowPosTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadRowPos::builder){
		};
		badSetColPosTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadColPos::builder){
		};
		badSetRowSpanTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadRowSpan::builder){
		};
		badSetColSpanTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadColSpan::builder){
		};
		badSetLogFontResourceLoaderWarningsTest = new FormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLogFontResourceLoaderWarnings::builder){
		};
		badSetLoggerTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLogger::builder){
		};
		badSetGraphEnvTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadGraphEnv::builder){
		};
		badSetFontFolderTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadFontFolder::builder){
		};
		badSetFontResourceLoaderTest = new FormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadFontResourceLoader::builder){
		};
		goodCustomSettingsTest = new FormFieldTest<>(goodFormFieldTestValues, TestFormField::builder){
			@Override
			protected TestFormField.TestFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<String> builder){
				return ((TestFormField.TestFormFieldBuilder) builder).editable(TestFormField.TEST_EDITABLE);
			}
			
			@Override
			protected void checkExtraSettings(FormField<String> field){
				assertEquals(TestFormField.TEST_EDITABLE, ((TestFormField) field).isEditable());
			}
		};
		badCustomSettingsTest = new FormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadCustomSetting::builder){
			@Override
			protected TestFormField.TestFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<String> builder){
				return ((TestFormField.TestFormFieldBuilder) builder).editable(TestFormField.TEST_EDITABLE);
			}
			
			@Override
			protected void checkExtraSettings(FormField<String> field){
				assertEquals(TestFormField.TEST_EDITABLE, ((TestFormField) field).isEditable());
			}
		};
	}
	
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
	
	/*
	 * Test setting builder values
	 */
	
	@Test
	public void testRightSetKey() throws Throwable{
		goodTest.testSetKey();
	}
	
	@Test
	public void testWrongSetKey() throws Throwable{
		try{
			badSetTest.testSetKey();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_KEY, TestFormField.WRONG_KEY), e.getMessage());
		}
	}
	
	@Test
	public void testRightSetDefaultValue() throws Throwable{
		goodTest.testSetDefaultValue();
	}
	
	@Test
	public void testWrongSetDefaultValue() throws Throwable{
		try{
			badSetTest.testSetDefaultValue();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_DEFAULT_VALUE, TestFormField.WRONG_DEFAULT_VALUE), e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelType() throws Throwable{
		goodTest.testSetLabelType();
	}
	
	@Test
	public void testWrongSetLabelType() throws Throwable{
		try{
			badSetTest.testSetLabelType();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
					TestFormField.TEST_LABEL_TYPE, TestFormField.WRONG_LABEL_TYPE), e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelForegroundPaint() throws Throwable{
		goodTest.testSetLabelForegroundPaint();
	}
	
	@Test
	public void testWrongSetLabelForegroundPaint() throws Throwable{
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
	public void testRightSetLabelBackgroundPaint() throws Throwable{
		goodTest.testSetLabelBackgroundPaint();
	}
	
	@Test
	public void testWrongSetLabelBackgroundPaint() throws Throwable{
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
	public void testRightSetLabelFont() throws Throwable{
		goodTest.testSetLabelFont();
	}
	
	@Test
	public void testWrongSetLabelFontFamily() throws Throwable{
		try{
			badSetTest.testSetLabelFont();
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
			badSetLabelFontStyleTest.testSetLabelFont();
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
			badSetLabelFontSizeTest.testSetLabelFont();
			fail();
		}catch(AssertionFailedError e){
			assertEquals(AssertionFailedErrors.buildAssertError(
							TestFormField.TEST_LABEL_FONT_SIZE, TestFormField.WRONG_LABEL_FONT_SIZE),
					e.getMessage());
		}
	}
	
	@Test
	public void testRightSetLabelShape() throws Throwable{
		goodTest.testSetLabelShape();
	}
	
	@Test
	public void testWrongSetLabelShape() throws Throwable{
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
	public void testRightSetLabelBorder() throws Throwable{
		goodTest.testSetLabelBorder();
	}
	
	@Test
	public void testWrongSetLabelBorder() throws Throwable{
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
	public void testRightSetRowPos() throws Throwable{
		goodTest.testSetRowPos();
	}
	
	@Test
	public void testWrongSetRowPos() throws Throwable{
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
	public void testRightSetColPos() throws Throwable{
		goodTest.testSetColPos();
	}
	
	@Test
	public void testWrongSetColPos() throws Throwable{
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
	public void testRightSetRowSpan() throws Throwable{
		goodTest.testSetRowSpan();
	}
	
	@Test
	public void testWrongSetRowSpan() throws Throwable{
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
	public void testRightSetColSpan() throws Throwable{
		goodTest.testSetColSpan();
	}
	
	@Test
	public void testWrongSetColSpan() throws Throwable{
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
	public void testRightSetLogFontResourceLoaderWarnings() throws Throwable{
		goodTest.testSetLogFontResourceLoaderWarnings();
	}
	
	@Test
	public void testWrongSetLogFontResourceLoaderWarnings() throws Throwable{
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
	public void testRightSetLogger() throws Throwable{
		goodTest.testSetLogger();
	}
	
	@Test
	public void testWrongSetLogger() throws Throwable{
		try{
			badSetTest.testSetLogger();
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
		goodTest.testSetGraphEnv();
	}
	
	@Test
	public void testWrongSetGraphEnv() throws Throwable{
		try{
			badSetTest.testSetGraphEnv();
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
		goodTest.testSetFontFolder();
	}
	
	@Test
	public void testWrongSetFontFolder() throws Throwable{
		try{
			badSetTest.testSetFontFolder();
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
		goodTest.testSetFontResourceLoader();
	}
	
	@Test
	public void testWrongSetFontResourceLoader() throws Throwable{
		try{
			badSetTest.testSetFontResourceLoader();
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
