package guild.herotypes;
public class Hero {
    protected String name;
    protected int category;
    protected double healthPointsMax;
    protected double healthPoints;
    protected double moneyUpgrade;
    protected int armorUpgrade;

    public Hero(String name, int category, double healthPointsMax){
        this.name=name;
        this.category=category;
        this.healthPointsMax=healthPointsMax;

        this.healthPoints=healthPointsMax;
        this.moneyUpgrade=20*Math.log(category+10);
        this.armorUpgrade= (int) Math.ceil(Math.log(category+10));
    }
    public String getName() {
        return name;
    }
    public int getCategory() { return category; }
    public double getHealthPoints() {
        return healthPoints;
    }

    public double getMoneyUpgrade() {
        return moneyUpgrade;
    }

    public int getArmorUpgrade() {
        return armorUpgrade;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void upgradeHero() {
        this.category+=1;
        this.healthPointsMax*=1.5;
        this.healthPoints=healthPointsMax;
        this.moneyUpgrade=20*Math.log(category+10);
        this.armorUpgrade= (int) Math.ceil(Math.log(category+10));
    }
}
