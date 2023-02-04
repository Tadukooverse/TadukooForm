package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.SimpleForm;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import java.awt.GraphicsEnvironment;

/**
 * Abstract {@link FormField} used for {@link Number}s using {@link JSpinner}.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.2.1
 *
 * @param <Type> The type of {@link Number} being stored in the field (used for default, min, max, and step values)
 */
public abstract class NumberFormField<Type extends Number & Comparable<?>> extends FormField<Type>{
	
	/**
	 * Builder to be used to create a {@link NumberFormField}. This is the abstract version to be extended
	 * in subclasses of NumberFormField. It has the following parameters:
	 *
	 * <table>
	 *     <caption>FormField Parameters</caption>
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
	 *         <td>Defaults to 0 in implementations (defaults to null here, will cause errors)</td>
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
	 *         <td>minValue</td>
	 *         <td>The minimum value allowed for the field</td>
	 *         <td>Defaults to null (no minimum)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>maxValue</td>
	 *         <td>The maximum value allowed for the field</td>
	 *         <td>Defaults to null (no maximum)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>stepSize</td>
	 *         <td>The increment value for the spinner for the field</td>
	 *         <td>Defaults to 1 in implementations (no default here)</td>
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
	 * @since Alpha v.0.2.1
	 *
	 * @param <Type> The type of {@link Number} being stored in the field (used for default value)
	 */
	public static abstract class NumberFormFieldBuilder<Type extends Number & Comparable<?>>
			extends FormFieldBuilder<Type>{
		/** The minimum value allowed for the field */
		protected Type minValue = null;
		/** The maximum value allowed for the field */
		protected Type maxValue = null;
		/** The increment value for the spinner for the field */
		protected Type stepSize;
		
		/**
		 * Constructs a new NumberFormFieldBuilder (to be called in subclasses)
		 */
		protected NumberFormFieldBuilder(){
			super();
		}
		
		/**
		 * @param minValue The minimum value allowed for the field
		 * @return this, to continue building
		 */
		public NumberFormFieldBuilder<Type> minValue(Type minValue){
			this.minValue = minValue;
			return this;
		}
		
		/**
		 * @param maxValue The maximum value allowed for the field
		 * @return this, to continue building
		 */
		public NumberFormFieldBuilder<Type> maxValue(Type maxValue){
			this.maxValue = maxValue;
			return this;
		}
		
		/**
		 * @param stepSize The increment value for the spinner for the field
		 * @return this, to continue building
		 */
		public NumberFormFieldBuilder<Type> stepSize(Type stepSize){
			this.stepSize = stepSize;
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public abstract NumberFormField<Type> build();
	}
	
	/** The minimum value allowed for this field */
	private final Type minValue;
	/** The maximum value allowed for this field */
	private final Type maxValue;
	/** The increment value for the spinner for this field */
	private final Type stepSize;
	
	/**
	 * Creates a new NumberFormField with the given parameters.
	 *
	 * @param type The {@link FieldType} of this field
	 * @param key The name of this field (used as a key in {@link SimpleForm Forms})
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
	 * @param minValue The minimum value allowed for this field
	 * @param maxValue The maximum value allowed for this field
	 * @param stepSize The increment value for the spinner for this field
	 */
	protected NumberFormField(FieldType type, String key, Type defaultValue,
	                          LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                          FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                          ShapeInfo labelShape, Border labelBorder,
	                          int rowPos, int colPos, int rowSpan, int colSpan,
	                          boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                          String fontFolder, FontResourceLoader fontResourceLoader,
	                          Type minValue, Type maxValue, Type stepSize){
		super(type, key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader);
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.stepSize = stepSize;
	}
	
	/**
	 * @return The minimum value allowed for this field
	 */
	public Type getMinValue(){
		return minValue;
	}
	
	/**
	 * @return The maximum value allowed for this field
	 */
	public Type getMaxValue(){
		return maxValue;
	}
	
	/**
	 * @return The increment value for the spinner for this field
	 */
	public Type getStepSize(){
		return stepSize;
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getJustComponent(){
		return new JSpinner(new SpinnerNumberModel(getDefaultValue(), minValue, maxValue, stepSize));
	}
	
	/** {@inheritDoc} */
	@Override
	public Type getValueFromJustComponent(JComponent component){
		if(component instanceof JSpinner){
			return convertToType((Number) ((JSpinner) component).getValue());
		}
		return null;
	}
	
	/**
	 * Used in {@link #getValue(JComponent)} to convert the {@link Number} from the {@link JSpinner} into the
	 * type used in this particular FormField.
	 *
	 * @param number The {@link Number} we got from the {@link JSpinner}
	 * @return The number in its proper Type
	 */
	protected abstract Type convertToType(Number number);
}