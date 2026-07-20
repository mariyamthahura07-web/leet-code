class DiningPhilosophers {

    ReentrantLock[] fork = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            fork[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        // Philosopher 4 picks right fork first
        if (philosopher == 4) {
            fork[right].lock();
            fork[left].lock();
        } else {
            fork[left].lock();
            fork[right].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        fork[left].unlock();
        fork[right].unlock();
    }
}
