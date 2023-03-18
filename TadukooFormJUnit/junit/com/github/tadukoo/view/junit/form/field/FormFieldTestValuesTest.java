package com.github.tadukoo.view.junit.form.field;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.border.ShapedEtchedBorder;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class FormFieldTestValuesTest{
	private static FieldType fieldType;
	private static String testDefaultValue;
	private static JComponent goodComponent;
	private static FormFieldTestValues<String> defTestValues;
	private FormFieldTestValues<String> testValues;
	
	@BeforeAll
	public static void setup() throws IOException{
		fieldType = FieldType.STRING;
		testDefaultValue = "Derp";
		goodComponent = new JLabel(("Yep sure"));
		defTestValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.goodComponent(goodComponent)
				.build();
	}
	
	/*
	 * Test Required Settings
	 */
	
	@Test
	public void testSetFieldType(){
		assertEquals(fieldType, defTestValues.getFieldType());
	}
	
	@Test
	public void testSetTestDefaultValue(){
		assertEquals(testDefaultValue, defTestValues.getTestDefaultValue());
	}
	
	@Test
	public void testSetGoodComponent(){
		assertEquals(goodComponent, defTestValues.getGoodComponent());
	}
	
	/*
	 * Test Default Settings (The Basics)
	 */
	
	@Test
	public void testDefaultTestKey(){
		assertEquals("Test", defTestValues.getTestKey());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(defTestValues.getDefaultValue());
	}
	
	/*
	 * Test Default Settings (Label Options - Defaults)
	 */
	
	@Test
	public void testDefaultDefaultLabelType(){
		assertEquals(LabelType.LABEL, defTestValues.getDefaultLabelType());
	}
	
	@Test
	public void testDefaultDefaultLabelForegroundPaint(){
		assertNull(defTestValues.getDefaultLabelForegroundPaint());
	}
	
	@Test
	public void testDefaultDefaultLabelBackgroundPaint(){
		assertNull(defTestValues.getDefaultLabelBackgroundPaint());
	}
	
	@Test
	public void testDefaultDefaultLabelFontFamily(){
		assertNull(defTestValues.getDefaultLabelFontFamily());
	}
	
	@Test
	public void testDefaultDefaultLabelFontStyle(){
		assertEquals(-1, defTestValues.getDefaultLabelFontStyle());
	}
	
	@Test
	public void testDefaultDefaultLabelFontSize(){
		assertEquals(-1, defTestValues.getDefaultLabelFontSize());
	}
	
	@Test
	public void testDefaultDefaultLabelShape(){
		assertNull(defTestValues.getDefaultLabelShape());
	}
	
	@Test
	public void testDefaultDefaultLabelBorder(){
		assertNull(defTestValues.getDefaultLabelBorder());
	}
	
	/*
	 * Test Default Settings (Label Options - Tests)
	 */
	
	@Test
	public void testDefaultTestLabelType(){
		assertEquals(LabelType.TITLED_BORDER, defTestValues.getTestLabelType());
	}
	
	@Test
	public void testDefaultTestLabelForegroundPaint(){
		assertEquals(new SizableColor(Color.RED), defTestValues.getTestLabelForegroundPaint());
	}
	
	@Test
	public void testDefaultTestLabelBackgroundPaint(){
		assertEquals(new SizableColor(Color.BLUE), defTestValues.getTestLabelBackgroundPaint());
	}
	
	@Test
	public void testDefaultTestLabelFontFamily(){
		assertEquals(FontFamilies.DIALOG.getFamily(), defTestValues.getTestLabelFontFamily());
	}
	
	@Test
	public void testDefaultTestLabelFontStyle(){
		assertEquals(Font.BOLD, defTestValues.getTestLabelFontStyle());
	}
	
	@Test
	public void testDefaultTestLabelFontSize(){
		assertEquals(27, defTestValues.getTestLabelFontSize());
	}
	
	@Test
	public void testDefaultTestLabelShape(){
		assertEquals(Shapes.CIRCLE.getShapeInfo(), defTestValues.getTestLabelShape());
	}
	
	@Test
	public void testDefaultTestLabelBorder(){
		assertEquals(ShapedLineBorder.builder().build(), defTestValues.getTestLabelBorder());
	}
	
	/*
	 * Test Default Settings (Positioning - Defaults)
	 */
	
	@Test
	public void testDefaultDefaultRowSpan(){
		assertEquals(1, defTestValues.getDefaultRowSpan());
	}
	
	@Test
	public void testDefaultDefaultColSpan(){
		assertEquals(1, defTestValues.getDefaultColSpan());
	}
	
	/*
	 * Test Default Settings (Positioning - Tests)
	 */
	
	@Test
	public void testDefaultTestRowPos(){
		assertEquals(2, defTestValues.getTestRowPos());
	}
	
	@Test
	public void testDefaultTestColPos(){
		assertEquals(5, defTestValues.getTestColPos());
	}
	
	@Test
	public void testDefaultTestRowSpan(){
		assertEquals(3, defTestValues.getTestRowSpan());
	}
	
	@Test
	public void testDefaultTestColSpan(){
		assertEquals(7, defTestValues.getTestColSpan());
	}
	
	/*
	 * Test Default Settings (Font Resource Loading - Defaults)
	 */
	
	@Test
	public void testDefaultDefaultLogFontResourceLoaderWarnings(){
		assertFalse(defTestValues.getDefaultLogFontResourceLoaderWarnings());
	}
	
	@Test
	public void testDefaultDefaultLogger(){
		assertNull(defTestValues.getDefaultLogger());
	}
	
	@Test
	public void testDefaultDefaultGraphEnv(){
		assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment(), defTestValues.getDefaultGraphEnv());
	}
	
	@Test
	public void testDefaultDefaultFontFolder(){
		assertEquals("fonts/", defTestValues.getDefaultFontFolder());
	}
	
	@Test
	public void testDefaultDefaultFontResourceLoader(){
		assertNull(defTestValues.getDefaultFontResourceLoader());
	}
	
	/*
	 * Test Default Settings (Font Resource Loading - Tests)
	 */
	
	@Test
	public void testDefaultTestLogFontResourceLoaderWarnings(){
		assertTrue(defTestValues.getTestLogFontResourceLoaderWarnings());
	}
	
	@Test
	public void testDefaultTestLogger(){
		assertNotNull(defTestValues.getTestLogger());
	}
	
	@Test
	public void testDefaultTestGraphEnv(){
		assertNull(defTestValues.getTestGraphEnv());
	}
	
	@Test
	public void testDefaultTestFontFolder(){
		assertEquals("testing/", defTestValues.getTestFontFolder());
	}
	
	@Test
	public void testDefaultTestFontResourceLoader(){
		assertNotNull(defTestValues.getTestFontResourceLoader());
	}
	
	/*
	 * Test Default Settings (Components)
	 */
	
	@Test
	public void testDefaultBadComponent(){
		JComponent badComp = defTestValues.getBadComponent();
		assertTrue(badComp instanceof JLabel);
		assertEquals("Derp", ((JLabel) defTestValues.getBadComponent()).getText());
	}
	
	/*
	 * Test Settings (The Basics)
	 */
	
	@Test
	public void testSetTestKey() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testKey("Derp")
				.testDefaultValue(testDefaultValue)
				.goodComponent(goodComponent)
				.build();
		assertEquals("Derp", testValues.getTestKey());
	}
	
	@Test
	public void testSetDefaultValue() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.defaultValue("Blah")
				.testDefaultValue(testDefaultValue)
				.goodComponent(goodComponent)
				.build();
		assertEquals("Blah", testValues.getDefaultValue());
	}
	
	/*
	 * Test Settings (Label Options - Defaults)
	 */
	
	@Test
	public void testSetDefaultLabelType() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelType(LabelType.NONE)
				.goodComponent(goodComponent)
				.build();
		assertEquals(LabelType.NONE, testValues.getDefaultLabelType());
	}
	
	@Test
	public void testSetDefaultLabelForegroundPaint() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelForegroundPaint(new SizableColor(Color.BLUE))
				.goodComponent(goodComponent)
				.build();
		assertEquals(new SizableColor(Color.BLUE), testValues.getDefaultLabelForegroundPaint());
	}
	
	@Test
	public void testSetDefaultLabelBackgroundPaint() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelBackgroundPaint(new SizableColor(Color.RED))
				.goodComponent(goodComponent)
				.build();
		assertEquals(new SizableColor(Color.RED), testValues.getDefaultLabelBackgroundPaint());
	}
	
	@Test
	public void testSetDefaultLabelFont() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelFont(FontFamilies.ARIMO.getFamily(), Font.ITALIC, 16)
				.goodComponent(goodComponent)
				.build();
		assertEquals(FontFamilies.ARIMO.getFamily(), testValues.getDefaultLabelFontFamily());
		assertEquals(Font.ITALIC, testValues.getDefaultLabelFontStyle());
		assertEquals(16, testValues.getDefaultLabelFontSize());
	}
	
	@Test
	public void testSetDefaultLabelFontFamily() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelFontFamily(FontFamilies.ARIMO.getFamily())
				.goodComponent(goodComponent)
				.build();
		assertEquals(FontFamilies.ARIMO.getFamily(), testValues.getDefaultLabelFontFamily());
	}
	
	@Test
	public void testSetDefaultLabelFontStyle() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelFontStyle(Font.ITALIC)
				.goodComponent(goodComponent)
				.build();
		assertEquals(Font.ITALIC, testValues.getDefaultLabelFontStyle());
	}
	
	@Test
	public void testSetDefaultLabelFontSize() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelFontSize(16)
				.goodComponent(goodComponent)
				.build();
		assertEquals(16, testValues.getDefaultLabelFontSize());
	}
	
	@Test
	public void testSetDefaultLabelShape() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelShape(Shapes.ROUND_RECTANGLE.getShapeInfo())
				.goodComponent(goodComponent)
				.build();
		assertEquals(Shapes.ROUND_RECTANGLE.getShapeInfo(), testValues.getDefaultLabelShape());
	}
	
	@Test
	public void testSetDefaultLabelBorder() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLabelBorder(ShapedEtchedBorder.builder().build())
				.goodComponent(goodComponent)
				.build();
		assertEquals(ShapedEtchedBorder.builder().build(), testValues.getDefaultLabelBorder());
	}
	
	/*
	 * Test Settings (Label Options - Tests)
	 */
	
	@Test
	public void testSetTestLabelType() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelType(LabelType.NONE)
				.goodComponent(goodComponent)
				.build();
		assertEquals(LabelType.NONE, testValues.getTestLabelType());
	}
	
	@Test
	public void testSetTestLabelForegroundPaint() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelForegroundPaint(new SizableColor(Color.YELLOW))
				.goodComponent(goodComponent)
				.build();
		assertEquals(new SizableColor(Color.YELLOW), testValues.getTestLabelForegroundPaint());
	}
	
	@Test
	public void testSetTestLabelBackgroundPaint() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelBackgroundPaint(new SizableColor(Color.GREEN))
				.goodComponent(goodComponent)
				.build();
		assertEquals(new SizableColor(Color.GREEN), testValues.getTestLabelBackgroundPaint());
	}
	
	@Test
	public void testSetTestLabelFont() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelFont(FontFamilies.CARLITO.getFamily(), Font.BOLD + Font.ITALIC, 30)
				.goodComponent(goodComponent)
				.build();
		assertEquals(FontFamilies.CARLITO.getFamily(), testValues.getTestLabelFontFamily());
		assertEquals(Font.BOLD + Font.ITALIC, testValues.getTestLabelFontStyle());
		assertEquals(30, testValues.getTestLabelFontSize());
	}
	
	@Test
	public void testSetTestLabelFontFamily() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelFontFamily(FontFamilies.CARLITO.getFamily())
				.goodComponent(goodComponent)
				.build();
		assertEquals(FontFamilies.CARLITO.getFamily(), testValues.getTestLabelFontFamily());
	}
	
	@Test
	public void testSetTestLabelFontStyle() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelFontStyle(Font.BOLD + Font.ITALIC)
				.goodComponent(goodComponent)
				.build();
		assertEquals(Font.BOLD + Font.ITALIC, testValues.getTestLabelFontStyle());
	}
	
	@Test
	public void testSetTestLabelFontSize() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelFontSize(30)
				.goodComponent(goodComponent)
				.build();
		assertEquals(30, testValues.getTestLabelFontSize());
	}
	
	@Test
	public void testSetTestLabelShape() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelShape(Shapes.RECTANGLE_WITH_CUT_CORNERS_TL_BR.getShapeInfo())
				.goodComponent(goodComponent)
				.build();
		assertEquals(Shapes.RECTANGLE_WITH_CUT_CORNERS_TL_BR.getShapeInfo(), testValues.getTestLabelShape());
	}
	
	@Test
	public void testSetTestLabelBorder() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testLabelBorder(ShapedEtchedBorder.builder().build())
				.goodComponent(goodComponent)
				.build();
		assertEquals(ShapedEtchedBorder.builder().build(), testValues.getTestLabelBorder());
	}
	
	/*
	 * Test Settings (Positioning - Defaults)
	 */
	
	@Test
	public void testSetDefaultRowSpan() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultRowSpan(25)
				.goodComponent(goodComponent)
				.build();
		assertEquals(25, testValues.getDefaultRowSpan());
	}
	
	@Test
	public void testSetDefaultColSpan() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultColSpan(27)
				.goodComponent(goodComponent)
				.build();
		assertEquals(27, testValues.getDefaultColSpan());
	}
	
	/*
	 * Test Settings (Positioning - Tests)
	 */
	
	@Test
	public void testSetTestRowPos() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testRowPos(42)
				.goodComponent(goodComponent)
				.build();
		assertEquals(42, testValues.getTestRowPos());
	}
	
	@Test
	public void testSetTestColPos() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testColPos(37)
				.goodComponent(goodComponent)
				.build();
		assertEquals(37, testValues.getTestColPos());
	}
	
	@Test
	public void testSetTestRowSpan() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testRowSpan(13)
				.goodComponent(goodComponent)
				.build();
		assertEquals(13, testValues.getTestRowSpan());
	}
	
	@Test
	public void testSetTestColSpan() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testColSpan(17)
				.goodComponent(goodComponent)
				.build();
		assertEquals(17, testValues.getTestColSpan());
	}
	
	/*
	 * Test Settings (Font Resource Loading - Defaults)
	 */
	
	@Test
	public void testSetDefaultLogFontResourceLoaderWarnings() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLogFontResourceLoaderWarnings(true)
				.testLogFontResourceLoaderWarnings(false)
				.goodComponent(goodComponent)
				.build();
		assertTrue(testValues.getDefaultLogFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSetDefaultLogger() throws IOException{
		EasyLogger defaultLogger = new EasyLogger(
				LoggerUtil.createFileLogger("target/garbo/test_garbo.log", Level.OFF));
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLogger(defaultLogger)
				.goodComponent(goodComponent)
				.build();
		assertEquals(defaultLogger, testValues.getDefaultLogger());
	}
	
	@Test
	public void testSetDefaultGraphEnv() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultGraphEnv(null)
				.testGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
				.goodComponent(goodComponent)
				.build();
		assertNull(testValues.getDefaultGraphEnv());
	}
	
	@Test
	public void testSetDefaultFontFolder() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultFontFolder("fonts2/")
				.goodComponent(goodComponent)
				.build();
		assertEquals("fonts2/", testValues.getDefaultFontFolder());
	}
	
	@Test
	public void testSetDefaultFontResourceLoader() throws IOException{
		FontResourceLoader defaultFontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultFontResourceLoader(defaultFontResourceLoader)
				.testFontResourceLoader(null)
				.goodComponent(goodComponent)
				.build();
		assertEquals(defaultFontResourceLoader, testValues.getDefaultFontResourceLoader());
	}
	
	/*
	 * Test Settings (Font Resource Loading - Tests)
	 */
	
	@Test
	public void testSetTestLogFontResourceLoaderWarnings() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLogFontResourceLoaderWarnings(true)
				.testLogFontResourceLoaderWarnings(false)
				.goodComponent(goodComponent)
				.build();
		assertFalse(testValues.getTestLogFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSetTestLogger() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultLogger(new EasyLogger(
						LoggerUtil.createFileLogger("target/garbo/test_garbo.log", Level.OFF)))
				.testLogger(null)
				.goodComponent(goodComponent)
				.build();
		assertNull(testValues.getTestLogger());
	}
	
	@Test
	public void testSetTestGraphEnv() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultGraphEnv(null)
				.testGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
				.goodComponent(goodComponent)
				.build();
		assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment(), testValues.getTestGraphEnv());
	}
	
	@Test
	public void testSetTestFontFolder() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.testFontFolder("fonts2/")
				.goodComponent(goodComponent)
				.build();
		assertEquals("fonts2/", testValues.getTestFontFolder());
	}
	
	@Test
	public void testSetTestFontResourceLoader() throws IOException{
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.defaultFontResourceLoader(new FontResourceLoader(false, null,
						null, "fonts/"))
				.testFontResourceLoader(null)
				.goodComponent(goodComponent)
				.build();
		assertNull(testValues.getTestFontResourceLoader());
	}
	
	/*
	 * Test Settings (Components)
	 */
	
	@Test
	public void testSetBadComponent() throws IOException{
		JTextField field = new JTextField("Test");
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testDefaultValue(testDefaultValue)
				.goodComponent(goodComponent)
				.badComponent(field)
				.build();
		assertEquals(field, testValues.getBadComponent());
	}
	
	/*
	 * Test Setting Everything
	 */
	
	@Test
	public void testAllSettings() throws IOException{
		EasyLogger defaultLogger = new EasyLogger(
				LoggerUtil.createFileLogger("target/garbo/test_garbo.log", Level.OFF));
		FontResourceLoader defaultFontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		JTextField badComponent = new JTextField("Test");
		testValues = FormFieldTestValues.<String>builder()
				.fieldType(fieldType)
				.testKey("Derp")
				.defaultValue("Blah")
				.testDefaultValue(testDefaultValue)
				.defaultLabelType(LabelType.NONE)
				.defaultLabelForegroundPaint(new SizableColor(Color.BLUE))
				.defaultLabelBackgroundPaint(new SizableColor(Color.RED))
				.defaultLabelFontFamily(FontFamilies.ARIMO.getFamily())
				.defaultLabelFontStyle(Font.ITALIC)
				.defaultLabelFontSize(16)
				.defaultLabelShape(Shapes.ROUND_RECTANGLE.getShapeInfo())
				.defaultLabelBorder(ShapedLineBorder.builder().build())
				.testLabelType(LabelType.LABEL)
				.testLabelForegroundPaint(new SizableColor(Color.YELLOW))
				.testLabelBackgroundPaint(new SizableColor(Color.GREEN))
				.testLabelFontFamily(FontFamilies.CARLITO.getFamily())
				.testLabelFontStyle(Font.BOLD + Font.ITALIC)
				.testLabelFontSize(30)
				.testLabelShape(Shapes.RECTANGLE_WITH_CUT_CORNERS_TL_BR.getShapeInfo())
				.testLabelBorder(ShapedEtchedBorder.builder().build())
				.defaultRowSpan(25).defaultColSpan(27)
				.testRowPos(42).testColPos(37)
				.testRowSpan(13).testColSpan(17)
				.defaultLogFontResourceLoaderWarnings(true)
				.defaultLogger(defaultLogger)
				.defaultGraphEnv(null)
				.defaultFontFolder("fonts2/")
				.defaultFontResourceLoader(defaultFontResourceLoader)
				.testLogFontResourceLoaderWarnings(false)
				.testLogger(null)
				.testGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
				.testFontFolder("fonts3/")
				.testFontResourceLoader(null)
				.goodComponent(goodComponent)
				.badComponent(badComponent)
				.build();
		assertEquals("Derp", testValues.getTestKey());
		assertEquals("Blah", testValues.getDefaultValue());
		assertEquals(LabelType.NONE, testValues.getDefaultLabelType());
		assertEquals(new SizableColor(Color.BLUE), testValues.getDefaultLabelForegroundPaint());
		assertEquals(new SizableColor(Color.RED), testValues.getDefaultLabelBackgroundPaint());
		assertEquals(FontFamilies.ARIMO.getFamily(), testValues.getDefaultLabelFontFamily());
		assertEquals(Font.ITALIC, testValues.getDefaultLabelFontStyle());
		assertEquals(16, testValues.getDefaultLabelFontSize());
		assertEquals(Shapes.ROUND_RECTANGLE.getShapeInfo(), testValues.getDefaultLabelShape());
		assertEquals(ShapedLineBorder.builder().build(), testValues.getDefaultLabelBorder());
		assertEquals(LabelType.LABEL, testValues.getTestLabelType());
		assertEquals(new SizableColor(Color.YELLOW), testValues.getTestLabelForegroundPaint());
		assertEquals(new SizableColor(Color.GREEN), testValues.getTestLabelBackgroundPaint());
		assertEquals(FontFamilies.CARLITO.getFamily(), testValues.getTestLabelFontFamily());
		assertEquals(Font.BOLD + Font.ITALIC, testValues.getTestLabelFontStyle());
		assertEquals(30, testValues.getTestLabelFontSize());
		assertEquals(Shapes.RECTANGLE_WITH_CUT_CORNERS_TL_BR.getShapeInfo(), testValues.getTestLabelShape());
		assertEquals(ShapedEtchedBorder.builder().build(), testValues.getTestLabelBorder());
		assertEquals(25, testValues.getDefaultRowSpan());
		assertEquals(27, testValues.getDefaultColSpan());
		assertEquals(42, testValues.getTestRowPos());
		assertEquals(37, testValues.getTestColPos());
		assertEquals(13, testValues.getTestRowSpan());
		assertEquals(17, testValues.getTestColSpan());
		assertTrue(testValues.getDefaultLogFontResourceLoaderWarnings());
		assertEquals(defaultLogger, testValues.getDefaultLogger());
		assertNull(testValues.getDefaultGraphEnv());
		assertEquals("fonts2/", testValues.getDefaultFontFolder());
		assertEquals(defaultFontResourceLoader, testValues.getDefaultFontResourceLoader());
		assertFalse(testValues.getTestLogFontResourceLoaderWarnings());
		assertNull(testValues.getTestLogger());
		assertEquals("fonts3/", testValues.getTestFontFolder());
		assertNull(testValues.getTestFontResourceLoader());
		assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment(), testValues.getTestGraphEnv());
		assertEquals(badComponent, testValues.getBadComponent());
	}
	
	/*
	 * Test Building Errors
	 */
	
	@Test
	public void testBuilderErrorFieldTypeMissing() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.testDefaultValue(testDefaultValue)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"fieldType is required!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorTestDefaultValueMissing() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.defaultValue(testDefaultValue)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"testDefaultValue is required!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorGoodComponentIsRequired() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"goodComponent is required!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultValueAndTestDefaultValueSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.defaultValue(testDefaultValue).testDefaultValue(testDefaultValue)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultValue and testDefaultValue must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelTypeAndTestLabelTypeSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelType(LabelType.LABEL).testLabelType(LabelType.LABEL)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelType and testLabelType must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelForegroundPaintAndTestLabelForegroundPaintSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelForegroundPaint(new SizableColor(Color.RED))
					.testLabelForegroundPaint(new SizableColor(Color.RED))
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelForegroundPaint and testLabelForegroundPaint must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelBackgroundPaintAndTestLabelBackgroundPaintSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelBackgroundPaint(new SizableColor(Color.RED))
					.testLabelBackgroundPaint(new SizableColor(Color.RED))
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelBackgroundPaint and testLabelBackgroundPaint must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelFontFamilyAndTestLabelFontFamilySame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelFontFamily(FontFamilies.CARLITO.getFamily())
					.testLabelFontFamily(FontFamilies.CARLITO.getFamily())
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelFontFamily and testLabelFontFamily must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelFontStyleAndTestLabelFontStyleSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelFontStyle(Font.BOLD).testLabelFontStyle(Font.BOLD)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelFontStyle and testLabelFontStyle must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelFontSizeAndTestLabelFontSizeSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelFontSize(16).testLabelFontSize(16)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelFontSize and testLabelFontSize must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelShapeAndTestLabelShapeSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelShape(Shapes.CIRCLE.getShapeInfo()).testLabelShape(Shapes.CIRCLE.getShapeInfo())
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelShape and testLabelShape must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLabelBorderAndTestLabelBorderSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLabelBorder(ShapedLineBorder.builder().build())
					.testLabelBorder(ShapedLineBorder.builder().build())
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLabelBorder and testLabelBorder must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultRowSpanAndTestRowSpanSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultRowSpan(5).testRowSpan(5)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultRowSpan and testRowSpan must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultColSpanAndTestColSpanSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultColSpan(5).testColSpan(5)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultColSpan and testColSpan must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLogFontResourceLoaderWarningsAndTestLogFontResourceLoaderWarningsSame()
			throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLogFontResourceLoaderWarnings(true).testLogFontResourceLoaderWarnings(true)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLogFontResourceLoaderWarnings and testLogFontResourceLoaderWarnings must be different!",
					e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultLoggerAndTestLoggerSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultLogger(null).testLogger(null)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultLogger and testLogger must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultGraphEnvAndTestGraphEnvSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
					.testGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultGraphEnv and testGraphEnv must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultFontFolderAndTestFontFolderSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultFontFolder("fonts/").testFontFolder("fonts/")
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultFontFolder and testFontFolder must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorDefaultFontResourceLoaderAndTestFontResourceLoaderSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.defaultFontResourceLoader(null).testFontResourceLoader(null)
					.goodComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"defaultFontResourceLoader and testFontResourceLoader must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorGoodComponentAndBadComponentSame() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.fieldType(fieldType)
					.testDefaultValue(testDefaultValue)
					.goodComponent(goodComponent).badComponent(goodComponent)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered the following errors building a FormFieldTestValues: \n" +
					"goodComponent and badComponent must be different!", e.getMessage());
		}
	}
	
	@Test
	public void testAllBuilderErrors() throws IOException{
		try{
			testValues = FormFieldTestValues.<String>builder()
					.defaultLabelType(LabelType.LABEL).testLabelType(LabelType.LABEL)
					.defaultLabelForegroundPaint(new SizableColor(Color.RED))
					.testLabelForegroundPaint(new SizableColor(Color.RED))
					.defaultLabelBackgroundPaint(new SizableColor(Color.RED))
					.testLabelBackgroundPaint(new SizableColor(Color.RED))
					.defaultLabelFontFamily(FontFamilies.CARLITO.getFamily())
					.testLabelFontFamily(FontFamilies.CARLITO.getFamily())
					.defaultLabelFontStyle(Font.BOLD).testLabelFontStyle(Font.BOLD)
					.defaultLabelFontSize(16).testLabelFontSize(16)
					.defaultLabelShape(Shapes.CIRCLE.getShapeInfo()).testLabelShape(Shapes.CIRCLE.getShapeInfo())
					.defaultLabelBorder(ShapedLineBorder.builder().build())
					.testLabelBorder(ShapedLineBorder.builder().build())
					.defaultRowSpan(5).testRowSpan(5)
					.defaultColSpan(5).testColSpan(5)
					.defaultLogFontResourceLoaderWarnings(true).testLogFontResourceLoaderWarnings(true)
					.defaultLogger(null).testLogger(null)
					.defaultGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
					.testGraphEnv(GraphicsEnvironment.getLocalGraphicsEnvironment())
					.defaultFontFolder("fonts/").testFontFolder("fonts/")
					.defaultFontResourceLoader(null).testFontResourceLoader(null)
					.badComponent(null)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("""
					Encountered the following errors building a FormFieldTestValues:\s
					fieldType is required!
					testDefaultValue is required!
					goodComponent is required!
					defaultValue and testDefaultValue must be different!
					defaultLabelType and testLabelType must be different!
					defaultLabelForegroundPaint and testLabelForegroundPaint must be different!
					defaultLabelBackgroundPaint and testLabelBackgroundPaint must be different!
					defaultLabelFontFamily and testLabelFontFamily must be different!
					defaultLabelFontStyle and testLabelFontStyle must be different!
					defaultLabelFontSize and testLabelFontSize must be different!
					defaultLabelShape and testLabelShape must be different!
					defaultLabelBorder and testLabelBorder must be different!
					defaultRowSpan and testRowSpan must be different!
					defaultColSpan and testColSpan must be different!
					defaultLogFontResourceLoaderWarnings and testLogFontResourceLoaderWarnings must be different!
					defaultLogger and testLogger must be different!
					defaultGraphEnv and testGraphEnv must be different!
					defaultFontFolder and testFontFolder must be different!
					defaultFontResourceLoader and testFontResourceLoader must be different!
					goodComponent and badComponent must be different!""", e.getMessage());
		}
	}
}
