package com.github.tadukoo.view.form.field.testutil;

import com.github.tadukoo.util.functional.NoException;
import com.github.tadukoo.util.functional.supplier.ThrowingSupplier;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.FormFieldTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * A Test class to be used to test {@link FormField FormFields}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @param <Type> The type to be used in the {@link FormField}
 */
public abstract class BaseFormFieldTest<Type>{
	
	/** The {@link FormFieldTestValues test values} to use for this test */
	private final FormFieldTestValues<Type> testVals;
	/** The builder method to use */
	private final ThrowingSupplier<FormField.FormFieldBuilder<Type>, NoException> builder;
	/** The default version of the form field */
	protected final FormField<Type> defaultFormField;
	
	/**
	 * Constructs a new {@link FormFieldTest} with the given parameters
	 *
	 * @param testVals The {@link FormFieldTestValues test values} to be used
	 * @param builder The builder method to use to build the form field
	 * @throws Throwable If anything goes wrong
	 */
	protected BaseFormFieldTest(
			FormFieldTestValues<Type> testVals, ThrowingSupplier<FormField.FormFieldBuilder<Type>, NoException> builder)
			throws Throwable{
		this.testVals = testVals;
		this.builder = builder;
		defaultFormField = buildDefaultFormField(builder);
	}
	
	/**
	 * Builds the default version of the form field
	 *
	 * @param builder The builder to use to build the form field
	 * @return The newly built default version of the form field
	 * @throws Throwable If anything goes wrong in building
	 */
	protected FormField<Type> buildDefaultFormField(
			ThrowingSupplier<FormField.FormFieldBuilder<Type>, NoException> builder)
			throws Throwable{
		return builder.get().build();
	}
	
	/*
	 * Test the Default values of the Builder
	 */
	
	/**
	 * Tests that the field type matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testFieldType(){
		Assertions.assertEquals(testVals.getFieldType(), defaultFormField.getType());
	}
	
	/**
	 * Tests that the default, default value matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultDefaultValue(){
		assertEquals(testVals.getDefaultValue(), defaultFormField.getDefaultValue());
	}
	
	/**
	 * Tests that the default label type matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelType(){
		Assertions.assertEquals(testVals.getDefaultLabelType(), defaultFormField.getLabelType());
	}
	
	/**
	 * Tests that the default label foreground paint matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelForegroundPaint(){
		assertEquals(testVals.getDefaultLabelForegroundPaint(), defaultFormField.getLabelForegroundPaint());
	}
	
	/**
	 * Tests that the default label background paint matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelBackgroundPaint(){
		assertEquals(testVals.getDefaultLabelBackgroundPaint(), defaultFormField.getLabelBackgroundPaint());
	}
	
	/**
	 * Tests that the default label font family matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelFontFamily(){
		assertEquals(testVals.getDefaultLabelFontFamily(), defaultFormField.getLabelFontFamily());
	}
	
	/**
	 * Tests that the default label font style matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelFontStyle(){
		assertEquals(testVals.getDefaultLabelFontStyle(), defaultFormField.getLabelFontStyle());
	}
	
	/**
	 * Tests that the default label font size matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelFontSize(){
		assertEquals(testVals.getDefaultLabelFontSize(), defaultFormField.getLabelFontSize());
	}
	
	/**
	 * Tests that the default label shape matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelShape(){
		assertEquals(testVals.getDefaultLabelShape(), defaultFormField.getLabelShape());
	}
	
	/**
	 * Tests that the default label border matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLabelBorder(){
		assertEquals(testVals.getDefaultLabelBorder(), defaultFormField.getLabelBorder());
	}
	
	/**
	 * Tests that the default row span matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultRowSpan(){
		assertEquals(testVals.getDefaultRowSpan(), defaultFormField.getRowSpan());
	}
	
	/**
	 * Tests that the default col span matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultColSpan(){
		assertEquals(testVals.getDefaultColSpan(), defaultFormField.getColSpan());
	}
	
	/**
	 * Tests that the default log font resource loader warnings matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLogFontResourceLoaderWarnings(){
		assertEquals(testVals.getDefaultLogFontResourceLoaderWarnings(), defaultFormField.logFontResourceLoaderWarnings());
	}
	
	/**
	 * Tests that the default logger matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultLogger(){
		assertEquals(testVals.getDefaultLogger(), defaultFormField.getLogger());
	}
	
	/**
	 * Tests that the default graph env matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultGraphEnv(){
		assertEquals(testVals.getDefaultGraphEnv(), defaultFormField.getGraphEnv());
	}
	
	/**
	 * Tests that the default font folder matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultFontFolder(){
		assertEquals(testVals.getDefaultFontFolder(), defaultFormField.getFontFolder());
	}
	
	/**
	 * Tests that the default font resource loader matches what's expected in the {@link #testVals test values}
	 */
	@Test
	public void testDefaultFontResourceLoader(){
		assertEquals(testVals.getDefaultFontResourceLoader(), defaultFormField.getFontResourceLoader());
	}
	
	/*
	 * Test the Set values of the Builder
	 */
	
	/**
	 * Tests setting the key on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the key
	 */
	@Test
	public void testSetKey() throws Throwable{
		FormField<Type> field = builder.get().key(testVals.getTestKey()).build();
		assertEquals(testVals.getTestKey(), field.getKey());
	}
	
	/**
	 * Tests setting the default value on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the default value
	 */
	@Test
	public void testSetDefaultValue() throws Throwable{
		FormField<Type> field = builder.get().defaultValue(testVals.getTestDefaultValue()).build();
		assertEquals(testVals.getTestDefaultValue(), field.getDefaultValue());
	}
	
	/**
	 * Tests setting the label type on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the label type
	 */
	@Test
	public void testSetLabelType() throws Throwable{
		FormField<Type> field = builder.get().labelType(testVals.getTestLabelType()).build();
		Assertions.assertEquals(testVals.getTestLabelType(), field.getLabelType());
	}
	
	/**
	 * Tests setting the label foreground paint on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the label foreground paint
	 */
	@Test
	public void testSetLabelForegroundPaint() throws Throwable{
		FormField<Type> field = builder.get().labelForegroundPaint(testVals.getTestLabelForegroundPaint()).build();
		assertEquals(testVals.getTestLabelForegroundPaint(), field.getLabelForegroundPaint());
	}
	
	/**
	 * Tests setting the label background paint on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the label background paint
	 */
	@Test
	public void testSetLabelBackgroundPaint() throws Throwable{
		FormField<Type> field = builder.get().labelBackgroundPaint(testVals.getTestLabelBackgroundPaint()).build();
		assertEquals(testVals.getTestLabelBackgroundPaint(), field.getLabelBackgroundPaint());
	}
	
	/**
	 * Tests setting the label font on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the label font
	 */
	@Test
	public void testSetLabelFont() throws Throwable{
		FormField<Type> field = builder.get()
				.labelFont(testVals.getTestLabelFontFamily(), testVals.getTestLabelFontStyle(),
						testVals.getTestLabelFontSize()).build();
		assertEquals(testVals.getTestLabelFontFamily(), field.getLabelFontFamily());
		assertEquals(testVals.getTestLabelFontStyle(), field.getLabelFontStyle());
		assertEquals(testVals.getTestLabelFontSize(), field.getLabelFontSize());
	}
	
	/**
	 * Tests setting the label shape on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the label shape
	 */
	@Test
	public void testSetLabelShape() throws Throwable{
		FormField<Type> field = builder.get().labelShape(testVals.getTestLabelShape()).build();
		assertEquals(testVals.getTestLabelShape(), field.getLabelShape());
	}
	
	/**
	 * Tests setting the label border on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the label border
	 */
	@Test
	public void testSetLabelBorder() throws Throwable{
		FormField<Type> field = builder.get().labelBorder(testVals.getTestLabelBorder()).build();
		assertEquals(testVals.getTestLabelBorder(), field.getLabelBorder());
	}
	
	/**
	 * Tests setting the row position on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the row position
	 */
	@Test
	public void testSetRowPos() throws Throwable{
		FormField<Type> field = builder.get().rowPos(testVals.getTestRowPos()).build();
		assertEquals(testVals.getTestRowPos(), field.getRowPos());
	}
	
	/**
	 * Tests setting the column position on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the column position
	 */
	@Test
	public void testSetColPos() throws Throwable{
		FormField<Type> field = builder.get().colPos(testVals.getTestColPos()).build();
		assertEquals(testVals.getTestColPos(), field.getColPos());
	}
	
	/**
	 * Tests setting the row span on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the row span
	 */
	@Test
	public void testSetRowSpan() throws Throwable{
		FormField<Type> field = builder.get().rowSpan(testVals.getTestRowSpan()).build();
		assertEquals(testVals.getTestRowSpan(), field.getRowSpan());
	}
	
	/**
	 * Tests setting the column span on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the column span
	 */
	@Test
	public void testSetColSpan() throws Throwable{
		FormField<Type> field = builder.get().colSpan(testVals.getTestColSpan()).build();
		assertEquals(testVals.getTestColSpan(), field.getColSpan());
	}
	
	/**
	 * Tests setting the log font resource loader warnings boolean on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the logFontResourceLoaderWarnings value
	 */
	@Test
	public void testSetLogFontResourceLoaderWarnings() throws Throwable{
		FormField<Type> field = builder.get()
				.logFontResourceLoaderWarnings(testVals.getTestLogFontResourceLoaderWarnings()).build();
		assertEquals(testVals.getTestLogFontResourceLoaderWarnings(), field.logFontResourceLoaderWarnings());
	}
	
	/**
	 * Tests setting the {@link EasyLogger logger} on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the {@link EasyLogger logger}
	 */
	@Test
	public void testSetLogger() throws Throwable{
		FormField<Type> field = builder.get().logger(testVals.getTestLogger()).build();
		assertEquals(testVals.getTestLogger(), field.getLogger());
	}
	
	/**
	 * Tests setting the {@link GraphicsEnvironment graphEnv} value on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the {@link GraphicsEnvironment graphEnv} value
	 */
	@Test
	public void testSetGraphEnv() throws Throwable{
		FormField<Type> field = builder.get().graphEnv(testVals.getTestGraphEnv()).build();
		assertEquals(testVals.getTestGraphEnv(), field.getGraphEnv());
	}
	
	/**
	 * Tests setting the font folder value on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the font folder value
	 */
	@Test
	public void testSetFontFolder() throws Throwable{
		FormField<Type> field = builder.get().fontFolder(testVals.getTestFontFolder()).build();
		assertEquals(testVals.getTestFontFolder(), field.getFontFolder());
	}
	
	/**
	 * Tests setting the {@link FontResourceLoader font resource loader} value on the builder and retrieving it
	 *
	 * @throws Throwable If anything goes wrong in setting + retrieving the {@link FontResourceLoader fontResourceLoader}
	 */
	@Test
	public void testSetFontResourceLoader() throws Throwable{
		FormField<Type> field = builder.get().fontResourceLoader(testVals.getTestFontResourceLoader()).build();
		assertEquals(testVals.getTestFontResourceLoader(), field.getFontResourceLoader());
	}
	
	/**
	 * Used to set non-standard settings on the {@link FormField.FormFieldBuilder builder}. This should be overridden
	 * by inheriting classes in order to set the specific settings on a {@link FormField form field's} builder
	 *
	 * @param builder The {@link FormField.FormFieldBuilder builder} to set the extra fields on
	 * @return The passed in {@link FormField.FormFieldBuilder builder} with the extra settings set on it
	 */
	protected FormField.FormFieldBuilder<Type> setExtraSettings(FormField.FormFieldBuilder<Type> builder){
		return builder;
	}
	
	/**
	 * Tests that the extra settings on the {@link FormField} have been set based on the
	 * values set in the {@link #setExtraSettings(FormField.FormFieldBuilder)} method. This method should be overridden
	 * by inheriting classes to test that their specific settings have been set correctly.
	 * This method is called within the {@link #testAllSettings()} test.
	 *
	 * @param field The {@link FormField field} with all the settings set on it
	 */
	protected void checkExtraSettings(FormField<Type> field){
		// Do nothing by default
	}
	
	/**
	 * Tests setting all the settings on the {@link FormField.FormFieldBuilder builder} are then set on the resulting
	 * {@link FormField}. This test calls the {@link #setExtraSettings(FormField.FormFieldBuilder)} method in order
	 * to set extra settings for the particular {@link FormField} and also calls {@link #checkExtraSettings(FormField)}
	 * in order to ensure that those extra settings are set correctly.
	 *
	 * @throws Throwable If anything goes wrong in testing all the settings on the {@link FormField.FormFieldBuilder builder}
	 */
	@Test
	public void testAllSettings() throws Throwable{
		FormField<Type> field = setExtraSettings(builder.get().key(testVals.getTestKey())
				.defaultValue(testVals.getTestDefaultValue())
				.labelType(testVals.getTestLabelType()).labelForegroundPaint(testVals.getTestLabelForegroundPaint())
				.labelBackgroundPaint(testVals.getTestLabelBackgroundPaint())
				.labelFont(testVals.getTestLabelFontFamily(), testVals.getTestLabelFontStyle(), testVals.getTestLabelFontSize())
				.labelShape(testVals.getTestLabelShape()).labelBorder(testVals.getTestLabelBorder())
				.rowPos(testVals.getTestRowPos()).colPos(testVals.getTestColPos())
				.rowSpan(testVals.getTestRowSpan()).colSpan(testVals.getTestColSpan())
				.logFontResourceLoaderWarnings(testVals.getTestLogFontResourceLoaderWarnings())
				.logger(testVals.getTestLogger()).graphEnv(testVals.getTestGraphEnv())
				.fontFolder(testVals.getTestFontFolder()).fontResourceLoader(testVals.getTestFontResourceLoader()))
				.build();
		assertEquals(testVals.getTestKey(), field.getKey());
		assertEquals(testVals.getTestDefaultValue(), field.getDefaultValue());
		Assertions.assertEquals(testVals.getTestLabelType(), field.getLabelType());
		assertEquals(testVals.getTestLabelForegroundPaint(), field.getLabelForegroundPaint());
		assertEquals(testVals.getTestLabelBackgroundPaint(), field.getLabelBackgroundPaint());
		assertEquals(testVals.getTestLabelFontFamily(), field.getLabelFontFamily());
		assertEquals(testVals.getTestLabelFontStyle(), field.getLabelFontStyle());
		assertEquals(testVals.getTestLabelFontSize(), field.getLabelFontSize());
		assertEquals(testVals.getTestLabelShape(), field.getLabelShape());
		assertEquals(testVals.getTestLabelBorder(), field.getLabelBorder());
		assertEquals(testVals.getTestRowPos(), field.getRowPos());
		assertEquals(testVals.getTestColPos(), field.getColPos());
		assertEquals(testVals.getTestRowSpan(), field.getRowSpan());
		assertEquals(testVals.getTestColSpan(), field.getColSpan());
		assertEquals(testVals.getTestLogFontResourceLoaderWarnings(), field.logFontResourceLoaderWarnings());
		assertEquals(testVals.getTestLogger(), field.getLogger());
		assertEquals(testVals.getTestGraphEnv(), field.getGraphEnv());
		assertEquals(testVals.getTestFontFolder(), field.getFontFolder());
		assertEquals(testVals.getTestFontResourceLoader(), field.getFontResourceLoader());
		checkExtraSettings(field);
	}
	
	/*
	 * Test the Component methods of the Form Field
	 */
	
	/**
	 * Tests getting the component from the field and asserts it's not null
	 *
	 * @throws Throwable If anything goes wrong in getting the component
	 */
	@Test
	public void testGetJustComponent() throws Throwable{
		FormField<Type> field = builder.get().key(testVals.getTestKey()).build();
		JComponent component = field.getJustComponent();
		assertNotNull(component);
	}
	
	/**
	 * Tests getting the value from a bad component to assert it's null
	 */
	@Test
	public void testGetValueFromJustComponentBadComponent(){
		assertNull(defaultFormField.getValueFromJustComponent(testVals.getBadComponent()));
	}
	
	/**
	 * Tests getting the value from a good component, that it is what we'd expect
	 */
	@Test
	public void testGetValueFromJustComponent(){
		assertEquals(testVals.getDefaultValue(), defaultFormField.getValueFromJustComponent(testVals.getGoodComponent()));
	}
}
