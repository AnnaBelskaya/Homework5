package autoservice;

public class CarDoors {
    private boolean doorOpened = false;
    private boolean windowOpened = false;

    public CarDoors(){

    }

    public void changeDoorState(){
        doorOpened = !doorOpened;
    }

    public void changeWindowState(){
        windowOpened = !windowOpened;
    }

    public void getDoorInfo(){
        System.out.println("\tДверь " + (doorOpened ? "открыта." : "закрыта."));
    }

    public void getWindowInfo(){
        System.out.println("\tОкно " + (windowOpened ? "открыто." : "закрыто."));
    }

}
