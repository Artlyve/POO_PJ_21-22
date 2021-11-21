import java.util.List;

public class Exit implements Printable {

    private boolean state;

    public void open(){
        this.state = true;
    }

    public void close(){
        this.state = false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name class: " + getClass().getSimpleName()+"\n");
        sb.append("Etat de la porte: " + this.state+"\n");
        return sb.toString();
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public static <T> void printDoorList(List<T> ld){
        ld.forEach(d -> {
            System.out.println(d.toString());
        });
    }
    public static void printDoorList2(List<AutoLockDoor> ld){
        ld.forEach(d -> {
            System.out.println(d.toString());
        });
    }
}