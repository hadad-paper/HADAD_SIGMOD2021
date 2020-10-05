package hadad.base.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import hadad.base.compiler.exceptions.CompilationException;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.commons.relationalschema.AccessPattern;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.Context;

/**
 * Query block tree (view) schema and constraints compiler interface.s
 */
public interface QueryBlockTreeViewCompiler {
    /**
     * Compiles the PACB context for the specified nested block trees.
     *
     * @param nbts
     *            the nested block trees.
     * @param bindingPatterns
     *            relational schema containing (only) the binding patterns for
     *            the views (represented by the given nested block trees).
     * @param includeComments
     *            if <code>true</code> (constraints) comments will be included.
     * @return the PACB context for the specified nested block trees.
     * @throws CompilationException
     */
    default Context compileContext(final List<QueryBlockTree> nbts, final RelationalSchema bindingPatterns,
            boolean includeComments) throws CompilationException {
        final Set<Relation> globalSchemaRelations = new HashSet<>();
        final Set<Relation> targetSchemaRelations = new HashSet<>();
        final Set<Constraint> forwardConstraints = new LinkedHashSet<>();
        final Set<Constraint> backwardConstraints = new LinkedHashSet<>();
        final Iterator<QueryBlockTree> it = nbts.iterator();
        while (it.hasNext()) {
            final QueryBlockTree nbt = it.next();
            forwardConstraints.addAll(compileForwardConstraints(nbt, includeComments));
            backwardConstraints.addAll(compileBackwardConstraints(nbt, includeComments));
            globalSchemaRelations.addAll(compileGlobalSchema(nbt).getRelations());
            targetSchemaRelations.addAll(compileTargetSchema(nbt).getRelations());
        }
        backwardConstraints.addAll(compileBindingPatternConstraints(bindingPatterns));
        return new Context(new RelationalSchema(new ArrayList<Relation>(globalSchemaRelations)),
                new RelationalSchema(new ArrayList<Relation>(targetSchemaRelations)),
                new ArrayList<Constraint>(forwardConstraints), new ArrayList<Constraint>(backwardConstraints));
    }

    /**
     * Compiles the PACB context for the specified nested block tree.
     *
     * @param nbt
     *            the nested block tree.
     * @param bindingPatterns
     *            relational schema containing (only) the binding patterns for
     *            the views (represented by the given nested block trees).
     * @param includeComments
     *            if <code>true</code> (constraints) comments will be included.
     * @return the PACB context for the specified nested block tree.
     * @throws CompilationException
     */
    default Context compileContext(final QueryBlockTree nbt, final RelationalSchema bindingPatterns,
            boolean includeComments) throws CompilationException {
        final List<Constraint> backwardConstraints = new ArrayList<>();
        backwardConstraints.addAll(compileBackwardConstraints(nbt, includeComments));
        backwardConstraints.addAll(compileBindingPatternConstraints(bindingPatterns));
        return new Context(compileGlobalSchema(nbt), compileTargetSchema(nbt),
                compileForwardConstraints(nbt, includeComments), backwardConstraints);
    }

    /**
     * Generates a list of accessibility constraints for the access patterns
     * specified in the relational schema given as an input.
     *
     * @param bindingPatterns
     *            - the relational schema with the appropriate access patterns.
     * @return a list of constraints modeling the access patterns defined in the schema
     *
     *  Stamatis Zampetakis
     */
    static List<? extends Constraint> compileBindingPatternConstraints(final RelationalSchema bindingPatterns) {
        List<Constraint> constraints = new ArrayList<Constraint>();
        for (Relation R : bindingPatterns.getRelations()) {

            for (AccessPattern acc : R.getAccPatterns()) {
                List<Atom> premise = new ArrayList<Atom>();
                List<Atom> conclusion = new ArrayList<Atom>();
                List<Variable> relationVariables = new ArrayList<Variable>();
                for (int i = 0; i < R.getArity(); i++) {
                    Variable x = new Variable("x" + i);
                    Atom D = new Atom("D", Arrays.asList(x));
                    if (acc.isAccessible(i)) {
                        conclusion.add(D);
                    } else {
                        premise.add(D);
                    }
                    relationVariables.add(x);
                }
                Atom ARel = new Atom(R.getName(), relationVariables);
                premise.add(ARel);
                //If the conclusion is empty then all attributes
                //are defined as an input. Thus there are no output
                //attributes and no reason to generate the constraint
                if (!conclusion.isEmpty()) {
                    Tgd execC = new Tgd(premise, conclusion);
                    constraints.add(execC);
                }
            }
        }
        return constraints;
    }

    /**
     * Compiles the constraints for the specified nested block tree.
     *
     * @param nbt
     *            the nested block tree.
     * @param includeComments
     *            if <code>true</code> (constraints) comments will be included.
     * @return the constraints for the specified nested block tree.
     * @throws CompilationException
     */
    List<? extends Constraint> compileForwardConstraints(final QueryBlockTree nbt, boolean includeComments)
            throws CompilationException;

    /**
     * Compiles the constraints for the backchase for the specified nested block
     * tree.
     *
     * @param nbt
     *            the nested block tree.
     * @param includeComments
     *            if <code>true</code> (constraints) comments will be included.
     * @return the constraints for the backchas for the specified nested block
     *         tree.
     * @throws CompilationException
     */
    List<? extends Constraint> compileBackwardConstraints(final QueryBlockTree nbt, boolean includeComments)
            throws CompilationException;

    /**
     * Compiles the global relational schema (contains all the relations) for
     * the specified nested block tree.
     *
     * @param nbt
     *            the nested block tree.
     * @return the global relational schema (contains all the relations) for the
     *         specified nested block tree.
     * @throws CompilationException
     */
    RelationalSchema compileGlobalSchema(final QueryBlockTree nbt) throws CompilationException;

    /**
     * Compiles the target relational schema (contains only those relations that
     * are in the target schema) for the specified nested block tree.
     *
     * @param nbt
     *            the nested block tree.
     * @return the target relational schema (contains only those relations that
     *         are in the target schema) for the specified nested block tree
     * @throws CompilationException
     */
    RelationalSchema compileTargetSchema(final QueryBlockTree nbt) throws CompilationException;
}
