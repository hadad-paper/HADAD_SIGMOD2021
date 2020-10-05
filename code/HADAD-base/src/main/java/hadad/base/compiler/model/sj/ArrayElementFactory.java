package hadad.base.compiler.model.sj;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.VariableFactory;

/**
 * Array Element Factory
 * 
 *   
 *
 */
@Singleton
public class ArrayElementFactory {
    private final VariableFactory variableFactory;
    private final Map<ReturnTerm, Variable> term2element;

    @Inject
    public ArrayElementFactory(@Named("ArrayElementVariableFactory") final VariableFactory variableFactory) {
        this.variableFactory = variableFactory;
        term2element = new HashMap<>();
    }

    public Variable getElement(final ReturnTerm term) {
        if (!term2element.containsKey(term)) {
            term2element.put(term, variableFactory.createFreshVar());
        }
        return term2element.get(term);
    }
}
