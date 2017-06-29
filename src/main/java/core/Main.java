package core;


import commands.delete;
import commands.stats.channel.log;
import listeners.commandListener;
import listeners.ersetzen;
import listeners.messageListener;
import listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import commands.stats.channel.loger;
import commands.stats.channel.mentioned;
import commands.stats.channel.mentionedstats;
import commands.stats.channel.messagestats;
import util.SECRETS;
import util.STATIC;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDABuilder builder;
    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.CLIENT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        addListeners();
        addCommand();

        builder.setGame(new Game() {
            @Override
            public String getName() {
                return STATIC.Game;
            }

            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public GameType getType() {
                return GameType.DEFAULT;
            }
        });


        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }

    }
    public static void addCommand() {
      commandHandler.commands.put("log", new log());
      commandHandler.commands.put("mentioned", new mentionedstats());
      commandHandler.commands.put("messages", new messagestats());
      commandHandler.commands.put("delete", new delete());
    }


    public static void addListeners() {
        builder.addListener(new readyListener());
        builder.addListener(new commandListener());
        builder.addListener(new loger());
        builder.addListener(new mentioned());
        builder.addListener(new ersetzen());
        builder.addListener(new messageListener());
    }

}
