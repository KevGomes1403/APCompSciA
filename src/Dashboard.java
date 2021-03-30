public class Dashboard implements Comparable{
    private int odometer;
    private int speedometer;
    private boolean checkEngine;

    public Dashboard () {
        this(0, 0);
        checkEngine = false;
    }

    public Dashboard (int milesTravelled, int speed) {
        if (milesTravelled >= 0 && milesTravelled <= 99999) {
            odometer = milesTravelled;
            checkEngine = false;
        } else {
            checkEngine = true;
            odometer = 0;
        }

        if (speed >= 0 && speed <= 100) {
            speedometer = speed;
            checkEngine = false;
        } else {
            checkEngine = true;
            speedometer = 0;
        }
    }

    public void accelerate () {
        if (speedometer != 100) {
            speedometer++;
        } else {
            speedometer = 0;
            checkEngine = true;
        }
    }

    public void drive (int numMinutes) {
        if (numMinutes > 720) {
            double hours = numMinutes / 60.0;
            double miles = hours * speedometer;
            odometer += Math.round(miles);

            if (odometer > 99999) {
                odometer = 0;
                checkEngine = true;
            }
        }
    }

    public int getOdometer() {
        return odometer;
    }

    public int getSpeedometer() {
        return speedometer;
    }

    public boolean getStatus() {
        return checkEngine;
    }

    public String toString () {
        String engine = "Off";
        if (checkEngine) {
            engine = "On";
        }

        String odo = "0000" + odometer;
        if (odometer > 999) {
            odo = "0" + odometer;
        } else if (odometer > 99) {
            odo = "00" + odometer;
        } else if (odometer > 9) {
            odo = "000" + odometer;
        } else if (odometer > 9999) {
            odo = "" + odometer;
        }
        String ofTheJedi = "Speedometer: " + speedometer + " MPH\nOdometer: " + odo + "\nCheck Engine: " + engine;
        return ofTheJedi;
    }

    public int compareTo(Object other) {
        Dashboard d = (Dashboard) other;

        if (this.getOdometer() == d.getOdometer()) {
            if (this.getSpeedometer() == d.getSpeedometer()) {
                if (this.getStatus() == d.getStatus()) {
                    return 0;
                } else if (!this.getStatus()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.getSpeedometer() < d.getSpeedometer()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.getOdometer() < d.getOdometer()){
            return -1;
        } else {
            return 1;
        }

    }

    public String race(Dashboard other, int acc1, int acc2) {
        boolean stalled1 = false;
        boolean stalled2 = false;
        String car1 = "";
        String car2 = "";
        String winner = "";
        String stat1;
        String stat2;
        String result = "";

        for(int i = 0; i < acc1; i++) {
            this.accelerate();

            if (this.checkEngine) {
                stalled1 = true;
                break;
            }
        }

        for (int i = 0; i < acc2; i++) {
            other.accelerate();

            if (other.getStatus()) {
                stalled2 = true;
                break;
            }
        }

        if (stalled1) {
            car1 = "First car stalled out!" + "\n";
        }

        if (stalled2) {
            car2 = "Second car stalled out!" + "\n";
        }

        if ((stalled1 && stalled2) || !(stalled1 || stalled2)) {
            if (this.speedometer > other.getSpeedometer()) {
                winner = "Car 1 has won the race!";
            } else if (this.speedometer < other.getSpeedometer()) {
                winner = "Car 2 has won the race!";
            } else {
                winner = "It's a tie!";
            }
        } else if (stalled1) {
            winner = "Car 2 has won the race!";
        } else if (stalled2) {
            winner = "Car 1 has won the race!";
        }

        stat1 = this.toString();
        stat2 = other.toString();

        result += car1 + car2 + "\n" + stat1 + "\n\n" + stat2 + "\n\n" + winner;
        return result;
    }

    //TODO: Fix this method according to edhesive standards
    public String difference(Dashboard other) {
        int result;
        String result1 = "";

        if (this.getOdometer() < other.getOdometer()) {
            double dx = other.getOdometer() - this.getOdometer();
            double result2 = dx / this.getSpeedometer() * 60.0;
            result = (int) Math.floor(result2);
            result1 = "First car will need to drive for " + result + " minutes to catch second car.";
        } else if (other.getOdometer() < this.getOdometer()) {
            double dx = this.getOdometer() - other.getOdometer();
            double result2 = (dx / other.getSpeedometer()) * 60.0;
            result = (int) Math.floor(result2);
            result1 = "Second car will need to drive for " + result + " minutes to catch first car.";
        }

        return result1;
    }
}