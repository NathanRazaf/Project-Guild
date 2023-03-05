import guild.herotypes.Hero;
import guildcommands.*;
import guild.*;

public class Main {
    public static void main(String[] args) {
        String errorLog = "Erreurs:";
        GuildCommandSystem guildCommandSystem = new GuildCommandSystem(args);

        Guilde maGuilde = makeGuilde(guildCommandSystem.actualCommand());
        Bank maBanque = new Bank(maGuilde.getMoneyInit(),maGuilde.getArmorNumber());

        while (guildCommandSystem.hasNextCommand()) {
            GuildCommand command = guildCommandSystem.nextCommand();
            switch (command.getName()) {
                case "buy-hero" -> {
                    String name = command.nextString();
                    int heroCategory = command.nextInt();
                    double moneyCost = command.nextDouble();
                    int armorsCost = command.nextInt();
                    double healthPointsMax = command.nextDouble();

                    if (maBanque.getMoney() >= moneyCost && maBanque.getArmors() >= armorsCost) {
                        if (healthPointsMax > 0)  {
                            maGuilde.heroList.get(heroCategory).add(new Hero(name, heroCategory, healthPointsMax));
                            maBanque.setMoney(maBanque.getMoney() - moneyCost);
                            maBanque.setArmors(maBanque.getArmors() - armorsCost);
                        }
                        else {
                            errorLog += "/n-Le héros que vous avez acheté est déjà mort...";
                        }
                    }
                    else {
                        errorLog += "/n-Il vous manque de l'argent/des armures pour acheter " + name + ".";
                    }

                }
                    case "buy-armor" -> {
                        int armorsBought = command.nextInt();
                        int costArmor = command.nextInt();

                        if (maBanque.getMoney() >= costArmor*armorsBought) {
                            maBanque.setArmors(maBanque.getArmors() + armorsBought);
                            maBanque.setMoney(maBanque.getMoney() - costArmor*armorsBought);
                        }
                        else {
                            errorLog += "/n-Il vous manque de l'argent pour acheter " + armorsBought + " armures à ";
                            errorLog += costArmor + " gold chacune.";
                        }
                    }
                    case "do-quest" -> {
                        int questCategory = command.nextInt();
                        double healthCost = command.nextDouble();
                        int moneyReward = command.nextInt();
                        int armorReward = command.nextInt();

                        if (questCategory > 4 || questCategory < 0 ||
                                healthCost <= 0 || moneyReward < 0 || armorReward < 0) {
                            errorLog += "/n-Cette quête est invalide!";
                        } else {
                            Quete quest = new Quete(questCategory,healthCost,moneyReward,armorReward);
                            Hero chosen = maGuilde.findHero(questCategory);
                            if (chosen == null) {
                                errorLog += "/n-Vous n'avez aucun héros dans l'inventaire";
                            }
                            else {
                                chosen.setHealthPoints(chosen.getHealthPoints() -
                                        quest.realHealthCost(chosen.getCategory()));
                                if (chosen.getHealthPoints() <= 0) {
                                    maGuilde.heroList.get(chosen.getCategory()).remove(chosen);
                                    errorLog += "/n-" + chosen.getName() + " est mort.";
                                } else {
                                    maBanque.setMoney(maBanque.getMoney() + quest.getMoneyReward());
                                    maBanque.setArmors(maBanque.getArmors() + quest.getArmorReward());
                                }
                            }
                        }
                    }
                    case "train-hero" -> {
                        String heroName = command.nextString();
                        Hero chosen = maGuilde.findHero(heroName);
                        if (chosen == null) {
                            errorLog += "/n-Vous n'avez pas de héros nommé " + heroName;
                        }
                        else if (chosen.getCategory() == 4) {
                            errorLog += "/n-" + heroName + " est déjà au niveau maximum";
                            maGuilde.heroList.get(chosen.getCategory()).add(chosen);
                        }
                        else if (maBanque.getMoney() < chosen.getMoneyUpgrade() &&
                                  maBanque.getArmors() < chosen.getArmorUpgrade()) {
                            errorLog += "/n-Vous n'avez pas assez d'argent pour améliorer " + heroName;
                            maGuilde.heroList.get(chosen.getCategory()).add(chosen);
                        }
                        else {
                            chosen.upgradeHero();
                            maBanque.setMoney(maBanque.getMoney() - chosen.getMoneyUpgrade());
                            maBanque.setArmors(maBanque.getArmors()- chosen.getArmorUpgrade());
                            maGuilde.heroList.get(chosen.getCategory()).add(chosen);
                        }
                    }
                }
            }

        System.out.println("Guild Bank account : "+maBanque.getMoney()+" gold and "+maBanque.getArmors()+" armours");
        if (maGuilde.printHeroList().equals("Heroes :")) {
            System.out.println("Aucun héros dans l'inventaire.");
        }
        else {
            System.out.println(maGuilde.printHeroList().replaceAll("/n",System.getProperty("line.separator")));
        }

        if (!errorLog.equals("Erreurs:")) {
            System.out.println(errorLog.replaceAll("/n",System.getProperty("line.separator")));
        }
    }

        public static Guilde makeGuilde (GuildCommand command){
            double montantInitial = command.nextDouble();
            int nbArmures = command.nextInt();
            return new Guilde(montantInitial, nbArmures);
        }
    }