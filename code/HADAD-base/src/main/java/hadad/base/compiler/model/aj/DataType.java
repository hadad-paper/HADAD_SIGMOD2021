package hadad.base.compiler.model.aj;

public enum DataType {
	OBJECT("o"), ARRAY("a");

	private final String str;

	private DataType(final String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}
}
