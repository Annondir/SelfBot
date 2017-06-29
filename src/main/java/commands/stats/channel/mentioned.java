package commands.stats.channel;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.STATIC.loggpath;

/**
 * Created by marce on 06.06.2017.
 */
public class mentioned extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getMentionedUsers().contains(event.getJDA().getSelfUser())) {
            String nachricht = event.getMessage().getContent();
            String authorname = event.getAuthor().getName();
            String authorid = event.getAuthor().getId();
            String author = authorname + " [" + authorid + "]";
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
            File logchannel = new File(dirchannel + "\\" + "mentioned.txt");
            File dirglobal = new File(loggpath + "\\" + "global");
            File logglobal = new File(dirglobal + "\\" + "mentioned.txt");

        if (dirchannel.mkdirs()) {
            System.out.println("Datei wurde erstellt: " + logchannel);
        } else {

        }
        try {
            writer = new FileWriter(logchannel, true);
            writer.write("[" +timeStamp + "] " + "@" + author + ": ");
            writer.write(System.getProperty("line.separator"));

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                writer = new FileWriter(logglobal, true);
                writer.write("[" + timeStamp + "] " + serverdirid + " || " + channeldirid + " @" + authorname + " [" + authorid + "] " +":   " + nachricht);
                writer.write(System.getProperty("line.separator"));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
