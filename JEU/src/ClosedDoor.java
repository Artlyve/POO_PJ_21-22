public class ClosedDoor extends Exit {

	@Override
	public void open() {
		System.out.println("Impossible d'ouvrir cette porte !");
	}

	public ClosedDoor(){
		super.close();
	}

}