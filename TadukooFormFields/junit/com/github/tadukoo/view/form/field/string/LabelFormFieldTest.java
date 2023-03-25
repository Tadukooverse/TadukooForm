package com.github.tadukoo.view.form.field.string;

import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class LabelFormFieldTest extends BaseFormFieldTest<String>{
	
	protected LabelFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<String>builder()
				.fieldType(FieldType.LABEL)
				.defaultValue("")
				.testDefaultValue("Derp")
				.defaultLabelType(LabelType.NONE)
				.testLabelType(LabelType.LABEL)
				.goodComponent(new JLabel(""))
				.badComponent(new JTextField("Test"))
				.build(), LabelFormField::builder);
	}
}
