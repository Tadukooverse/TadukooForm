package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoubleFormFieldTest extends BaseFormFieldTest<Double>{
	
	protected DoubleFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Double>builder()
				.fieldType(FieldType.DOUBLE)
				.defaultValue(0.0)
				.testDefaultValue(42.0)
				.goodComponent(new JSpinner(
						new SpinnerNumberModel(0.0, null, null, 1.0)))
				.build(), DoubleFormField::builder);
	}
	
	private DoubleFormField getDefaultField(){
		return (DoubleFormField) defaultFormField;
	}
	
	@Test
	public void testDefaultMinValue(){
		assertNull(getDefaultField().getMinValue());
	}
	
	@Test
	public void testDefaultMaxValue(){
		assertNull(getDefaultField().getMaxValue());
	}
	
	@Test
	public void testDefaultStepSize(){
		assertEquals(Double.valueOf(1), getDefaultField().getStepSize());
	}
	
	@Test
	public void testSetMinValue(){
		DoubleFormField field = DoubleFormField.builder().minValue(1.0).build();
		assertEquals(Double.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		DoubleFormField field = DoubleFormField.builder().maxValue(125.0).build();
		assertEquals(Double.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		DoubleFormField field = DoubleFormField.builder().stepSize(5.0).build();
		assertEquals(Double.valueOf(5), field.getStepSize());
	}
	
	@Override
	protected DoubleFormField.DoubleFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Double> builder){
		return ((DoubleFormField.DoubleFormFieldBuilder) builder)
				.minValue(1.0).maxValue(125.0).stepSize(5.0);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Double> sentField){
		DoubleFormField field = (DoubleFormField) sentField;
		assertEquals(Double.valueOf(1), field.getMinValue());
		assertEquals(Double.valueOf(125), field.getMaxValue());
		assertEquals(Double.valueOf(5), field.getStepSize());
	}
}
