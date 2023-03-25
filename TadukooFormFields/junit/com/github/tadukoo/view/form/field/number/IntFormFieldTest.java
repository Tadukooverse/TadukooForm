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

public class IntFormFieldTest extends BaseFormFieldTest<Integer>{
	
	protected IntFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Integer>builder()
				.fieldType(FieldType.INT)
				.defaultValue(0)
				.testDefaultValue(42)
				.goodComponent(new JSpinner(
						new SpinnerNumberModel(0, null, null, 1)))
				.build(), IntFormField::builder);
	}
	
	private IntFormField getDefaultField(){
		return (IntFormField) defaultFormField;
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
		assertEquals(Integer.valueOf(1), getDefaultField().getStepSize());
	}
	
	@Test
	public void testSetMinValue(){
		IntFormField field = IntFormField.builder().minValue(1).build();
		assertEquals(Integer.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		IntFormField field = IntFormField.builder().maxValue(125).build();
		assertEquals(Integer.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		IntFormField field = IntFormField.builder().stepSize(5).build();
		assertEquals(Integer.valueOf(5), field.getStepSize());
	}
	
	@Override
	protected IntFormField.IntFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Integer> builder){
		return ((IntFormField.IntFormFieldBuilder) builder)
				.minValue(1).maxValue(125).stepSize(5);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Integer> sentField){
		IntFormField field = (IntFormField) sentField;
		assertEquals(Integer.valueOf(1), field.getMinValue());
		assertEquals(Integer.valueOf(125), field.getMaxValue());
		assertEquals(Integer.valueOf(5), field.getStepSize());
	}
}
