package model.players;
import java.util.*;
import java.util.List;
public class PlayerCollection implements Iterable<GamePlayer> {
 private List<GamePlayer> list;
 public PlayerCollection() {
   list = new ArrayList<GamePlayer>();
 }
 
 public void add(GamePlayer game_player) {
   list.add(game_player);
 }
  public GamePlayer get(String player) {
    if (player==null) {return null;}
    
    for(GamePlayer p : list) {
      if(p.getClass().getSimpleName().equals(player)) {
        return p;
      }
     
    }
    return null;
    
  }
  public void sort() {
    for(int i =1; i<list.size() ;i++) {
      int j=i-1;
      GamePlayer player= list.get(i);
      while (j>=0 && player.compareTo(list.get(j))<0) {
        list.set(j+1, list.get(j));
        j--;
      }
      list.set(j+1, player);
      
    }
   
  }
  public List<GamePlayer> getList(){
    return this.list;
  }

@Override
public Iterator<GamePlayer> iterator() {
  // TODO Auto-generated method stub
  return new PlayerCollectionIterator(this);
}



}