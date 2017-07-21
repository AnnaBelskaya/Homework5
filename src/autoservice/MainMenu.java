package autoservice;

import static autoservice.MainClass.s;

public class MainMenu {
    private Car car;

    public void createCar(){
        System.out.println("\tNEW CAR");
        System.out.print("Enter the date of manufacture: ");
        String date = s.next();
        car = new Car(date);
        car.setEngineType();
        car.setMaxSpeed();
        car.setAccelerationTime();
        car.setSeatingCapacity();
        car.setPassengesNumber();
        car.setSpeed();
        nextActions();
    }

    public void nextActions(){
        System.out.println("MENU");
        System.out.println("\t1. Add/remove passengers.");
        System.out.println("\t2. Open/close doors.");
        System.out.println("\t3. Open/close windows.");
        System.out.println("\t4. Change speed.");
        System.out.println("\t5. Add/remove wheels.");
        System.out.println("\t6. Show/change info.");
        System.out.println("\t7. Exit.");
        System.out.print("\n\tEnter the number of the next action: ");
        switch (s.nextInt()){
            case 1:
                actionsWithPassengers();
                break;
            case 2:
                actionsWithDoors();
                break;
            case 3:
                actionsWithWindows();
                break;
            case 4:
                actionsWithSpeed();
                break;
            case 5:
                actionsWithWheels();
                break;
            case 6:
                generalInfo();
                break;
        }
    }


    public void actionsWithPassengers(){
        System.out.println("\nPASSENGERS:");
        car.passengersInfo();
        System.out.println("\t\t1. Add passengers.");
        System.out.println("\t\t2. Remove passengers.");
        System.out.println("\t\t3. Remove all passengers.");
        System.out.println("\t\t4. Back to main menu.");
        System.out.print("\t\tEnter the number of the next action: ");
        switch (s.nextInt()){
            case 1:
                car.addPassenger();
                car.passengersInfo();
                actionsWithPassengers();
                break;
            case 2:
                car.removeOnePassenger();
                car.passengersInfo();
                actionsWithPassengers();
                break;
            case 3:
                car.removeAllPassengers();
                car.passengersInfo();
                actionsWithPassengers();
                break;
            case 4:
                nextActions();
                break;
        }
    }
    public void actionsWithDoors() {
        System.out.println("\nDOORS:");
        System.out.println("Total number of the doors is: " + car.getDoorsNum());
        System.out.println("\t\t1. Open the door.");
        System.out.println("\t\t2. Close the door.");
        System.out.println("\t\t3. Information about doors.");
        System.out.println("\t\t4. Back to the main menu.");
        System.out.print("\t\tEnter the number of the next action: ");
        switch (s.nextInt()) {
            case 1:
                car.changeDoorState(true);
                actionsWithDoors();
                break;
            case 2:
                car.changeDoorState(false);
                actionsWithDoors();
                break;
            case 3:
                car.doorsInfo();
                actionsWithDoors();
                break;
            case 4:
                nextActions();
                break;
        }
    }
    public void actionsWithWindows(){
        System.out.println("\nWINDOWS:");
        System.out.println("Total number of the windows is: " + car.getDoorsNum());
        System.out.println("\t\t1. Open the window.");
        System.out.println("\t\t2. Close the window.");
        System.out.println("\t\t3. Back to main menu.");
        System.out.print("\t\tEnter the number of the next action: ");
        switch (s.nextInt()) {
            case 1:
                car.changeWindowState(true);
                actionsWithWindows();
                break;
            case 2:
                car.changeWindowState(false);
                actionsWithWindows();
                break;
            case 3:
                nextActions();
                break;
        }

    }
    public void actionsWithSpeed(){
        System.out.println("\nSPEED:");
        System.out.println("Current speed is: " + car.getCurrentSpeed());
        System.out.println("\t\t1. Change current speed.");
        System.out.println("\t\t2. Change maximum speed.");
        System.out.println("\t\t3. Show current maximum speed.");
        System.out.println("\t\t4. Back to the main menu.");
        System.out.print("\t\tEnter the number of the next action: ");
        switch (s.nextInt()) {
            case 1:
                car.changeCurrentSpeed();
                actionsWithSpeed();
                break;
            case 2:
                car.setMaxSpeed();
                actionsWithSpeed();
                break;
            case 3:
                car.countMaxCurrentSpeed();
                actionsWithSpeed();
                break;
            case 4:
                nextActions();
                break;
        }
    }
    public void actionsWithWheels(){
        System.out.println("\nWHEELS:");
        System.out.println("Total number of the wheels is: " + car.getWheelsNum());
        System.out.println("\t\t1. Add wheel.");
        System.out.println("\t\t2. Remove all wheels.");
        System.out.println("\t\t3. Change tire.");
        System.out.println("\t\t4. Change tire rubbing.");
        System.out.println("\t\t5. Show information about wheels.");
        System.out.println("\t\t6. Back to the main menu.");
        System.out.print("\t\tEnter the number of the next action: ");
        switch (s.nextInt()) {
            case 1:
                car.addSeveralWheels();
                actionsWithWheels();
                break;
            case 2:
                car.removeAllWheels();
                actionsWithWheels();
                break;
            case 3:
                car.setNewTire();
                actionsWithWheels();
                break;
            case 4:
                car.changeTireRubbing();
                actionsWithWheels();
                break;
            case 5:
                car.wheelsInfo();
                actionsWithWheels();
                break;
            case 6:
                nextActions();
                break;
        }
    }
    public void generalInfo() {
        System.out.println("\nGENERAL INFORMATION:");
        System.out.println("\t\t1. Show general information.");
        System.out.println("\t\t2. Change engine type.");
        System.out.println("\t\t3. Change acceleration time.");
        System.out.println("\t\t4. Change seating capacity.");
        System.out.println("\t\t5. Back to the main menu.");
        System.out.print("\n\t\tEnter the number of the next action: ");
        switch (s.nextInt()) {
            case 1:
                car.getInfo();
                generalInfo();
                break;
            case 2:
                car.setEngineType();
                generalInfo();
                break;
            case 3:
                car.setAccelerationTime();
                generalInfo();
                break;
            case 4:
                car.setSeatingCapacity();
                generalInfo();
                break;
            case 5:
                nextActions();
                break;
        }
    }
}
