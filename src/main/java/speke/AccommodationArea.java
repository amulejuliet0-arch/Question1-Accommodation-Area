package speke;

public abstract class AccommodationArea {
    public final String name;
    private int occupants = 0;
    private final boolean[] lights = new boolean[] { false, false, false };

    protected AccommodationArea(String name) {
        this.name = name;
    }

    public void addOccupants(int count) {
        if (count < 0) return;
        occupants += count;
    }

    public void removeOccupants(int count) {
        if (count < 0) return;
        occupants = Math.max(0, occupants - count);
    }

    public void switchOnLight(int index) {
        if (index >= 1 && index <= 3) {
            lights[index - 1] = true;
        }
    }

    public void switchOffLight(int index) {
        if (index >= 1 && index <= 3) {
            lights[index - 1] = false;
        }
    }

    public void reportStatus() {
        System.out.println("\n=== Status Report: " + name + " ===");
        System.out.println("Occupants: " + occupants);
        for (int i = 0; i < lights.length; i++) {
            System.out.println("Light " + (i + 1) + ": " + (lights[i] ? "ON" : "OFF"));
        }
    }
}
