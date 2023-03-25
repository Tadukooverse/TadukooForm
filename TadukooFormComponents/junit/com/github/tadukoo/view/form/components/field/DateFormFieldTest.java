package com.github.tadukoo.view.form.components.field;

import com.github.tadukoo.util.time.DateUtil;
import com.github.tadukoo.view.form.components.DateForm;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateFormFieldTest extends BaseFormFieldTest<Date>{
	
	public DateFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Date>builder()
				.fieldType(FieldType.DATE)
				.testDefaultValue(DateUtil.createDate(Month.JULY, 4, 1776))
				.goodComponent(new DateForm(null, 1900, 2100))
				.build(), DateFormField::builder);
	}
	
	private DateFormField getDefaultField(){
		return (DateFormField) defaultFormField;
	}
	
	@Test
	public void testDefaultMinYear(){
		assertEquals(1900, getDefaultField().getMinYear());
	}
	
	@Test
	public void testDefaultMaxYear(){
		assertEquals(2100, getDefaultField().getMaxYear());
	}
	
	@Test
	public void testSetMinYear(){
		DateFormField field = DateFormField.builder().minYear(120).build();
		assertEquals(120, field.getMinYear());
	}
	
	@Test
	public void testSetMaxYear(){
		DateFormField field = DateFormField.builder().maxYear(1920).build();
		assertEquals(1920, field.getMaxYear());
	}
	
	@Override
	protected DateFormField.DateFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<Date> builder){
		return ((DateFormField.DateFormFieldBuilder) builder)
				.minYear(120).maxYear(1920);
	}
	
	@Override
	protected void checkExtraSettings(FormField<Date> sentField){
		DateFormField field = (DateFormField) sentField;
		assertEquals(120, field.getMinYear());
		assertEquals(1920, field.getMaxYear());
	}
	
	@Test
	public void testGetJustComponentDefaultValue() throws Throwable{
		Date date = DateUtil.createDate(Month.JULY, 4, 2000);
		DateFormField field = DateFormField.builder().defaultValue(date).build();
		
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(date, dateForm.getDate());
		assertEquals(Month.JULY, dateForm.getMonth());
		assertEquals(4, dateForm.getDay());
		assertEquals(2000, dateForm.getYear());
	}
	
	@Test
	public void testGetJustComponentMinYear() throws Throwable{
		DateFormField field = DateFormField.builder().minYear(120).build();
		
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(120, dateForm.getMinYear());
	}
	
	@Test
	public void testGetJustComponentMaxYear() throws Throwable{
		DateFormField field = DateFormField.builder().maxYear(1920).build();
		
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(1920, dateForm.getMaxYear());
	}
	
	@Test
	public void testGetJustComponentAllSettings() throws Throwable{
		Date date = DateUtil.createDate(Month.JULY, 4, 1776);
		DateFormField field = DateFormField.builder().defaultValue(date).minYear(120).maxYear(1920).build();
		
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(date, dateForm.getDate());
		assertEquals(Month.JULY, dateForm.getMonth());
		assertEquals(4, dateForm.getDay());
		assertEquals(1776, dateForm.getYear());
		assertEquals(120, dateForm.getMinYear());
		assertEquals(1920, dateForm.getMaxYear());
	}
}
