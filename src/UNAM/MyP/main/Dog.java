package UNAM.MyP.main;

import java.util.Random;

class Dog {
    private DogState angry;
    private DogState happy;
    private DogState sad;
    private DogState sleeping;
    private DogState dogState;
    private final Random random = new Random();
    private int positiveStimulus;
    private int negativeStimulus;

    Dog() {
        this.angry = new Angry();
        this.happy = new Happy();
        this.sad = new Sad();
        this.sleeping = new Sleeping();
        this.dogState = this.initState();
    }

    private DogState initState() {
        int randInt = random.nextInt(4);
        DogState[] states = {getAngry(), getHappy(), getSad(), getSleeping()};
        return states[randInt];
    }

    private void setState(DogState newDogSate) {
        this.dogState = newDogSate;
        this.dogState.message();
    }


    private void play() {
        System.out.println("the dog plays with you.");
    }

    private void attack() {
        System.out.println("the dog bit you!");
        System.exit(1);
    }

    private void eat() {
        System.out.println("the dog eats the food!");
    }

    private void growl() {
        System.out.println("the dog growls at you.");
    }


    private void idle() {
        System.out.println("the dog sits idly. He seems to be trying to figure out what to do next.");
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

    private DogState getAngry() {
        return angry;
    }

    private DogState getHappy() {
        return happy;
    }

    private DogState getSad() {
        return sad;
    }

    private DogState getSleeping() {
        return sleeping;
    }

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
         * Reaction when the dog is fed.
         */
        void feed();

        /**
         * Gets a description of the dog's state.
         */
        void message();
    }

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
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            setState(getHappy());
        }
    }
}
