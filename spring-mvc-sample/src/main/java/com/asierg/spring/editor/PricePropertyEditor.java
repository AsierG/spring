package com.asierg.spring.editor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

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
        if (getValue() != null) {
            return String.valueOf((Double) getValue());
        } else {
            return null;
        }
    }

}
