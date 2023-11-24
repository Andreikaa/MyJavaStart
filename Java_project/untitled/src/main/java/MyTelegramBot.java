import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {

    public static final String ";

    public static final String BOT_USERNAME = "pybot";

    public static final String URI = "https://api.nasa.gov/planetary/apod?api_key=Ebal3kttQhYgyckEjtEvQb8wAyiBcIMRUaUptmc7";

    public static long chat_id;

    public MyTelegramBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            chat_id = update.getMessage().getChatId();
            switch (update.getMessage().getText()) {
                case "/help":
                    sendMessage("Ïðèâåò, ÿ áîò NASA! ß âûñûëàþ ññûëêè íà êàðòèíêè ïî çàïðîñó. " +
                            "Íàïîìèíàþ, ÷òî êàðòèíêè íà ñàéòå NASA îáíîâëÿþòñÿ ðàç â ñóòêè");
                    break;
                case "/give":
                    try {
                        sendMessage(Utils.getUrl(URI));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    sendMessage("ß íå ïîíèìàþ :(");
            }
        }
    }


    private void sendMessage(String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
