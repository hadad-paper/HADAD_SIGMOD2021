package hadad.base.rewriter.stresstest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Tgd;
import hadad.commons.constraints.parser.ParseException;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.Comment;

public class Utils {
	private static final String CHARSET = "utf-8";

	public static List<Constraint> replaceConstraintsTag(
			final List<? extends Constraint> constraints,
			final String oldViewName,
			final String oldTag, final String newViewName, final String newTag) {
		return constraints
				.stream()
				.filter(c -> !blacklist().contains(c))
				.map(c -> replaceTag(c, oldViewName, oldTag, newViewName,
						newTag)).collect(Collectors.toList());
	}

	public static List<Constraint> replaceConstraintsRelation(final List<? extends Constraint> constraints,
			final String oldViewName, final String oldRelation, final String newViewName, final String newRelation) {
		return constraints.stream().filter(c -> !blacklist().contains(c))
				.map(c -> replaceRelation(c, oldViewName, oldRelation, newViewName, newRelation))
				.collect(Collectors.toList());
	}

	private static List<Constraint> blacklist() {
		final List<Constraint> blacklist = new ArrayList<Constraint>();
		try {
			blacklist.add(Tgd.fromString("eq(x,y)->eq(y,x);"));
			blacklist.add(Tgd.fromString("child(x,y)->desc(x,y);"));
			blacklist.add(Tgd.fromString("desc(x,y),desc(y,z)->desc(x,z);"));
			blacklist.add(Egd.fromString("tag(x,t),tag(x,t1)->t=t1;"));
		} catch (UnsupportedEncodingException | ParseException e) {
			e.printStackTrace();
		}
		return blacklist;
	}

	private static Constraint replaceTag(final Constraint constraint,
			final String oldViewName, final String oldTag,
			final String newViewName, final String newTag) {
		if (constraint instanceof Egd) {
			return replaceTag((Egd) constraint, oldViewName, oldTag,
					newViewName, newTag);
		} else if (constraint instanceof Tgd) {
			return replaceTag((Tgd) constraint, oldViewName, oldTag,
					newViewName, newTag);
		} else if (constraint instanceof Comment) {
			return new Comment(constraint.toString());
		} else {
			return null;
		}
	}

	private static Constraint replaceRelation(final Constraint constraint, final String oldViewName,
			final String oldRelation, final String newViewName, final String newRelation) {
		if (constraint instanceof Egd) {
			return replaceRelation((Egd) constraint, oldViewName, oldRelation, newViewName, newRelation);
		} else if (constraint instanceof Tgd) {
			return replaceRelation((Tgd) constraint, oldViewName, oldRelation, newViewName, newRelation);
		} else if (constraint instanceof Comment) {
			return new Comment(constraint.toString());
		} else {
			return null;
		}
	}

	private static Constraint replaceTag(final Egd constraint,
			final String oldViewName, final String oldTag,
			final String newViewName, final String newTag) {
		return new Egd(replaceAtomsTag(constraint.getPremise(), oldViewName,
				oldTag, newViewName, newTag), constraint.getConclusion());
		// replaceEqualitiesTag(constraint.getConclusion(), oldTag, newTag));
	}

	private static Constraint replaceTag(final Tgd constraint,
			final String oldViewName, final String oldTag,
			final String newViewName, final String newTag) {
		return new Tgd(replaceAtomsTag(constraint.getPremise(), oldViewName,
				oldTag, newViewName, newTag), replaceAtomsTag(
				constraint.getConclusion(), oldViewName, oldTag, newViewName,
				newTag));
	}

	private static Constraint replaceRelation(final Egd constraint, final String oldViewName, final String oldRelation,
			final String newViewName, final String newRelation) {
		return new Egd(
				replaceAtomsRelation(constraint.getPremise(), oldViewName, oldRelation, newViewName, newRelation),
				constraint.getConclusion());
		// replaceEqualitiesTag(constraint.getConclusion(), oldTag, newTag));
	}

	private static Constraint replaceRelation(final Tgd constraint, final String oldViewName, final String oldRelation,
			final String newViewName, final String newRelation) {
		return new Tgd(
				replaceAtomsRelation(constraint.getPremise(), oldViewName, oldRelation, newViewName, newRelation),
				replaceAtomsRelation(constraint.getConclusion(), oldViewName, oldRelation, newViewName, newRelation));
	}

	private static List<Atom> replaceAtomsTag(final List<Atom> atoms,
			final String oldViewName, final String oldTag,
			final String newViewName, final String newTag) {
		return atoms
				.stream()
				.map(a -> replaceTag(a, oldViewName, oldTag, newViewName,
						newTag)).collect(Collectors.toList());
	}

	private static List<Atom> replaceAtomsRelation(final List<Atom> atoms, final String oldViewName,
			final String oldRelation, final String newViewName, final String newRelation) {
		return atoms.stream().map(a -> replaceRelation(a, oldViewName, oldRelation, newViewName, newRelation))
				.collect(Collectors.toList());
	}

	private static Atom replaceTag(final Atom atom, final String oldViewName,
			final String oldTag, final String newViewName, final String newTag) {
		return new Atom(atom.getPredicate().replace(oldViewName, newViewName),
				replaceTermsTag(atom.getTerms(), oldTag, newTag));
	}

	private static Atom replaceRelation(final Atom atom, final String oldViewName, final String oldRelation,
			final String newViewName, final String newRelation) {
		return new Atom(atom.getPredicate().replace(oldViewName, newViewName).replace(oldRelation, newRelation),
				atom.getTerms());
	}

	private static List<Term> replaceTermsTag(final List<? extends Term> terms,
			final String oldTag, final String newTag) {
		return terms.stream().map(t -> replaceTag(t, oldTag, newTag))
				.collect(Collectors.toList());
	}

	private static Term replaceTag(final Term term, final String oldTag,
			final String newTag) {
		if (term instanceof StringConstant
				&& ((StringConstant) term).getValue().equals(oldTag)) {
			return new StringConstant(newTag);
		} else {
			return term;
		}
	}

	public static List<Relation> changeRelationsViewName(
			final List<Relation> relations, final String oldViewName,
			final String newViewName) {
		return relations.stream()
				.map(r -> changeViewName(r, oldViewName, newViewName))
				.collect(Collectors.toList());
	}

	private static Relation changeViewName(final Relation relation,
			final String oldViewName, final String newViewName) {
		return new Relation(relation.getName()
				.replace(oldViewName, newViewName), relation.getArity());
	}

	public static void writeConstraints(final String fileName,
			final List<? extends Constraint> constraints) throws IOException {
		final File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		final Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileName), CHARSET));
		try {
			for (final Constraint constraint : constraints) {
				writer.write(constraint.toString()
						+ (constraint instanceof Comment ? "" : ";\n"));
			}
		} catch (IOException e) {
			throw e;
		} finally {
			writer.close();
		}
	}

	public static void writeSchemas(final String fileName,
			final RelationalSchema sourceSchema,
			final RelationalSchema targetSchema) throws IOException {
		final File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		final Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileName), CHARSET));
		try {
			writer.write(sourceSchema.toString() + "\n");
			writer.write(targetSchema.toString());
		} catch (IOException e) {
			throw e;
		} finally {
			writer.close();
		}
	}
}
