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


/////Избыточный код


    public CarDoors(boolean doorOpened, boolean windowOpened){
        this.doorOpened = doorOpened;
        this.windowOpened = windowOpened;
    }

    public boolean getDoorOpened(){
        return doorOpened;
    }

    public boolean isWindowOpened(){
        return windowOpened;
    }

    public void openTheDoor(){
        doorOpened = true;
    }

    public void closeTheDoor(){
        doorOpened = false;
    }

    public void setDoorOpened(boolean doorOpened){
        this.doorOpened = doorOpened;
    }

    public void setWindowOpened(boolean windowOpened){
        this.windowOpened = windowOpened;
    }

}
