package autoservice;

import java.util.ArrayList;

import static autoservice.MainClass.s;

public class Car {
    private final String year;
    private String engineType;
    private int maxSpeed;
    private int accelerationTime;
    private int seatingCapacity;
    private int currentPassNum;
    private int currentSpeed;
    private int doorsNum = 4;
    private int wheelsNum = 4;
    private ArrayList<CarDoors> doors = new ArrayList<>();
    private ArrayList<CarWheels> wheels = new ArrayList<>();

    public Car(String year){
        this.year = year;
        addDoors();
        addWheels();
    }

    private void addDoors(){
        for (int i = 0; i < doorsNum; i++){
            doors.add(new CarDoors());
        }
    }

    private void addWheels(){
        for (int i = 0; i < wheelsNum; i++){
            wheels.add(new CarWheels());
        }
    }

    //////////////get/set/////////////

    public void setEngineType(){
        System.out.print("Set engine type: ");
        engineType = s.next();
    }

    public void setMaxSpeed(){
        System.out.print("Set maximum speed: ");
        maxSpeed = s.nextInt();
    }

    public void setAccelerationTime(){
        System.out.print("Set acceleration time: ");
        accelerationTime = s.nextInt();
    }

    public void setSeatingCapacity(){
        System.out.print("Set seating capacity: ");
        seatingCapacity = s.nextInt();
    }

    private void setCurrentPassNum(int currentPassNum){
        this.currentPassNum = currentPassNum;
    }

    private void setCurrentSpeed(int currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }

    public int getSeatingCapacity(){
        return seatingCapacity;
    }

    public int getDoorsNum(){
        return doorsNum;
    }

    public int getWheelsNum(){
        return wheelsNum;
    }

    ///////////////Speed///////////////

    public void setSpeed(){
        System.out.print("Set current speed: ");
        int speed = s.nextInt();
        if (speed <= maxSpeed){
            setCurrentSpeed(speed);
        } else {
            setCurrentSpeed(maxSpeed);
        }
    }

    public void changeCurrentSpeed(){
        if (currentPassNum > 0) {
            System.out.print("\t\tChanging the speed. Enter new value:  ");
            int speed = s.nextInt();
            if (speed <= maxSpeed) {
                currentSpeed = speed;
            } else {
                System.out.println("\t\tThe value is too big.");
            }
        } else {
            System.out.println("\t\tThere is no one in the car. The speed can't be changed.");
        }
    }

    public void countMaxCurrentSpeed(){
        if (currentPassNum > 0) {
            System.out.print("\t\tMaximum current speed:  ");
            if (wheelsNum > 0) {
                double tireState = wheels.get(0).getTireState();
                for (int i = 0; i < wheelsNum; i++) {
                    if (wheels.get(i).getTireState() < tireState) {
                        tireState = wheels.get(i).getTireState();
                    }
                }
                System.out.println(maxSpeed * tireState);
            } else {
                System.out.println("\t\tThere are no wheels in the car.");
            }
        } else {
            System.out.println("\t\tThere is no one in the car. Maximum speed is 0.");
        }
    }

    public void speedInfo(){
        System.out.println("\t\tCurrent speed: " + currentSpeed);
    }

    ///////////////Passengers///////////////

    public void setPassengesNumber(){
        System.out.print("Set current passengers number: ");
        int passengers = s.nextInt();
        if (passengers <= seatingCapacity){
            setCurrentPassNum(passengers);
        } else {
            setCurrentPassNum(seatingCapacity);
        }
    }

    public void addPassenger(){
        if (seatingCapacity - currentPassNum > 0){
            currentPassNum++;
        } else {
            System.out.println("\t\tYou can't add more passengers.");
        }
    }

    public void removeOnePassenger(){
        if (currentPassNum > 0){
            currentPassNum--;
        } else {
            System.out.println("\t\tThere is no one in the car.");
        }
    }

    public void removeAllPassengers(){
        currentPassNum = 0;
        System.out.println("\t\tAll passengers are out.");
    }

    public void passengersInfo(){
        System.out.println("\t\tCurrent number of passengers: " + currentPassNum);
    }

    ///////////////Wheels///////////////

    public void addSeveralWheels(){
        System.out.print("Enter the number of wheels you want to add: ");
        int n = s.nextInt();
        wheelsNum+=n;
        for (int i = 0; i < n; i++) {
            wheels.add(new CarWheels());
        }
        System.out.println("One wheel added. Total number of wheels: " + wheelsNum);
    }

    public void removeAllWheels(){
        for (int i = 0; i < wheelsNum; i++){
            wheels.remove(0);
        }
        wheelsNum = 0;
        System.out.println("\t\tAll wheels were removed.");
    }

    public void setNewTire(){
        if (wheelsNum >0) {
            System.out.printf("\t\tEnter the number of the wheel (1-%d): ", wheelsNum);
            int index = s.nextInt();
            if (index<=wheelsNum && index > 0){
                wheels.get(--index).changeTire();
            } else {
                System.out.println("\t\tYou entered wrong index.");
            }
        } else {
            System.out.println("\t\tThere are no wheels.");
        }
    }

    public void changeTireRubbing(){
        if (wheelsNum >0) {
            System.out.printf("\t\tEnter the number of the wheel (1-%d): ", wheelsNum);
            int index = s.nextInt();
            if (index<=wheelsNum && index > 0){
                System.out.printf("\t\tEnter the tire percentage: ");
                wheels.get(--index).tireRubbing(s.nextDouble());
            } else {
                System.out.println("\t\tYou entered wrong index.");
            }
        } else {
            System.out.println("\t\tThere are no wheels.");
        }
    }

    public void wheelsInfo(){
        if (wheelsNum >0) {
            for (int i = 0; i < wheelsNum; i++){
                System.out.print("\t\t" + (i+1) + ". ");
                wheels.get(i).getInfo();
            }
        } else {
            System.out.println("\t\tThere are no wheels.");
        }
    }

    /////////////////Doors/////////////////

    public void changeDoorState(boolean open){
        if (doorsNum >0) {
            System.out.printf("\t\tEnter the number of the door (1-%d): ", wheelsNum);
            int index = s.nextInt();
            if (index<=doorsNum && index > 0){
                index--;
                if (open) {
                    doors.get(index).openTheDoor();
                } else {
                    doors.get(index).closeTheDoor();
                }
            } else {
                System.out.println("\t\tYou entered wrong index.");
            }
        } else {
            System.out.println("\t\tThere are no doors.");
        }
    }

    public void doorsInfo(){
        System.out.println("\nTotal number of doors: " + doorsNum);
        if (doorsNum >0) {
            for (int i = 0; i < doorsNum; i++){
                System.out.print("\t\t" + (i+1) + " - ");
                doors.get(i).getDoorInfo();
            }
        } else {
            System.out.println("\t\tThere are no doors.");
        }
        System.out.println("");
    }

    /////////////////Windows/////////////////

    public void changeWindowState(boolean open){
        if (doorsNum >0) {
            System.out.printf("\t\tEnter the number of the window (1-%d): ", doorsNum);
            int index = s.nextInt();
            if (index<=doorsNum && index > 0){
                index--;
                if (!doors.get(index).isWindowOpened() && open){
                    doors.get(index).changeWindowState();
                } else {
                    if (doors.get(index).isWindowOpened() && !open) {
                        doors.get(index).changeWindowState();
                    }
                }
            } else {
                System.out.println("\t\tYou entered wrong index.");
            }
        } else {
            System.out.println("\t\tThere are no doors.");
        }
    }
    /////////////////General/////////////////

    public void getInfo(){
        System.out.println("GENERAL INFORMATION");
        System.out.println("\tYear of manufacture:\t" + year);
        System.out.println("\tEngine type:\t" + engineType);
        System.out.println("\tAcceleration time:\t" + accelerationTime);
        System.out.println("\tSPEED:\n\t\tMaximum speed:\t" + maxSpeed);
        System.out.printf("\t\tCurrent speed:\t%d\n", currentSpeed);
        countMaxCurrentSpeed();
        System.out.println("\tPASSENGERS:\n\t\tSeating capacity:\t" + seatingCapacity);
        System.out.println("\t\tCurrent passengers number:\t" + currentPassNum);
        System.out.printf("\tDoors number:\t%d\n\tWheels number: \t%d\n", doorsNum, wheelsNum);
    }

    /*public Car(int year, String engineType, int maxSpeed, int accelerationTime, int seatingCapacity,
               int currentPassnum){
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.seatingCapacity = seatingCapacity;
        this.currentPassnum = currentPassnum;
        this.currentSpeed = currentSpeed;
    }*/

}
