package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.Album;
import io.mbab.sda.groupproject.entity.Song;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class CreateAlbumAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final AlbumRepository repository;

    @Override
    public void execute() {
        System.out.println("0) Przejdź do poprzedniego menu");
        System.out.println("Podaj nazwę Albumu:");

        var input = scanner.nextLine();


        if (pressedZero(input)) return;

        var builder = Album.builder().name(input);

        System.out.println("Podaj autora:");

        input = scanner.nextLine();

        if (pressedZero(input)) return;



        var album = builder.author(input).build();

        repository.create(album);
        ctx.use(MainAction.class).execute();
    }

    private boolean pressedZero(String input) {
        if (input.equals("0")) {
            ctx.use(MainAction.class).execute();
            return true;
        }
        return false;
    }
}
