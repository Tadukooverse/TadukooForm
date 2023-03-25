package com.github.tadukoo.view.form.field;

/**
 * Field Type is used in {@link FormField} for what type of field it is.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.2
 */
public enum FieldType{
	/** A boolean field */
	BOOLEAN,
	/** An int field */
	INT,
	/** A float field */
	FLOAT,
	/** A double field */
	DOUBLE,
	/** A short field */
	SHORT,
	/** A long field */
	LONG,
	/** A label field */
	LABEL,
	/** A string field */
	SINGLE_LINE_STRING,
	/** A password field */
	PASSWORD,
	/** A Date field */
	DATE,
	/** A drop-down field */
	DROP_DOWN,
	/** A button (not really a field) */
	BUTTON,
	/** A form field */
	FORM,
	/** A Table (List) field */
	TABLE,
	/** Used for fields not covered by this non-exhaustive list made outside of Tadukoo Form */
	CUSTOM
}
