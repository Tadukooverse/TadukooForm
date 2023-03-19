package com.github.tadukoo.view.form.field.testutil.test.testfields;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.border.ShapedBevelBorder;
import com.github.tadukoo.view.border.ShapedEtchedBorder;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shapes;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Test Form Field is a {@link FormField} that uses a String and is used for testing purposes
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public class TestFormField extends FormField<String>{
	/** The {@link FieldType} used in this class */
	public static final FieldType FIELD_TYPE = FieldType.STRING;
	/** A {@link FieldType} to use as an incorrect {@link FieldType} */
	public static final FieldType WRONG_FIELD_TYPE = FieldType.BOOLEAN;
	/** A value to use for testing setting the key */
	public static final String TEST_KEY = "Test";
	/** A value to use in testing for a wrong key */
	public static final String WRONG_KEY = "Derp";
	/** The correct default value used in this class */
	public static final String DEFAULT_VALUE = "Derp";
	/** A value to use as a wrong default value */
	public static final String WRONG_DEFAULT_VALUE = "Blah";
	/** A value to use to test setting the default value */
	public static final String TEST_DEFAULT_VALUE = "Test";
	/** The default {@link LabelType} */
	public static final LabelType DEFAULT_LABEL_TYPE = LabelType.LABEL;
	/** A wrong value to use for testing {@link LabelType} */
	public static final LabelType WRONG_LABEL_TYPE = LabelType.NONE;
	/** A value to use for testing setting the {@link LabelType} */
	public static final LabelType TEST_LABEL_TYPE = LabelType.TITLED_BORDER;
	/** The default labelForegroundPaint value */
	public static final SizablePaint DEFAULT_LABEL_FOREGROUND_PAINT = new SizableColor(Color.RED);
	/** An incorrect labelForegroundPaint value for testing */
	public static final SizablePaint WRONG_LABEL_FOREGROUND_PAINT = new SizableColor(Color.BLUE);
	/** A labelForegroundPaint value to use for setting during testing */
	public static final SizablePaint TEST_LABEL_FOREGROUND_PAINT = new SizableColor(Color.YELLOW);
	/** The default labelBackgroundPaint value */
	public static final SizablePaint DEFAULT_LABEL_BACKGROUND_PAINT = new SizableColor(Color.GREEN);
	/** An incorrect labelBackgroundPaint value for testing */
	public static final SizablePaint WRONG_LABEL_BACKGROUND_PAINT = new SizableColor(Color.YELLOW);
	/** A labelBackgroundPaint value to use for setting during testing */
	public static final SizablePaint TEST_LABEL_BACKGROUND_PAINT = new SizableColor(Color.RED);
	/** The default {@link FontFamily} value */
	public static final FontFamily DEFAULT_LABEL_FONT_FAMILY = FontFamilies.CARLITO.getFamily();
	/** An incorrect {@link FontFamily} value for testing */
	public static final FontFamily WRONG_LABEL_FONT_FAMILY = FontFamilies.CALLIGRASERIF.getFamily();
	/** A {@link FontFamily} value to use for setting during testing */
	public static final FontFamily TEST_LABEL_FONT_FAMILY = FontFamilies.BANGERS.getFamily();
	/** The default font style value */
	public static final int DEFAULT_LABEL_FONT_STYLE = Font.BOLD;
	/** An incorrect font style value for testing */
	public static final int WRONG_LABEL_FONT_STYLE = Font.ITALIC;
	/** A font style value for setting during testing */
	public static final int TEST_LABEL_FONT_STYLE = Font.BOLD + Font.ITALIC;
	/** The default font size value */
	public static final int DEFAULT_LABEL_FONT_SIZE = 16;
	/** An incorrect font size value for testing */
	public static final int WRONG_LABEL_FONT_SIZE = 42;
	/** A font size value for setting during testing */
	public static final int TEST_LABEL_FONT_SIZE = 12;
	/** The default label {@link ShapeInfo} */
	public static final ShapeInfo DEFAULT_LABEL_SHAPE = Shapes.CIRCLE.getShapeInfo();
	/** An incorrect {@link ShapeInfo} to use for testing */
	public static final ShapeInfo WRONG_LABEL_SHAPE = Shapes.RECTANGLE.getShapeInfo();
	/** A label {@link ShapeInfo} to use for setting during testing */
	public static final ShapeInfo TEST_LABEL_SHAPE = Shapes.RECTANGLE_WITH_CUT_CORNERS_TL_BR.getShapeInfo();
	/** The default label {@link Border} */
	public static final Border DEFAULT_LABEL_BORDER = ShapedLineBorder.builder().build();
	/** An incorrect {@link Border} to use for testing */
	public static final Border WRONG_LABEL_BORDER = ShapedEtchedBorder.builder().build();
	/** A label {@link Border} to use for setting during testing */
	public static final Border TEST_LABEL_BORDER = ShapedBevelBorder.builder().build();
	/** An incorrect row pos to use for testing */
	public static final int WRONG_ROW_POS = 47;
	/** A row pos value to use for setting during testing */
	public static final int TEST_ROW_POS = 2;
	/** An incorrect col pos to use for testing */
	public static final int WRONG_COL_POS = 27;
	/** A col pos value to use for setting during testing */
	public static final int TEST_COL_POS = 3;
	/** The default row span value */
	public static final int DEFAULT_ROW_SPAN = 2;
	/** An incorrect row span value for testing */
	public static final int WRONG_ROW_SPAN = 7;
	/** A row span value to use for setting during testing */
	public static final int TEST_ROW_SPAN = 3;
	/** The default col span value */
	public static final int DEFAULT_COL_SPAN = 3;
	/** An incorrect col span value for testing */
	public static final int WRONG_COL_SPAN = 16;
	/** A col span value to use for setting during testing */
	public static final int TEST_COL_SPAN = 2;
	/** The default logFontResourceLoaderWarnings value */
	public static final boolean DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS = false;
	/** An incorrect logFontResourceLoaderWarnings value */
	public static final boolean WRONG_LOG_FONT_RESOURCE_LOADER_WARNINGS = true;
	/** A logFontResourceLoaderWarnings value for setting during testing */
	public static final boolean TEST_LOG_FONT_RESOURCE_LOADER_WARNINGS = true;
	/** The default {@link EasyLogger} value */
	public static final EasyLogger DEFAULT_LOGGER = null;
	/** An incorrect {@link EasyLogger} value to use for testing */
	public static final EasyLogger WRONG_LOGGER;
	/** A {@link EasyLogger} value to use for setting during testing */
	public static final EasyLogger TEST_LOGGER;
	static{
		try{
			WRONG_LOGGER = new EasyLogger(LoggerUtil.createFileLogger(
					"target/garbo/test2-" + System.currentTimeMillis() + ".log", Level.OFF));
			TEST_LOGGER = new EasyLogger(LoggerUtil.createFileLogger(
					"target/garbo/test-" + System.currentTimeMillis() + ".log", Level.OFF));
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	/** The default {@link GraphicsEnvironment} value */
	public static final GraphicsEnvironment DEFAULT_GRAPH_ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	/** An incorrect {@link GraphicsEnvironment} value to use for testing */
	public static final GraphicsEnvironment WRONG_GRAPH_ENV = null;
	/** A {@link GraphicsEnvironment} value to use for setting for testing */
	public static final GraphicsEnvironment TEST_GRAPH_ENV = null;
	/** The default font folder value */
	public static final String DEFAULT_FONT_FOLDER = "test_fonts";
	/** An incorrect font folder value */
	public static final String WRONG_FONT_FOLDER = "wrong_fonts";
	/** A font folder value to use for setting during testing */
	public static final String TEST_FONT_FOLDER = "derp_fonts";
	/** The default {@link FontResourceLoader} value */
	public static final FontResourceLoader DEFAULT_FONT_RESOURCE_LOADER = new FontResourceLoader(
			false, null, GraphicsEnvironment.getLocalGraphicsEnvironment(), "test");
	/** An incorrect {@link FontResourceLoader} value */
	public static final FontResourceLoader WRONG_FONT_RESOURCE_LOADER = null;
	/** A {@link FontResourceLoader} value to use for setting during testing */
	public static final FontResourceLoader TEST_FONT_RESOURCE_LOADER = new FontResourceLoader(
			false, null, null, "yep");
	
	/** A good component to be used in testing */
	public static final JComponent GOOD_COMPONENT = new JLabel(DEFAULT_VALUE);
	/** A bad component to be used in testing */
	public static final JComponent BAD_COMPONENT = new JTextField(WRONG_DEFAULT_VALUE);
	
	/** The default editable value */
	public static final Boolean DEFAULT_EDITABLE = true;
	/** An incorrect editable value for testing */
	public static final Boolean WRONG_EDITABLE = null;
	/** An editable value to use for setting during testing */
	public static final Boolean TEST_EDITABLE = false;
	
	/**
	 * Builder to be used to create a {@link TestFormField}. It has the following parameters:
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
	 *         <td>Defaults to {@link #DEFAULT_LABEL_BACKGROUND_PAINT}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelFont</td>
	 *         <td>The Font to use for the Label - specified as a {@link FontFamily}, style, and size</td>
	 *         <td>Defaults to {@link #DEFAULT_LABEL_FONT_FAMILY}, {@link #DEFAULT_LABEL_FONT_STYLE},
	 *         and {@link #DEFAULT_LABEL_FONT_SIZE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelShape</td>
	 *         <td>The {@link ShapeInfo} to use for the Label</td>
	 *         <td>Defaults to {@link #DEFAULT_LABEL_SHAPE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelBorder</td>
	 *         <td>The {@link Border} to use for the Label</td>
	 *         <td>Defaults to {@link #DEFAULT_LABEL_BORDER}</td>
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
	 *         <td>Defaults to {@link #DEFAULT_ROW_SPAN}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>colSpan</td>
	 *         <td>The column span of the field</td>
	 *         <td>Defaults to {@link #DEFAULT_COL_SPAN}</td>
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
	 *         <td>{@link #DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>logger</td>
	 *         <td>An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>{@link #DEFAULT_LOGGER}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>graphEnv</td>
	 *         <td>The {@link GraphicsEnvironment} to load fonts to in the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>{@link #DEFAULT_GRAPH_ENV}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fontFolder</td>
	 *         <td>The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>{@link #DEFAULT_FONT_FOLDER}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fontResourceLoader</td>
	 *         <td>The {@link FontResourceLoader} to use in loading fonts and/or ensuring they're in the system</td>
	 *         <td>{@link #DEFAULT_FONT_RESOURCE_LOADER}</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.4
	 */
	public static class TestFormFieldBuilder extends FormFieldBuilder<String>{
		/** Whether the field can be edited or not */
		private Boolean editable = DEFAULT_EDITABLE;
		
		/** Can't create TestFormFieldBuilder outside TestFormField */
		protected TestFormFieldBuilder(){
			super();
			defaultValue = DEFAULT_VALUE;
			labelType = DEFAULT_LABEL_TYPE;
			labelForegroundPaint = DEFAULT_LABEL_FOREGROUND_PAINT;
			labelBackgroundPaint = DEFAULT_LABEL_BACKGROUND_PAINT;
			labelFontFamily = DEFAULT_LABEL_FONT_FAMILY;
			labelFontStyle = DEFAULT_LABEL_FONT_STYLE;
			labelFontSize = DEFAULT_LABEL_FONT_SIZE;
			labelShape = DEFAULT_LABEL_SHAPE;
			labelBorder = DEFAULT_LABEL_BORDER;
			rowSpan = DEFAULT_ROW_SPAN;
			colSpan = DEFAULT_COL_SPAN;
			logFontResourceLoaderWarnings = DEFAULT_LOG_FONT_RESOURCE_LOADER_WARNINGS;
			logger = DEFAULT_LOGGER;
			graphEnv = DEFAULT_GRAPH_ENV;
			fontFolder = DEFAULT_FONT_FOLDER;
			fontResourceLoader = DEFAULT_FONT_RESOURCE_LOADER;
		}
		
		/*
		 * The Basics
		 */
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder defaultValue(String defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/*
		 * Label Settings
		 */
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder labelForegroundPaint(SizablePaint labelForegroundPaint){
			super.labelForegroundPaint(labelForegroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			super.labelBackgroundPaint(labelBackgroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder labelFont(FontFamily labelFontFamily, int labelFontStyle, int labelFontSize){
			super.labelFont(labelFontFamily, labelFontStyle, labelFontSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder labelShape(ShapeInfo labelShape){
			super.labelShape(labelShape);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder labelBorder(Border labelBorder){
			super.labelBorder(labelBorder);
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/**
		 * @param editable Whether this field is editable or not
		 * @return this, to continue building
		 */
		public TestFormFieldBuilder editable(Boolean editable){
			this.editable = editable;
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public TestFormField build(){
			return new TestFormField(key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader, editable);
		}
	}
	
	/** Whether this field is editable or not */
	private final Boolean editable;
	
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
	 * @param logger An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *               - can be ignored if you specify your own FontResourceLoader
	 * @param graphEnv The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *                 - can be ignored if you specify your own FontResourceLoader
	 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *                   - can be ignored if you specify your own FontResourceLoader
	 * @param fontResourceLoader The {@link FontResourceLoader} to use for fonts on this field
	 */
	protected TestFormField(String key, String defaultValue,
	                        LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                        FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                        ShapeInfo labelShape, Border labelBorder,
	                        int rowPos, int colPos, int rowSpan, int colSpan,
	                        boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                        String fontFolder, FontResourceLoader fontResourceLoader){
		super(FIELD_TYPE, key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader);
		this.editable = null;
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
	 * @param logger An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *               - can be ignored if you specify your own FontResourceLoader
	 * @param graphEnv The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *                 - can be ignored if you specify your own FontResourceLoader
	 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *                   - can be ignored if you specify your own FontResourceLoader
	 * @param fontResourceLoader The {@link FontResourceLoader} to use for fonts on this field
	 * @param editable Whether this field is editable or not
	 */
	protected TestFormField(String key, String defaultValue,
	                        LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                        FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                        ShapeInfo labelShape, Border labelBorder,
	                        int rowPos, int colPos, int rowSpan, int colSpan,
	                        boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                        String fontFolder, FontResourceLoader fontResourceLoader,
	                        Boolean editable){
		super(FIELD_TYPE, key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader);
		this.editable = editable;
	}
	
	/**
	 * @return A new {@link TestFormFieldBuilder} to use to make a {@link TestFormField}
	 */
	public static TestFormFieldBuilder builder(){
		return new TestFormFieldBuilder();
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
	
	/**
	 * @return Whether this field is editable or not
	 */
	public Boolean isEditable(){
		return editable;
	}
}
