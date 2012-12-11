public class item {
	private Object datum;
	private item child;

	public item() {
		this(0, null);
	}

	public item(Object d) {
		datum = d;
	}

	public item(Object d, item n) {
		datum = d;
		child = n;
	}

	public void setDatum(Object d) {
		datum = d;
	}

	public void setChild(item n) {
		child = n;
	}

	public Object getDatum() {
		return this.datum;
	}

	public item getChild() {
		return this.child;
	}

	public void displayNode() {
		System.out.print(datum);
	}
}
