package br.com.mt.store.commons.domain;

import java.util.HashSet;
import java.util.Set;

public class BusinessException extends RuntimeException {
    private final Set<String> mensagensDeErro;

    public BusinessException(String message) {
        super(message);
        mensagensDeErro = new HashSet<>();
        mensagensDeErro.add(message);
    }

    public BusinessException(Set<String> mensagensDeErro) {
        super(mensagensDeErro.stream().iterator().next());
        this.mensagensDeErro = new HashSet<>();
        this.mensagensDeErro.addAll(mensagensDeErro);
    }

    public Set<String> getMensagensDeErro() {
        return mensagensDeErro;
    }
}
