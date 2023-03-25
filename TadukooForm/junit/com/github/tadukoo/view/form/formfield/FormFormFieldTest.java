package com.github.tadukoo.view.form.formfield;

import com.github.tadukoo.view.form.AbstractSimpleForm;
import com.github.tadukoo.view.form.Form;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormFormFieldTest extends BaseFormFieldTest<Form>{
	
	public FormFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<Form>builder()
				.fieldType(FieldType.FORM)
				.testDefaultValue(new AbstractSimpleForm(new HashMap<>()){
					
					@Override
					public void saveValues(){
						super.saveValues();
					}
					
					@Override
					public void setDefaultFields(){
					
					}
				})
				.defaultLabelType(LabelType.TITLED_BORDER)
				.testLabelType(LabelType.LABEL)
				.goodComponent(new JLabel("No value"))
				.build(), FormFormField::builder);
	}
	
	private FormFormField getDefaultField(){
		return (FormFormField) defaultFormField;
	}
	
	@Test
	public void testGetJustComponentNoForm(){
		JComponent component = getDefaultField().getJustComponent();
		assertTrue(component instanceof JLabel);
		assertEquals("No value", ((JLabel) component).getText());
	}
	
	@Test
	public void testGetJustComponentForm() throws Throwable{
		Form form = new AbstractSimpleForm(new HashMap<>()){
			
			@Override
			public void saveValues(){
				super.saveValues();
			}
			
			@Override
			public void setDefaultFields(){
			
			}
		};
		
		FormFormField field = FormFormField.builder().defaultValue(form).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof AbstractSimpleForm);
		assertEquals(form, component);
	}
	
	@Test
	public void testGetValueFromJustComponentNotForm(){
		assertNull(getDefaultField().getValueFromJustComponent(new JLabel("Test")));
	}
	
	@Test
	public void testGetValueFromJustComponentForm() throws Throwable{
		final boolean[] savedValues = {false};
		Form form = new AbstractSimpleForm(new HashMap<>()){
			
			@Override
			public void saveValues(){
				super.saveValues();
				savedValues[0] = true;
			}
			
			@Override
			public void setDefaultFields(){
			
			}
		};
		
		assertEquals(form, getDefaultField().getValueFromJustComponent(form.asComponent()));
		assertTrue(savedValues[0]);
	}
}
