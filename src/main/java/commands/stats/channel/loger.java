package commands.stats.channel;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.STATIC.loggpath;

/**
 * Created by marce on 06.06.2017.
 */
public class loger extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        String nachricht = event.getMessage().getContent();
        String authorname = event.getAuthor().getName();
        String authorid = event.getAuthor().getId();
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy | HH:mm:ss").format(new Date());
        String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        FileWriter writer;
        String ServerName = event.getGuild().getName();
        String ServerID = event.getGuild().getId();
        String Server = ServerName + " [" + ServerID + "]";
        String ChannelName = event.getTextChannel().getName();
        String ChannelID = event.getTextChannel().getId();
        String Channel = ChannelName + " [" + ChannelID + "]";
        String serverdirid = Server;
        String channeldirid = Channel;
        String logname = "log vom " + dateStamp + ".txt";
        File dirchannel = new File(loggpath + "\\" + serverdirid + "\\" + channeldirid);
        File logchannel = new File(dirchannel + "\\");
        File dirglobal = new File(loggpath + "\\" + "global");
        File logglobal = new File(dirglobal + "\\");
        if (!logchannel.exists()) {
            return;
        }
        try {
            writer = new FileWriter(logchannel + "\\" + "mentioned.txt", true);
            writer = new FileWriter(logchannel + "\\"+ logname, true);
            writer.write("[" + timeStamp + "] " + "@" + authorname + " [" + authorid + "] " +":   " + nachricht);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer = new FileWriter(logglobal + "\\" + "mentioned.txt", true);
            writer = new FileWriter(logglobal + "\\" + logname, true);
            writer.write("[" + timeStamp + "] " + serverdirid + " || " + channeldirid + " @" + authorname + " [" + authorid + "] " +":   " + nachricht);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
