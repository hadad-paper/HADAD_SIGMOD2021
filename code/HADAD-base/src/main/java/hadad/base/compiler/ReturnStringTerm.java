package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents (nested block tree) block return template string (leaf) term.
 */
public final class ReturnStringTerm extends ReturnTerm implements ReturnLeafTerm {
    /* The string of this return (leaf) term */
    private final String str;

    /**
     * Constructs a new return template string (leaf) term with the specified
     * string.
     *
     * @param str
     *            the string for the return (leaf) term.
     */
    public ReturnStringTerm(final String str) {
        this(null, str);
    }

    /**
     * Constructs a new return template string (leaf) term with the specified
     * parent return template construct term and string.
     *
     * @param parent
     *            the parent return template construct term.
     * @param str
     *            the string for the return (leaf) term.
     */
    public ReturnStringTerm(final ReturnConstructTerm parent, final String str) {
        super(parent);
        this.str = checkNotNull(str);
    }

    @Override
    public Term toTerm() {
        return new StringConstant(str);
    }

    @Override
    public void accept(final ReturnTemplateVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        return builder.build();
    }

    @Override
    public String toString() {
        return "\"" + str + "\"";
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, super.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReturnStringTerm)) {
            return false;
        }
        final ReturnStringTerm p = (ReturnStringTerm) o;
        return super.equals(p) && str.equals(p.str);
    }
}
