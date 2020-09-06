package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewAlbumAction implements MenuAction {

    private final MenuActionContext ctx;
    private final AlbumRepository repository;

    @Override
    public void execute() {
        var albums = repository.getAll();

        if (albums.isEmpty()) {
            System.out.println("Brak danych do wyświetlenia");
        } else {
            System.out.println("\n");
            albums.forEach(System.out::println);
            System.out.println("\n");
        }

        ctx.use(MainAction.class).execute();
    }
}
