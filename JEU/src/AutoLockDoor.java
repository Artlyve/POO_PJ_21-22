public class AutoLockDoor extends Exit {


    private boolean locked;





    public void lock(){
        if(!this.isState()){
            this.locked = true;
        }else{
            System.out.println("Attention tu ne peux pas la vérouiller, ta porte est ouverte");
        }
    }


    public void unlock(){
        if(!this.isState()){
            this.locked = false;
        }else{
            System.out.println("Attention ta porte est ouverte !");
        }
    }

    @Override
    public void open() {
        super.open();
        unlock();

    }

    @Override
    public void close() {
        super.close();
        //lock();
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name class: " + getClass().getSimpleName()+"\n");
        sb.append("Etat de la porte: " + super.isState()+"\n");
        sb.append("Etat du verou: " + this.locked+"\n");
        return sb.toString();
    }



    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

}