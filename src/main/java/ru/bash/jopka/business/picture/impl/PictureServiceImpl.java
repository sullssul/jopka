package ru.bash.jopka.business.picture.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.business.picture.PictureService;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.usecase.*;
import ru.bash.jopka.controller.dto.picture.CreatePictureRequest;
import ru.bash.jopka.controller.dto.picture.FindPictureWithFilterRequest;
import ru.bash.jopka.controller.dto.picture.UpdatePictureRequest;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final CreatePictureCommand createCommand;
    private final DeletePictureCommand deleteCommand;
    private final UpdatePictureCommand updateCommand;
    private final FindPictureQuery findQuery;
    private final FindAllPicturesQuery findAllQuery;
    private final FindPictureWithFilterQuery findWithFilterQuery;

    @Override
    public Picture update(UpdatePictureRequest request) {
        return updateCommand.execute(request);
    }

    @Override
    public Set<Picture> findWithFilter(FindPictureWithFilterRequest request) {
        return findWithFilterQuery.execute(request);
    }

    @Override
    public Picture create(CreatePictureRequest request) {
        return createCommand.execute(request);
    }

    @Override
    public Picture find(int id) {
        return findQuery.execute(id);
    }

    @Override
    public Set<Picture> findAll() {
        return findAllQuery.execute();
    }

    @Override
    public String delete(long id) {
        deleteCommand.execute(id);
        return "Работа успешно удалена";
    }
}