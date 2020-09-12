package io.mbab.sda.groupproject;

import io.mbab.sda.groupproject.config.Configuration;
import io.mbab.sda.groupproject.config.JpaUtil;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.action.MainAction;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.AlbumRepository;
import io.mbab.sda.groupproject.repository.CrudRepositoryFactory;

import java.util.Scanner;

public class Application {

  public static void main(String... args) {
    var emFactory =
        JpaUtil.getEntityManagerFactory(Configuration.getDataSource(), Configuration.getEntityClass());
    var repositoryFactory = new CrudRepositoryFactory(emFactory);
    var scanner = new CustomScanner();

    new MenuActionContext(scanner, repositoryFactory).use(MainAction.class).execute();
  }
}
