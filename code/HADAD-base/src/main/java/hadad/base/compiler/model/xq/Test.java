package hadad.base.compiler.model.xq;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;
import hadad.base.compiler.model.xq.naive.XQNaiveModule;
import hadad.base.compiler.model.xq.naive.XQNaiveNestedBlockTreeCompiler;
import hadad.base.rewriter.Context;

public class Test {
	private static final String	OUTPUT_FORWARD_CONSTRAINTS_FILE		= "src/test/resources/server/forward_constraints";		
	private static final String	OUTPUT_BACKWARD_CONSTRAINTS_FILE	= "src/test/resources/server/backward_constraints";	
	private static final String	OUTPUT_SCHEMA_FILE					= "src/test/resources/server/schemas";
	private static final String INPUT_QUERY_FILE = "src/test/resources/compiler/xq/test6/v.view";
	private static final int COMPILER = 0;

	public static void main(String[] args) throws Exception {
		Injector injector = null;
		switch (COMPILER) {
			case 0:
				injector = Guice.createInjector(new XQNaiveModule());
				break;
			case 1:
				injector = Guice.createInjector(
				        new hadad.base.compiler.model.xq.alternative.firststep.XQAlternativeModule());
				break;
			case 2:
				injector = Guice.createInjector(
				        new hadad.base.compiler.model.xq.alternative.secondstep.XQAlternativeModule());
				break;
		}

		XQBlockNestedTreeBuilder builder = injector.getInstance(XQBlockNestedTreeBuilder.class);
		final QueryBlockTree nbt = builder
		        .buildQueryBlockTree(FileUtils.readFileToString(new File(INPUT_QUERY_FILE)));
		System.out.println(nbt.toString());
		System.out.println(nbt.getRoot().encoding(injector.getInstance(XQBlockEncoder.class)));
		Context context = null;
		switch (COMPILER) {
			case 0:
				XQNaiveNestedBlockTreeCompiler compiler0 = injector.getInstance(XQNaiveNestedBlockTreeCompiler.class);
				context = compiler0.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
				break;
			case 1:
				hadad.base.compiler.model.xq.alternative.firststep.XQAlternativeNestedBlockTreeCompiler compiler1 = injector
				        .getInstance(
				                hadad.base.compiler.model.xq.alternative.firststep.XQAlternativeNestedBlockTreeCompiler.class);
				context = compiler1.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
				break;
			case 2:
				hadad.base.compiler.model.xq.alternative.secondstep.XQAlternativeNestedBlockTreeCompiler compiler2 = injector
				        .getInstance(
				                hadad.base.compiler.model.xq.alternative.secondstep.XQAlternativeNestedBlockTreeCompiler.class);
				context = compiler2.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
				break;
		}
		Utils.writeConstraints(OUTPUT_FORWARD_CONSTRAINTS_FILE, context.getForwardConstraints());
		Utils.writeConstraints(OUTPUT_BACKWARD_CONSTRAINTS_FILE, context.getBackwardConstraints());
		Utils.writeSchemas(OUTPUT_SCHEMA_FILE, context.getGlobalSchema(), context.getTargetSchema());
	}
}
