package guild;
import guild.herotypes.*;

import java.util.*;

public class Guilde {
    private double initAmount;
    private int armorNumber;
    public ArrayList<ArrayList<Hero>> heroList = new ArrayList<>();

    public Guilde(double initAmount, int armorNumber) {
        this.initAmount=initAmount;
        this.armorNumber=armorNumber;
        for (int i=0; i<5; i++) {
            heroList.add(new ArrayList<>());
        }
    }

    public double getInitAmount() {
        return initAmount;
    }

    public int getArmorNumber() {
        return armorNumber;
    }

    public String printHeroList() {
        String heroLog = "Heroes :";
        for (int i=0; i<5; i++) {
            for (int j=0; j<heroList.get(i).toArray().length; j++) {
                heroLog+="/n-"+heroList.get(i).get(j).getName()+": level="+(int) heroList.get(i).get(j).getCategory()+" HP="+heroList.get(i).get(j).getHealthPointsCurrent();
            }
        }
        return heroLog;
    }
}
