package com.example.bot.pluggable.genge.handler;

import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.callback.Message;
import com.linecorp.bot.model.content.Content;
import com.linecorp.bot.model.content.TextContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodeHandler implements Handler {
    @Autowired
    private LineBotClient lineBotClient;

    @Override
    public HandlerResponse told(TextContent textContent) throws LineBotAPIException {
        String encoded = Base64.getEncoder()
                .encodeToString(
                        textContent.getText()
                                .getBytes(StandardCharsets.UTF_8));

        lineBotClient.sendText(
                textContent.getFrom(),
                encoded
        );
        return HandlerResponse.OK;
    }
}
