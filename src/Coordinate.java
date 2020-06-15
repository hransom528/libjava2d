public class Coordinate  {
	private int x; //X key
	private int y; //Y key
	
	//Default constructor
	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}
	
	//Constructor
	public Coordinate(int xVal, int yVal) {
		this.x = xVal;
		this.y = yVal;
	}
	
	//Creates clone of current Coordinate object
	@Override
	protected Object clone() {
		return new Coordinate(this.x, this.y);
	}
	
	//Determines if an object is equal to current object based off of string representations
	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (obj.toString().equalsIgnoreCase(this.toString()))
			bool = true;
		return bool;
	}
	
	/**Determines if another Coordinate object is equal to current Coordinate
	 * @param otherCoord Coordinate object
	 * @return true if information in both Coordinate objects is equal, false otherwise
	 */
	public boolean equals(Coordinate otherCoord) {
		boolean bool = false;
		if ((otherCoord.getX().equals(this.x)) && (otherCoord.getY().equals(this.y)))
			bool = true;
		return bool;
	}
	/**
	 * Gets x value
	 * @return the x
	 */
	public Object getX() {
		return x;
	}

	/**
	 * Gets y value
	 * @return the y
	 */
	public Object getY() {
		return y;
	}
	
	/**
	 * Sets x value
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets y value
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(this.x);
		sb.append(", ");
		sb.append(this.y);
		sb.append(")");
		return sb.toString();
	}
}