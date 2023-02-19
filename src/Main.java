import guildcommands.*;
import guild.*;
import herotypes.*;
public class Main {

    public static void main(String[] args) {
        GuildCommandSystem guildCommandSystem = new GuildCommandSystem(args);

        Guilde maGuilde = makeGuilde(guildCommandSystem.nextCommand());

        while (guildCommandSystem.hasNextCommand()) {
            GuildCommand command = guildCommandSystem.nextCommand();
            switch (command.getName()) {
                case "buy-hero" -> {
                    String heroName = command.nextString();
                    int category = command.nextInt();
                    double costMoney = command.nextDouble();
                    int costArmor = command.nextInt();
                    double healthPoints = command.nextInt();
                    }

                case "buy-armor" -> {
                    int armorsBought = command.nextInt();
                    int armorPrice = command.nextInt();
                    if (maGuilde.getInitAmount() < armorsBought*armorPrice) {
                        System.out.println("Non tu peux pas");
                    }
                    else {
                        System.out.println("Armures achetées:"+armorsBought);
                    }
                }
                case "do-quest" -> {
                    int category = command.nextInt();
                    double healthCost = command.nextDouble();
                    int moneyReward = command.nextInt();
                    int armorReward = command.nextInt();
                }
                case "train-hero" -> {
                    String name = command.nextString();
                }
            }
        }
    }


    public static Guilde makeGuilde(GuildCommand command) {
        int montantInitial = command.nextInt();
        int nbArmures = command.nextInt();
        return new Guilde(montantInitial, nbArmures);
    }






}
