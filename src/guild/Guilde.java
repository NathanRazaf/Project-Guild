package guild;
import guild.herotypes.*;

import java.util.*;

public class Guilde {
    private final double moneyInit;
    private final int armorNumber;
    public ArrayList<ArrayList<Hero>> heroList = new ArrayList<>();

    public Guilde(double moneyInit, int armorNumber) {
        this.moneyInit = moneyInit;
        this.armorNumber = armorNumber;
        for (int i=0 ; i<5 ; i++) {
            heroList.add(new ArrayList<>());
        }
    }

    public double getMoneyInit() {
        return moneyInit;
    }

    public int getArmorNumber() {
        return armorNumber;
    }

    public String printHeroList() {
        String heroLog = "Heroes :";
        for (int i=0; i<5; i++) {
            for (int j=0; j<heroList.get(i).size(); j++) {
                heroLog+="/n-" + heroList.get(i).get(j).getName() + ": level="
                         + heroList.get(i).get(j).getCategory()
                         + " HP=" + heroList.get(i).get(j).getHealthPoints();
            }
        }
        return heroLog;
    }

    public Hero findHero(String name) {
        for (int i=0 ; i<heroList.size() ; i++) {
            for (int j=0 ; j<heroList.get(i).size() ; j++) {
                if (heroList.get(i).get(j).getName().equals(name)) {
                    ArrayList clone = (ArrayList) heroList.get(i).clone();
                    heroList.get(i).remove(j);
                    return (Hero) clone.get(j);
                }
            }
        }
        return null;
    }

    public Hero findHero(int questCategory) {
        for (int i=questCategory; i<5; i++) {
            if (heroList.get(i).size() != 0) {
                return heroList.get(i).get(0);
            }
        }
        for (int i=questCategory-1; i>=0; i--) {
            if (heroList.get(i).size() != 0) {
                return heroList.get(i).get(0);
            }
        }
    return null;
    }
}
