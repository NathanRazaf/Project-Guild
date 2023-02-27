package guild;

public class Bank {
    private double money;
    private int armors;

    public Bank(double money, int armors) { this.money=money; this.armors=armors;}
    public double getMoney() {
        return money;
    }

    public int getArmors() {
        return armors;
    }

    public void setArmors(int armors) {
        this.armors = armors;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
