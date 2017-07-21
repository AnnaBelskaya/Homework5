package autoservice;

public class CarDoors {
    private boolean doorOpened = false;
    private boolean windowOpened = false;

    public CarDoors(){

    }

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

    public void changeDoorState(){
        doorOpened = !doorOpened;
    }

    public void changeWindowState(){
        windowOpened = !windowOpened;
    }

    public void getDoorInfo(){
        System.out.println("door is " + (doorOpened ? "opened." : "closed."));
    }

    public void getWindowInfo(){
        System.out.println("Window is " + (windowOpened ? "opened." : "closed."));
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
