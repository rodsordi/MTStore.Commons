package br.com.mt.store.commons.app.dto;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public interface Localizable<T> {

    T localize(ResourceBundleMessageSource source, Locale locale);

}
