package com.github.tadukoo.view.form.field.testutil.test;

import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormField;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadColPos;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadColSpan;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadCustomSetting;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadDefaultValue;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadFontFolder;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadFontResourceLoader;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadFontSize;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadFontStyle;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadGraphEnv;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLabelBackgroundPaint;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLabelBorder;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLabelFontFamily;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLabelForegroundPaint;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLabelShape;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLabelType;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLogFontResourceLoaderWarnings;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadLogger;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadRowPos;
import com.github.tadukoo.view.form.field.testutil.test.testfields.BadTestFormFieldBadRowSpan;
import com.github.tadukoo.view.form.field.testutil.test.testfields.TestFormField;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseBaseFormFieldTestTest{
	protected FormFieldTestValues<String> goodFormFieldTestValues;
	protected BaseFormFieldTest<String> goodTest, badDefaultsTest, badSetTest;
	protected BaseFormFieldTest<String> badSetDefaultValueTest, badSetLabelTypeTest,
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
		goodTest = new BaseFormFieldTest<>(goodFormFieldTestValues, TestFormField::builder){
		};
		badDefaultsTest = new BaseFormFieldTest<>(FormFieldTestValues.<String>builder()
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
		badSetTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormField::builder){
		};
		badSetDefaultValueTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadDefaultValue::builder){
		};
		badSetLabelTypeTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLabelType::builder){
		};
		badSetLabelForegroundPaintTest = new BaseFormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLabelForegroundPaint::builder){
		};
		badSetLabelBackgroundPaintTest = new BaseFormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLabelBackgroundPaint::builder){
		};
		badSetLabelFontFamilyTest = new BaseFormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLabelFontFamily::builder){
		};
		badSetLabelFontStyleTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadFontStyle::builder){
		};
		badSetLabelFontSizeTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadFontSize::builder){
		};
		badSetLabelShapeTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLabelShape::builder){
		};
		badSetLabelBorderTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLabelBorder::builder){
		};
		badSetRowPosTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadRowPos::builder){
		};
		badSetColPosTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadColPos::builder){
		};
		badSetRowSpanTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadRowSpan::builder){
		};
		badSetColSpanTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadColSpan::builder){
		};
		badSetLogFontResourceLoaderWarningsTest = new BaseFormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadLogFontResourceLoaderWarnings::builder){
		};
		badSetLoggerTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadLogger::builder){
		};
		badSetGraphEnvTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadGraphEnv::builder){
		};
		badSetFontFolderTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadFontFolder::builder){
		};
		badSetFontResourceLoaderTest = new BaseFormFieldTest<>(goodFormFieldTestValues,
				BadTestFormFieldBadFontResourceLoader::builder){
		};
		goodCustomSettingsTest = new BaseFormFieldTest<>(goodFormFieldTestValues, TestFormField::builder){
			@Override
			protected TestFormField.TestFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<String> builder){
				return ((TestFormField.TestFormFieldBuilder) builder).editable(TestFormField.TEST_EDITABLE);
			}
			
			@Override
			protected void checkExtraSettings(FormField<String> field){
				assertEquals(TestFormField.TEST_EDITABLE, ((TestFormField) field).isEditable());
			}
		};
		badCustomSettingsTest = new BaseFormFieldTest<>(goodFormFieldTestValues, BadTestFormFieldBadCustomSetting::builder){
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
	
}
