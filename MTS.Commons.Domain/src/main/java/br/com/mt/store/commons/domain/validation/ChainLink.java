package br.com.mt.store.commons.domain.validation;

import java.util.Optional;

public abstract class ChainLink {

    private ChainLink previous;
    private ChainLink next;

    public <T extends ChainLink> T getFirst() {
        return (T) Optional.ofNullable(previous)
                .map(previous -> previous.getFirst())
                .orElse(this);
    }

    public ChainLink linkWith(ChainLink link) {
        next = link;
        link.previous = this;
        return link;
    }

    protected <U extends ChainLink> Optional<U> next() {
        return Optional.ofNullable((U)next);
    }
}
