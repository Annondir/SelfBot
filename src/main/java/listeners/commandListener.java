package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;
import core.*;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by marce on 15.05.2017.
 */
public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() == event.getJDA().getSelfUser().getId()) {

            try {
                commandHandler.handlerCommand(commandHandler.parse.parser(event.getMessage().getContent(), event));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }

    }

}
