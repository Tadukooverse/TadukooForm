package com.github.tadukoo.view.form.field.string;

import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JPasswordField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordFormFieldTest extends BaseFormFieldTest<String>{
	
	public PasswordFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<String>builder()
				.fieldType(FieldType.PASSWORD)
				.defaultValue("")
				.testDefaultValue("Derp")
				.goodComponent(new JPasswordField(""))
				.build(), PasswordFormField::builder);
	}
	
	private PasswordFormField getDefaultField(){
		return (PasswordFormField) defaultFormField;
	}
	
	@Test
	public void testDefaultEditable(){
		assertTrue(getDefaultField().isEditable());
	}
	
	@Test
	public void testDefaultColumns(){
		assertEquals(-1, getDefaultField().getColumns());
	}
	
	@Test
	public void testSetEditable(){
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.editable(false)
				.build();
		assertFalse(field.isEditable());
	}
	
	@Test
	public void testSetColumns(){
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.columns(42)
				.build();
		assertEquals(42, field.getColumns());
	}
	
	@Override
	protected PasswordFormField.PasswordFormFieldBuilder setExtraSettings(
			FormField.FormFieldBuilder<String> builder){
		return ((PasswordFormField.PasswordFormFieldBuilder) builder)
				.editable(false).columns(42);
	}
	
	@Override
	protected void checkExtraSettings(FormField<String> sentField){
		PasswordFormField field = (PasswordFormField) sentField;
		assertFalse(field.isEditable());
		assertEquals(42, field.getColumns());
	}
	
	@Test
	public void testGetJustComponentNonEmptyDefaultValue() throws Throwable{
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.defaultValue("Derp")
				.rowPos(1).colPos(1)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JPasswordField);
		assertEquals("Derp", new String(((JPasswordField) component).getPassword()));
		assertEquals("Derp", field.getValueFromJustComponent(component));
	}
	
	@Test
	public void testGetJustComponentEditable() throws Throwable{
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JPasswordField);
		assertTrue(((JPasswordField) component).isEditable());
	}
	
	@Test
	public void testGetJustComponentEditableFalse() throws Throwable{
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.editable(false)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JPasswordField);
		assertFalse(((JPasswordField) component).isEditable());
	}
	
	@Test
	public void testGetJustComponentDefaultColumns() throws Throwable{
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JPasswordField);
		assertEquals(25, ((JPasswordField) component).getColumns());
	}
	
	@Test
	public void testGetJustComponentSetColumns() throws Throwable{
		PasswordFormField field = PasswordFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.columns(105)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JPasswordField);
		assertEquals(105, ((JPasswordField) component).getColumns());
	}
}
