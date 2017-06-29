package commands.stats.channel;

import commands.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static util.STATIC.loggpath;

/**
 * Created by marce on 07.06.2017.
 */
public class mentionedstats implements Command{

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {
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
        File dirchannel = new File(loggpath + "\\" + serverdirid + "\\" + channeldirid);
        File mentionedchannel = new File(dirchannel + "\\" + "mentioned.txt");
        File dirglobal = new File(loggpath + "\\" + "global");
        File mentionedglobal = new File(dirglobal + "\\" + "mentioned.txt");
        FileReader fileReaderchannel = new FileReader(mentionedchannel);
        BufferedReader bufferedReaderchannel = new BufferedReader(fileReaderchannel);
        FileReader fileReaderglobal = new FileReader(mentionedglobal);
        BufferedReader bufferedReaderglobal = new BufferedReader(fileReaderglobal);
        if (args[0].equalsIgnoreCase("channel")) {
            if (!dirchannel.exists()) {
            } else {
                String mentionedcount = String.valueOf(bufferedReaderchannel.lines().count());

                Message msg = event.getMessage().editMessage(mentionedcount).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                    }
                }, 10000);
            }
        }
        else if (args[0].equalsIgnoreCase("global")) {
            if ((!dirglobal.exists())) {

            } else {
                String mentionedcount = String.valueOf(bufferedReaderglobal.lines().count());
                Message msg = event.getMessage().editMessage(mentionedcount).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                    }
                }, 1000);
            }
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
