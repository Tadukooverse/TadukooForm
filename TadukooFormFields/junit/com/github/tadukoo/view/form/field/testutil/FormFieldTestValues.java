package com.github.tadukoo.view.form.field.testutil;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.util.logger.EasyLogger;
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
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

/**
 * The values to use for testing the basics of a {@link FormField}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @param <Type> The type to use for the value stored in the {@link FormField} this is used for
 */
public class FormFieldTestValues<Type>{
	
	/**
	 * A builder used to build a {@link FormFieldTestValues} object. It takes the following parameters:
	 *
	 * <table>
	 *     <caption>Form Field Test Values Parameters</caption>
	 *     <tr>
	 *         <th>Parameter Name</th>
	 *         <th>Description</th>
	 *         <th>Default or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>fieldType</td>
	 *         <td>The default {@link FieldType} to use</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testKey</td>
	 *         <td>The key to use for testing setting it</td>
	 *         <td>Defaults to "Test"</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultValue</td>
	 *         <td>The default default value to use</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testDefaultValue</td>
	 *         <td>The default value to use for testing setting it</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelType</td>
	 *         <td>The default {@link LabelType} to use</td>
	 *         <td>Defaults to {@link LabelType#LABEL}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelForegroundPaint</td>
	 *         <td>The default {@link SizablePaint} to use for the label foreground</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelBackgroundPaint</td>
	 *         <td>The default {@link SizablePaint} to use for the label background</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelFontFamily</td>
	 *         <td>The default {@link FontFamily} to use for the label</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelFontStyle</td>
	 *         <td>The default font style to use for the label</td>
	 *         <td>Defaults to -1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelFontSize</td>
	 *         <td>The default font size to use for the label</td>
	 *         <td>Defaults to -1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelShape</td>
	 *         <td>The default {@link ShapeInfo Shape} to use for the label</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLabelBorder</td>
	 *         <td>The default {@link Border} to use for the label</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *      <tr>
	 *         <td>testLabelType</td>
	 *         <td>The {@link LabelType} to use to test setting it</td>
	 *         <td>Defaults to {@link LabelType#TITLED_BORDER}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelForegroundPaint</td>
	 *         <td>The {@link SizablePaint} to use for the label foreground to test setting it</td>
	 *         <td>Defaults to a {@link SizableColor} with {@link Color#RED}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelBackgroundPaint</td>
	 *         <td>The {@link SizablePaint} to use for the label background to test setting it</td>
	 *         <td>Defaults to a {@link SizableColor} with {@link Color#BLUE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelFontFamily</td>
	 *         <td>The {@link FontFamily} to use for the label to test setting it</td>
	 *         <td>Defaults to {@link FontFamilies#DIALOG}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelFontStyle</td>
	 *         <td>The font style to use for the label to test setting it</td>
	 *         <td>Defaults to {@link Font#BOLD}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelFontSize</td>
	 *         <td>The font size to use for the label to test setting it</td>
	 *         <td>Defaults to 27</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelShape</td>
	 *         <td>The {@link ShapeInfo Shape} to use for the label to test setting it</td>
	 *         <td>Defaults to {@link Shapes#CIRCLE}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLabelBorder</td>
	 *         <td>The {@link Border} to use for the label to test setting it</td>
	 *         <td>Defaults to a {@link ShapedLineBorder}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultRowSpan</td>
	 *         <td>The default row span to use</td>
	 *         <td>Defaults to 1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultColSpan</td>
	 *         <td>The default column span to use</td>
	 *         <td>Defaults to 1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testRowPos</td>
	 *         <td>The row position to use to test setting it</td>
	 *         <td>Defaults to 2</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testColPos</td>
	 *         <td>The column position to use to test setting it</td>
	 *         <td>Defaults to 5</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testRowSpan</td>
	 *         <td>The row span to use to test setting it</td>
	 *         <td>Defaults to 3</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testColSpan</td>
	 *         <td>The column span to use to test setting it</td>
	 *         <td>Defaults to 7</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLogFontResourceLoaderWarnings</td>
	 *         <td>The default logFontResourceLoaderWarnings value</td>
	 *         <td>Defaults to {@code false}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultLogger</td>
	 *         <td>The default {@link EasyLogger logger} to use</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultGraphEnv</td>
	 *         <td>The default {@link GraphicsEnvironment} to use</td>
	 *         <td>Defaults to {@link GraphicsEnvironment#getLocalGraphicsEnvironment()}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultFontFolder</td>
	 *         <td>The default font folder location</td>
	 *         <td>Defaults to fonts/</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultFontResourceLoader</td>
	 *         <td>The default {@link FontResourceLoader} to use</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLogFontResourceLoaderWarnings</td>
	 *         <td>The logFontResourceLoaderWarnings value to test setting it</td>
	 *         <td>Defaults to {@code true}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testLogger</td>
	 *         <td>The {@link EasyLogger logger} to use to test setting it</td>
	 *         <td>Defaults to a dummy {@link EasyLogger logger}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testGraphEnv</td>
	 *         <td>The {@link GraphicsEnvironment} to use to test setting it</td>
	 *         <td>Defaults to {@code null}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testFontFolder</td>
	 *         <td>The font folder location to test setting it</td>
	 *         <td>Defaults to testing/</td>
	 *     </tr>
	 *     <tr>
	 *         <td>testFontResourceLoader</td>
	 *         <td>The {@link FontResourceLoader} to use to test setting it</td>
	 *         <td>Defaults to a dummy {@link FontResourceLoader}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>goodComponent</td>
	 *         <td>A {@link JComponent} that the correct default value can be retrieved from</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>badComponent</td>
	 *         <td>A {@link JComponent} that does not match the proper expected {@link JComponent} for getValue</td>
	 *         <td>Defaults to a {@link JLabel} with "Derp" as the value</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.4
	 * @param <Type> The type to use for the value stored in the {@link FormField} this is used for
	 */
	public static class FormFieldTestValuesBuilder<Type>{
		/*
		 * The Basics
		 */
		/** The default {@link FieldType} to use */
		private FieldType fieldType = null;
		/** The key to use for testing setting it */
		private String testKey = "Test";
		/** The default default value to use */
		private Type defaultValue = null;
		/** The default value to use for testing setting it */
		private Type testDefaultValue = null;
		
		/*
		 * Label Options
		 */
		/** The default {@link LabelType} to use */
		private LabelType defaultLabelType = LabelType.LABEL;
		/** The default {@link SizablePaint} to use for the label foreground */
		private SizablePaint defaultLabelForegroundPaint = null;
		/** The default {@link SizablePaint} to use for the label background */
		private SizablePaint defaultLabelBackgroundPaint = null;
		/** The default {@link FontFamily} to use for the label */
		private FontFamily defaultLabelFontFamily = null;
		/** The default font style to use for the label */
		private int defaultLabelFontStyle = -1;
		/** The default font size to use for the label */
		private int defaultLabelFontSize = -1;
		/** The default {@link ShapeInfo Shape} to use for the label */
		private ShapeInfo defaultLabelShape = null;
		/** The default {@link Border} to use for the label */
		private Border defaultLabelBorder = null;
		/** The {@link LabelType} to use for testing setting it */
		private LabelType testLabelType = LabelType.TITLED_BORDER;
		/** The {@link SizablePaint} to use for testing setting the label foreground */
		private SizablePaint testLabelForegroundPaint = new SizableColor(Color.RED);
		/** The {@link SizablePaint} to use for testing setting the label background */
		private SizablePaint testLabelBackgroundPaint = new SizableColor(Color.BLUE);
		/** The {@link FontFamily} to use for the label to test setting it */
		private FontFamily testLabelFontFamily = FontFamilies.DIALOG.getFamily();
		/** The font style to use for the label to test setting it */
		private int testLabelFontStyle = Font.BOLD;
		/** The font size to use for the label to test setting it */
		private int testLabelFontSize = 27;
		/** The {@link ShapeInfo Shape} to use for the label to test setting it */
		private ShapeInfo testLabelShape = Shapes.CIRCLE.getShapeInfo();
		/** The {@link Border} to use for the label to test setting it */
		private Border testLabelBorder = ShapedLineBorder.builder().build();
		
		/*
		 * Positioning
		 */
		/** The default row span to use */
		private int defaultRowSpan = 1;
		/** The default column span to use */
		private int defaultColSpan = 1;
		/** The row position to use to test setting it */
		private int testRowPos = 2;
		/** The column position to use to test setting it */
		private int testColPos = 5;
		/** The row span to use to test setting it */
		private int testRowSpan = 3;
		/** The column span to use to test setting it */
		private int testColSpan = 7;
		
		/*
		 * Font Resource Loading
		 */
		/** The default logFontResourceLoaderWarnings value */
		private boolean defaultLogFontResourceLoaderWarnings = false;
		/** The default {@link EasyLogger logger} to use */
		private EasyLogger defaultLogger = null;
		/** The default {@link GraphicsEnvironment} to use */
		private GraphicsEnvironment defaultGraphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		/** The default fonts folder path */
		private String defaultFontFolder = "fonts/";
		/** The default {@link FontResourceLoader} to use */
		private FontResourceLoader defaultFontResourceLoader = null;
		/** The logFontResourceLoaderWarnings value to test setting it */
		private boolean testLogFontResourceLoaderWarnings = true;
		/** The {@link EasyLogger logger} to use to test setting it */
		private EasyLogger testLogger = new EasyLogger(LoggerUtil.createFileLogger(
				"target/garbo/test-" + System.currentTimeMillis() + ".log", Level.OFF));
		/** The {@link GraphicsEnvironment} to use to test setting it*/
		private GraphicsEnvironment testGraphEnv = null;
		/** The fonts folder path  to test setting it */
		private String testFontFolder = "testing/";
		/** The {@link FontResourceLoader} to use to test setting it */
		private FontResourceLoader testFontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		
		/*
		 * Components
		 */
		/** A {@link JComponent} that the correct default value can be retrieved from */
		private JComponent goodComponent = null;
		/** A {@link JComponent} that does not match the proper expected {@link JComponent} for getValue */
		private JComponent badComponent = new JLabel("Derp");
		
		/** Not allowed to instantiate outside of {@link FormFieldTestValues} */
		private FormFieldTestValuesBuilder() throws IOException{ }
		
		/*
		 * The Basics
		 */
		
		/**
		 * @param fieldType The default {@link FieldType} to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> fieldType(FieldType fieldType){
			this.fieldType = fieldType;
			return this;
		}
		
		/**
		 * @param testKey The key to use for testing setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testKey(String testKey){
			this.testKey = testKey;
			return this;
		}
		
		/**
		 * @param defaultValue The default default value to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultValue(Type defaultValue){
			this.defaultValue = defaultValue;
			return this;
		}
		
		/**
		 * @param testDefaultValue The default value to use for testing setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testDefaultValue(Type testDefaultValue){
			this.testDefaultValue = testDefaultValue;
			return this;
		}
		
		/*
		 * Label Options
		 */
		
		/**
		 * @param defaultLabelType The default {@link LabelType} to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelType(LabelType defaultLabelType){
			this.defaultLabelType = defaultLabelType;
			return this;
		}
		
		/**
		 * @param defaultLabelForegroundPaint The default {@link SizablePaint} to use for the label foreground
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelForegroundPaint(SizablePaint defaultLabelForegroundPaint){
			this.defaultLabelForegroundPaint = defaultLabelForegroundPaint;
			return this;
		}
		
		/**
		 * @param defaultLabelBackgroundPaint The default {@link SizablePaint} to use for the label background
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelBackgroundPaint(SizablePaint defaultLabelBackgroundPaint){
			this.defaultLabelBackgroundPaint = defaultLabelBackgroundPaint;
			return this;
		}
		
		/**
		 * Sets the default label font settings
		 *
		 * @param defaultLabelFontFamily The default {@link FontFamily} to use for the label
		 * @param defaultLabelFontStyle The default font style to use for the label
		 * @param defaultLabelFontSize The default font size to use for the label
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelFont(
				FontFamily defaultLabelFontFamily, int defaultLabelFontStyle, int defaultLabelFontSize){
			this.defaultLabelFontFamily = defaultLabelFontFamily;
			this.defaultLabelFontStyle = defaultLabelFontStyle;
			this.defaultLabelFontSize = defaultLabelFontSize;
			return this;
		}
		
		/**
		 * @param defaultLabelFontFamily The default {@link FontFamily} to use for the label
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelFontFamily(FontFamily defaultLabelFontFamily){
			this.defaultLabelFontFamily = defaultLabelFontFamily;
			return this;
		}
		
		/**
		 * @param defaultLabelFontStyle The default font style to use for the label
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelFontStyle(int defaultLabelFontStyle){
			this.defaultLabelFontStyle = defaultLabelFontStyle;
			return this;
		}
		
		/**
		 * @param defaultLabelFontSize The default font size to use for the label
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelFontSize(int defaultLabelFontSize){
			this.defaultLabelFontSize = defaultLabelFontSize;
			return this;
		}
		
		/**
		 * @param defaultLabelShape The default {@link ShapeInfo Shape} to use for the label
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelShape(ShapeInfo defaultLabelShape){
			this.defaultLabelShape = defaultLabelShape;
			return this;
		}
		
		/**
		 * @param defaultLabelBorder The default {@link Border} to use for the label
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLabelBorder(Border defaultLabelBorder){
			this.defaultLabelBorder = defaultLabelBorder;
			return this;
		}
		
		/**
		 * @param testLabelType The {@link LabelType} to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelType(LabelType testLabelType){
			this.testLabelType = testLabelType;
			return this;
		}
		
		/**
		 * @param testLabelForegroundPaint The {@link SizablePaint} to use for the label foreground to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelForegroundPaint(SizablePaint testLabelForegroundPaint){
			this.testLabelForegroundPaint = testLabelForegroundPaint;
			return this;
		}
		
		/**
		 * @param testLabelBackgroundPaint The {@link SizablePaint} to use for the label background to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelBackgroundPaint(SizablePaint testLabelBackgroundPaint){
			this.testLabelBackgroundPaint = testLabelBackgroundPaint;
			return this;
		}
		
		/**
		 * Sets the label font settings to test setting them
		 *
		 * @param testLabelFontFamily The {@link FontFamily} to use for the label to test setting it
		 * @param testLabelFontStyle The font style to use for the label to test setting it
		 * @param testLabelFontSize The font size to use for the label to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelFont(
				FontFamily testLabelFontFamily, int testLabelFontStyle, int testLabelFontSize){
			this.testLabelFontFamily = testLabelFontFamily;
			this.testLabelFontStyle = testLabelFontStyle;
			this.testLabelFontSize = testLabelFontSize;
			return this;
		}
		
		/**
		 * @param testLabelFontFamily The {@link FontFamily} to use for the label to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelFontFamily(FontFamily testLabelFontFamily){
			this.testLabelFontFamily = testLabelFontFamily;
			return this;
		}
		
		/**
		 * @param testLabelFontStyle The font style to use for the label to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelFontStyle(int testLabelFontStyle){
			this.testLabelFontStyle = testLabelFontStyle;
			return this;
		}
		
		/**
		 * @param testLabelFontSize The font size to use for the label to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelFontSize(int testLabelFontSize){
			this.testLabelFontSize = testLabelFontSize;
			return this;
		}
		
		/**
		 * @param testLabelShape The {@link ShapeInfo Shape} to use for the label to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelShape(ShapeInfo testLabelShape){
			this.testLabelShape = testLabelShape;
			return this;
		}
		
		/**
		 * @param testLabelBorder The {@link Border} to use for the label to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLabelBorder(Border testLabelBorder){
			this.testLabelBorder = testLabelBorder;
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/**
		 * @param defaultRowSpan The default row span to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultRowSpan(int defaultRowSpan){
			this.defaultRowSpan = defaultRowSpan;
			return this;
		}
		
		/**
		 * @param defaultColSpan The default column span to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultColSpan(int defaultColSpan){
			this.defaultColSpan = defaultColSpan;
			return this;
		}
		
		/**
		 * @param testRowPos The row position to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testRowPos(int testRowPos){
			this.testRowPos = testRowPos;
			return this;
		}
		
		/**
		 * @param testColPos The column position to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testColPos(int testColPos){
			this.testColPos = testColPos;
			return this;
		}
		
		/**
		 * @param testRowSpan The row span to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testRowSpan(int testRowSpan){
			this.testRowSpan = testRowSpan;
			return this;
		}
		
		/**
		 * @param testColSpan The column span to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testColSpan(int testColSpan){
			this.testColSpan = testColSpan;
			return this;
		}
		
		/*
		 * Font Resource Loading
		 */
		
		/**
		 * @param defaultLogFontResourceLoaderWarnings The default logFontResourceLoaderWarnings value
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLogFontResourceLoaderWarnings(boolean defaultLogFontResourceLoaderWarnings){
			this.defaultLogFontResourceLoaderWarnings = defaultLogFontResourceLoaderWarnings;
			return this;
		}
		
		/**
		 * @param defaultLogger The default {@link EasyLogger logger} to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultLogger(EasyLogger defaultLogger){
			this.defaultLogger = defaultLogger;
			return this;
		}
		
		/**
		 * @param defaultGraphEnv The default {@link GraphicsEnvironment} to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultGraphEnv(GraphicsEnvironment defaultGraphEnv){
			this.defaultGraphEnv = defaultGraphEnv;
			return this;
		}
		/**
		 * @param defaultFontFolder The default fonts folder path
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultFontFolder(String defaultFontFolder){
			this.defaultFontFolder = defaultFontFolder;
			return this;
		}
		
		/**
		 * @param defaultFontResourceLoader The default {@link FontResourceLoader} to use
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> defaultFontResourceLoader(FontResourceLoader defaultFontResourceLoader){
			this.defaultFontResourceLoader = defaultFontResourceLoader;
			return this;
		}
		
		/**
		 * @param testLogFontResourceLoaderWarnings The logFontResourceLoaderWarnings value to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLogFontResourceLoaderWarnings(boolean testLogFontResourceLoaderWarnings){
			this.testLogFontResourceLoaderWarnings = testLogFontResourceLoaderWarnings;
			return this;
		}
		
		/**
		 * @param testLogger The {@link EasyLogger logger} to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testLogger(EasyLogger testLogger){
			this.testLogger = testLogger;
			return this;
		}
		
		/**
		 * @param testGraphEnv The {@link GraphicsEnvironment} to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testGraphEnv(GraphicsEnvironment testGraphEnv){
			this.testGraphEnv = testGraphEnv;
			return this;
		}
		/**
		 * @param testFontFolder The fonts folder path to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testFontFolder(String testFontFolder){
			this.testFontFolder = testFontFolder;
			return this;
		}
		
		/**
		 * @param testFontResourceLoader The {@link FontResourceLoader} to use to test setting it
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> testFontResourceLoader(FontResourceLoader testFontResourceLoader){
			this.testFontResourceLoader = testFontResourceLoader;
			return this;
		}
		
		/*
		 * Components
		 */
		
		/**
		 * @param goodComponent A {@link JComponent} that the correct default value can be retrieved from
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> goodComponent(JComponent goodComponent){
			this.goodComponent = goodComponent;
			return this;
		}
		
		/**
		 * @param badComponent A {@link JComponent} that does not match the proper expected {@link JComponent} for getValue
		 * @return this, to continue building
		 */
		public FormFieldTestValuesBuilder<Type> badComponent(JComponent badComponent){
			this.badComponent = badComponent;
			return this;
		}
		
		/**
		 * Checks for any errors in the set parameters and will throw an {@link IllegalArgumentException} if any
		 * are found
		 */
		private void checkForErrors(){
			List<String> errors = new ArrayList<>();
			
			/*
			 * Required Fields
			 */
			
			// fieldType is required
			if(fieldType == null){
				errors.add("fieldType is required!");
			}
			
			// testDefaultValue is required
			if(testDefaultValue == null){
				errors.add("testDefaultValue is required!");
			}
			
			// goodComponent is required
			if(goodComponent == null){
				errors.add("goodComponent is required!");
			}
			
			/*
			 * Default vs. Test Fields (must be different)
			 */
			
			// defaultValue and testDefaultValue must be different
			if(Objects.equals(defaultValue, testDefaultValue)){
				errors.add("defaultValue and testDefaultValue must be different!");
			}
			
			// defaultLabelType and testLabelType must be different
			if(Objects.equals(defaultLabelType, testLabelType)){
				errors.add("defaultLabelType and testLabelType must be different!");
			}
			
			// defaultLabelForegroundPaint and testLabelForegroundPaint must be different
			if(Objects.equals(defaultLabelForegroundPaint, testLabelForegroundPaint)){
				errors.add("defaultLabelForegroundPaint and testLabelForegroundPaint must be different!");
			}
			
			// defaultLabelBackgroundPaint and testLabelBackgroundPaint must be different
			if(Objects.equals(defaultLabelBackgroundPaint, testLabelBackgroundPaint)){
				errors.add("defaultLabelBackgroundPaint and testLabelBackgroundPaint must be different!");
			}
			
			// defaultLabelFontFamily and testLabelFontFamily must be different
			if(Objects.equals(defaultLabelFontFamily, testLabelFontFamily)){
				errors.add("defaultLabelFontFamily and testLabelFontFamily must be different!");
			}
			
			// defaultLabelFontStyle and testLabelFontStyle must be different
			if(defaultLabelFontStyle == testLabelFontStyle){
				errors.add("defaultLabelFontStyle and testLabelFontStyle must be different!");
			}
			
			// defaultLabelFontSize and testLabelFontSize must be different
			if(defaultLabelFontSize == testLabelFontSize){
				errors.add("defaultLabelFontSize and testLabelFontSize must be different!");
			}
			
			// defaultLabelShape and testLabelShape must be different
			if(Objects.equals(defaultLabelShape, testLabelShape)){
				errors.add("defaultLabelShape and testLabelShape must be different!");
			}
			
			// defaultLabelBorder and testLabelBorder must be different
			if(Objects.equals(defaultLabelBorder, testLabelBorder)){
				errors.add("defaultLabelBorder and testLabelBorder must be different!");
			}
			
			// defaultRowSpan and testRowSpan must be different
			if(defaultRowSpan == testRowSpan){
				errors.add("defaultRowSpan and testRowSpan must be different!");
			}
			
			// defaultColSpan and testColSpan must be different
			if(defaultColSpan == testColSpan){
				errors.add("defaultColSpan and testColSpan must be different!");
			}
			
			// defaultLogFontResourceLoaderWarnings and testLogFontResourceLoaderWarnings must be different
			if(defaultLogFontResourceLoaderWarnings == testLogFontResourceLoaderWarnings){
				errors.add("defaultLogFontResourceLoaderWarnings and testLogFontResourceLoaderWarnings must be different!");
			}
			
			// defaultLogger and testLogger must be different
			if(Objects.equals(defaultLogger, testLogger)){
				errors.add("defaultLogger and testLogger must be different!");
			}
			
			// defaultGraphEnv and testGraphEnv must be different
			if(Objects.equals(defaultGraphEnv, testGraphEnv)){
				errors.add("defaultGraphEnv and testGraphEnv must be different!");
			}
			
			// defaultFontFolder and testFontFolder must be different
			if(StringUtil.equalsIgnoreCase(defaultFontFolder, testFontFolder)){
				errors.add("defaultFontFolder and testFontFolder must be different!");
			}
			
			// defaultFontResourceLoader and testFontResourceLoader must be different
			if(Objects.equals(defaultFontResourceLoader, testFontResourceLoader)){
				errors.add("defaultFontResourceLoader and testFontResourceLoader must be different!");
			}
			
			// goodComponent and badComponent must be different
			if(Objects.equals(goodComponent, badComponent)){
				errors.add("goodComponent and badComponent must be different!");
			}
			
			// Report any errors
			if(!errors.isEmpty()){
				throw new IllegalArgumentException("Encountered the following errors building a FormFieldTestValues: " +
						"\n" + StringUtil.buildStringWithNewLines(errors));
			}
		}
		
		/**
		 * Builds a new {@link FormFieldTestValues} using the set parameters after checking for errors
		 *
		 * @return The newly built {@link FormFieldTestValues}
		 */
		public FormFieldTestValues<Type> build(){
			checkForErrors();
			
			return new FormFieldTestValues<>(fieldType, testKey, defaultValue, testDefaultValue, defaultLabelType,
					defaultLabelForegroundPaint, defaultLabelBackgroundPaint,
					defaultLabelFontFamily, defaultLabelFontStyle, defaultLabelFontSize,
					defaultLabelShape, defaultLabelBorder,
					testLabelType, testLabelForegroundPaint, testLabelBackgroundPaint,
					testLabelFontFamily, testLabelFontStyle, testLabelFontSize,
					testLabelShape, testLabelBorder,
					defaultRowSpan, defaultColSpan,
					testRowPos, testColPos, testRowSpan, testColSpan,
					defaultLogFontResourceLoaderWarnings, defaultLogger,
					defaultGraphEnv, defaultFontFolder, defaultFontResourceLoader,
					testLogFontResourceLoaderWarnings, testLogger,
					testGraphEnv, testFontFolder, testFontResourceLoader,
					goodComponent, badComponent);
		}
	}
	
	/*
	 * The Basics
	 */
	/** The default {@link FieldType} to use */
	private final FieldType fieldType;
	/** The key to use for testing setting it */
	private final String testKey;
	/** The default default value to use */
	private final Type defaultValue;
	/** The default value to use for testing setting it */
	private final Type testDefaultValue;
	
	/*
	 * Label Options
	 */
	/** The default {@link LabelType} to use */
	private final LabelType defaultLabelType;
	/** The default {@link SizablePaint} to use for the label foreground */
	private final SizablePaint defaultLabelForegroundPaint;
	/** The default {@link SizablePaint} to use for the label background */
	private final SizablePaint defaultLabelBackgroundPaint;
	/** The default {@link FontFamily} to use for the label */
	private final FontFamily defaultLabelFontFamily;
	/** The default font style to use for the label */
	private final int defaultLabelFontStyle;
	/** The default font size to use for the label */
	private final int defaultLabelFontSize;
	/** The default {@link ShapeInfo Shape} to use for the label */
	private final ShapeInfo defaultLabelShape;
	/** The default {@link Border} to use for the label */
	private final Border defaultLabelBorder;
	/** The {@link LabelType} to use to test setting it */
	private final LabelType testLabelType;
	/** The {@link SizablePaint} to use for the label foreground to test setting it */
	private final SizablePaint testLabelForegroundPaint;
	/** The {@link SizablePaint} to use for the label background to test setting it */
	private final SizablePaint testLabelBackgroundPaint;
	/** The {@link FontFamily} to use for the label to test setting it */
	private final FontFamily testLabelFontFamily;
	/** The font style to use for the label to test setting it */
	private final int testLabelFontStyle;
	/** The font size to use for the label to test setting it */
	private final int testLabelFontSize;
	/** The {@link ShapeInfo Shape} to use for the label to test setting it */
	private final ShapeInfo testLabelShape;
	/** The {@link Border} to use for the label to test setting it */
	private final Border testLabelBorder;
	
	/*
	 * Positioning
	 */
	/** The default row span to use */
	private final int defaultRowSpan;
	/** The default column span to use */
	private final int defaultColSpan;
	/** The row position to use to test setting it */
	private final int testRowPos;
	/** The column position to use to test setting it */
	private final int testColPos;
	/** The row span to use to test setting it */
	private final int testRowSpan;
	/** The column span to use to test setting it */
	private final int testColSpan;
	
	/*
	 * Font Resource Loading
	 */
	/** The default logFontResourceLoaderWarnings value */
	private final boolean defaultLogFontResourceLoaderWarnings;
	/** The default {@link EasyLogger logger} to use */
	private final EasyLogger defaultLogger;
	/** The default {@link GraphicsEnvironment} to use */
	private final GraphicsEnvironment defaultGraphEnv;
	/** The default fonts folder path */
	private final String defaultFontFolder;
	/** The default {@link FontResourceLoader} to use */
	private final FontResourceLoader defaultFontResourceLoader;
	/** The logFontResourceLoaderWarnings value to test setting it */
	private final boolean testLogFontResourceLoaderWarnings;
	/** The {@link EasyLogger logger} to use to test setting it */
	private final EasyLogger testLogger;
	/** The {@link GraphicsEnvironment} to use to test setting it */
	private final GraphicsEnvironment testGraphEnv;
	/** The fonts folder path to test setting it */
	private final String testFontFolder;
	/** The {@link FontResourceLoader} to use to test setting it */
	private final FontResourceLoader testFontResourceLoader;
	
	/*
	 * Components
	 */
	/** A {@link JComponent} that the correct default value can be retrieved from */
	private final JComponent goodComponent;
	/** A {@link JComponent} that does not match the proper expected {@link JComponent} for getValue */
	private final JComponent badComponent;
	
	/**
	 * Constructs a new {@link FormFieldTestValues} object using the given parameters
	 *
	 * @param fieldType The default {@link FieldType} to use
	 * @param testKey The key to use for testing setting it
	 * @param defaultValue The default default value to use
	 * @param testDefaultValue The default value to use for testing setting it
	 * @param defaultLabelType The default {@link LabelType} to use
	 * @param defaultLabelForegroundPaint The default {@link SizablePaint} to use for the label foreground
	 * @param defaultLabelBackgroundPaint The default {@link SizablePaint} to use for the label background
	 * @param defaultLabelFontFamily The default {@link FontFamily} to use for the label
	 * @param defaultLabelFontStyle The default font style to use for the label
	 * @param defaultLabelFontSize The default font size to use for the label
	 * @param defaultLabelShape The default {@link ShapeInfo Shape} to use for the label
	 * @param defaultLabelBorder The default {@link Border} to use for the label
	 * @param testLabelType The {@link LabelType} to use to test setting it
	 * @param testLabelForegroundPaint The {@link SizablePaint} to use for the label foreground to test setting it
	 * @param testLabelBackgroundPaint The {@link SizablePaint} to use for the label background to test setting it
	 * @param testLabelFontFamily The {@link FontFamily} to use for the label to test setting it
	 * @param testLabelFontStyle The font style to use for the label to test setting it
	 * @param testLabelFontSize The font size to use for the label to test setting it
	 * @param testLabelShape The {@link ShapeInfo Shape} to use for the label to test setting it
	 * @param testLabelBorder The {@link Border} to use for the label to test setting it
	 * @param defaultRowSpan The default row span to use
	 * @param defaultColSpan The default column span to use
	 * @param testRowPos The row position to use to test setting it
	 * @param testColPos The column position to use to test setting it
	 * @param testRowSpan The row span to use to test setting it
	 * @param testColSpan The column span to use to test setting it
	 * @param defaultLogFontResourceLoaderWarnings The default logFontResourceLoaderWarnings value
	 * @param defaultLogger The default {@link EasyLogger logger} to use
	 * @param defaultGraphEnv The default {@link GraphicsEnvironment} to use
	 * @param defaultFontFolder The default fonts folder path
	 * @param defaultFontResourceLoader The default {@link FontResourceLoader} to use
	 * @param testLogFontResourceLoaderWarnings The logFontResourceLoaderWarnings value to test setting it
	 * @param testLogger The {@link EasyLogger logger} to use to test setting it
	 * @param testGraphEnv The {@link GraphicsEnvironment} to use to test setting it
	 * @param testFontFolder The fonts folder path to test setting it
	 * @param testFontResourceLoader The {@link FontResourceLoader} to use to test setting it
	 * @param goodComponent A {@link JComponent} that the correct default value can be retrieved from
	 * @param badComponent A {@link JComponent} that does not match the proper expected {@link JComponent} for getValue
	 */
	private FormFieldTestValues(
			FieldType fieldType, String testKey, Type defaultValue, Type testDefaultValue, LabelType defaultLabelType,
			SizablePaint defaultLabelForegroundPaint, SizablePaint defaultLabelBackgroundPaint,
			FontFamily defaultLabelFontFamily, int defaultLabelFontStyle, int defaultLabelFontSize,
			ShapeInfo defaultLabelShape, Border defaultLabelBorder,
			LabelType testLabelType, SizablePaint testLabelForegroundPaint, SizablePaint testLabelBackgroundPaint,
			FontFamily testLabelFontFamily, int testLabelFontStyle, int testLabelFontSize,
			ShapeInfo testLabelShape, Border testLabelBorder,
			int defaultRowSpan, int defaultColSpan,
			int testRowPos, int testColPos, int testRowSpan, int testColSpan,
			boolean defaultLogFontResourceLoaderWarnings, EasyLogger defaultLogger,
			GraphicsEnvironment defaultGraphEnv, String defaultFontFolder, FontResourceLoader defaultFontResourceLoader,
			boolean testLogFontResourceLoaderWarnings, EasyLogger testLogger,
			GraphicsEnvironment testGraphEnv, String testFontFolder, FontResourceLoader testFontResourceLoader,
			JComponent goodComponent, JComponent badComponent
	){
		this.fieldType = fieldType;
		this.testKey = testKey;
		this.defaultValue = defaultValue;
		this.testDefaultValue = testDefaultValue;
		this.defaultLabelType = defaultLabelType;
		this.defaultLabelForegroundPaint = defaultLabelForegroundPaint;
		this.defaultLabelBackgroundPaint = defaultLabelBackgroundPaint;
		this.defaultLabelFontFamily = defaultLabelFontFamily;
		this.defaultLabelFontStyle = defaultLabelFontStyle;
		this.defaultLabelFontSize = defaultLabelFontSize;
		this.defaultLabelShape = defaultLabelShape;
		this.defaultLabelBorder = defaultLabelBorder;
		this.testLabelType = testLabelType;
		this.testLabelForegroundPaint = testLabelForegroundPaint;
		this.testLabelBackgroundPaint = testLabelBackgroundPaint;
		this.testLabelFontFamily = testLabelFontFamily;
		this.testLabelFontStyle = testLabelFontStyle;
		this.testLabelFontSize = testLabelFontSize;
		this.testLabelShape = testLabelShape;
		this.testLabelBorder = testLabelBorder;
		this.defaultRowSpan = defaultRowSpan;
		this.defaultColSpan = defaultColSpan;
		this.testRowPos = testRowPos;
		this.testColPos = testColPos;
		this.testRowSpan = testRowSpan;
		this.testColSpan = testColSpan;
		this.defaultLogFontResourceLoaderWarnings = defaultLogFontResourceLoaderWarnings;
		this.defaultLogger = defaultLogger;
		this.defaultGraphEnv = defaultGraphEnv;
		this.defaultFontFolder = defaultFontFolder;
		this.defaultFontResourceLoader = defaultFontResourceLoader;
		this.testLogFontResourceLoaderWarnings = testLogFontResourceLoaderWarnings;
		this.testLogger = testLogger;
		this.testGraphEnv = testGraphEnv;
		this.testFontFolder = testFontFolder;
		this.testFontResourceLoader = testFontResourceLoader;
		this.goodComponent = goodComponent;
		this.badComponent = badComponent;
	}
	
	/**
	 * @return A {@link FormFieldTestValuesBuilder builder} to use to build a {@link FormFieldTestValues}
	 * @param <Type> The Type used in the {@link FormField} used for these {@link FormFieldTestValues}
	 * @throws IOException If something goes wrong in the {@link FormFieldTestValuesBuilder}
	 */
	public static <Type> FormFieldTestValuesBuilder<Type> builder() throws IOException{
		return new FormFieldTestValuesBuilder<>();
	}
	
	/*
	 * The Basics
	 */
	
	/**
	 * @return The default {@link FieldType} to use
	 */
	public FieldType getFieldType(){
		return fieldType;
	}
	
	/**
	 * @return The key to use for testing setting it
	 */
	public String getTestKey(){
		return testKey;
	}
	
	/**
	 * @return The default default value to use
	 */
	public Type getDefaultValue(){
		return defaultValue;
	}
	
	/**
	 * @return The default value to use for testing setting it
	 */
	public Type getTestDefaultValue(){
		return testDefaultValue;
	}
	
	/*
	 * Label Options
	 */
	
	/**
	 * @return The default {@link LabelType} to use
	 */
	public LabelType getDefaultLabelType(){
		return defaultLabelType;
	}
	
	/**
	 * @return The default {@link SizablePaint} to use for the label foreground
	 */
	public SizablePaint getDefaultLabelForegroundPaint(){
		return defaultLabelForegroundPaint;
	}
	
	/**
	 * @return The default {@link SizablePaint} to use for the label background
	 */
	public SizablePaint getDefaultLabelBackgroundPaint(){
		return defaultLabelBackgroundPaint;
	}
	
	/**
	 * @return The default {@link FontFamily} to use for the label
	 */
	public FontFamily getDefaultLabelFontFamily(){
		return defaultLabelFontFamily;
	}
	
	/**
	 * @return The default font style to use for the label
	 */
	public int getDefaultLabelFontStyle(){
		return defaultLabelFontStyle;
	}
	
	/**
	 * @return The default font size to use for the label
	 */
	public int getDefaultLabelFontSize(){
		return defaultLabelFontSize;
	}
	
	/**
	 * @return The default {@link ShapeInfo Shape} to use for the label
	 */
	public ShapeInfo getDefaultLabelShape(){
		return defaultLabelShape;
	}
	
	/**
	 * @return The default {@link Border} to use for the label
	 */
	public Border getDefaultLabelBorder(){
		return defaultLabelBorder;
	}
	
	/**
	 * @return The {@link LabelType} to use to test setting it
	 */
	public LabelType getTestLabelType(){
		return testLabelType;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for the label foreground to test setting it
	 */
	public SizablePaint getTestLabelForegroundPaint(){
		return testLabelForegroundPaint;
	}
	
	/**
	 * @return The {@link SizablePaint} to use for the label background to test setting it
	 */
	public SizablePaint getTestLabelBackgroundPaint(){
		return testLabelBackgroundPaint;
	}
	
	/**
	 * @return The {@link FontFamily} to use for the label to test setting it
	 */
	public FontFamily getTestLabelFontFamily(){
		return testLabelFontFamily;
	}
	
	/**
	 * @return The font style to use for the label to test setting it
	 */
	public int getTestLabelFontStyle(){
		return testLabelFontStyle;
	}
	
	/**
	 * @return The font size to use for the label to test setting it
	 */
	public int getTestLabelFontSize(){
		return testLabelFontSize;
	}
	
	/**
	 * @return The {@link ShapeInfo Shape} to use for the label to test setting it
	 */
	public ShapeInfo getTestLabelShape(){
		return testLabelShape;
	}
	
	/**
	 * @return The {@link Border} to use for the label to test setting it
	 */
	public Border getTestLabelBorder(){
		return testLabelBorder;
	}
	
	/*
	 * Positioning
	 */
	
	/**
	 * @return The default row span to use
	 */
	public int getDefaultRowSpan(){
		return defaultRowSpan;
	}
	
	/**
	 * @return The default column span to use
	 */
	public int getDefaultColSpan(){
		return defaultColSpan;
	}
	
	/**
	 * @return The row position to use to test setting it
	 */
	public int getTestRowPos(){
		return testRowPos;
	}
	
	/**
	 * @return The column position to use to test setting it
	 */
	public int getTestColPos(){
		return testColPos;
	}
	
	/**
	 * @return The row span to use to test setting it
	 */
	public int getTestRowSpan(){
		return testRowSpan;
	}
	
	/**
	 * @return The column span to use to test setting it
	 */
	public int getTestColSpan(){
		return testColSpan;
	}
	
	/*
	 * Font Resource Loading
	 */
	
	/**
	 * @return The default logFontResourceLoaderWarnings value
	 */
	public boolean getDefaultLogFontResourceLoaderWarnings(){
		return defaultLogFontResourceLoaderWarnings;
	}
	
	/**
	 * @return The default {@link EasyLogger logger} to use
	 */
	public EasyLogger getDefaultLogger(){
		return defaultLogger;
	}
	
	/**
	 * @return The default {@link GraphicsEnvironment} to use
	 */
	public GraphicsEnvironment getDefaultGraphEnv(){
		return defaultGraphEnv;
	}
	
	/**
	 * @return The default fonts folder path
	 */
	public String getDefaultFontFolder(){
		return defaultFontFolder;
	}
	
	/**
	 * @return The default {@link FontResourceLoader} to use
	 */
	public FontResourceLoader getDefaultFontResourceLoader(){
		return defaultFontResourceLoader;
	}
	
	/**
	 * @return The logFontResourceLoaderWarnings value to test setting it
	 */
	public boolean getTestLogFontResourceLoaderWarnings(){
		return testLogFontResourceLoaderWarnings;
	}
	
	/**
	 * @return The {@link EasyLogger logger} to use to test setting it
	 */
	public EasyLogger getTestLogger(){
		return testLogger;
	}
	
	/**
	 * @return The {@link GraphicsEnvironment} to use to test setting it
	 */
	public GraphicsEnvironment getTestGraphEnv(){
		return testGraphEnv;
	}
	
	/**
	 * @return The fonts folder path to test setting it
	 */
	public String getTestFontFolder(){
		return testFontFolder;
	}
	
	/**
	 * @return The {@link FontResourceLoader} to use to test setting it
	 */
	public FontResourceLoader getTestFontResourceLoader(){
		return testFontResourceLoader;
	}
	
	/*
	 * Components
	 */
	/**
	 * @return A {@link JComponent} that the correct default value can be retrieved from
	 */
	public JComponent getGoodComponent(){
		return goodComponent;
	}
	
	/**
	 * @return A {@link JComponent} that does not match the proper expected {@link JComponent} for getValue
	 */
	public JComponent getBadComponent(){
		return badComponent;
	}
}
