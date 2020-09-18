package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.Album;
import io.mbab.sda.groupproject.entity.Song;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.AlbumRepository;
import io.mbab.sda.groupproject.repository.SongRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@RequiredArgsConstructor
public class CreateSongAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final SongRepository repository;

    @Override
    public void execute() {
        System.out.println("0) Przejdź do poprzedniego menu");



        System.out.println("Podaj nazwę Utworu:");
        var input = scanner.nextLine();
        if (pressedZero(input)) return;
        var builder = Song.builder().name(input);

        System.out.println("Podaj autora:");
        input = scanner.nextLine();
        if (pressedZero(input)) return;
        builder.author(input);

        System.out.println("Podaj dlugosc:");
        if (pressedZero(input)) return;
        input = scanner.nextLine();
        builder.duration(input);

        System.out.println("Podaj ID albumu:");
        if (pressedZero(input)) return;
        int inputInt = scanner.nextInt();
        Album album = repository.getAlbumById(inputInt);
        builder.albums(album);

        var song = builder.build();




        repository.create(song);
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
