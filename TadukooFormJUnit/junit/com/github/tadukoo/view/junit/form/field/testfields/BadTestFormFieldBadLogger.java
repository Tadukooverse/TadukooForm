package com.github.tadukoo.view.junit.form.field.testfields;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.GraphicsEnvironment;

/**
 * Test Form Field is a {@link FormField} that uses a String and is used for testing purposes
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public class BadTestFormFieldBadLogger extends TestFormField{
	
	/**
	 * Builder to be used to create a {@link BadTestFormField}. It has the following parameters:
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
	 *         <td>The name of the field (used as a key in forms)</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultValue</td>
	 *         <td>The starting value of the field</td>
	 *         <td>Defaults to {@link #DEFAULT_VALUE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelType</td>
	 *         <td>The {@link LabelType} to use for the field</td>
	 *         <td>Defaults to {@link #DEFAULT_LABEL_TYPE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelForegroundPaint</td>
	 *         <td>The {@link SizablePaint} for the foreground of the Label</td>
	 *         <td>Defaults to {@link #DEFAULT_LABEL_FOREGROUND_PAINT}</td>
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
	 */
	public static class BadTestFormFieldBuilder extends TestFormFieldBuilder{
		
		/** Can't create BadTestFormFieldBuilder outside BadTestFormField */
		private BadTestFormFieldBuilder(){
			super();
		}
		
		/*
		 * The Basics
		 */
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder defaultValue(String defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/*
		 * Label Settings
		 */
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder labelForegroundPaint(SizablePaint labelForegroundPaint){
			super.labelForegroundPaint(labelForegroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			super.labelBackgroundPaint(labelBackgroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder labelFont(FontFamily labelFontFamily, int labelFontStyle, int labelFontSize){
			super.labelFont(labelFontFamily, labelFontStyle, labelFontSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder labelShape(ShapeInfo labelShape){
			super.labelShape(labelShape);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder labelBorder(Border labelBorder){
			super.labelBorder(labelBorder);
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public BadTestFormFieldBadLogger build(){
			return new BadTestFormFieldBadLogger(key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, graphEnv,
					fontFolder, fontResourceLoader);
		}
	}
	
	/**
	 * Creates a new TestFormField with the given parameters
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
	 * @param graphEnv The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *                 - can be ignored if you specify your own FontResourceLoader
	 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *                   - can be ignored if you specify your own FontResourceLoader
	 * @param fontResourceLoader The {@link FontResourceLoader} to use for fonts on this field
	 */
	protected BadTestFormFieldBadLogger(
			String key, String defaultValue,
			LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
			FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
			ShapeInfo labelShape, Border labelBorder,
			int rowPos, int colPos, int rowSpan, int colSpan,
			boolean logFontResourceLoaderWarnings, GraphicsEnvironment graphEnv,
			String fontFolder, FontResourceLoader fontResourceLoader){
		super(key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, WRONG_LOGGER, graphEnv,
				fontFolder, fontResourceLoader);
	}
	
	/**
	 * @return A new {@link BadTestFormFieldBuilder} to use to make a {@link BadTestFormField}
	 */
	public static BadTestFormFieldBuilder builder(){
		return new BadTestFormFieldBuilder();
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getJustComponent(){
		return new JLabel(getDefaultValue());
	}
	
	/** {@inheritDoc} */
	@Override
	public String getValueFromJustComponent(JComponent component){
		if(component instanceof JLabel){
			return ((JLabel) component).getText();
		}else{
			return null;
		}
	}
}
