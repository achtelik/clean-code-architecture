package it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.repos;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.entities.ChatMessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChatMessageRepository extends PagingAndSortingRepository<ChatMessageEntity, Long> {
}
