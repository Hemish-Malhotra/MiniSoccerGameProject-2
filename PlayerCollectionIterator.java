package model.players;

import java.util.*;

public class PlayerCollectionIterator implements Iterator<GamePlayer> {

  ListIterator<GamePlayer> iter;

  public PlayerCollectionIterator(PlayerCollection players) {
    iter = (ListIterator<GamePlayer>) players.getList().listIterator();
  }

  public boolean hasNext() {
    return iter.hasNext();

  }

  @Override
  public GamePlayer next() {

    return iter.next();
  }
  
  public ListIterator<GamePlayer> getIter() {
	  return iter;
  }

}