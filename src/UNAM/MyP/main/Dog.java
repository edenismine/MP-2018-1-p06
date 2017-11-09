package UNAM.MyP.main;


class Dog {
	
	
	String mood;

	Dog() {
	}

	void setMood(String edo) {
		mood =edo;
	}


	void play() {
		System.out.println("the dog plays with you.");
	}

	void attack() {
		System.out.println("the dogs wants to bite you.");

	}

	void eat() {
		System.out.println("the dog eats happily!");
	}


	void idle() {
		System.out.println("the dog sits idly. He seems to be trying to figure out what to do next.");
	}

}
