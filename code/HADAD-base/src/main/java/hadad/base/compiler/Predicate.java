package hadad.base.compiler;

public enum Predicate {
	EQUALS("eq");

	private final String str;

	private Predicate(final String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}
}
