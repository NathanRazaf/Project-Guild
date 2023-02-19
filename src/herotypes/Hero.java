package herotypes;

public class Hero {
    protected String name;
    protected double costMoney;
    protected int costArmor;
    protected double healthPoints;

    public Hero(String name, double costMoney, int costArmor, double healthPoints){
        this.name=name;
        this.costMoney=costMoney;
        this.costArmor=costArmor;
        this.healthPoints=healthPoints;
    }

    public String getName() {
        return name;
    }

    public double getCostMoney() {
        return costMoney;
    }

    public int getCostArmor() {
        return costArmor;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setCostArmor(int costArmor) {
        this.costArmor = costArmor;
    }

    public void setCostMoney(double costMoney) {
        this.costMoney = costMoney;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

}
