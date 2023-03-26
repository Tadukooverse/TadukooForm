package com.github.tadukoo.view.form.field;

/**
 * An interface for {@link FormField FormFields} that have an editable boolean
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface IsEditable{
	
	/**
	 * @return Whether this field can be edited or not
	 */
	boolean isEditable();
	
	/**
	 * @param editable Whether this field can be edited or not
	 */
	void setEditable(boolean editable);
}
