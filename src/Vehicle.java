public class Vehicle {
    private int location;

    public Vehicle() {
        location = 0;
    }

    public Vehicle(int location) {
        if (location <= 20 && location >= -20) {
            this.location = location;
        } else {
            this.location = 0;
        }
    }

    public void forward() {
        if (this.location < 20) {
            this.location++;
        }
    }

    public void backward() {
        if (this.location > -20) {
            this.location--;
        }
    }

    public int getLocation() {
        return this.location;
    }

    public String toString() {
        String result = "";

        for (int i = -20; i < this.location; i++) {
            result += " ";
        }
        result += "@";

        return result;
    }
}
