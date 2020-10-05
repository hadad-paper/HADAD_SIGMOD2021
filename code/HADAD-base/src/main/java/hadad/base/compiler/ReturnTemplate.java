package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.rits.cloning.Cloner;

import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents (query block tree) block return template.
 *
 * Does not support two return construct terms with the same element.s
 */
public final class ReturnTemplate {
    /* The model of this path expression. */
    private final String model;
    /* The terms in this return template. */
    private final ImmutableList<ReturnTerm> terms;

    /**
     * Constructs a new return template with the specified model and terms.
     *
     * @param model
     *            the model for the path expression.
     * @param terms
     *            the terms for the return template.
     */
    public ReturnTemplate(final String model, final List<ReturnTerm> terms) {
        this.model = checkNotNull(model);
        this.terms = ImmutableList.copyOf(checkNotNull(terms));
    }

    /**
     * The model for this return template.
     *
     * @return model for this return template.
     */
    public String getModel() {
        return model;
    }

    /**
     * The terms in this return template.
     *
     * @return the terms in this return template.
     */
    public List<ReturnTerm> getTerms() {
        return terms;
    }

    /**
     * <code>true</code> if the created node of the return terms in this return
     * template are set.
     *
     * Throws an illegal state exception if some of the return terms in this
     * return template are set and some others are not.
     *
     * @return <code>true</code> if the created node of the return terms in this
     *         return template are set.
     * @throws IllegalStateException
     */
    public boolean hasCreatedNodesSetted() throws IllegalStateException {
        Boolean setted = null;
        for (final ReturnTerm term : terms) {
            if (setted == null) {
                setted = hasCreatedNodesSetted(term);
            } else {
                if (setted != hasCreatedNodesSetted(term)) {
                    throw new IllegalStateException("Some return term created node are set and some others are not.");
                }
            }
        }
        return setted;
    }

    /**
     * Auxiliary method to compute hasCreatedNodesSetted().
     *
     * @param term
     *            the return template term.
     * @return <code>true</code> if the created node(s) of the specified return
     *         term is/are set.
     */
    private boolean hasCreatedNodesSetted(final ReturnTerm term) {
        if (term instanceof ReturnConstructTerm) {
            return ((ReturnConstructTerm) term).hasCreatedNodesSetted();
        } else {
            return term.hasCreatedNode();
        }
    }

    /**
     * The created nodes of the return terms in this return template.
     *
     * @param addCreatedNodeFlagForNonConstructChild
     * @return the created nodes of the return terms in this return template.
     */
    public List<Variable> getCreatedNodes(boolean isRootBlock, boolean addCreatedNodeFlagForNonConstructChild) {
        final ImmutableList.Builder<Variable> builder = ImmutableList.builder();
        for (final ReturnTerm term : terms) {
            if (term instanceof ReturnConstructTerm) {
                builder.addAll(((ReturnConstructTerm) term).getCreatedNodes(isRootBlock,
                        addCreatedNodeFlagForNonConstructChild));
            } else {
                builder.add(term.getCreatedNode());
            }
        }
        return builder.build();
    }

    /**
     * The created node for the specified element.
     *
     * @param element
     *            the element of this return template whose created node is to
     *            be returned
     * @return the created node for the specified element.
     */
    Variable getCreatedNode(final Element element) {
        for (final ReturnTerm term : terms) {
            if (term instanceof ReturnConstructTerm) {
                final Variable createdNode = ((ReturnConstructTerm) term).getCreatedNode(element);
                if (createdNode != null) {
                    return createdNode;
                }
            }
        }
        throw new IllegalStateException(
                "The element " + element.toString() + " is not contained in this return template.");
    }

    /**
     * The variables referred in this return template.
     *
     * @return variables referred in this return template.
     */
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        terms.stream().map(ReturnTerm::getReferredVariables).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * Visitor pattern.
     *
     * Provides a way to navigate the return template and its elements.
     *
     * @param visitor
     *            the return template visitor implementation.
     */
    public void accept(final ReturnTemplateVisitor visitor) {
        visitor.visit(this);
        terms.stream().forEach(c -> c.accept(visitor));
    }

    public ReturnTemplate deepClone() {
        final Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(terms.toString());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(terms);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReturnTemplate)) {
            return false;
        }
        final ReturnTemplate p = (ReturnTemplate) o;
        return terms.equals(p.terms);
    }
}
