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

public class FloatFormFieldTest extends BaseFormFieldTest<Float>{
	
	public FloatFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Float>builder()
				.fieldType(FieldType.FLOAT)
				.defaultValue(0.0f)
				.testDefaultValue(4.2f)
				.goodComponent(new JSpinner(
						new SpinnerNumberModel(0.0f, null, null, 1.0f)))
				.build(), FloatFormField::builder);
	}
	
	private FloatFormField getDefaultField(){
		return (FloatFormField) defaultFormField;
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
		assertEquals(Float.valueOf(1), getDefaultField().getStepSize());
	}
	
	@Test
	public void testSetMinValue(){
		FloatFormField field = FloatFormField.builder().minValue(1.0f).build();
		assertEquals(Float.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		FloatFormField field = FloatFormField.builder().maxValue(125.0f).build();
		assertEquals(Float.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		FloatFormField field = FloatFormField.builder().stepSize(5.0f).build();
		assertEquals(Float.valueOf(5), field.getStepSize());
	}
	
	@Override
	protected FloatFormField.FloatFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Float> builder){
		return ((FloatFormField.FloatFormFieldBuilder) builder)
				.minValue(1.0f).maxValue(125.0f).stepSize(5.0f);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Float> sentField){
		FloatFormField field = (FloatFormField) sentField;
		assertEquals(Float.valueOf(1), field.getMinValue());
		assertEquals(Float.valueOf(125), field.getMaxValue());
		assertEquals(Float.valueOf(5), field.getStepSize());
	}
}
