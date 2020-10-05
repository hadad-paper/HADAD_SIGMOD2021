package hadad.base.compiler.model.sppj.naive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.compiler.CreatedNodesSetteQueryBlockTree;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeConstraintsTemplate;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.exceptions.CompilationException;
import hadad.base.compiler.model.sppj.Predicate;
import hadad.base.compiler.model.sppj.SPPJDocumentNamesExtractor;
import hadad.base.compiler.model.sppj.Utils;
import hadad.base.rewriter.Comment;

/**
 * SpPJ NaiveQueryBlockTreeCompiler
 * 
 * @author 
 */
public final class SPPJNaiveQueryBlockTreeCompiler implements QueryBlockTreeViewCompiler {
    private final String documentNamePrefix;
    private final String viewNamePrefix;
    private final CreatedNodesSetteQueryBlockTree createdNodesSetterVisitor;
    private final QueryBlockTreeConstraintsTemplate forwardConstraintsTemplate;
    private final QueryBlockTreeConstraintsTemplate backwardConstraintsTemplate;
    private final SPPJForwardEncoderNestedBlockTreeVisitor forwardEncoderVisitor;
    private final SPPJBackwardEncoderNestedBlockTreeVisitor backwardEncoderVisitor;
    private final SPPJDocumentNamesExtractor sPPJDocumentNamesExtractor;

    @Inject
    public SPPJNaiveQueryBlockTreeCompiler(@Named("document_name_prefix") final String documentNamePrefix,
            @Named("view_name_prefix") final String viewNamePrefix,
            final CreatedNodesSetteQueryBlockTree createdNodesSetterVisitor,
            @Named("ForwardConstraintsTemplate") final QueryBlockTreeConstraintsTemplate forwardConstraintsTemplate,
            @Named("BackwardConstraintsTemplate") final QueryBlockTreeConstraintsTemplate backwardConstraintsTemplate,
            final SPPJForwardEncoderNestedBlockTreeVisitor forwardEncoderVisitor,
            final SPPJBackwardEncoderNestedBlockTreeVisitor backwardEncoderVisitor,
            final SPPJDocumentNamesExtractor sPPJDocumentNamesExtractor) {
        this.documentNamePrefix = documentNamePrefix;
        this.viewNamePrefix = viewNamePrefix;
        this.createdNodesSetterVisitor = createdNodesSetterVisitor;
        this.forwardConstraintsTemplate = forwardConstraintsTemplate;
        this.backwardConstraintsTemplate = backwardConstraintsTemplate;
        this.forwardEncoderVisitor = forwardEncoderVisitor;
        this.backwardEncoderVisitor = backwardEncoderVisitor;
        this.sPPJDocumentNamesExtractor = sPPJDocumentNamesExtractor;
    }

    @Override
    public List<? extends Constraint> compileForwardConstraints(final QueryBlockTree nbt, boolean includeComments)
            throws CompilationException {
        final Set<String> documentNames = sPPJDocumentNamesExtractor.getDocumentNames(nbt);
        final QueryBlockTree nbtClone = nbt.deepClone();
        createdNodesSetterVisitor.setCreatedNodes(nbtClone);
        final List<Constraint> constraints = new ArrayList<Constraint>();
        if (includeComments && forwardConstraintsTemplate.hasGrexSchemaForwardConstraints()) {
            constraints.add(new Comment("Grex schema constraints"));
        }
        constraints.addAll(forwardConstraintsTemplate.getGrexSchemaConstraints(documentNames));

        if (includeComments && forwardConstraintsTemplate.hasViewsConstraints()) {
            constraints.add(new Comment(nbtClone.getQueryName() + " view constraints"));
        }
        constraints.addAll(forwardConstraintsTemplate.getViewsConstraints(documentNames, nbtClone.getQueryName()));
        constraints.addAll(forwardEncoderVisitor.compileConstraints(nbtClone, includeComments));
        return constraints;
    }

    @Override
    public List<? extends Constraint> compileBackwardConstraints(final QueryBlockTree nbt, boolean includeComments)
            throws CompilationException {
        final Set<String> documentNames = sPPJDocumentNamesExtractor.getDocumentNames(nbt);
        final QueryBlockTree nbtClone = nbt.deepClone();
        createdNodesSetterVisitor.setCreatedNodes(nbtClone);
        final List<Constraint> constraints = new ArrayList<Constraint>();
        if (includeComments && backwardConstraintsTemplate.hasGrexSchemaForwardConstraints()) {
            constraints.add(new Comment("Grex schema constraints"));
        }
        constraints.addAll(backwardConstraintsTemplate.getGrexSchemaConstraints(documentNames));
        if (includeComments && backwardConstraintsTemplate.hasViewsConstraints()) {
            constraints.add(new Comment(nbtClone.getQueryName() + " view constraints"));
        }
        constraints.addAll(backwardConstraintsTemplate.getViewsConstraints(documentNames, nbtClone.getQueryName()));
        constraints.addAll(backwardEncoderVisitor.compileConstraints(nbtClone, includeComments));
        return constraints;
    }

    @Override
    public RelationalSchema compileGlobalSchema(final QueryBlockTree nbt) throws CompilationException {
        final Set<String> documentNames = sPPJDocumentNamesExtractor.getDocumentNames(nbt);
        final QueryBlockTree nbtClone = nbt.deepClone();
        final List<Relation> relations = new ArrayList<Relation>(getRelations(nbtClone));

        for (final Relation relation : Utils.getGlobalRelationsToEnsure(documentNamePrefix, documentNames,
                viewNamePrefix, nbt.getQueryName())) {
            if (!relations.contains(relation)) {
                relations.add(relation);
            }
        }
        return new RelationalSchema(relations);
    }

    @Override
    public RelationalSchema compileTargetSchema(final QueryBlockTree nbt) throws CompilationException {
        final QueryBlockTree nbtClone = nbt.deepClone();
        final List<Relation> targetSchemaRelations = new ArrayList<Relation>();
        for (final Relation relation : getRelations(nbtClone)) {
            if (isInTargetSchema(nbtClone.getQueryName(), relation)) {
                targetSchemaRelations.add(relation);
            }
        }
        for (final Relation relation : Utils.getTargetRelationsToEnsure(viewNamePrefix, nbt.getQueryName())) {
            if (!targetSchemaRelations.contains(relation)) {
                targetSchemaRelations.add(relation);
            }
        }
        return new RelationalSchema(targetSchemaRelations);
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
        if (!relation.getName().startsWith(Predicate.COPY.toString())
                && (relation.getName().equals(viewName) || relation.getName().endsWith(viewNamePrefix + viewName))) {
            return true;
        }
        return false;
    }
}