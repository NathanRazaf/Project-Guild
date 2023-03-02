public class Quete {
    private int questCategory;
    private double healthCost;
    private int moneyReward;
    private int armorReward;

    public Quete(int questCategory, double healthCost, int moneyReward, int armorReward) {
        this.questCategory=questCategory;
        this.healthCost=healthCost;
        this.moneyReward=moneyReward;
        this.armorReward=armorReward;
    }

    public int getQuestCategory() {
        return questCategory;
    }
    public double getHealthCost() {
        return healthCost;
    }
    public int getArmorReward() {
        return armorReward;
    }
    public int getMoneyReward() {
        return moneyReward;
    }

    public double realHealthCost(int heroCategory) {
        return healthCost - (heroCategory-questCategory) * 1.5;
    }
}
