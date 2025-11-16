package com.openmind.CommunicationAndSupport.Interfaces.REST.Transform;

import com.openmind.CommunicationAndSupport.Domain.Model.Aggregates.conversation;
import com.openmind.CommunicationAndSupport.Interfaces.REST.Resources.chatbotReplyResource;
import com.openmind.CommunicationAndSupport.Interfaces.REST.Resources.conversationResource;
import org.springframework.stereotype.Component;

@Component
public class conversationResourceAssembler {
    private final messageResourceAssembler messageResourceAssembler;

    public conversationResourceAssembler(messageResourceAssembler messageResourceAssembler) {
        this.messageResourceAssembler = messageResourceAssembler;
    }

    public conversationResource toResource(conversation aggregate){
        return new conversationResource(
                aggregate.id().value(),
                aggregate.customerId().value(),
                aggregate.isActive(),
                aggregate.createdAt().value(),
                aggregate.updatedAt().value(),
                messageResourceAssembler.toResourceList(aggregate.messages())
        );
    }
}
