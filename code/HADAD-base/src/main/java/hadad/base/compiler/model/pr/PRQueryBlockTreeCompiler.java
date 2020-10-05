package hadad.base.compiler.model.pr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.Comment;
import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.exceptions.CompilationException;

/**
 * PR QueryBlockTreeCompiler which implements {@link QueryBlockTreeViewCompiler}.
 * 
 *   Aloatibi
 */
public final class PRQueryBlockTreeCompiler implements QueryBlockTreeViewCompiler {
    private static final BlockEncoder BLOCK_ENCODER = new PRBlockEncoder();

    @Override
    public List<? extends Constraint> compileForwardConstraints(final QueryBlockTree nbt, boolean includeComments)
            throws CompilationException {
        final ConjunctiveQuery view = nbt2cq(nbt);

        final List<Atom> premise = new ArrayList<Atom>(view.getBody());
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(new Atom(view.getName(), view.getHead()));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        if (includeComments) {
            constraints.add(new Comment(view.getName() + " view constraints"));
        }
        constraints.add(new Tgd(premise, conclusion));

        return constraints;
    }

    @Override
    public List<? extends Constraint> compileBackwardConstraints(final QueryBlockTree nbt, boolean includeComments)
            throws CompilationException {
        final ConjunctiveQuery view = nbt2cq(nbt);

        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(new Atom(view.getName(), view.getHead()));
        final List<Atom> conclusion = new ArrayList<Atom>(view.getBody());

        final List<Constraint> constraints = new ArrayList<Constraint>();
        if (includeComments) {
            constraints.add(new Comment(view.getName() + " view constraints"));
        }
        constraints.add(new Tgd(premise, conclusion));

        return constraints;
    }

    @Override
    public RelationalSchema compileGlobalSchema(final QueryBlockTree nbt) throws CompilationException {
        return new RelationalSchema(new ArrayList<Relation>(getRelations(nbt)));
    }

    @Override
    public RelationalSchema compileTargetSchema(final QueryBlockTree nbt) throws CompilationException {
        final List<Relation> targetSchemaRelations = new ArrayList<Relation>();
        for (final Relation relation : getRelations(nbt)) {
            if (isInTargetSchema(nbt.getQueryName(), relation)) {
                targetSchemaRelations.add(relation);
            }
        }
        final Relation eq = new Relation(hadad.base.compiler.Predicate.EQUALS.toString(), 2);
        if (!targetSchemaRelations.contains(eq)) {
            targetSchemaRelations.add(eq);
        }
        return new RelationalSchema(targetSchemaRelations);
    }

    private ConjunctiveQuery nbt2cq(final QueryBlockTree nbt) {
        /*
         * Query need to be renamed using the view name (removing the Dewey
         * notation).
         *
         * Conditions are already encoded in RQ.
         */
        final ConjunctiveQuery cq = nbt.getRoot().encoding(BLOCK_ENCODER);
        return new ConjunctiveQuery(nbt.getQueryName(), cq.getHead(), cq.getBody());
    }

    private Set<Relation> getRelations(final QueryBlockTree nbt) {
        final Set<Relation> relations = getRelations(compileForwardConstraints(nbt, false));
        relations.addAll(getRelations(compileBackwardConstraints(nbt, false)));
        return relations;
    }

    private Set<Relation> getRelations(final List<? extends Constraint> constraints) {
        final Set<Relation> relations = new HashSet<Relation>();
        for (final Constraint constraint : constraints) {
            if (!(constraint instanceof Comment)) {
                for (final Atom atom : constraint.getPremise()) {
                    relations.add((new Relation(atom.getPredicate(), atom.getTerms().size())));
                }
                if (constraint instanceof Tgd) {
                    for (final Atom atom : ((Tgd) constraint).getConclusion()) {
                        relations.add((new Relation(atom.getPredicate(), atom.getTerms().size())));
                    }
                }
            }
        }
        return relations;
    }

    private boolean isInTargetSchema(final String viewName, final Relation relation) throws CompilationException {
        return relation.getName().equals(viewName);
    }
}