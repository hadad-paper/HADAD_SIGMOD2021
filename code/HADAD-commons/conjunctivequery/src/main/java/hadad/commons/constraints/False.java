package hadad.commons.constraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Homomorphism;

public class False extends Constraint implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public False(final List<Atom> premises) {
        super(premises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premise);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof False) && premise.equals(((False) o).premise);
    }

    @Override
    public boolean isEquivalent(Constraint other) {
        if (!(other instanceof False)) {
            return false;
        }
        return isContained(other);
    }

    private boolean isContained(final Constraint other) {
        final List<Atom> atomsPremise1 = new ArrayList<Atom>(premise);
        final List<Atom> atomsPremise2 = new ArrayList<Atom>(other.premise);
        final List<Homomorphism> premiseHomomorphisms = Homomorphism.findHomomorphisms(atomsPremise1, atomsPremise2);
        if (premiseHomomorphisms.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "false";
    }

}
