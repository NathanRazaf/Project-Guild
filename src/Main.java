import guild.herotypes.Hero;
import guildcommands.*;
import guild.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    /**
     * Args: array with
     * <ol>
     *     <li>guild:&lt;montant initial&gt;,&lt;armures initiales&gt;</li>
     * </ol>
     *
     * @param args
     */

    //test
    public static void main(String[] args) {
        String errorLog = "Erreurs:";
        GuildCommandSystem guildCommandSystem = new GuildCommandSystem(args);

        Guilde maGuilde = makeGuilde(guildCommandSystem.actualCommand());
        Bank maBanque = new Bank(maGuilde.getInitAmount(),maGuilde.getArmorNumber());

        while (guildCommandSystem.hasNextCommand()) {
            GuildCommand command = guildCommandSystem.nextCommand();
            switch (command.getName()) {
                case "buy-hero" -> {
                    String name = command.nextString();
                    int heroCategory = command.nextInt();
                    double moneyCost = command.nextDouble();
                    int armorsCost = command.nextInt();
                    double healthPointsInit = command.nextDouble();

                    if (maBanque.getMoney() >= moneyCost && maBanque.getArmors() >= armorsCost) {
                        maGuilde.heroList.get(0).add(new Hero(name, heroCategory, healthPointsInit));
                        maBanque.setMoney(maBanque.getMoney()-moneyCost);
                        maBanque.setArmors(maBanque.getArmors()-armorsCost);
                    }
                    else {
                        errorLog+="/n-Il vous manque de l'argent/des armures pour acheter "+name+".";
                    }

                }
                    case "buy-armor" -> {
                        int armorsBought = command.nextInt();
                        int costArmor = command.nextInt();
                    }
                    case "do-quest" -> {
                        int questCategory = command.nextInt();
                        double healthCost = command.nextDouble();
                        int moneyReward = command.nextInt();
                        int armorReward = command.nextInt();
                    }
                    case "train-hero" -> {
                        String heroName = command.nextString();
                    }
                }
            }
        System.out.println("Guild Bank account : "+maBanque.getMoney()+" gold and "+maBanque.getArmors()+" armours");
        System.out.println(maGuilde.printHeroList().replaceAll("/n",System.getProperty("line.separator")));
        System.out.println(errorLog.replaceAll("/n",System.getProperty("line.separator")));

        }

        public static Guilde makeGuilde (GuildCommand command){
            double montantInitial = command.nextDouble();
            int nbArmures = command.nextInt();
            return new Guilde(montantInitial, nbArmures);
        }
    }