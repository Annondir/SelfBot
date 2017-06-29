package util;

import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marce on 15.05.2017.
 */
public class STATIC{
    
    static MessageReceivedEvent event;

    public static final String PREFIX = "!";

    public static final String VERSION = "1.0.0";

    public static final String GAMEAFK = "AFK";

    public static final String Game = "Alles und nichts";

    public static final String[] elfPerms = {"Elf"};

    public static final String[] scharPerms = {"Silberne Schar"};

    public static final String[] faustPerms = {"Faust Myrias"};

    public static final String[] orgaPerms = {"Orga"};

    public static final String[] ritterPERMS = {"Ritter"};

    public static final String falsch = " du hast nicht die benötigten Berechtigungn, um das zu tun!";

    public static final String warning = ":warning:  ";

    public static final String loggpath = "D:\\IdeaProjects\\Selfbot\\logs";
    
    public static final String nachrichten = event.getMessage().getContent();

}
