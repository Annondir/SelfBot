package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by marce on 07.06.2017.
 */
public class messageListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println(event.getMessage().getContent());
    }
}
