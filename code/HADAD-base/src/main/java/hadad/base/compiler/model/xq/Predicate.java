package hadad.base.compiler.model.xq;

public enum Predicate {
	CHILD("child_xq"),
	DESCENDANT("desc_xq"),
	TEXT("text_xq"),
	TAG("tag_xq"),
	ROOT("root_xq"),
	HAS_ATTRIBUTE("attr_xq"),
	HAS_ATTRIBUTE_VALUE("val_xq"),
	EQUALS("eq_xq"),
	EXTRACT("extr_xq"),
	CREATE("create_xq"),
	COPY("copy_xq"),
	SKOLEM("sk_xq");

	private final String str;

	private Predicate(final String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}
}
