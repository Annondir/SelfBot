package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by marce on 07.06.2017.
 */
public class ersetzen extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getAuthor().getId() == event.getJDA().getSelfUser().getId()) {
            if (event.getMessage().getContent().startsWith("[rage]")){
                event.getMessage().editMessage("(╯⫑益⫒）╯︵ ┻━┻").queue();
            }
            else if (event.getMessage().getContent().startsWith("[lenny]")) {
                event.getMessage().editMessage("( ͡° ͜ʖ ͡°)").queue();
            }
            else if (event.getMessage().getContent().startsWith("[happy]")) {
                event.getMessage().editMessage("ヽ(◕▾◕)ﾉ").queue();
            }
            else if (event.getMessage().getContent().startsWith("[wtf]")) {
                event.getMessage().editMessage("ಠ_ಠ").queue();
            }
            else if (event.getMessage().getContent().startsWith("[sad]")) {
                event.getMessage().editMessage("|⪨∀⪩|").queue();
            }
            else if (event.getMessage().getContent().startsWith("[ragequit]")) {
                event.getMessage().editMessage("┻━┻ ︵ヽ(`Д´)ﾉ︵ ┻━┻").queue();
            }
        }
    }
}
