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
        System.out.print("Тип двигателя: ");
        engineType = s.next();
    }

    public void setMaxSpeed(){
        System.out.print("Максимальная скорость: ");
        maxSpeed = s.nextInt();
    }

    public void setAccelerationTime(){
        System.out.print("Время разгона до 100 км/ч: ");
        accelerationTime = s.nextInt();
    }

    public void setSeatingCapacity(){
        System.out.print("Пассажировместимость: ");
        seatingCapacity = s.nextInt();
    }

    private void setCurrentPassNum(int currentPassNum){
        this.currentPassNum = currentPassNum;
    }

    private void setCurrentSpeed(int currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }

    public int getDoorsNum(){
        return doorsNum;
    }

    public int getWheelsNum(){
        return wheelsNum;
    }

    ///////////////Speed///////////////

    public void setSpeed(){
        System.out.print("Текущая скорость: ");
        int speed = s.nextInt();
        if (speed <= maxSpeed){
            setCurrentSpeed(speed);
        } else {
            setCurrentSpeed(maxSpeed);
        }
    }

    public void changeCurrentSpeed(){
        if (currentPassNum > 0) {
            System.out.print("\t\tВведите новое значение скорости:  ");
            int speed = s.nextInt();
            if (speed <= maxSpeed) {
                currentSpeed = speed;
            } else {
                System.out.println("\t\tЧисло слишком большое.");
            }
        } else {
            System.out.println("\t\tСкорость невозможно изменить, потому что в машине никого нет.");
        }
    }

    public void countMaxCurrentSpeed(){
        if (currentPassNum > 0) {
            System.out.print("\tМаксимальная возможная скорость:  ");
            if (wheelsNum > 0) {
                double tireState = wheels.get(0).getTireState();
                for (int i = 0; i < wheelsNum; i++) {
                    if (wheels.get(i).getTireState() < tireState) {
                        tireState = wheels.get(i).getTireState();
                    }
                }
                System.out.println(maxSpeed * tireState);
            } else {
                System.out.println("\t\tВ машине нет колёс. Максимальная возможная скорость  - 0.");
            }
        } else {
            System.out.println("\t\tВ машине никого нет. Максимальная возможная скорость  - 0.");
        }
    }

    public void speedInfo(){
        System.out.println("\t\tТекущая скорость: " + currentSpeed);
    }

    ///////////////Passengers///////////////

    public void setPassengesNumber(){
        System.out.print("Введите количество пассажиров: ");
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
            System.out.println("\t\tПашина переполнена. Невозможно добавить пассажира.\n");
        }
    }

    public void removeOnePassenger(){
        if (currentPassNum > 0){
            currentPassNum--;
        } else {
            System.out.println("\t\tВ машине никого нет.");
        }
    }

    public void removeAllPassengers(){
        currentPassNum = 0;
        System.out.println("\t\tВсе пассажиры высажены из машины.");
    }

    public void passengersInfo(){
        System.out.println("\t\tТекущее количество пассажиров: " + currentPassNum);
    }

    ///////////////Wheels///////////////

    public void addSeveralWheels(){
        System.out.print("Введите количество колёс, которые нужно добавить: ");
        int n = s.nextInt();
        wheelsNum+=n;
        for (int i = 0; i < n; i++) {
            wheels.add(new CarWheels());
        }
        System.out.println("Колёса добавлены. Общее количество колёс: " + wheelsNum);
    }

    public void removeAllWheels(){
        for (int i = 0; i < wheelsNum; i++){
            wheels.remove(0);
        }
        wheelsNum = 0;
        System.out.println("\t\tВсе колёса сняты.");
    }

    public void setNewTire(){
        if (wheelsNum >0) {
            System.out.printf("\t\tВведите индекс колеса (1-%d): ", wheelsNum);
            int index = s.nextInt();
            if (index<=wheelsNum && index > 0){
                wheels.get(--index).setNewTire();
            } else {
                System.out.println("\t\tКолеса с таким индеексом не существует.");
            }
        } else {
            System.out.println("\t\tВсе колёса сняты.");
        }
    }

    public void changeTireRubbing(){
        if (wheelsNum >0) {
            System.out.printf("\t\tВведите индекс колеса (1-%d): ", wheelsNum);
            int index = s.nextInt();
            if (index<=wheelsNum && index > 0){
                System.out.printf("\t\tНа сколько процентов стереть шину: ");
                wheels.get(--index).tireRubbing(s.nextDouble());
            } else {
                System.out.println("\t\t.Колеса с таким индеексом не существует.");
            }
        } else {
            System.out.println("\t\tВсе колёса сняты.");
        }
    }

    public void wheelsInfo(){
        if (wheelsNum >0) {
            for (int i = 0; i < wheelsNum; i++){
                System.out.print("\t\t" + (i+1) + ". ");
                wheels.get(i).getInfo();
            }
        } else {
            System.out.println("\t\tВсе колёса сняты.");
        }
    }

    /////////////////Doors/////////////////

    public void changeDoorState(){
        if (doorsNum >0) {
            System.out.printf("\t\tВведите индекс двери (1-%d): ", doorsNum);
            int index = s.nextInt();
            if (index<=doorsNum && index > 0) {
                index--;
                doors.get(index).changeDoorState();
                doors.get(index).getDoorInfo();
            } else {
                System.out.println("\t\tДвери с таким индексом не сщуствует.");
            }
        } else {
            System.out.println("\t\tВ машине нет дверей.");
        }
    }

    public void doorsInfo(){
        System.out.println("\nОбщее количество дверей: " + doorsNum);
        if (doorsNum >0) {
            for (int i = 0; i < doorsNum; i++){
                System.out.print("\t\t" + (i+1) + " - ");
                doors.get(i).getDoorInfo();
            }
        } else {
            System.out.println("\t\tВ машине нет дверей.");
        }
        System.out.println("");
    }

    /////////////////Windows/////////////////

    public void changeWindowState(){
        if (doorsNum >0) {
            System.out.printf("\t\tВведите индекс окна (1-%d): ", doorsNum);
            int index = s.nextInt();
            if (index<=doorsNum && index > 0){
                index--;
                doors.get(index).changeWindowState();
                doors.get(index).getWindowInfo();
            } else {
                System.out.println("\t\tОкна с таким индексом не существует.");
            }
        } else {
            System.out.println("\t\tВ машине нет окон.");
        }
    }
    /////////////////General/////////////////

    public void getInfo(){
        System.out.println("ОБЩАЯ ИНФОРМАЦИЯ");
        System.out.println("\tДата производства:\t" + year);
        System.out.println("\tТип двигателя:\t" + engineType);
        System.out.println("\tВремя разгона:\t" + accelerationTime);
        System.out.println("\tМаксимальная скорость:\t" + maxSpeed);
        System.out.printf("\tТекущая скорость:\t%d\n", currentSpeed);
        countMaxCurrentSpeed();
        System.out.println("\tПассажировместимость:\t" + seatingCapacity);
        System.out.println("\tТекущее количество пассажиров:\t" + currentPassNum);
        System.out.printf("\tКоличество дверей:\t%d\n\tКоличество колёс: \t%d\n", doorsNum, wheelsNum);
    }

}
