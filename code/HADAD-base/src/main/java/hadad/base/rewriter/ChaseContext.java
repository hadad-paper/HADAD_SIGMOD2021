package hadad.base.rewriter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.google.common.collect.ImmutableList;

import hadad.db.canonicaldb.Database;
import hadad.db.chase.Assertion;
import hadad.db.chase.EqualityGenConstraint;
import hadad.db.chase.TupleGenConstraint;

public final class ChaseContext {
	/* The database. */
	private final Database db;
	/* The assertions for the chase. */
	private final ImmutableList<Assertion> assertions;
	/* The tgds for the chase. */
	private final ImmutableList<TupleGenConstraint> tgds;
	/* The egds for the chase. */
	private final ImmutableList<EqualityGenConstraint> egds;

	public ChaseContext(final Database db, final List<Assertion> assertions,
			final List<TupleGenConstraint> tgds,
			final List<EqualityGenConstraint> egds) {
		this.db = checkNotNull(db);
		this.assertions = ImmutableList.copyOf(checkNotNull(assertions));
		this.tgds = ImmutableList.copyOf(checkNotNull(tgds));
		this.egds = ImmutableList.copyOf(checkNotNull(egds));
	}

	public Database getDb() {
		return db;
	}

	public List<Assertion> getAssertions() {
		return assertions;
	}

	public List<TupleGenConstraint> getTgds() {
		return tgds;
	}

	public List<EqualityGenConstraint> getEgds() {
		return egds;
	}

	public void flush() {
		db.flush();
		assertions.stream().forEach(Assertion::flush);
		tgds.stream().forEach(TupleGenConstraint::flush);
		egds.stream().forEach(EqualityGenConstraint::flush);
	}
}
