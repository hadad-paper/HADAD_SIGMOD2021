package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

import hadad.base.compiler.exceptions.CompilationException;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Tgd;

public class QueryBlockTreeConstraintsTemplate {
    private final ImmutableList<? extends Constraint> grexSchemaConstraints;
    private final ImmutableList<? extends Constraint> viewsConstraints;
    private final String documentNameTemplate;
    private final String documentNamePrefix;
    private final String viewNameTemplate;
    private final String viewNamePrefix;

    public QueryBlockTreeConstraintsTemplate(final List<Constraint> grexSchemaConstraints,
            final List<Constraint> viewsConstraints, final String documentNameTemplate, final String documentNamePrefix,
            final String viewNameTemplate, final String viewNamePrefix) {
        this.grexSchemaConstraints = ImmutableList.copyOf(checkNotNull(grexSchemaConstraints));
        this.viewsConstraints = ImmutableList.copyOf(checkNotNull(viewsConstraints));
        this.documentNameTemplate = checkNotNull(documentNameTemplate);
        this.documentNamePrefix = checkNotNull(documentNamePrefix);
        this.viewNameTemplate = checkNotNull(viewNameTemplate);
        this.viewNamePrefix = checkNotNull(viewNamePrefix);
    }

    public boolean hasGrexSchemaForwardConstraints() {
        return !grexSchemaConstraints.isEmpty();
    }

    public List<? extends Constraint> getGrexSchemaConstraints(final Set<String> documentNames) {
        final ImmutableList.Builder<Constraint> builder = ImmutableList.builder();
        documentNames.stream().map(n -> getGrexSchemaConstraints(n)).forEach(builder::addAll);
        return builder.build();
    }

    private List<? extends Constraint> getGrexSchemaConstraints(final String documentName) {
        return grexSchemaConstraints.stream().map(c -> setDocumentName(c, documentName)).collect(Collectors.toList());
    }

    public boolean hasViewsConstraints() {
        return !viewsConstraints.isEmpty();
    }

    public List<? extends Constraint> getViewsConstraints(final Set<String> documentNames, final String viewName) {
        final ImmutableList.Builder<Constraint> builder = ImmutableList.builder();
        documentNames.stream().map(n -> getViewsConstraints(n, viewName)).forEach(builder::addAll);
        return builder.build();
    }

    public List<? extends Constraint> getViewsConstraints(final String documentName, final String viewName) {
        return viewsConstraints.stream().map(c -> setDocumentAndViewNames(c, documentName, viewName))
                .collect(Collectors.toList());
    }

    private Constraint setDocumentName(final Constraint constraint, final String documentName)
            throws CompilationException {
        if (constraint instanceof Tgd) {
            return setDocumentName((Tgd) constraint, documentName);
        } else if (constraint instanceof Egd) {
            return setDocumentName((Egd) constraint, documentName);
        } else {
            throw new CompilationException("Unsupported constraint.");
        }
    }

    private Tgd setDocumentName(final Tgd constraint, final String documentName) {
        return new Tgd(setDocumentName(constraint.getPremise(), documentName),
                setDocumentName(constraint.getConclusion(), documentName));
    }

    private Egd setDocumentName(final Egd constraint, final String documentName) {
        return new Egd(setDocumentName(constraint.getPremise(), documentName), constraint.getConclusion());
    }

    private List<Atom> setDocumentName(final List<Atom> atoms, final String documentName) {
        final List<Atom> newAtoms = new ArrayList<Atom>();
        for (final Atom atom : atoms) {
            newAtoms.add(setDocumentName(atom, documentName));
        }
        return newAtoms;
    }

    private Atom setDocumentName(final Atom atom, final String documentName) {
        return new Atom(setDocumentName(atom.getPredicate(), documentName), atom.getTerms());
    }

    private String setDocumentName(final String predicate, final String documentName) {
        return predicate.replace(documentNameTemplate, documentNamePrefix + documentName);
    }

    private Constraint setDocumentAndViewNames(final Constraint constraint, final String documentName,
            final String viewName) throws CompilationException {
        if (constraint instanceof Tgd) {
            return setDocumentAndViewNames((Tgd) constraint, documentName, viewName);
        } else if (constraint instanceof Egd) {
            return setDocumentAndViewNames((Egd) constraint, documentName, viewName);
        } else {
            throw new CompilationException("Unsupported constraint.");
        }
    }

    private Tgd setDocumentAndViewNames(final Tgd constraint, final String documentName, final String viewName) {
        return new Tgd(setDocumentAndViewNames(constraint.getPremise(), documentName, viewName),
                setDocumentAndViewNames(constraint.getConclusion(), documentName, viewName));
    }

    private Egd setDocumentAndViewNames(final Egd constraint, final String documentName, final String viewName) {
        return new Egd(setDocumentAndViewNames(constraint.getPremise(), documentName, viewName),
                constraint.getConclusion());
    }

    private List<Atom> setDocumentAndViewNames(final List<Atom> atoms, final String documentName,
            final String viewName) {
        final List<Atom> newAtoms = new ArrayList<Atom>();
        for (final Atom atom : atoms) {
            newAtoms.add(setDocumentAndViewNames(atom, documentName, viewName));
        }
        return newAtoms;
    }

    private Atom setDocumentAndViewNames(final Atom atom, final String documentName, final String viewName) {
        return new Atom(setDocumentAndViewNames(atom.getPredicate(), documentName, viewName), atom.getTerms());
    }

    private String setDocumentAndViewNames(final String predicate, final String documentName, final String viewName) {
        return predicate.replace(documentNameTemplate, documentNamePrefix + documentName).replace(viewNameTemplate,
                viewNamePrefix + viewName);
    }
}
