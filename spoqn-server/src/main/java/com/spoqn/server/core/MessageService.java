package com.spoqn.server.core;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.mybatis.guice.transactional.Transactional;

import com.spoqn.server.data.Message;
import com.spoqn.server.data.mappers.MessageMapper;

@Singleton
@Transactional
public class MessageService {

    @Inject private MessageMapper mapper;

    public Message create(String loginId, Message message) {

        message = message.toBuilder()
                .id(UUID.randomUUID())
                .user(loginId)
                .build();

        mapper.create(message);
        return mapper.findOne(message.getId());
    }

    public List<Message> read() {
        return Collections.unmodifiableList(mapper.findAll());
    }

    public Message read(UUID id) {
        return mapper.findOne(id);
    }
}
