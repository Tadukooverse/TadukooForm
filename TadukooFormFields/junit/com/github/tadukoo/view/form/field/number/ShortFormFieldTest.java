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

public class ShortFormFieldTest extends BaseFormFieldTest<Short>{
	
	protected ShortFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Short>builder()
				.fieldType(FieldType.SHORT)
				.defaultValue((short) 0)
				.testDefaultValue((short) 7)
				.goodComponent(new JSpinner(
						new SpinnerNumberModel((short) 0, null, null, (short) 1)))
				.build(), ShortFormField::builder);
	}
	
	private ShortFormField getDefaultField(){
		return (ShortFormField) defaultFormField;
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
		assertEquals(Short.valueOf((short) 1), getDefaultField().getStepSize());
	}
	
	@Test
	public void testSetMinValue(){
		ShortFormField field = ShortFormField.builder().minValue((short) 1).build();
		assertEquals(Short.valueOf((short) 1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		ShortFormField field = ShortFormField.builder().maxValue((short) 125).build();
		assertEquals(Short.valueOf((short) 125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		ShortFormField field = ShortFormField.builder().stepSize((short) 5).build();
		assertEquals(Short.valueOf((short) 5), field.getStepSize());
	}
	
	@Override
	protected ShortFormField.ShortFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Short> builder){
		return ((ShortFormField.ShortFormFieldBuilder) builder)
				.minValue((short) 1).maxValue((short) 125).stepSize((short) 5);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Short> sentField){
		ShortFormField field = (ShortFormField) sentField;
		assertEquals(Short.valueOf((short) 1), field.getMinValue());
		assertEquals(Short.valueOf((short) 125), field.getMaxValue());
		assertEquals(Short.valueOf((short) 5), field.getStepSize());
	}
}
