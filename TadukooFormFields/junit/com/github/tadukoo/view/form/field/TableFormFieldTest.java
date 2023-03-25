package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.map.MapUtil;
import com.github.tadukoo.util.pojo.AbstractOrderedMappedPojo;
import com.github.tadukoo.util.pojo.OrderedMappedPojo;
import com.github.tadukoo.util.tuple.Pair;
import com.github.tadukoo.view.components.TadukooTable;
import com.github.tadukoo.view.form.field.testutil.BaseFormFieldTest;
import com.github.tadukoo.view.form.field.testutil.FormFieldTestValues;
import org.junit.jupiter.api.Test;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableFormFieldTest extends BaseFormFieldTest<List<OrderedMappedPojo>>{
	private final Map<String, JComponent> columnDefs = MapUtil.createMap(Pair.of("Test", new JLabel("Test")),
			Pair.of("Derp", new JButton("Derp")));
	
	public TableFormFieldTest() throws Throwable{
		super(FormFieldTestValues.<List<OrderedMappedPojo>>builder()
				.fieldType(FieldType.TABLE)
				.testDefaultValue(ListUtil.createList())
				.defaultLabelType(LabelType.NONE)
				.goodComponent(TadukooTable.builder()
						.data(null)
						.build())
				.build(), TableFormField::builder);
	}
	
	private TableFormField getDefaultField(){
		return (TableFormField) defaultFormField;
	}
	
	@Test
	public void testDefaultColumnDefs(){
		Map<String, JComponent> columnDefs = getDefaultField().getColumnDefs();
		assertNotNull(columnDefs);
		assertTrue(columnDefs.isEmpty());
	}
	
	@Test
	public void testSetColumnDefs(){
		Map<String, JComponent> columnDefs = MapUtil.createMap(Pair.of("Test", new JLabel("Test")),
				Pair.of("Derp", new JButton("Derp")));
		TableFormField field = TableFormField.builder()
				.columnDefs(columnDefs).build();
		assertEquals(columnDefs, field.getColumnDefs());
	}
	
	@Test
	public void testSetSingleColumnDef(){
		String fieldName = "Test";
		JComponent component = new JLabel("Test");
		TableFormField field = TableFormField.builder()
				.columnDef(fieldName, component)
				.build();
		Map<String, JComponent> columnDefs = field.getColumnDefs();
		assertTrue(columnDefs.containsKey(fieldName));
		assertEquals(1, columnDefs.keySet().size());
		assertEquals(component, columnDefs.get(fieldName));
	}
	
	@Test
	public void testSetSingleColumnDefFormField() throws Throwable{
		String fieldName = "Test";
		FormField<String> formField = StringFormField.builder().build();
		TableFormField field = TableFormField.builder()
				.columnDef(fieldName, formField)
				.build();
		Map<String, JComponent> columnDefs = field.getColumnDefs();
		assertTrue(columnDefs.containsKey(fieldName));
		assertEquals(1, columnDefs.keySet().size());
		assertNotNull(columnDefs.get(fieldName));
	}
	
	@Override
	protected TableFormField.TableFormFieldBuilder setExtraSettings(
			FormField.FormFieldBuilder<List<OrderedMappedPojo>> builder){
		return ((TableFormField.TableFormFieldBuilder) builder)
				.columnDefs(columnDefs);
	}
	
	@Override
	protected void checkExtraSettings(FormField<List<OrderedMappedPojo>> field){
		assertEquals(columnDefs, ((TableFormField) field).getColumnDefs());
	}
	
	@Test
	public void testGetValueFromJustComponent(){
		TableFormField field = TableFormField.builder().build();
		
		TadukooTable table2 = TadukooTable.builder().keyOrder(ListUtil.createList("Derp", "Test")).build();
		OrderedMappedPojo pojo = new AbstractOrderedMappedPojo(){
			@Override
			public List<String> getKeyOrder(){
				return ListUtil.createList("Derp", "Test");
			}
		};
		pojo.setItem("Derp", 5);
		pojo.setItem("Test", "Yep");
		table2.addRow(pojo);
		
		List<OrderedMappedPojo> result = field.getValueFromJustComponent(table2);
		assertEquals(1, result.size());
		OrderedMappedPojo resultPojo = result.get(0);
		assertEquals(5, resultPojo.getItem("Derp"));
		assertEquals("Yep", resultPojo.getItem("Test"));
	}
}
