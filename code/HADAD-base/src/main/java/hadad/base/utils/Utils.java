package hadad.base.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.JsonObject;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
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

    public static List<Constraint> replaceConstraintsTag(final List<? extends Constraint> constraints,
            final String oldViewName, final String oldTag, final String newViewName, final String newTag) {
        return constraints.stream().filter(c -> !blacklist().contains(c))
                .map(c -> replaceTag(c, oldViewName, oldTag, newViewName, newTag)).collect(Collectors.toList());
    }

    public static List<Constraint> replaceConstraintsRelation(final List<? extends Constraint> constraints,
            final String oldViewName, final String oldRelation, final String newViewName, final String newRelation,
            final int num) {
        return constraints.stream().filter(c -> !blacklist().contains(c))
                .map(c -> replaceRelation(c, oldViewName, oldRelation, newViewName, newRelation, num))
                .collect(Collectors.toList());
    }

    public static List<Constraint> replaceConstraintsRelation1(final List<? extends Constraint> constraints,
            final String oldViewName, final String oldRelation, final String newViewName, final String newRelation,
            final String tag, final int num) {
        return constraints.stream().filter(c -> !blacklist().contains(c))
                .map(c -> replaceRelation(c, oldViewName, oldRelation, newViewName, newRelation, num))
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

    private static Constraint replaceTag(final Constraint constraint, final String oldViewName, final String oldTag,
            final String newViewName, final String newTag) {
        if (constraint instanceof Egd) {
            return replaceTag((Egd) constraint, oldViewName, oldTag, newViewName, newTag);
        } else if (constraint instanceof Tgd) {
            return replaceTag((Tgd) constraint, oldViewName, oldTag, newViewName, newTag);
        } else if (constraint instanceof Comment) {
            return new Comment(constraint.toString());
        } else {
            return null;
        }
    }

    private static Constraint replaceRelation(final Constraint constraint, final String oldViewName,
            final String oldRelation, final String newViewName, final String newRelation, int num) {
        if (constraint instanceof Egd) {
            return replaceRelation((Egd) constraint, oldViewName, oldRelation, newViewName, newRelation, num);
        } else if (constraint instanceof Tgd) {
            return replaceRelation((Tgd) constraint, oldViewName, oldRelation, newViewName, newRelation, num);
        } else if (constraint instanceof Comment) {
            return new Comment(constraint.toString());
        } else {
            return null;
        }
    }

    private static Constraint replaceTag(final Egd constraint, final String oldViewName, final String oldTag,
            final String newViewName, final String newTag) {
        return new Egd(replaceAtomsTag(constraint.getPremise(), oldViewName, oldTag, newViewName, newTag),
                constraint.getConclusion());
        // replaceEqualitiesTag(constraint.getConclusion(), oldTag, newTag));
    }

    private static Constraint replaceTag(final Tgd constraint, final String oldViewName, final String oldTag,
            final String newViewName, final String newTag) {
        return new Tgd(replaceAtomsTag(constraint.getPremise(), oldViewName, oldTag, newViewName, newTag),
                replaceAtomsTag(constraint.getConclusion(), oldViewName, oldTag, newViewName, newTag));
    }

    private static Constraint replaceRelation(final Egd constraint, final String oldViewName, final String oldRelation,
            final String newViewName, final String newRelation, final int num) {
        return new Egd(
                replaceAtomsRelation(constraint.getPremise(), oldViewName, oldRelation, newViewName, newRelation, num),
                constraint.getConclusion());
        // replaceEqualitiesTag(constraint.getConclusion(), oldTag, newTag));
    }

    private static Constraint replaceRelation(final Tgd constraint, final String oldViewName, final String oldRelation,
            final String newViewName, final String newRelation, final int num) {
        return new Tgd(
                replaceAtomsRelation(constraint.getPremise(), oldViewName, oldRelation, newViewName, newRelation, num),
                replaceAtomsRelation(constraint.getConclusion(), oldViewName, oldRelation, newViewName, newRelation,
                        num));
    }

    private static List<Atom> replaceAtomsTag(final List<Atom> atoms, final String oldViewName, final String oldTag,
            final String newViewName, final String newTag) {
        return atoms.stream().map(a -> replaceTag(a, oldViewName, oldTag, newViewName, newTag))
                .collect(Collectors.toList());
    }

    private static List<Atom> replaceAtomsRelation(final List<Atom> atoms, final String oldViewName,
            final String oldRelation, final String newViewName, final String newRelation, final int num) {
        return atoms.stream().map(a -> replaceRelation(a, oldViewName, oldRelation, newViewName, newRelation, num))
                .collect(Collectors.toList());
    }

    private static Atom replaceTag(final Atom atom, final String oldViewName, final String oldTag,
            final String newViewName, final String newTag) {
        return new Atom(atom.getPredicate().replace(oldViewName, newViewName),
                replaceTermsTag(atom.getTerms(), oldTag, newTag));
    }

    private static Atom replaceRelation(final Atom atom, final String oldViewName, final String oldRelation,
            final String newViewName, final String newRelation, final int num) {
        final List<Term> terms = new ArrayList<Term>();
        /*return new Atom(atom.getPredicate().replace(oldViewName, newViewName).replace(oldRelation, newRelation),
        		atom.getTerms());*/
        if (oldViewName.equals("R")) {
            terms.addAll(replaceTermsTag(atom.getTerms(), "SUBJECT_ID", "SUBJECT_ID" + num));
            return new Atom(atom.getPredicate().replace(oldViewName, newViewName).replace(oldRelation, newRelation),
                    terms);
        } else {
            return new Atom(atom.getPredicate().replace(oldViewName, newViewName).replace(oldRelation, newRelation),
                    atom.getTerms());
        }

    }

    private static List<Term> replaceTermsTag(final List<? extends Term> terms, final String oldTag,
            final String newTag) {
        return terms.stream().map(t -> replaceTag(t, oldTag, newTag)).collect(Collectors.toList());
    }

    private static Term replaceTag(final Term term, final String oldTag, final String newTag) {
        if (term instanceof StringConstant && ((StringConstant) term).getValue().equals(oldTag)) {
            return new StringConstant(newTag);

        } else {
            return term;
        }
    }

    public static List<Relation> changeRelationsViewName(final List<Relation> relations, final String oldViewName,
            final String newViewName) {
        return relations.stream().map(r -> changeViewName(r, oldViewName, newViewName)).collect(Collectors.toList());
    }

    private static Relation changeViewName(final Relation relation, final String oldViewName,
            final String newViewName) {
        return new Relation(relation.getName().replace(oldViewName, newViewName), relation.getArity());
    }

    public static void writeConstraints(final String fileName, final List<? extends Constraint> constraints)
            throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (final Constraint constraint : constraints) {
                writer.write(constraint.toString() + (constraint instanceof Comment ? "" : ";\n"));
            }
        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    public static void writeSchemas(final String fileName, final RelationalSchema sourceSchema,
            final RelationalSchema targetSchema) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            writer.write(sourceSchema.toString() + "\n");
            writer.write(targetSchema.toString());
        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    public static Map<String, List<String>> readQueryTemplates(final String fileName) throws IOException {

        final Map<String, List<String>> tagedQueryTemplates = new HashMap<String, List<String>>();
        final File file = new File(fileName);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fileReader);
        List<String> queryTemplates = new ArrayList<String>();
        String line;
        try {
            String[] tag = null;
            StringBuffer queryTemplate = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                if (line.startsWith("TAG")) {
                    if (tag != null) {
                        // queryTemplates.add("Q<>:-DUMMY("+tag[1]+");");
                        queryTemplates.add("Q<>:-DUMMY(x);");
                        tagedQueryTemplates.put(tag[1], queryTemplates);
                    }
                    queryTemplates = new ArrayList<String>();
                    tag = line.split(":");
                } else {
                    if (!line.endsWith(";")) {
                        queryTemplate.append(line);
                    } else {
                        queryTemplate.append(line);
                        queryTemplates.add(queryTemplate.toString());
                        queryTemplate = new StringBuffer();
                    }
                }
                if (line.startsWith("-END")) {
                    // queryTemplates.add("Q<>:-DUMMY("+tag[1]+");");
                    queryTemplates.add("Q<>:-DUMMY(x);");
                    tagedQueryTemplates.put(tag[1], queryTemplates);
                }

            }

        } catch (IOException e) {
            throw e;
        } finally {
            reader.close();
        }
        return tagedQueryTemplates;
    }

    public static void writeWorklaod(final List<ConjunctiveQuery> workload, final String fileName) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (final ConjunctiveQuery query : workload) {
                writer.write(query.toString() + "\n\n");
            }

        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    public static void writeConjunctiveQueryQuery(final ConjunctiveQuery query, final String fileName)
            throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {

            writer.write(query.toString() + "\n\n");

        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    /**
     * Write rewritings time
     * 
     * @param workload
     * @param fileName
     * @throws IOException
     */
    public static void writeRewritingsTime(final List<Double> times, final String fileName) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (final double time : times) {
                writer.write(time + "\n");
            }

        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    /**
     * Write rewritings
     * 
     * @param workload
     * @param fileName
     * @throws IOException
     */
    public static void writeRewritings(final List<ConjunctiveQuery> rws, final String fileName) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (final ConjunctiveQuery rw : rws) {
                writer.write(rw + "\n");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    /**
     * Write SQL queries
     * 
     * @param workload
     * @param fileName
     * @throws IOException
     */
    public static void writeSQLQueries(final List<String> workloadSQL, final String fileName) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (final String query : workloadSQL) {
                writer.write(query.toString() + "\n\n");
            }

        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    /**
     * Write Satisfiable SQL queries
     * 
     * @param workload
     * @param fileName
     * @throws IOException
     */
    public static void writeSatisfiableSQLQueries(final List<String> satQueries, final String fileName,
            final Map<String, Integer> satCount) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (final String query : satQueries) {
                writer.write("Count:" + satCount.get(query) + "\n" + query + "\n\n");
            }

        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    /**
     * Replace parameterized predicate with value
     * 
     * @param taggedQueryTemplates
     * @param path
     * @return
     * @throws IOException
     */
    public static Map<String, List<String>> replaceParamterizedTemplates(
            final Map<String, List<String>> taggedQueryTemplates, final String path) throws IOException {

        final Map<String, List<String>> replacedQueryTemplates = new HashMap<String, List<String>>();
        for (final Map.Entry<String, List<String>> entery : taggedQueryTemplates.entrySet()) {
            final List<String> queries = new ArrayList<String>();
            final File file = new File(path + entery.getKey() + ".csv");
            final FileReader fileReader = new FileReader(file);
            final BufferedReader reader = new BufferedReader(fileReader);
            String line;
            queries.add(entery.getValue().get(0));
            queries.add(entery.getValue().get(2));
            while ((line = reader.readLine()) != null) {
                final String query = entery.getValue().get(1).replaceAll("\\?", line.split(",")[0]);
                queries.add(query);
            }

            replacedQueryTemplates.put(entery.getKey(), queries);
            reader.close();
        }

        return replacedQueryTemplates;
    }

    /**
     * Read workload
     * 
     * @param taggedQueryTemplates
     * @param path
     * @return
     * @throws hadad.commons.conjunctivequery.parser.ParseException
     * @throws IllegalArgumentException
     * @throws IOException
     * @throws IOException
     */
    public static List<ConjunctiveQuery> readWorkload(final String fileName)
            throws IllegalArgumentException, hadad.commons.conjunctivequery.parser.ParseException, IOException {

        final List<ConjunctiveQuery> queries = new ArrayList<ConjunctiveQuery>();
        final File file = new File(fileName);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                ConjunctiveQuery query = hadad.base.rewriter.server.Utils.parseQuery(line);
                queries.add(query);
            }
        }
        reader.close();
        return queries;
    }

    /**
     * Output execution time of queries
     * 
     * @param fileName
     * @throws IOException
     */
    public static void writeQueriesTimes(final String fileName, final Map<String, Long> queriesTime)
            throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
        try {
            for (Map.Entry<String, Long> queryTime : queriesTime.entrySet()) {
                writer.write(queryTime.getKey() + " : " + queryTime.getValue());
            }
        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
    }

    /**
     * Output execution time of queries
     * 
     * @param fileName
     * @throws IOException
     */
    public static String writeJsonData(final String fileName, final List<JsonObject> jsonObjects) throws IOException {

        final String FILPATH = "src/main/resources/" + fileName + ".json";
        final File file = new File(FILPATH);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();;
        final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILPATH), CHARSET));
        try {
            for (final JsonObject jsonObject : jsonObjects) {
                writer.write(jsonObject.toString() + "\n");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            writer.close();
        }
        return file.getAbsolutePath();
    }
}
