package santaSimple;

public class Person {

	private String name;
	private String color;

	public Person(String _name) {
		setName(_name);
		// setColor(_color);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
