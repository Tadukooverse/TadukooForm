package com.github.tadukoo.view.form.field.string;

import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JTextField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleLineStringFormFieldTest extends BaseFormFieldTest<String>{
	
	public SingleLineStringFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<String>builder()
				.fieldType(FieldType.SINGLE_LINE_STRING)
				.defaultValue("")
				.testDefaultValue("Derp")
				.goodComponent(new JTextField(""))
				.build(), SingleLineStringFormField::builder);
	}
	
	private SingleLineStringFormField getDefaultField(){
		return (SingleLineStringFormField) defaultFormField;
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
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.editable(false)
				.build();
		assertFalse(field.isEditable());
	}
	
	@Test
	public void testSetColumns(){
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.columns(42)
				.build();
		assertEquals(42, field.getColumns());
	}
	
	@Override
	protected SingleLineStringFormField.SingleLineStringFormFieldBuilder setExtraSettings(
			FormField.FormFieldBuilder<String> builder){
		return ((SingleLineStringFormField.SingleLineStringFormFieldBuilder) builder)
				.editable(false).columns(42);
	}
	
	@Override
	protected void checkExtraSettings(FormField<String> sentField){
		SingleLineStringFormField field = (SingleLineStringFormField) sentField;
		assertFalse(field.isEditable());
		assertEquals(42, field.getColumns());
	}
	
	@Test
	public void testGetJustComponentNonEmptyDefaultValue() throws Throwable{
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.defaultValue("Derp")
				.rowPos(1).colPos(1)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JTextField);
		assertEquals("Derp", ((JTextField) component).getText());
		assertEquals("Derp", field.getValueFromJustComponent(component));
	}
	
	@Test
	public void testGetJustComponentEditable() throws Throwable{
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JTextField);
		assertTrue(((JTextField) component).isEditable());
	}
	
	@Test
	public void testGetJustComponentEditableFalse() throws Throwable{
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.editable(false)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JTextField);
		assertFalse(((JTextField) component).isEditable());
	}
	
	@Test
	public void testGetJustComponentDefaultColumns() throws Throwable{
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JTextField);
		assertEquals(25, ((JTextField) component).getColumns());
	}
	
	@Test
	public void testGetJustComponentSetColumns() throws Throwable{
		SingleLineStringFormField field = SingleLineStringFormField.builder()
				.key("Test")
				.rowPos(1).colPos(1)
				.columns(105)
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof JTextField);
		assertEquals(105, ((JTextField) component).getColumns());
	}
}
