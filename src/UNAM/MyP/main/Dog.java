package UNAM.MyP.main;


class Dog {
    private DogState angry;
    private DogState happy;
    private DogState sad;
    private DogState sleeping;
    private DogState dogState;

    Dog() {
        this.angry = new Angry();
        this.happy = new Happy();
        this.sad = new Sad();
        this.sleeping = new Sleeping();
        this.dogState = new Happy();
    }

    void setState(DogState newDogSate) {
        this.dogState = newDogSate;
    }


    void play() {
        System.out.println("the dog plays with you.");
    }

    void attack() {
        System.out.println("the dogs wants to bite you.");
        System.exit(1);
    }

    void eat() {
        System.out.println("the dog eats happily!");
    }


    void idle() {
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
    }

    private class Angry implements DogState {

        @Override
        public void pet() {
            // TODO: implement
        }

        @Override
        public void kick() {
            // TODO: implement
        }

        @Override
        public void feed() {
            // TODO: implement
        }
    }

    private class Happy implements DogState {

        @Override
        public void pet() {
            // TODO: implement
        }

        @Override
        public void kick() {
            // TODO: implement
        }

        @Override
        public void feed() {
            // TODO: implement
        }
    }

    private class Sad implements DogState {

        @Override
        public void pet() {
            // TODO: implement
        }

        @Override
        public void kick() {
            // TODO: implement
        }

        @Override
        public void feed() {
            // TODO: implement
        }
    }

    private class Sleeping implements DogState {

        @Override
        public void pet() {
            // TODO: implement
        }

        @Override
        public void kick() {
            // TODO: implement
        }

        @Override
        public void feed() {
            // TODO: implement
        }
    }
}
