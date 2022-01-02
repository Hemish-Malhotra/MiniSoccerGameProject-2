package model.players;

public class PlayerStatistics  {
	private int stat;

	public int getStatistics() {
		return this.stat;
	}

	public void setStatistics(int stat) {
		this.stat = stat;
	}
	
	@Override
	public String toString() {
		return Integer.toString(stat);
	}
	

	
}
