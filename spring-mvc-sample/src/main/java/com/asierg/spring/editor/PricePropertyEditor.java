package com.asierg.spring.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class PricePropertyEditor extends PropertyEditorSupport {

	public PricePropertyEditor() {

	}

	public void setAsText(String priceText) {
		if (!StringUtils.isEmpty(priceText)) {
			setValue(Double.parseDouble(priceText));
		} else {
			setValue(null);
		}
	}

	public String getAsText() {
		if ((Double) getValue() != null) {
			return String.valueOf((Double) getValue());
		} else {
			return null;
		}
	}

}
