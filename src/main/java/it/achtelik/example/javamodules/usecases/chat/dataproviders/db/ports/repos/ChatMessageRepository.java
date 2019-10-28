package it.achtelik.example.javamodules.usecases.chat.dataproviders.db.ports.repos;

import it.achtelik.example.javamodules.usecases.chat.dataproviders.db.entities.ChatMessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChatMessageRepository extends PagingAndSortingRepository<ChatMessageEntity, Long> {
}
