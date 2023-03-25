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

public class LongFormFieldTest extends BaseFormFieldTest<Long>{
	
	public LongFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Long>builder()
				.fieldType(FieldType.LONG)
				.defaultValue(0L)
				.testDefaultValue(42L)
				.goodComponent(new JSpinner(
						new SpinnerNumberModel(0L, null, null, 1L)))
				.build(), LongFormField::builder);
	}
	
	private LongFormField getDefaultField(){
		return (LongFormField) defaultFormField;
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
		assertEquals(Long.valueOf(1), getDefaultField().getStepSize());
	}
	
	@Test
	public void testSetMinValue(){
		LongFormField field = LongFormField.builder().minValue(1L).build();
		assertEquals(Long.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		LongFormField field = LongFormField.builder().maxValue(125L).build();
		assertEquals(Long.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		LongFormField field = LongFormField.builder().stepSize(5L).build();
		assertEquals(Long.valueOf(5), field.getStepSize());
	}
	
	@Override
	protected LongFormField.LongFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Long> builder){
		return ((LongFormField.LongFormFieldBuilder) builder)
				.minValue(1L).maxValue(125L).stepSize(5L);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Long> sentField){
		LongFormField field = (LongFormField) sentField;
		assertEquals(Long.valueOf(1), field.getMinValue());
		assertEquals(Long.valueOf(125), field.getMaxValue());
		assertEquals(Long.valueOf(5), field.getStepSize());
	}
}
