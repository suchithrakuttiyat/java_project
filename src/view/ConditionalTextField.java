package view;

import javafx.scene.control.TextField;

/**
 * ConditionalTextField is a TextField that accepts specific inputs(with "condition" condition, with limited number of elements.
 */
public class ConditionalTextField extends TextField {
	String condition = "";
	int nrOfElements = 0;
	
	ConditionalTextField(String condition, int nrOfElements) {
		this.condition = condition;
		this.nrOfElements = nrOfElements;	
	}

	@Override
	public void replaceText(int start, int end, String text) {
		if (matches(text)) {
			super.replaceText(start, end, text.toUpperCase());
		}
	}
	
	@Override
	public void replaceSelection(String text) {
		if (matches(text)) {
			super.replaceSelection(text);
		}
	}

	private boolean matches(String text) {
		return text.isEmpty() ||  ( text.length() < nrOfElements && text.matches(condition));
	}

}