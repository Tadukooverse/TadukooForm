package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDownFormFieldTest extends BaseFormFieldTest<String>{
	
	public DropDownFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<String>builder()
				.fieldType(FieldType.DROP_DOWN)
				.testDefaultValue("Yep")
				.goodComponent(new JComboBox<>(new String[]{null}))
				.build(), DropDownFormField::builder);
	}
	
	private DropDownFormField getDefaultField(){
		return (DropDownFormField) defaultFormField;
	}
	
	@Test
	public void testDefaultEditable(){
		assertTrue(getDefaultField().isEditable());
	}
	
	@Test
	public void testDefaultOptions(){
		assertArrayEquals(new String[]{}, getDefaultField().getOptions());
	}
	
	@Test
	public void testSetEditable(){
		DropDownFormField field = DropDownFormField.builder().editable(false).build();
		assertFalse(field.isEditable());
	}
	
	@Test
	public void testSetOptions(){
		DropDownFormField field = DropDownFormField.builder().options(new String[]{"Test", "Derp"}).build();
		assertArrayEquals(new String[]{"Test", "Derp"}, field.getOptions());
	}
	
	@Override
	protected DropDownFormField.DropDownFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<String> builder){
		return ((DropDownFormField.DropDownFormFieldBuilder) builder)
				.editable(false)
				.options(new String[]{"Test", "Derp"});
	}
	
	@Override
	protected void checkExtraSettings(FormField<String> sentField){
		DropDownFormField field = (DropDownFormField) sentField;
		assertFalse(field.isEditable());
		assertArrayEquals(new String[]{"Test", "Derp"}, field.getOptions());
	}
	
	@Test
	public void testGetJustComponentOptions(){
		DropDownFormField field = DropDownFormField.builder().options(new String[]{"Derp", "Test"}).build();
		
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JComboBox);
		JComboBox<?> comboBox = (JComboBox<?>) component;
		assertEquals(2, comboBox.getItemCount());
	}
	
	@Test
	public void testGetJustComponentAllSettings(){
		DropDownFormField field = DropDownFormField.builder()
				.defaultValue("Test")
				.options(new String[]{"Derp", "Test"})
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JComboBox);
		assertEquals("Test", ((JComboBox<?>) component).getSelectedItem());
		assertEquals(2, ((JComboBox<?>) component).getItemCount());
	}
}
