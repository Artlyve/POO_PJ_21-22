import java.util.Scanner;

public class SecretCodeDoor extends AutoLockDoor {

    private final int DEF_CODE = 1234;
    private int code;


    public SecretCodeDoor(){
        this.code = DEF_CODE;
    }

    @Override
    public void unlock() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer votre code");
        int codeEnter = sc.nextInt();
        if(codeEnter == this.code){
            super.setState(true);
            super.setLocked(true);
        }else{
            super.close();
            System.out.println("Code non valide");
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}