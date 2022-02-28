package com.homeward.webstore.handler.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RedisExpirationListener extends KeyExpirationEventMessageListener {
    /**
     * Creates new {@link MessageListener} for {@code __keyevent@*__:expired} messages.
     *
     * @param listenerContainer must not be {@literal null}.
     */
    public RedisExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对 redis 数据失效事件, 进行数据处理
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        //拿到key
        log.info("Redis的key: \"{}\" 已过期, channel: \"{}\"", message.toString(), new String(pattern));
    }
}
