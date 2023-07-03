
import java.util.Random;

public class Main {

    private static ProcessState processState = ProcessState.RUNNING;
    private static final Object mutex = new Object();
    private static Thread abstractProgram = new Thread(new AbstractProgram());


    static class AbstractProgram implements Runnable {

        @Override
        public void run() {
            System.out.println("Abstract program start");
            Thread daemonThread = new Thread(() -> {
                try {
                while (true) {

                    Thread.sleep(new Random().nextInt(3000));

                    synchronized (mutex) {
                        processState = ProcessState.values()[new Random().nextInt(ProcessState.values().length)];
                        System.out.println("Daemon changed program state to " + processState);
                        mutex.notify();
                    }
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            daemonThread.setDaemon(true); //поток не будет препятствовать выходу JVM после завершения программы
            daemonThread.start();
            System.out.println("Started the daemon thread");
        }
    }

    static class Supervisor implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Supervisor is working");
                abstractProgram.start();
                while (!abstractProgram.isInterrupted()) {
                    synchronized (mutex) {
                            mutex.wait();
                        switch (processState) {
                            case FATAL_ERROR:
                                abstractProgram.interrupt();
                                //processState = ProcessState.RUNNING;
                                System.out.println("Supervisor stopped the program");
                                break;
                            case STOPPING, UNKNOWN:
                                processState = ProcessState.RUNNING;
                                System.out.println("Supervisor restarted the program");
                                break;
                            case RUNNING:
                                System.out.println("Supervisor did nothing");
                                break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new Supervisor()).start();
    }
}
