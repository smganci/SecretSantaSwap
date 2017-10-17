package santaSimple;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Person a = new Person("Sarah");
		Person b = new Person("Anna");
		Person c = new Person("Jamie");
		Person d = new Person("Hailey");
		Person e = new Person("Morgan");
		Person m = new Person("Mac <3");

		ArrayList<Person> list = new ArrayList<Person>();

		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(m);

		SantaList santa = new SantaList(list);
		ArrayList<Person> people = santa.getSantas();
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i).getName());
		}

		// System.out.println(santa.getGiftee(a).getName());

		printSantas(santa.getMap());

	}

	public static void printSantas(HashMap<Person, Person> map) {
		for (Person p : map.keySet()) {
			System.out.println("Santa: " + p.getName() + ", Giftee: " + map.get(p).getName());
		}

	}

}
