package io.mbab.sda.groupproject.menu;

import io.mbab.sda.groupproject.menu.action.CreateCityAction;
import io.mbab.sda.groupproject.menu.action.MainAction;
import io.mbab.sda.groupproject.menu.action.MenuAction;
import io.mbab.sda.groupproject.menu.action.ViewCitiesAction;
import io.mbab.sda.groupproject.repository.CityRepository;
import io.mbab.sda.groupproject.repository.CrudRepositoryFactory;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class MenuActionContext {

  private MenuAction action;
  private Map<Class<? extends MenuAction>, MenuAction> holder = new HashMap<>();

  public MenuActionContext(CrudRepositoryFactory repositoryFactory) {
    initHolder(repositoryFactory);
  }

  public MenuActionContext use(Class<? extends MenuAction> actionClass) {
    action = holder.get(actionClass);
    return this;
  }

  @SneakyThrows
  public void execute() {
    if (action == null) throw new RuntimeException("Menu action not set");
    action.execute();
  }

  private void initHolder(CrudRepositoryFactory repositoryFactory) {
    holder.put(MainAction.class, new MainAction(this));
    holder.put(
        CreateCityAction.class,
        new CreateCityAction(this, repositoryFactory.get(CityRepository.class)));
    holder.put(
        ViewCitiesAction.class,
        new ViewCitiesAction(this, repositoryFactory.get(CityRepository.class)));
  }
}