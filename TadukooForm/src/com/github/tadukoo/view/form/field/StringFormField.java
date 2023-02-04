package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.components.TadukooLabel;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.SimpleForm;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

/**
 * String Form Field is a {@link FormField} that uses a String. This could be an input prompt or a title
 * (See {@link StringFieldType})
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.2
 */
public class StringFormField extends FormField<String>{
	
	/**
	 * String Field Type is used to determine type of String field
	 */
	public enum StringFieldType{
		/** A normal {@link JTextField} - used as a text input prompt */
		NORMAL,
		/** A {@link JLabel} */
		TITLE,
		/** A {@link JPasswordField} - used as a text input prompt that hides the text */
		PASSWORD
	}
	
	/**
	 * Builder to be used to create a {@link StringFormField}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>StringFormField Parameters</caption>
	 *     <tr>
	 *         <th>Name</th>
	 *         <th>Description</th>
	 *         <th>Default Value or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>key</td>
	 *         <td>The name of the field (used as a key in {@link SimpleForm Forms})</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultValue</td>
	 *         <td>The starting value of the field</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelType</td>
	 *         <td>The {@link LabelType} to use for the field</td>
	 *         <td>Defaults to {@link LabelType#LABEL}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelForegroundPaint</td>
	 *         <td>The {@link SizablePaint} for the foreground of the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label foreground paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelBackgroundPaint</td>
	 *         <td>The {@link SizablePaint} for the background of the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label background paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelFont</td>
	 *         <td>The Font to use for the Label - specified as a {@link FontFamily}, style, and size</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label font)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelShape</td>
	 *         <td>The {@link ShapeInfo} to use for the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label shape)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelBorder</td>
	 *         <td>The {@link Border} to use for the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label border)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>rowPos</td>
	 *         <td>The row position of the field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>colPos</td>
	 *         <td>The column position of the field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>rowSpan</td>
	 *         <td>The row span of the field</td>
	 *         <td>Defaults to 1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>colSpan</td>
	 *         <td>The column span of the field</td>
	 *         <td>Defaults to 1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>stringFieldType</td>
	 *         <td>The {@link StringFieldType type} of String field</td>
	 *         <td>Defaults to {@link StringFieldType#NORMAL}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>editable</td>
	 *         <td>Whether the field can be edited or not</td>
	 *         <td>Defaults to true</td>
	 *     </tr>
	 *     <tr>
	 *         <td>columns</td>
	 *         <td>Number of columns used to determine the width of the field</td>
	 *         <td>Defaults to -1 (to use the defaultValue for determining size)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>stringBackgroundPaint</td>
	 *         <td>The background {@link SizablePaint paint} to use for the String field</td>
	 *         <td>Defaults to {@code null} (to use the default Look &amp; Feel setting)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>stringForegroundPaint</td>
	 *         <td>The foreground {@link SizablePaint paint} to use for the String field</td>
	 *         <td>Defaults to {@code null} (to use the default Look &amp; Feel setting)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>stringDisabledForegroundPaint</td>
	 *         <td>The disabled foreground {@link SizablePaint paint} to use for the String field</td>
	 *         <td>Defaults to {@code null} (to use the default Look &amp; Feel setting)</td>
	 *     </tr>
	 * </table>
	 * This builder also provides methods and parameters for {@link FontResourceLoader font resource loading}:
	 * <table>
	 *     <caption>Font Resource Loading Parameters</caption>
	 *     <tr>
	 *         <th>Field</th>
	 *         <th>Description</th>
	 *         <th>Default Value</th>
	 *     </tr>
	 *     <tr>
	 *         <td>logFontResourceLoaderWarnings</td>
	 *         <td>Whether to log warnings generated by the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>logger</td>
	 *         <td>An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>null (since logging warnings is set to false by default)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>graphEnv</td>
	 *         <td>The {@link GraphicsEnvironment} to load fonts to in the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>{@link GraphicsEnvironment#getLocalGraphicsEnvironment()}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fontFolder</td>
	 *         <td>The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>"fonts/"</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fontResourceLoader</td>
	 *         <td>The {@link FontResourceLoader} to use in loading fonts and/or ensuring they're in the system</td>
	 *         <td>a new FontResourceLoader with the specified values for {@link #logFontResourceLoaderWarnings},
	 *         {@link #logger}, {@link #graphEnv}, and {@link #fontFolder}</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.4
	 * @since Alpha v.0.2
	 */
	public static class StringFormFieldBuilder extends FormFieldBuilder<String>{
		/** The {@link StringFieldType type} of String field */
		private StringFieldType stringFieldType = StringFieldType.NORMAL;
		/** Whether the field can be edited or not */
		private boolean editable = true;
		/** Number of columns used to determine the width of the field */
		private int columns = -1;
		/** The {@link SizablePaint paint} to use for the background of the String field */
		private SizablePaint stringBackgroundPaint = null;
		/** The {@link SizablePaint paint} to use for the foreground of the String field */
		private SizablePaint stringForegroundPaint = null;
		/** The {@link SizablePaint paint} to use for the disabled foreground of the String field */
		private SizablePaint stringDisabledForegroundPaint = null;
		
		/** Can't create StringFormFieldBuilder outside StringFormField */
		private StringFormFieldBuilder(){
			super();
		}
		
		/*
		 * The Basics
		 */
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder defaultValue(String defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/*
		 * Label Settings
		 */
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelForegroundPaint(SizablePaint labelForegroundPaint){
			super.labelForegroundPaint(labelForegroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			super.labelBackgroundPaint(labelBackgroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelFont(FontFamily labelFontFamily, int labelFontStyle, int labelFontSize){
			super.labelFont(labelFontFamily, labelFontStyle, labelFontSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelShape(ShapeInfo labelShape){
			super.labelShape(labelShape);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelBorder(Border labelBorder){
			super.labelBorder(labelBorder);
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/*
		 * String Specific Methods
		 */
		
		/**
		 * @param stringFieldType The {@link StringFieldType type} of String field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder stringFieldType(StringFieldType stringFieldType){
			this.stringFieldType = stringFieldType;
			return this;
		}
		
		/**
		 * @param editable Whether the field can be edited or not
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder editable(boolean editable){
			this.editable = editable;
			return this;
		}
		
		/**
		 * @param columns Number of columns used to determine the width of the field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder columns(int columns){
			this.columns = columns;
			return this;
		}
		
		/**
		 * @param stringBackgroundPaint The {@link SizablePaint paint} to use for the background of the String field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder stringBackgroundPaint(SizablePaint stringBackgroundPaint){
			this.stringBackgroundPaint = stringBackgroundPaint;
			return this;
		}
		
		/**
		 * @param stringForegroundPaint The {@link SizablePaint paint} to use for the foreground of the String field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder stringForegroundPaint(SizablePaint stringForegroundPaint){
			this.stringForegroundPaint = stringForegroundPaint;
			return this;
		}
		
		/**
		 * @param stringDisabledForegroundPaint The {@link SizablePaint paint} to use for the
		 * disabled foreground of the String field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder stringDisabledForegroundPaint(SizablePaint stringDisabledForegroundPaint){
			this.stringDisabledForegroundPaint = stringDisabledForegroundPaint;
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormField build(){
			return new StringFormField(key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					stringFieldType, editable, columns,
					stringBackgroundPaint, stringForegroundPaint,
					stringDisabledForegroundPaint);
		}
	}
	
	/** The {@link StringFieldType type} of String field */
	private final StringFieldType stringFieldType;
	/** Whether this field can be edited or not */
	private final boolean editable;
	/** Number of columns used to determine the width of this field */
	private final int columns;
	/** The {@link SizablePaint paint} to use for the background of the String field */
	private final SizablePaint stringBackgroundPaint;
	/** The {@link SizablePaint paint} to use for the foreground of the String field */
	private final SizablePaint stringForegroundPaint;
	/** The {@link SizablePaint paint} to use for the disabled foreground of the String field */
	private final SizablePaint stringDisabledForegroundPaint;
	
	/**
	 * Creates a new StringFormField with the given parameters
	 *
	 * @param key The name of this field (used as a key in Forms)
	 * @param defaultValue The starting value of the field
	 * @param labelType The {@link LabelType} to use for this field
	 * @param labelForegroundPaint The {@link SizablePaint} for the foreground of the Label
	 * @param labelBackgroundPaint The {@link SizablePaint} for the background of the Label
	 * @param labelFontFamily The {@link FontFamily} for the Label's font
	 * @param labelFontStyle The font style for the Label
	 * @param labelFontSize The font size for the Label
	 * @param labelShape The {@link ShapeInfo} to use for the Label
	 * @param labelBorder The {@link Border} to use for the Label
	 * @param rowPos The row position of this field
	 * @param colPos The column position of this field
	 * @param rowSpan The row span of this field
	 * @param colSpan The column span of this field
	 * @param logFontResourceLoaderWarnings Whether to log warnings generated by the FontResourceLoader
	 *                                      - can be ignored if you specify your own FontResourceLoader
	 * @param logger An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *               - can be ignored if you specify your own FontResourceLoader
	 * @param graphEnv The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *                 - can be ignored if you specify your own FontResourceLoader
	 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *                   - can be ignored if you specify your own FontResourceLoader
	 * @param fontResourceLoader The {@link FontResourceLoader} to use for fonts on this field
	 * @param stringFieldType The {@link StringFieldType type} of String field
	 * @param editable Whether this field can be edited or not
	 * @param columns Number of columns used to determine the width of this field
	 * @param stringBackgroundPaint The {@link SizablePaint paint} to use for the background of the String field
	 * @param stringForegroundPaint The {@link SizablePaint paint} to use for the foreground of the String field
	 * @param stringDisabledForegroundPaint The {@link SizablePaint paint} to use for the disabled foreground of the String field
	 */
	private StringFormField(String key, String defaultValue,
	                        LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                        FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                        ShapeInfo labelShape, Border labelBorder,
	                        int rowPos, int colPos, int rowSpan, int colSpan,
	                        boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                        String fontFolder, FontResourceLoader fontResourceLoader,
	                        StringFieldType stringFieldType, boolean editable, int columns,
	                        SizablePaint stringBackgroundPaint, SizablePaint stringForegroundPaint,
	                        SizablePaint stringDisabledForegroundPaint){
		super(FieldType.STRING, key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader);
		this.stringFieldType = stringFieldType;
		this.editable = editable;
		this.columns = columns;
		this.stringBackgroundPaint = stringBackgroundPaint;
		this.stringForegroundPaint = stringForegroundPaint;
		this.stringDisabledForegroundPaint = stringDisabledForegroundPaint;
	}
	
	/**
	 * @return A new {@link StringFormFieldBuilder} to use to make a {@link StringFormField}
	 */
	public static StringFormFieldBuilder builder(){
		return new StringFormFieldBuilder();
	}
	
	/**
	 * @return The {@link StringFieldType type} of String field
	 */
	public StringFieldType getStringFieldType(){
		return stringFieldType;
	}
	
	/**
	 * @return Whether this field can be edited or not
	 */
	public boolean isEditable(){
		return editable;
	}
	
	/**
	 * @return Number of columns used to determine the width of the field
	 */
	public int getColumns(){
		return columns;
	}
	
	/**
	 * @return The {@link SizablePaint paint} to use for the background of the String field
	 */
	public SizablePaint getStringBackgroundPaint(){
		return stringBackgroundPaint;
	}
	
	/**
	 * @return The {@link SizablePaint paint} to use for the foreground of the String field
	 */
	public SizablePaint getStringForegroundPaint(){
		return stringForegroundPaint;
	}
	
	/**
	 * @return The {@link SizablePaint paint} to use for the disabled foreground of the String field
	 */
	public SizablePaint getStringDisabledForegroundPaint(){
		return stringDisabledForegroundPaint;
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getJustComponent() throws IOException, FontFormatException{
		String value = getDefaultValue();
		
		// Create the appropriate text field type based on the String Field Type
		JTextField textField = null;
		switch(stringFieldType){
			case TITLE -> {
				return TadukooLabel.builder()
						.text(value)
						.backgroundPaint(stringBackgroundPaint)
						.foregroundPaint(stringForegroundPaint)
						.disabledForegroundPaint(stringDisabledForegroundPaint)
						.build();
			}
			case NORMAL -> textField = new JTextField();
			case PASSWORD -> textField = new JPasswordField();
		}
		
		// Set the text on the field if default value isn't blank
		if(StringUtil.isNotBlank(value)){
			textField.setText(value);
		}
		
		// Set editable
		textField.setEditable(editable);
		
		// Set columns if it's defined, or default to 25 if columns is not defined + default value is blank
		if(columns != -1){
			textField.setColumns(columns);
		}else if(StringUtil.isBlank(value)){
			textField.setColumns(25);
		}
		
		return textField;
	}
	
	/** {@inheritDoc} */
	@Override
	public String getValueFromJustComponent(JComponent component){
		if(component instanceof JLabel){
			return ((JLabel) component).getText();
		}else if(component instanceof JTextField){
			return ((JTextField) component).getText();
		}else{
			return null;
		}
	}
}
