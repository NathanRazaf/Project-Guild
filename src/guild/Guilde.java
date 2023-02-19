package guild;

public class Guilde {
    private int initAmount;
    private int armorNumber;

    public Guilde(int initAmount, int armorNumber) {
        this.initAmount=initAmount;
        this.armorNumber=armorNumber;
    }


    public int getInitAmount() {
        return initAmount;
    }

    public int getArmorNumber() {
        return armorNumber;
    }
}
