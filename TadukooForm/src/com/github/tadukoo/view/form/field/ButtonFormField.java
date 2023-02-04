package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.components.TadukooButton;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.SimpleForm;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Button Form Field is a {@link FormField} that is just a button
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.2
 */
public class ButtonFormField extends FormField<String>{
	
	/**
	 * Builder to be used to create a {@link ButtonFormField}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>ButtonFormField Parameters</caption>
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
	 *         <td>Defaults to {@link LabelType#NONE}</td>
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
	 *         <td>actionListener</td>
	 *         <td>The action to perform on click of the Button</td>
	 *         <td>Defaults to null (no action)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonForegroundPaint</td>
	 *         <td>The {@link SizablePaint} to use for the foreground of the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button foreground paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonBackgroundPaint</td>
	 *         <td>The {@link SizablePaint} to use for the background of the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button background paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonSelectPaint</td>
	 *         <td>The {@link SizablePaint} to use for when the Button is selected</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button select paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonFocusPaint</td>
	 *         <td>The {@link SizablePaint} to use for when the Button is focused</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button focus paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonDisabledTextPaint</td>
	 *         <td>The {@link SizablePaint} to use for disabled text on the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button disabled text paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonFont</td>
	 *         <td>The {@link Font} to use on the Button (specified via {@link FontFamily}, font style,
	 *         and font size</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button font)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonBorder</td>
	 *         <td>The {@link Border} to use on the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button border)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>buttonShape</td>
	 *         <td>The {@link ShapeInfo} to use on the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button shape)</td>
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
	public static class ButtonFormFieldBuilder extends FormFieldBuilder<String>{
		/** The action to perform on click of the Button */
		private ActionListener actionListener = null;
		
		/** The {@link SizablePaint} to use for the foreground of the Button */
		private SizablePaint buttonForegroundPaint = null;
		/** The {@link SizablePaint} to use for the background of the Button */
		private SizablePaint buttonBackgroundPaint = null;
		/** The {@link SizablePaint} to use for when the Button is selected */
		private SizablePaint buttonSelectPaint = null;
		/** The {@link SizablePaint} to use for when the Button is focused */
		private SizablePaint buttonFocusPaint = null;
		/** The {@link SizablePaint} to use for disabled text on the Button */
		private SizablePaint buttonDisabledTextPaint = null;
		
		/** The {@link FontFamily} to use on the font of the Button */
		private FontFamily buttonFontFamily = null;
		/** The font style to use on the font of the Button */
		private int buttonFontStyle = -1;
		/** The font size to use on the font of the Button */
		private int buttonFontSize = -1;
		/** The {@link Border} to use on the Button */
		private Border buttonBorder = null;
		/** The {@link ShapeInfo} to use on the Button */
		private ShapeInfo buttonShape = null;
		
		/** Not allowed to create ButtonFormFieldBuilder outside of ButtonFormField */
		private ButtonFormFieldBuilder(){
			super();
			labelType = LabelType.NONE;
		}
		
		/*
		 * The Basics
		 */
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder defaultValue(String defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/*
		 * Label Settings
		 */
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder labelForegroundPaint(SizablePaint labelForegroundPaint){
			super.labelForegroundPaint(labelForegroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			super.labelBackgroundPaint(labelBackgroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder labelFont(FontFamily labelFontFamily, int labelFontStyle, int labelFontSize){
			super.labelFont(labelFontFamily, labelFontStyle, labelFontSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder labelShape(ShapeInfo labelShape){
			super.labelShape(labelShape);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder labelBorder(Border labelBorder){
			super.labelBorder(labelBorder);
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/*
		 * Button Specific Methods
		 */
		
		/**
		 * @param actionListener The action to perform on click of the Button
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder actionListener(ActionListener actionListener){
			this.actionListener = actionListener;
			return this;
		}
		
		/**
		 * @param buttonForegroundPaint The {@link SizablePaint} to use for the foreground of the Button
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonForegroundPaint(SizablePaint buttonForegroundPaint){
			this.buttonForegroundPaint = buttonForegroundPaint;
			return this;
		}
		
		/**
		 * @param buttonBackgroundPaint The {@link SizablePaint} to use for the background of the Button
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonBackgroundPaint(SizablePaint buttonBackgroundPaint){
			this.buttonBackgroundPaint = buttonBackgroundPaint;
			return this;
		}
		
		/**
		 * @param buttonSelectPaint The {@link SizablePaint} to use for when the Button is selected
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonSelectPaint(SizablePaint buttonSelectPaint){
			this.buttonSelectPaint = buttonSelectPaint;
			return this;
		}
		
		/**
		 * @param buttonFocusPaint The {@link SizablePaint} to use for when the Button is focused
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonFocusPaint(SizablePaint buttonFocusPaint){
			this.buttonFocusPaint = buttonFocusPaint;
			return this;
		}
		
		/**
		 * @param buttonDisabledTextPaint The {@link SizablePaint} to use for disabled text on the Button
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonDisabledTextPaint(SizablePaint buttonDisabledTextPaint){
			this.buttonDisabledTextPaint = buttonDisabledTextPaint;
			return this;
		}
		
		/**
		 * Specifies the font to use on the Button
		 *
		 * @param buttonFontFamily The {@link FontFamily} to use
		 * @param buttonFontStyle The font style to use
		 * @param buttonFontSize The font size to use
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonFont(FontFamily buttonFontFamily, int buttonFontStyle, int buttonFontSize){
			this.buttonFontFamily = buttonFontFamily;
			this.buttonFontStyle = buttonFontStyle;
			this.buttonFontSize = buttonFontSize;
			return this;
		}
		
		/**
		 * @param buttonBorder The {@link Border} to use on the Button
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonBorder(Border buttonBorder){
			this.buttonBorder = buttonBorder;
			return this;
		}
		
		/**
		 * @param buttonShape The {@link ShapeInfo} to use on the Button
		 * @return this, to continue building
		 */
		public ButtonFormFieldBuilder buttonShape(ShapeInfo buttonShape){
			this.buttonShape = buttonShape;
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public ButtonFormField build(){
			return new ButtonFormField(key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					actionListener,
					buttonForegroundPaint, buttonBackgroundPaint,
					buttonSelectPaint, buttonFocusPaint, buttonDisabledTextPaint,
					buttonFontFamily, buttonFontStyle, buttonFontSize,
					buttonBorder, buttonShape);
		}
	}
	
	/** The action to perform on click of the Button */
	private final ActionListener actionListener;
	/** The {@link SizablePaint} to use for the foreground of the Button */
	private final SizablePaint buttonForegroundPaint;
	/** The {@link SizablePaint} to use for the background of the Button */
	private final SizablePaint buttonBackgroundPaint;
	/** The {@link SizablePaint} to use for when the Button is selected */
	private final SizablePaint buttonSelectPaint;
	/** The {@link SizablePaint} to use for when the Button is focused */
	private final SizablePaint buttonFocusPaint;
	/** The {@link SizablePaint} to use for disabled text on the Button */
	private final SizablePaint buttonDisabledTextPaint;
	/** The {@link FontFamily} to use on the font of the Button */
	private final FontFamily buttonFontFamily;
	/** The font style to use on the font of the Button */
	private final int buttonFontStyle;
	/** The font size to use on the font of the Button */
	private final int buttonFontSize;
	/** The {@link Border} to use on the Button */
	private final Border buttonBorder;
	/** The {@link ShapeInfo} to use on the Button */
	private final ShapeInfo buttonShape;
	
	/**
	 * Creates a new ButtonFormField with the given parameters
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
	 * @param actionListener The action to perform on click of the Button
	 * @param buttonForegroundPaint The {@link SizablePaint} to use for the foreground of the Button
	 * @param buttonBackgroundPaint The {@link SizablePaint} to use for the background of the Button
	 * @param buttonSelectPaint The {@link SizablePaint} to use for when the Button is selected
	 * @param buttonFocusPaint The {@link SizablePaint} to use for when the Button is focused
	 * @param buttonDisabledTextPaint The {@link SizablePaint} to use for disabled text on the Button
	 * @param buttonFontFamily The {@link FontFamily} to use on the font of the Button
	 * @param buttonFontStyle The font style to use on the font of the Button
	 * @param buttonFontSize The font size to use on the font of the Button
	 * @param buttonBorder The {@link Border} to use on the Button
	 * @param buttonShape The {@link ShapeInfo} to use on the Button
	 */
	private ButtonFormField(String key, String defaultValue,
	                        LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                        FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                        ShapeInfo labelShape, Border labelBorder,
	                        int rowPos, int colPos, int rowSpan, int colSpan,
	                        boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                        String fontFolder, FontResourceLoader fontResourceLoader,
	                        ActionListener actionListener,
	                        SizablePaint buttonForegroundPaint, SizablePaint buttonBackgroundPaint,
	                        SizablePaint buttonSelectPaint, SizablePaint buttonFocusPaint,
	                        SizablePaint buttonDisabledTextPaint,
	                        FontFamily buttonFontFamily, int buttonFontStyle, int buttonFontSize,
	                        Border buttonBorder, ShapeInfo buttonShape){
		super(FieldType.BUTTON, key, defaultValue,
				labelType,labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader);
		this.actionListener = actionListener;
		this.buttonForegroundPaint = buttonForegroundPaint;
		this.buttonBackgroundPaint = buttonBackgroundPaint;
		this.buttonSelectPaint = buttonSelectPaint;
		this.buttonFocusPaint = buttonFocusPaint;
		this.buttonDisabledTextPaint = buttonDisabledTextPaint;
		this.buttonFontFamily = buttonFontFamily;
		this.buttonFontStyle = buttonFontStyle;
		this.buttonFontSize = buttonFontSize;
		this.buttonBorder = buttonBorder;
		this.buttonShape = buttonShape;
	}
	
	/**
	 * @return A new {@link ButtonFormFieldBuilder} to use to make a {@link ButtonFormField}
	 */
	public static ButtonFormFieldBuilder builder(){
		return new ButtonFormFieldBuilder();
	}
	
	/**
	 * @return The action to perform on click of the Button
	 */
	public ActionListener getActionListener(){
		return actionListener;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for the foreground of the Button
	 */
	public SizablePaint getButtonForegroundPaint(){
		return buttonForegroundPaint;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for the background of the Button
	 */
	public SizablePaint getButtonBackgroundPaint(){
		return buttonBackgroundPaint;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for when the Button is selected
	 */
	public SizablePaint getButtonSelectPaint(){
		return buttonSelectPaint;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for when the Button is focused
	 */
	public SizablePaint getButtonFocusPaint(){
		return buttonFocusPaint;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for disabled text on the Button
	 */
	public SizablePaint getButtonDisabledTextPaint(){
		return buttonDisabledTextPaint;
	}
	
	/**
	 * @return The {@link FontFamily} to use on the font of the Button
	 */
	public FontFamily getButtonFontFamily(){
		return buttonFontFamily;
	}
	
	/**
	 * @return The font style to use on the font of the Button
	 */
	public int getButtonFontStyle(){
		return buttonFontStyle;
	}
	
	/**
	 * @return The font size to use on the font of the Button
	 */
	public int getButtonFontSize(){
		return buttonFontSize;
	}
	
	/**
	 * @return The {@link Border} to use on the Button
	 */
	public Border getButtonBorder(){
		return buttonBorder;
	}
	
	/**
	 * @return The {@link ShapeInfo} to use on the Button
	 */
	public ShapeInfo getButtonShape(){
		return buttonShape;
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getJustComponent() throws IOException, FontFormatException{
		return TadukooButton.builder()
				.text(getKey())
				.actionListener(actionListener)
				.foregroundPaint(buttonForegroundPaint).backgroundPaint(buttonBackgroundPaint)
				.selectPaint(buttonSelectPaint).focusPaint(buttonFocusPaint).disabledTextPaint(buttonDisabledTextPaint)
				.font(buttonFontFamily, buttonFontStyle, buttonFontSize)
				.border(buttonBorder).shapeInfo(buttonShape)
				.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings()).logger(getLogger())
				.graphEnv(getGraphEnv()).fontFolder(getFontFolder()).fontResourceLoader(getFontResourceLoader())
				.build();
	}
	
	/** {@inheritDoc} */
	@Override
	public String getValueFromJustComponent(JComponent component){
		return null;
	}
}
