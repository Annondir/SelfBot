package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.IOException;

/**
 * Created by marce on 04.06.2017.
 */
public class AFKListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getMentionedUsers().contains(event.getJDA().getSelfUser())) {
                event.getTextChannel().sendMessage(":warning: Sorry " + event.getAuthor().getAsMention() + ", ich bin momentan AFK").queue();
            }
        }

    }
