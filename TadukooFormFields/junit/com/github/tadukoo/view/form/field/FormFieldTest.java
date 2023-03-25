package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormFieldTest extends BaseFormFieldTest<String>{
	
	private static class TestFormField extends FormField<String>{
		
		private TestFormField(FieldType type, String key, String defaultValue,
		                      LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
		                      FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
		                      ShapeInfo labelShape, Border labelBorder,
		                      int rowPos, int colPos, int rowSpan, int colSpan,
		                      boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
		                      String fontFolder, FontResourceLoader fontResourceLoader){
			super(type, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize, labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader);
		}
		
		@Override
		public JComponent getJustComponent(){
			return new JLabel(getDefaultValue());
		}
		
		@Override
		public String getValueFromJustComponent(JComponent component){
			if(component instanceof JLabel label){
				return label.getText();
			}else{
				return null;
			}
		}
	}
	
	private static class TestFormFieldBuilder extends FormField.FormFieldBuilder<String>{
		
		public TestFormFieldBuilder(){ }
		
		@Override
		public FormField<String> build(){
			return new TestFormField(FieldType.SINGLE_LINE_STRING, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize, labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader);
		}
	}
	
	/** {@inheritDoc} */
	public FormFieldTest() throws Throwable{
		super(FormFieldTestValues.<String>builder()
				.fieldType(FieldType.SINGLE_LINE_STRING)
				.testDefaultValue("Yes")
				.goodComponent(new JLabel((String) null))
				.badComponent(new JTextField("Derp"))
				.build(), TestFormFieldBuilder::new);
	}
	
	private FormField<String> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5).build();
	}
	
	/*
	 * Test Component Methods
	 */
	
	@Test
	public void testAddLabelToComponentNone() throws Throwable{
		field = new TestFormFieldBuilder()
				.labelType(LabelType.NONE)
				.build();
		JLabel label = new JLabel("Test");
		assertEquals(label, field.addLabelToComponent(label, false));
	}
	
	@Test
	public void testAddLabelToComponentTitledBorder() throws Throwable{
		field = new TestFormFieldBuilder()
				.labelType(LabelType.TITLED_BORDER)
				.build();
		JLabel label = (JLabel) field.addLabelToComponent(new JLabel("Test"), false);
		assertTrue(label.getBorder() instanceof TitledBorder);
	}
	
	@Test
	public void testAddLabelToComponentLabel() throws Throwable{
		field = new TestFormFieldBuilder()
				.labelType(LabelType.LABEL)
				.build();
		JComponent component = field.addLabelToComponent(new JLabel("Derp"), false);
		assertTrue(component instanceof JPanel);
		JPanel panel = (JPanel) component;
		assertTrue(panel.getComponent(0) instanceof JLabel);
		assertTrue(panel.getComponent(1) instanceof JLabel);
	}
	
	@Test
	public void testAddLabelToComponentLabelOnTop() throws Throwable{
		field = new TestFormFieldBuilder()
				.labelType(LabelType.LABEL)
				.build();
		JComponent component = field.addLabelToComponent(new JLabel("Derp"), true);
		assertTrue(component instanceof JPanel);
		JPanel panel = (JPanel) component;
		assertTrue(panel.getComponent(0) instanceof JLabel);
		assertTrue(panel.getComponent(1) instanceof JLabel);
	}
	
	@Test
	public void testExtractJustComponentLabel() throws Throwable{
		field = new TestFormFieldBuilder()
				.labelType(LabelType.LABEL)
				.build();
		assertTrue(field.extractJustComponent(field.getComponent(false)) instanceof JLabel);
	}
	
	@Test
	public void testExtractJustComponentNoLabel() throws Throwable{
		field = new TestFormFieldBuilder()
				.labelType(LabelType.NONE)
				.build();
		assertTrue(field.extractJustComponent(field.getComponent(false)) instanceof JLabel);
	}
}
