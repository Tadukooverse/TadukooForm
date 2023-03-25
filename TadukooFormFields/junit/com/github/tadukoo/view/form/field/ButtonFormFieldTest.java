package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.components.TadukooButton;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonFormFieldTest extends BaseFormFieldTest<String>{
	private final ActionListener testAction = e -> { };
	
	public ButtonFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<String>builder()
				.fieldType(FieldType.BUTTON)
				.testDefaultValue("Test")
				.defaultLabelType(LabelType.NONE)
				.goodComponent(TadukooButton.builder().build())
				.build(), ButtonFormField::builder);
	}
	
	public ButtonFormField getDefaultFormField(){
		return (ButtonFormField) defaultFormField;
	}
	
	/*
	 * ActionListener
	 */
	
	@Test
	public void testDefaultActionListener(){
		assertNull(getDefaultFormField().getActionListener());
	}
	
	@Test
	public void testSetActionListener(){
		ButtonFormField field = ButtonFormField.builder().actionListener(testAction).build();
		assertEquals(testAction, field.getActionListener());
	}
	
	/*
	 * Button Foreground Paint
	 */
	
	@Test
	public void testDefaultButtonForegroundPaint(){
		assertNull(getDefaultFormField().getButtonForegroundPaint());
	}
	
	@Test
	public void testSetButtonForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		ButtonFormField field = ButtonFormField.builder().buttonForegroundPaint(red).build();
		assertEquals(red, field.getButtonForegroundPaint());
	}
	
	/*
	 * Button Background Paint
	 */
	
	@Test
	public void testDefaultButtonBackgroundPaint(){
		assertNull(getDefaultFormField().getButtonBackgroundPaint());
	}
	
	@Test
	public void testSetButtonBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		ButtonFormField field = ButtonFormField.builder().buttonBackgroundPaint(blue).build();
		assertEquals(blue, field.getButtonBackgroundPaint());
	}
	
	/*
	 * Button Select Paint
	 */
	
	@Test
	public void testDefaultButtonSelectPaint(){
		assertNull(getDefaultFormField().getButtonSelectPaint());
	}
	
	@Test
	public void testSetButtonSelectPaint(){
		SizableColor yellow = new SizableColor(Color.YELLOW);
		ButtonFormField field = ButtonFormField.builder().buttonSelectPaint(yellow).build();
		assertEquals(yellow, field.getButtonSelectPaint());
	}
	
	/*
	 * Button Focus Paint
	 */
	
	@Test
	public void testDefaultButtonFocusPaint(){
		assertNull(getDefaultFormField().getButtonFocusPaint());
	}
	
	@Test
	public void testSetButtonFocusPaint(){
		SizableColor black = new SizableColor(Color.BLACK);
		ButtonFormField field = ButtonFormField.builder().buttonFocusPaint(black).build();
		assertEquals(black, field.getButtonFocusPaint());
	}
	
	/*
	 * Button Disabled Text Paint
	 */
	
	@Test
	public void testDefaultButtonDisabledTextPaint(){
		assertNull(getDefaultFormField().getButtonDisabledTextPaint());
	}
	
	@Test
	public void testSetButtonDisabledTextPaint(){
		SizableColor gray = new SizableColor(Color.GRAY);
		ButtonFormField field = ButtonFormField.builder().buttonDisabledTextPaint(gray).build();
		assertEquals(gray, field.getButtonDisabledTextPaint());
	}
	
	/*
	 * Button Font
	 */
	
	@Test
	public void testDefaultButtonFontFamily(){
		assertNull(getDefaultFormField().getButtonFontFamily());
	}
	
	@Test
	public void testDefaultButtonFontStyle(){
		assertEquals(-1, getDefaultFormField().getButtonFontStyle());
	}
	
	@Test
	public void testDefaultButtonFontSize(){
		assertEquals(-1, getDefaultFormField().getButtonFontSize());
	}
	
	@Test
	public void testSetButtonFont(){
		ButtonFormField field = ButtonFormField.builder()
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
	}
	
	/*
	 * Button Border
	 */
	
	@Test
	public void testDefaultButtonBorder(){
		assertNull(getDefaultFormField().getButtonBorder());
	}
	
	@Test
	public void testSetButtonBorder(){
		Border border = ShapedLineBorder.builder().build();
		ButtonFormField field = ButtonFormField.builder().buttonBorder(border).build();
		assertEquals(border, field.getButtonBorder());
	}
	
	/*
	 * Button Shape
	 */
	
	@Test
	public void testDefaultButtonShape(){
		assertNull(getDefaultFormField().getButtonShape());
	}
	
	@Test
	public void testSetButtonShape(){
		ButtonFormField field = ButtonFormField.builder().buttonShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getButtonShape());
	}
	
	@Override
	protected ButtonFormField.ButtonFormFieldBuilder setExtraSettings(FormField.FormFieldBuilder<String> builder){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		SizableColor yellow = new SizableColor(Color.YELLOW);
		SizableColor gray = new SizableColor(Color.GRAY);
		Border buttonBorder = ShapedLineBorder.builder().build();
		return ((ButtonFormField.ButtonFormFieldBuilder) builder)
				.actionListener(testAction)
				.buttonForegroundPaint(red).buttonBackgroundPaint(blue)
				.buttonSelectPaint(black).buttonFocusPaint(yellow).buttonDisabledTextPaint(gray)
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.buttonBorder(buttonBorder).buttonShape(Shapes.CIRCLE.getShapeInfo());
	}
	
	@Override
	protected void checkExtraSettings(FormField<String> sentField){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		SizableColor yellow = new SizableColor(Color.YELLOW);
		SizableColor gray = new SizableColor(Color.GRAY);
		Border buttonBorder = ShapedLineBorder.builder().build();
		ButtonFormField field = (ButtonFormField) sentField;
		assertEquals(testAction, field.getActionListener());
		assertEquals(red, field.getButtonForegroundPaint());
		assertEquals(blue, field.getButtonBackgroundPaint());
		assertEquals(black, field.getButtonSelectPaint());
		assertEquals(yellow, field.getButtonFocusPaint());
		assertEquals(gray, field.getButtonDisabledTextPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
		assertEquals(buttonBorder, field.getButtonBorder());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getButtonShape());
	}
	
	@Test
	@Override
	public void testGetJustComponent() throws IOException, FontFormatException{
		ButtonFormField field = ButtonFormField.builder().key("Test Key").build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		assertEquals("Test Key", ((TadukooButton) component).getText());
	}
	
	@Test
	public void testGetJustComponentActionListener() throws IOException, FontFormatException{
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.actionListener(testAction).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(testAction, button.getActionListeners()[0]);
	}
	
	@Test
	public void testGetJustComponentButtonForegroundPaint() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonForegroundPaint(red).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(red, button.getForegroundPaint());
	}
	
	@Test
	public void testGetJustComponentButtonBackgroundPaint() throws IOException, FontFormatException{
		SizableColor blue = new SizableColor(Color.BLUE);
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonBackgroundPaint(blue).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(blue, button.getBackgroundPaint());
	}
	
	@Test
	public void testGetJustComponentButtonSelectPaint() throws IOException, FontFormatException{
		SizableColor black = new SizableColor(Color.BLACK);
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonSelectPaint(black).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(black, button.getSelectPaint());
	}
	
	@Test
	public void testGetJustComponentButtonFocusPaint() throws IOException, FontFormatException{
		SizableColor yellow = new SizableColor(Color.YELLOW);
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonFocusPaint(yellow).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(yellow, button.getFocusPaint());
	}
	
	@Test
	public void testGetJustComponentButtonDisabledTextPaint() throws IOException, FontFormatException{
		SizableColor gray = new SizableColor(Color.GRAY);
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonDisabledTextPaint(gray).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(gray, button.getDisabledTextPaint());
	}
	
	@Test
	public void testGetJustComponentButtonFont() throws IOException, FontFormatException{
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		Font font = button.getFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), font.getName());
		assertEquals(Font.BOLD, font.getStyle());
		assertEquals(12, font.getSize());
	}
	
	@Test
	public void testGetJustComponentButtonBorder() throws IOException, FontFormatException{
		Border border = ShapedLineBorder.builder().build();
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonBorder(border).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(border, button.getBorder());
	}
	
	@Test
	public void testGetJustComponentButtonShape() throws IOException, FontFormatException{
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.buttonShape(Shapes.CIRCLE.getShapeInfo()).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), button.getShapeInfo());
	}
	
	@Test
	public void testGetJustComponentAllSettings() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		SizableColor yellow = new SizableColor(Color.YELLOW);
		SizableColor gray = new SizableColor(Color.GRAY);
		Border border = ShapedLineBorder.builder().build();
		ButtonFormField field = ButtonFormField.builder().key("Test")
				.actionListener(testAction)
				.buttonForegroundPaint(red).buttonBackgroundPaint(blue)
				.buttonSelectPaint(black).buttonFocusPaint(yellow).buttonDisabledTextPaint(gray)
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.buttonBorder(border).buttonShape(Shapes.CIRCLE.getShapeInfo())
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(testAction, button.getActionListeners()[0]);
		assertEquals(red, button.getForegroundPaint());
		assertEquals(blue, button.getBackgroundPaint());
		assertEquals(black, button.getSelectPaint());
		assertEquals(yellow, button.getFocusPaint());
		assertEquals(gray, button.getDisabledTextPaint());
		Font font = button.getFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), font.getName());
		assertEquals(Font.BOLD, font.getStyle());
		assertEquals(12, font.getSize());
		assertEquals(border, button.getBorder());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), button.getShapeInfo());
	}
}
