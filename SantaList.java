package santaSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SantaList {

	private HashMap<Person, Person> map;
	private Random rand;
	private ArrayList<Person> giftees;
	private ArrayList<Person> santas;

	public SantaList(ArrayList<Person> people) {

		rand = new Random();
		giftees = new ArrayList<Person>();
		santas = new ArrayList<Person>();
		map = new HashMap<Person, Person>();

		for (int i = 0; i < people.size(); i++) {
			giftees.add(people.get(i));
			santas.add(people.get(i));

		}

		assignSanta();

	}

	// plan cycle through all the santas and assign them a randomly selected giftee
	// if the giftee matches, assign another giftee
	// remove the giftee from the list
	// if last giftee and santa match, do a swap

	private void assignSanta() {

		for (int i = 0; i < santas.size(); i++) {
			Person giftee;
			Person santa = santas.get(i);

			if (giftees.size() == 1) {
				if (giftees.get(0).getName().equals(santa.getName())) {
					giftee = giftees.get(0);
					map.put(santa, giftee);

					this.swap(santa, santas.get(i - 1));

				} else {
					giftee = giftees.get(0);
					map.put(santa, giftee);
					giftees.remove(giftee);
				}

			} else {
				giftee = this.getGiftee(santa);
				map.put(santa, giftee);
				giftees.remove(giftee);
			}
		}

		// somehow randomly assign

	}

	public Person whoDoIBuyAGiftFor(Person me) {
		return map.get(me);
	}

	public String whatDoTheyLike(Person p) {
		return p.getColor();
	}

	private boolean swap(Person a, Person b) {
		String personA = a.getName();
		String personB = b.getName();
		String personAGiftee = map.get(a).getName();
		String personBGiftee = map.get(b).getName();
		if (personA.equals(personBGiftee) || personB.equals(personAGiftee) || personA.equals(personB)) {
			return false;
		} else {
			Person temp = map.get(a);
			map.put(a, map.get(b));
			map.put(b, temp);
			return true;
		}
	}

	// this will get a random person from the giftees list
	public Person getGiftee(Person santa) {
		int randomIndex = rand.nextInt(giftees.size() - 1);
		Person giftee = giftees.get(randomIndex);

		// if the giftee is the same as the santa, then call getGiftee again
		if (giftee.getName().equals(santa.getName())) {
			return this.getGiftee(santa);
		}
		// special cases
		// giftee and santa are the same person
		// there is only one giftee left and it matches the person
		// swap if the last one

		return giftee;
	}

	public HashMap<Person, Person> getMap() {
		return map;
	}

	public void manualMap(Person santa, Person giftee) {
		map.put(santa, giftee);
	}

	public ArrayList<Person> getSantas() {
		return santas;
	}

}
