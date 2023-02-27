package guild.herotypes;
import java.math.*;
public class Hero {
    protected String name;
    protected int category;
    protected double costMoney;
    protected int costArmor;
    protected double healthPointsInit;
    protected double healthPointsCurrent;
    protected double moneyUpgrade;
    protected int armorUpgrade;

    public Hero(String name, int category, double healthPointsInit){
        this.name=name;
        this.category=category;
        this.healthPointsInit=healthPointsInit;

        this.healthPointsCurrent=healthPointsInit;
        this.moneyUpgrade=20*Math.log(category+10);
        this.armorUpgrade= (int) Math.ceil(Math.log(category+10));
    }
    public String getName() {
        return name;
    }
    public double getCategory() { return category; }
    public double getHealthPointsCurrent() {
        return healthPointsCurrent;
    }

    public void upgradeHero() {
        this.category+=1;
        this.healthPointsInit*=1.5;
        this.moneyUpgrade=20*Math.log(category+10);
        this.armorUpgrade= (int) Math.ceil(Math.log(category+10));
    }
}