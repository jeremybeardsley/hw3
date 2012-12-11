class list {
	private item top;
	private item lastTop;
	String output;

	public list() {
		top = null;
		lastTop = null;
	}

	public void push(Object a) {
		item temp = new item(a);
		lastTop = top;
		temp.setChild(top);
		top = temp;
	}

	public Object pop() {
		Object a = top.getDatum();
		top = top.getChild();
		return a;
	}

	public boolean empty() {
		return (top == null);
	}

	public Object ontop() {
		Object a = top.getDatum();

		return a;
	}

	public Object previousTop() {
		Object a = lastTop.getDatum();

		return a;
	}

	public int Priority(Object item) {
		if (item.equals(">"))
			return 1;
		if (item.equals("<"))
			return 2;
		if (item.equals("&"))
			return 4;
		if (item.equals("V"))
			return 3;
		if (item.equals("~"))
			return 5;
		if (item.equals("("))
			return 0;

		return 7;
	}

	public void postfix(String item) {
		list testList = new list();
		output = "";

		for (int i = 0; i < item.length(); i++) {
			char ch = item.charAt(i);
			if (ch == ('V') || ch == ('&') || ch == ('~') || ch == ('#')
					|| ch == ('>') || ch == ('<')) {
				while (!testList.empty()
						&& Priority(testList.ontop()) >= Priority(ch))
					output += testList.pop();
				testList.push(ch);
			} else if (ch == '(') {
				testList.push(ch);
			} else if (ch == ')') {
				while (!testList.ontop().equals('('))
					output += testList.pop();
				testList.pop();
			} else
				output += ch;
		}
		while (!testList.empty()) {
			output += testList.pop();
		}
		System.out.println("Postfix Form = " + output);
	}

	public void Evaluate(String g) {
		list testList = new list();
		String v1 = "", v2 = "", v3 = "", v4 = "", v5 = "", v6 = "", v7 = "", v8 = "", v9 = "";
		String m = "";
		String l = "";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';
			if (ch == 'P' || ch == 'Q' || ch == 'R') {
				testList.push(z);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}

		}
		if (testList.pop().equals("t"))
			v1 = "true";
		else
			v1 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';

			if (ch == 'P' || ch == 'Q') {
				testList.push(z);
				m += z;
			} else if (ch == 'R') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v2 = "true";
		else
			v2 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';
			if (ch == 'P' || ch == 'R') {
				testList.push(z);
				m += z;
			} else if (ch == 'Q') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v3 = "true";
		else
			v3 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';

			if (ch == 'P') {
				testList.push(z);
				m += z;
			} else if (ch == 'Q' || ch == 'R') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v4 = "true";
		else
			v4 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';

			if (ch == 'Q' || ch == 'R') {
				testList.push(z);
				m += z;
			} else if (ch == 'P') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v5 = "true";
		else
			v5 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';

			if (ch == 'Q') {
				testList.push(z);
				m += z;
			} else if (ch == 'P' || ch == 'R') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v6 = "true";
		else
			v6 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';

			if (ch == 'R') {
				testList.push(z);
				m += z;
			} else if (ch == 'P' || ch == 'Q') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}

				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v7 = "true";
		else
			v7 = "false";

		for (int i = 0; i < g.length(); i++) {
			char ch = g.charAt(i);
			char z = 't';
			char y = 'f';

			if (ch == 'Q' || ch == 'P' || ch == 'R') {
				testList.push(y);
				m += z;
			} else if (ch == '>') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '<') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				}
				m += ch;
			} else if (ch == '&') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == 'V') {
				if (testList.ontop().equals("t")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("t")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("t")) {
					testList.pop();
					testList.pop();
					testList.push(z);
				} else if (testList.ontop().equals("f")
						&& testList.previousTop().equals("f")) {
					testList.pop();
					testList.pop();
					testList.push(y);
				}
				m += ch;
			} else if (ch == '~') {
				if (testList.ontop().equals("t")) {
					testList.pop();
					testList.push(y);
				} else {
					testList.pop();
					testList.push(z);
				}
				m += ch;
			}
		}
		if (testList.pop().equals("t"))
			v8 = "true";
		else
			v8 = "false";

		if (v1 == "true" && v2 == "true" && v3 == "true" && v4 == "true"
				&& v5 == "true" && v7 == "true" && v7 == "true")
			System.out.println("Equivalent");
		else
			System.out.println("Not equivalent");
	}
}
