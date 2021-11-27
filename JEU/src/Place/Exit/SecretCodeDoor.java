package Place.Exit;

import java.util.Scanner;

public class SecretCodeDoor extends Exit {

	private final int DEFAULT_CODE;

	/**
	 * 
	 * @param code
	 */
	public SecretCodeDoor(int code) {
		super();
		this.DEFAULT_CODE = code;

	}

	@Override
	public void open() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer votre code");
		int codeEnter = sc.nextInt();
		if(codeEnter == this.DEFAULT_CODE){
			super.setState(true);
		}else{
			super.close();
			System.out.println("Code non valide");
		}
		sc.close();
	}


}