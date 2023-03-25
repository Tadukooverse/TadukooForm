package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import org.junit.jupiter.api.Test;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertNull;

public class NumberFormFieldTest extends BaseFormFieldTest<Integer>{
	
	private static class TestFormField extends NumberFormField<Integer>{
		
		private TestFormField(FieldType type, String key, Integer defaultValue,
		                      LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
		                      FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
		                      ShapeInfo labelShape, Border labelBorder,
		                      int rowPos, int colPos, int rowSpan, int colSpan,
		                      boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
		                      String fontFolder, FontResourceLoader fontResourceLoader,
		                      Integer minValue, Integer maxValue, Integer stepSize){
			super(type, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					minValue, maxValue, stepSize);
		}
		
		@Override
		protected Integer convertToType(Number number){
			return number.intValue();
		}
	}
	
	private static class TestFormFieldBuilder extends NumberFormField.NumberFormFieldBuilder<Integer>{
		
		private TestFormFieldBuilder(){
			defaultValue = 0;
			stepSize = 1;
		}
		
		@Override
		public NumberFormField<Integer> build(){
			return new TestFormField(FieldType.INT, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					minValue, maxValue, stepSize);
		}
	}
	
	public NumberFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Integer>builder()
				.fieldType(FieldType.INT)
				.defaultValue(0)
				.testDefaultValue(42)
				.goodComponent(new JSpinner(
						new SpinnerNumberModel(0, null, null, 1)))
				.build(), TestFormFieldBuilder::new);
	}
	
	private NumberFormField<Integer> getDefaultField(){
		return (NumberFormField<Integer>) defaultFormField;
	}
	
	@Test
	public void testDefaultMinValue(){
		assertNull(getDefaultField().getMinValue());
	}
	
	@Test
	public void testDefaultMaxValue(){
		assertNull(getDefaultField().getMaxValue());
	}
}
