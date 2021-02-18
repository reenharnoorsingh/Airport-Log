import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Airport {
    private final Queue<String> landingQueue;
    private final Queue<String> takeOffQueue;
    private final ArrayList<String> log;

    /**
     * Default Constructor
     */
    public Airport() {
        this.landingQueue = new LinkedList<String>();
        this.takeOffQueue = new LinkedList<String>();
        this.log = new ArrayList<String>();
    }

    public void addTakeOff(String flightNumber) {
        takeOffQueue.add(flightNumber);
    }

    public void addLanding(String flightNumber) {
        landingQueue.add(flightNumber);
    }

    public String handleNextAction() {
        String flightNumber;
        if (landingQueue.isEmpty() == true && takeOffQueue.isEmpty() == true) {
            return "No plane is waiting to land or take-off.";
        } else if (landingQueue.isEmpty() == false) {
            flightNumber = landingQueue.remove();
            log.add("Flight " + flightNumber + " landed.");
            return "Flight " + flightNumber + " is landing";
        } else {
            flightNumber = takeOffQueue.remove();
            log.add("Flight " + flightNumber + " taken-off.");
            return "Flight " + flightNumber + " is taking-off";
        }
    }

    public String waitingPlanes() {
        ArrayList<String> planeQueue = new ArrayList<>();

        if (landingQueue.isEmpty() == true && takeOffQueue.isEmpty() == true) {
            return "No plane is in the landing and take-off queues.";
        }
        if (takeOffQueue.isEmpty() == false) {
            System.out.println("Planes waiting for take-off\n");
            System.out.println("---------------------------\n");
            for (String item : takeOffQueue) {
                planeQueue.add(item);
            }
        }

        if (landingQueue.isEmpty() == false) {
            System.out.println("Planes waiting for landing\n");
            System.out.println("--------------------------\n");
            for (String item : landingQueue) {
                planeQueue.add(item);
            }
        }
        return planeQueue.toString();
    }

    public String log() {
        StringBuilder printLog = new StringBuilder();
        if (log.isEmpty() == true) {
            System.out.println("No activity exists.");
        } else {
            System.out.println("List of the landing/take-off activities\n");
            System.out.println("---------------------------------------\n");
            for (String list : log) {
                printLog.append(list + "\n");
            }
        }
        return printLog.toString();
    }
}
