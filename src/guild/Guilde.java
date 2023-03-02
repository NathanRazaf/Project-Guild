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
        for (int i=0 ; i<5 ; i++) {
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
            for (int j=0; j<heroList.get(i).size(); j++) {
                heroLog+="/n-" + heroList.get(i).get(j).getName() + ": level="
                         + (int) heroList.get(i).get(j).getCategory()
                         + " HP=" + heroList.get(i).get(j).getHealthPointsCurrent();
            }
        }
        return heroLog;
    }

    public Hero findHero(String name) {
        for (int i=0 ; i<heroList.size() ; i+=1) {
            if (heroList.get(i) != null) {
                for (int j=0 ; j<heroList.get(i).size() ; j++) {
                    if (heroList.get(i).get(j).getName().equals(name)) {
                        ArrayList clone = (ArrayList) heroList.get(i).clone();
                        heroList.get(i).remove(j);
                        return (Hero) clone.get(j);
                    }
                }
            }
        }

        return null;
    }
}
