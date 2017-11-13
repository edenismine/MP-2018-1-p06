package fciencias.myp.main;

import fciencias.clutil.CLUtil;

import java.util.Random;

/**
 * Implementation of a Dog using the State design pattern.
 * Has four states (angry, happy, sad, sleeping) and three
 * possible interactions (pet, feed, kick), as well as four
 * reactions (play, eat, attack, growl).
 *
 * @author Luis Daniel Aragon Bermudez 416041271
 */
class Dog {
    /**
     * Random.
     */
    private final Random random = new Random();
    /**
     * Angry context.
     */
    private DogState angry;
    /**
     * Happy context.
     */
    private DogState happy;
    /**
     * Sad context.
     */
    private DogState sad;
    /**
     * Sleeping context.
     */
    private DogState sleeping;
    /**
     * Current context.
     */
    private DogState dogState;
    /**
     * Current positive stimulus level.
     */
    private int positiveStimulus;
    /**
     * Current negative stimulus level.
     */
    private int negativeStimulus;

    /**
     * Creates a dog with a random state.
     */
    Dog() {
        this.angry = new Angry();
        this.happy = new Happy();
        this.sad = new Sad();
        this.sleeping = new Sleeping();
        this.dogState = this.initState();
    }

    /**
     * Randomly returns one of the dog's states.
     *
     * @return a random context.
     */
    private DogState initState() {
        int randInt = random.nextInt(3);
        DogState[] states = {getAngry(), getHappy(), getSad()};
        return states[randInt];
    }

    /**
     * Sets the current context to the provided context and prints its corresponding message.
     *
     * @param newDogSate The dog's new context.
     */
    private void setState(DogState newDogSate) {
        this.dogState = newDogSate;
        this.dogState.message();
    }

    /**
     * Describes what happens when the dog plays.
     */
    private void play() {
        System.out.println("The dog plays with you.");
    }

    /**
     * Describes what happens when the dog attacks. Exits the program.
     */
    private void attack() {
        System.out.println("The dog bit you!");
        System.exit(1);
    }

    /**
     * Describes what happens when the dog eats.
     */
    private void eat() {
        System.out.println("The dog eats the food!");
    }

    /**
     * Describes what happens when the dog growls.
     */
    private void growl() {
        System.out.println("The dog growls at you.");
    }

    /**
     * Reaction when the dog is pet.
     */
    void pet() {
        this.dogState.pet();
    }

    /**
     * Reaction when the dog is kicked.
     */
    void kick() {
        this.dogState.kick();
    }

    /**
     * Reaction when the dog is fed.
     */
    void feed() {
        this.dogState.feed();
    }

    /**
     * Retrieves The dog's Angry context.
     *
     * @return The dog's Angry context.
     */
    private DogState getAngry() {
        return angry;
    }

    /**
     * Retrieves The dog's Happy context.
     *
     * @return The dog's Happy context.
     */
    private DogState getHappy() {
        return happy;
    }

    /**
     * Retrieves The dog's Sad context.
     *
     * @return The dog's Sad context.
     */
    private DogState getSad() {
        return sad;
    }

    /**
     * Retrieves The dog's Sleeping context.
     *
     * @return The dog's Sleeping context.
     */
    private DogState getSleeping() {
        return sleeping;
    }

    /**
     * Interface that describes a valid state for a Dog.
     */
    private interface DogState {
        /**
         * Reaction when the dog is pet.
         */
        void pet();

        /**
         * Reaction when the dog is kicked.
         */
        void kick();

        /**
         * Reaction when he dog is fed.
         */
        void feed();

        /**
         * Gets a description of the dog's state.
         */
        void message();
    }

    /**
     * DogState of an Angry dog and its corresponding reactions.
     */
    private class Angry implements DogState {

        @Override
        public void pet() {
            this.feed();
        }

        @Override
        public void kick() {
            attack();
        }

        @Override
        public void feed() {
            positiveStimulus++;
            growl();
            if (positiveStimulus > 2) {
                positiveStimulus = 0;
                setState(getHappy());
            } else {
                this.message();
            }
        }

        @Override
        public void message() {
            System.out.println("The dog seems uneasy. It must be angry.");
        }
    }

    /**
     * DogState of a Happy dog and its corresponding reactions.
     */
    private class Happy implements DogState {

        @Override
        public void pet() {
            play();
            this.message();
        }

        @Override
        public void kick() {
            growl();
            setState(getAngry());
        }

        @Override
        public void feed() {
            eat();
            int randInt = random.nextInt(2);
            switch (randInt) {
                case 0:
                    setState(getHappy());
                    break;
                default:
                    setState(getSleeping());
                    setState(getHappy());
                    break;
            }
        }

        @Override
        public void message() {
            System.out.println("The dog is wagging its tail. It must be happy!");
        }
    }

    /**
     * DogState of a Sad dog and its corresponding reactions.
     */
    private class Sad implements DogState {

        @Override
        public void pet() {
            play();
            setState(getHappy());
        }

        @Override
        public void kick() {
            negativeStimulus++;
            if (negativeStimulus > 2) {
                negativeStimulus = 0;
                setState(getAngry());
            } else {
                this.message();
            }
        }

        @Override
        public void feed() {
            eat();
            setState(getHappy());
        }

        @Override
        public void message() {
            System.out.println("The dog's ears are down. It looks sad.");
        }
    }

    /**
     * DogState of a Sleeping dog and its corresponding reactions.
     */
    private class Sleeping implements DogState {

        @Override
        public void pet() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void kick() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void feed() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void message() {
            System.out.print("The dog is sleeping");
            for (char x : ".....".toCharArray()) {
                System.out.print(x);
                CLUtil.sleep(1000);
            }
            setState(getHappy());
        }
    }
}
