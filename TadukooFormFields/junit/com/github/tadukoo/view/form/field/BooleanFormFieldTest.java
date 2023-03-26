package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanFormFieldTest extends BaseFormFieldTest<Boolean>{
	
	protected BooleanFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Boolean>builder()
				.fieldType(FieldType.BOOLEAN)
				.defaultValue(false).testDefaultValue(true)
				.defaultLabelType(LabelType.NONE)
				.goodComponent(new JCheckBox("Testing", false))
				.build(), BooleanFormField::builder);
	}
	
	private BooleanFormField getDefaultField(){
		return (BooleanFormField) defaultFormField;
	}
	
	@Test
	public void testDefaultEditable(){
		assertTrue(getDefaultField().isEditable());
	}
	
	@Override
	protected BooleanFormField.BooleanFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Boolean> builder){
		return ((BooleanFormField.BooleanFormFieldBuilder) builder).editable(false);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Boolean> field){
		assertFalse(((BooleanFormField) field).isEditable());
	}
	
	@Test
	public void testSetEditable(){
		getDefaultField().setEditable(false);
		assertFalse(getDefaultField().isEditable());
	}
	
	@Test
	public void testGetJustComponentDefaultValue(){
		BooleanFormField field = BooleanFormField.builder().key("Test").defaultValue(true).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
		assertTrue(((JCheckBox) component).isSelected());
	}
	
	@Test
	public void testGetJustComponentNotEditable(){
		BooleanFormField field = BooleanFormField.builder().key("Test").editable(false).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
		assertFalse(component.isEnabled());
	}
	
	@Test
	public void testGetJustComponentAllSettings(){
		BooleanFormField field = BooleanFormField.builder().key("Test").defaultValue(true).editable(false).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
		assertTrue(((JCheckBox) component).isSelected());
		assertFalse(component.isEnabled());
	}
}
