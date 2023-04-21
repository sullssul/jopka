package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.repository.PictureRepository;

@Component
@RequiredArgsConstructor
public class DeletePictureCommand {
    private final PictureRepository repository;
    private final GetPictureQuery getQuery;

    public void execute(long id) {
        getQuery.execute(id);
        repository.delete(id);
    }
}
