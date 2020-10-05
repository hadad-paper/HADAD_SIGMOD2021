package hadad.base.compiler.model.rk;

public enum DataType {
	LIST("l"), SET("s"), MAP("m"), INTERNALMAP("im"), KEYSLOOKUP("km");

	private final String str;

	private DataType(final String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}
}
