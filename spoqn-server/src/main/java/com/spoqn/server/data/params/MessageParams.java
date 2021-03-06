package com.spoqn.server.data.params;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageParams {
    Set<String> rooms;
    Set<UUID> topics;
    Set<String> tags;
    Set<UUID> users;
    Boolean direct;
    Instant since;
    Instant until;
    Integer top;
}
