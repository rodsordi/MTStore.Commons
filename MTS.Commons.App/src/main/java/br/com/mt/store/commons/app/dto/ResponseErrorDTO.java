package br.com.mt.store.commons.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseErrorDTO {

    private String erro;
    private Set<String> erros;

    private ResponseErrorDTO(String erro, Set<String> erros) {
        this.erro = erro;
        this.erros = erros;
    }

    //TODO: Apresentar Builder Pattern
    public static class Builder {
        private String erro;
        private Set<String> erros;

        public Builder addErro(String erro) {
            if (this.erro == null) {
                this.erro = erro;
                return this;
            }
            else if (erros == null) {
                erros = new HashSet<>();
                erros.add(this.erro);
            }
            erros.add(erro);
            return this;
        }

        public ResponseErrorDTO build() {
            return new ResponseErrorDTO(erro, erros);
        }
    }
}