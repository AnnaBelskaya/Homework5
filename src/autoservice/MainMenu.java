package autoservice;

import static autoservice.MainClass.s;

public class MainMenu {
    private Car car;

    public void createCar(){
        System.out.println("\tНовая машина");
        System.out.print("Введите дату производства: ");
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

    private void nextActions(){
        System.out.println("МЕНЮ");
        System.out.println("\t1. Добавить/высадить 1 пассажира.");
        System.out.println("\t2. Открыть/закрыть дверь");
        System.out.println("\t3. Открыть/закрыть окно.");
        System.out.println("\t4. Изменить скорость.");
        System.out.println("\t5. Добавить/удалить колесо.");
        System.out.println("\t6. Показать/изменить общую информацию.");
        System.out.println("\t7. Выход.");
        System.out.print("\n\tВведите номер действия [1-7]: ");
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


    private void actionsWithPassengers(){
        System.out.println("\nПАССАЖИРЫ:");
        car.passengersInfo();
        System.out.println("\t\t1. Добавить пассажира.");
        System.out.println("\t\t2. Высадить пассажира.");
        System.out.println("\t\t3. Высадить всех пассажиров.");
        System.out.println("\t\t4. Назад в меню.");
        System.out.print("\tВведите номер действия [1-4]: ");
        switch (s.nextInt()){
            case 1:
                car.addPassenger();
                actionsWithPassengers();
                break;
            case 2:
                car.removeOnePassenger();
                actionsWithPassengers();
                break;
            case 3:
                car.removeAllPassengers();
                actionsWithPassengers();
                break;
            case 4:
                nextActions();
                break;
        }
    }
    private void actionsWithDoors() {
        System.out.println("\nДВЕРИ:");
        System.out.println("Текущее количество дверей: " + car.getDoorsNum());
        System.out.println("\t\t1. Открыть/закрыть дверь.");
        System.out.println("\t\t2. Вывести общую информацию.");
        System.out.println("\t\t3. Назад в меню.");
        System.out.print("\t\tВведите номер действия [1-4]: ");
        switch (s.nextInt()) {
            case 1:
                car.changeDoorState();
                actionsWithDoors();
                break;
            case 2:
                car.doorsInfo();
                actionsWithDoors();
                break;
            case 3:
                nextActions();
                break;
        }
    }
    private void actionsWithWindows(){
        System.out.println("\nОКНА:");
        System.out.println("Текущее количество окон: " + car.getDoorsNum());
        System.out.println("\t\t1. Открыть/закрыть окно.");
        System.out.println("\t\t2. Назад в меню.");
        System.out.print("\t\tВведите номер действия [1-2]: ");
        switch (s.nextInt()) {
            case 1:
                car.changeWindowState();
                actionsWithWindows();
                break;
            case 2:
                nextActions();
                break;
        }

    }
    private void actionsWithSpeed(){
        System.out.println("\nСКОРОСТЬ:");
        System.out.println("Текущая скорость: " + car.getCurrentSpeed());
        System.out.println("\t\t1. Изменить текущую скорость.");
        System.out.println("\t\t2. Изменить максимальную скорость.");
        System.out.println("\t\t3. Показать максимальную скорость.");
        System.out.println("\t\t4. Назад в меню.");
        System.out.print("\t\tВведите номер действия [1-4]: ");
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
    private void actionsWithWheels(){
        System.out.println("\nКОЛЁСА/ШИНЫ:");
        System.out.println("Текущее количество колёс: " + car.getWheelsNum());
        System.out.println("\t\t1. Добавить колесо.");
        System.out.println("\t\t2. Снять все колёса.");
        System.out.println("\t\t3. Заменить шину.");
        System.out.println("\t\t4. Стереть шину.");
        System.out.println("\t\t5. Вывести общую информацию о шинах.");
        System.out.println("\t\t6. Назад в меню.");
        System.out.print("\t\tВведите номер действия [1-6]: ");
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
    private void generalInfo() {
        System.out.println("\nОБЩАЯ ИНФОРМАЦИЯ:");
        System.out.println("\t\t1. Вывести общую информацию.");
        System.out.println("\t\t2. Изменить тип двигателя.");
        System.out.println("\t\t3. Изменить время разгона до 100км/ч.");
        System.out.println("\t\t4. Изменить пассажировместимость.");
        System.out.println("\t\t5. Назад в меню.");
        System.out.print("\n\t\tВведите номер действия [1-5]: ");
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
