package commands.stats.channel;

import commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.STATIC.loggpath;

/**
 * Created by marce on 06.06.2017.
 */
public class log implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {
        String nachricht = event.getMessage().getContent();
        String author = event.getAuthor().getName();
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
        File löschordner = new File(loggpath + "\\" + serverdirid);
        File dirglobal = new File(loggpath + "\\" + "global");
        File logglobal = new File(dirglobal + "\\");
        String deleted = "deleted";
        if (args[0].equalsIgnoreCase("create")) {
            if (args[1] == null) {
                return;
            }
            if (args[1].equalsIgnoreCase("channel")) {
                if (dirchannel.mkdirs()) {
                    event.getMessage().delete().queue();
                    writer = new FileWriter(logchannel + "\\" + "mentioned.txt", true);
                    writer = new FileWriter(logchannel + "\\" + logname, true);
                    System.out.println("Datei wurde erstellt: " + logchannel);
                } else if (dirchannel.exists()) {
                    event.getMessage().delete().queue();
                    System.out.println("Log existiert bereits");
                }
            }
            else if (args[1].equalsIgnoreCase("global")) {
                if (dirglobal.mkdirs()) {
                    event.getMessage().delete().queue();
                    writer = new FileWriter(logglobal + "\\" +"mentioned.txt", true);
                    writer = new FileWriter(logglobal + "\\" + logname, true);
                    System.out.println("Datei wurde erstellt: " + logglobal);
                } else if (dirglobal.exists()) {
                    event.getMessage().delete().queue();
                    System.out.println("Log existiert bereits");
                }
            }
        }
        if (args[0].equalsIgnoreCase("remove")) {
            event.getMessage().delete().queue();
            File zulöschenderordner = new File(loggpath + "\\" + "Gelöschte Ordner" + "\\" + deleted + "." + serverdirid + "." + dateStamp);
            if (zulöschenderordner.exists()) {
                zulöschenderordner.delete();
                löschordner.renameTo(new File(loggpath + "\\" + "Gelöschte Ordner" + "\\" + deleted + "." + serverdirid + "." + dateStamp));
            }else {
                löschordner.renameTo(new File(loggpath + "\\" + "Gelöschte Ordner" + "\\" + deleted + "." + serverdirid + "." + dateStamp));
                System.out.println("Ordner aus der Liste genommen");
            }
        }
        return;
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
