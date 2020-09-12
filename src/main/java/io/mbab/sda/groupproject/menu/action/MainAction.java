package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class MainAction implements MenuAction {

  private final CustomScanner scanner;
  private final MenuActionContext ctx;


  @Override
  public void execute() {
    System.out.println("0) Zamknij aplikację");
    System.out.println("1) Dodaj album");
    System.out.println("2) Wyswietl albumy");
    System.out.println("3) Dodaj utwór do albumu");
    System.out.println("4) Wyświetl utwory");

    var input = scanner.nextLine();

    if (input.equals("0")) {
      System.exit(0);
      return;
    }

    if (input.equals("1")) {
      ctx.use(CreateAlbumAction.class).execute();
      return;
    }

    if (input.equals("2")) {
      ctx.use(ViewAlbumAction.class).execute();
      return;
    }

    if (input.equals("3")) {
      ctx.use(CreateSongAction.class).execute();
      return;
    }

    if (input.equals("4")) {
      ctx.use(ViewSongAction.class).execute();
      return;
    }


    System.out.println("Wprowadzono nieprawidłowa wartość!");
    execute();
  }
}
