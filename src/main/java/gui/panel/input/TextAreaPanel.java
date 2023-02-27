package gui.panel.input;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.panel.InputPanel;

public class TextAreaPanel extends InputPanel{
	private JLabel label;
	private JTextArea textArea = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textArea);
	
	{ rootPanel.setLayout(new BorderLayout()) ;}

	public JScrollPane getScroll() {
		return scroll;
	}

	public TextAreaPanel(String name) {
		this(name, 10, 10, null, null);
	}
	
	public TextAreaPanel(String name, int columns, int rows) {
		this(name, columns, rows, null, null);
	}
	
	public TextAreaPanel(String name, String labelText) {
		this(name, 10, 10, labelText, BorderLayout.WEST);
	}
	
	public TextAreaPanel(String name, int columns, int rows, String labelText) {
		this(name, columns, rows, labelText, BorderLayout.WEST);
	}
	
	public TextAreaPanel(String name, int columns, int rows, String labelText, String labelDirection) {
		setName(name);
		label = new JLabel(labelText);
		label.setPreferredSize(new Dimension(80, 25));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textArea.setLineWrap(true);
		textArea.setColumns(columns);
		textArea.setRows(rows);
		rootPanel.add(label, labelDirection);
		rootPanel.add(scroll, BorderLayout.CENTER);
	}
	
	public void setLabelText(String text) {
		label.setText(text);
	}

	public JLabel getLabel() {
		return label;
	}
	
	public JTextArea getTextField() {
		return textArea;
	}

	@Override
	public String getValue() {
		return textArea.getText();
	}
	
	public void setRows(int rows) {
		textArea.setRows(rows);
	}

	@Override
	public void setValue(Object value) {
		textArea.setText(value.toString());
	}
	
	public void reset() {
		textArea.setText("");
	}
}