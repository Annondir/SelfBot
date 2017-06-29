package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.Arrays;

/**
 * Created by marce on 18.05.2017.
 */
public class permsCore {

    public static int check(MessageReceivedEvent event) {
        for (Role r:
             event.getGuild().getMember(event.getAuthor()).getRoles()) {

            if (Arrays.stream(STATIC.orgaPerms).parallel().anyMatch(r.getName() :: contains)) {
                return 5;
            }

            else if (Arrays.stream(STATIC.ritterPERMS).parallel().anyMatch(r.getName() :: contains)) {
                return 4;
            }
            else if (Arrays.stream(STATIC.faustPerms).parallel().anyMatch(r.getName() :: contains)) {
                return 3;
            }
            else if (Arrays.stream(STATIC.scharPerms).parallel().anyMatch(r.getName() :: contains)) {
                return 2;
            }

            else if (Arrays.stream(STATIC.elfPerms).parallel().anyMatch(r.getName() :: contains)) {
                return 1;
            }

            else {

                event.getTextChannel().sendMessage(":warning:  " + event.getAuthor().getAsMention() + " du hast nicht die benötigten Berechtigungen um das zu tun").queue();

            }

        }

        return 0;
    }

}
