import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * The {@code Grid} class is a modifiable {@code Collection} of Objects of type T arranged
 * in a 2D {@code ArrayList} pattern. </br>
 * </br>
 * Please see {@link java.util.Collection} and {@link java.util.ArrayList} for
 * more info.
 *
 * @author Harris Ransom
 * @author Ben Guerrieri
 * @version 1.0
 * @param <T> any valid type
 */
public class Grid<T> implements Collection<T>, Cloneable {
	private int xSize; //Starting x size
	private int ySize; //Starting y size
	private ArrayList<ArrayList<T>> grid;

	/**
	 * Grid Constructor
	 * 
	 * @param xSize
	 * @param ySize
	 * @throws InvalidParameterException If parameters are smaller than 0 or larger
	 *                                   than {@code Integer.MAX_VALUE}
	 */
	@SuppressWarnings("unchecked")
	public Grid(int xSize, int ySize) throws InvalidParameterException {
		super();
		if ((xSize >= 0) && (ySize >= 0) && (xSize < Integer.MAX_VALUE) && (ySize < Integer.MAX_VALUE)) {
			this.xSize = xSize;
			this.ySize = ySize;
			this.grid = new ArrayList<ArrayList<T>>();

			// Fills grid with rows
			for (int i = 0; i < ySize; i++) {
				grid.add(new ArrayList<T>());
			}

			// Fills grid with default objects
			for (ArrayList<T> subArray : grid) {
				for (int i = 0; i < this.xSize; i++) {
					subArray.add((T) new Object());
				}
			}
		} else {
			this.xSize = 0;
			this.ySize = 0;
			throw new InvalidParameterException();
		}
	}

	/**
	 * Returns specific array row size
	 * 
	 * @return Current dimension for a specified row
	 */
	public int getXSize(int rowIndex) {
		return this.grid.get(rowIndex).size();
	}

	/**
	 * Returns current column size
	 * 
	 * @return Current integer column dimension
	 */
	public int getYSize() {
		return this.grid.size();
	}

	/**
	 * Returns the initial X dimension
	 * 
	 * @return Starting X integer dimension
	 */
	public int getStartXSize() {
		return this.xSize;
	}

	/**
	 * Returns initial Y dimension
	 * 
	 * @return Starting Y integer dimension
	 */
	public int getStartYSize() {
		return this.ySize;
	}

	/**
	 * Gets total size of grid
	 * 
	 * @see java.util.Collection#size()
	 */
	@Override
	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			for (int i = 0; i < this.grid.size(); i++) {
				for (int j = 0; j < this.grid.get(i).size(); j++) {
					size += 1;
				}
			}
		}
		return size;
	}

	/**
	 * Gets object at a specific coordinate in the grid
	 * 
	 * @param xCoord
	 * @param yCoord
	 * @return Object at (xCoord, yCoord) of type T
	 */
	public Object get(int xCoord, int yCoord) {
		Object returnObject = new Object();
		try {
			returnObject = grid.get(yCoord).get(xCoord);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unknown error getting object at (" + xCoord + ", " + yCoord + ")");
		}
		return returnObject;
	}

	/**
	 * Modifies object at specific coordinate
	 * 
	 * @param xCoord
	 * @param yCoord
	 */
	@SuppressWarnings("unchecked")
	public void set(int xCoord, int yCoord, Object obj) {
		grid.get(yCoord).set(xCoord, (T) obj);
	}

	/**
	 * Inserts new object at coordinate
	 * 
	 * @param xCoord
	 * @param yCoord
	 * @param obj
	 */
	@SuppressWarnings("unchecked")
	public void add(int xCoord, int yCoord, Object obj) {
		grid.get(yCoord).add(xCoord, (T) obj);
	}

	/**
	 * Appends object to the end of the grid
	 * 
	 * @see java.util.Collection#add(java.lang.Object)
	 * @param e object to be added
	 */
	@Override
	public boolean add(T e) {
		try {
			if (this.grid.get(this.grid.size() - 1).size() >= this.getStartXSize()) {
				this.grid.add(new ArrayList<T>());
				this.add(this.grid.get(this.grid.size() - 1).size(), this.grid.size() - 1, e);
			} else {
				this.add(this.grid.get(this.grid.size() - 1).size() - 1, this.grid.size() - 1, e);
			}
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
	}

	/**
	 * Creates new row by appending ArrayList e
	 * 
	 * @param e
	 * @return {@code true}
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean addRow(ArrayList<T> e) {
		this.grid.add(e);
		return true;
	}

	/**
	 * Adds all objects in collection c to grid
	 * 
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (Object item : c) {
			this.add((T) item);
		}
		return false;
	}

	/**
	 * Removes object o from grid
	 * 
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		boolean bool = false;
		for (int i = 0; i < this.getYSize(); i++) {
			for (int j = 0; j < this.getXSize(i); j++) {
				if (this.get(j, i).equals(o)) {
					try {
						this.grid.get(i).remove(j);
						bool = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return bool;
	}

	/**
	 * Removes object from specific coordinate
	 * 
	 * @param xCoord
	 * @param yCoord
	 * @return Boolean if grid changed
	 */
	public boolean remove(int xCoord, int yCoord) {
		boolean changed = false;
		try {
			this.grid.get(yCoord).remove(xCoord);
			changed = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return changed;
	}

	/**
	 * @param Row Y index
	 * @return Row removed
	 * @see java.util.ArrayList#remove(int)
	 */
	public ArrayList<T> remove(int yIndex) {
		return grid.remove(yIndex);
	}

	/**
	 * Removes all objects in collection c from grid
	 * 
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean bool = false;
		Object[] objs = new Object[c.size()];
		objs = c.toArray(objs);

		for (int a = 0; a < objs.length; a++) {
			for (int i = 0; i < this.getYSize(); i++) {
				for (int j = 0; j < this.getXSize(i); j++) {
					if (this.get(j, i).equals(objs[a])) {
						try {
							this.grid.get(i).remove(j);
							bool = true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return bool;
	}

	/**
	 * Removes row from grid
	 * 
	 * @param rowIndex
	 */
	public void removeRow(int rowIndex) {
		this.grid.remove(rowIndex);
	}

	/**
	 * Clears grid
	 * 
	 * @see java.util.Collection#clear()
	 */
	@Override
	public void clear() {
		if (!this.isEmpty()) {
			for (int i = 0; i < this.grid.size(); i++) {
				for (int j = 0; j < this.grid.get(i).size(); j++) {
					this.grid.get(i).remove(j);
				}
			}
			this.clear();
		}
	}

	/**
	 * Returns grid in printable String form
	 * 
	 * @return String returnString
	 * @see java.util.Collection#toString()
	 */
	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		returnString.append("[");

		if (this.isEmpty()) {
			return returnString.append("]").toString();
		} else {
			for (int i = 0; i < this.grid.size(); i++) {
				for (int j = 0; j < this.grid.get(i).size(); j++) {
					returnString.append(grid.get(i).get(j).toString());
					if (j < this.grid.get(i).size() - 1) {
						returnString.append(", ");
					}
				}
				if (i < this.getYSize() - 1) {
					returnString.append("\n ");
				}
			}
		}
		return returnString.append("]").toString();
	}

	/**
	 * Returns grid in array form
	 * 
	 * @see java.util.Collection#toArray()
	 */
	@Override
	public Object[] toArray() {
		Object[] objArr = new Object[this.size()];
		int index = 0;
		for (int i = 0; i < this.grid.size(); i++) {
			for (int j = 0; j < this.grid.get(i).size(); j++) {
				objArr[index] = this.get(j, i);
				index++;
			}
		}
		return objArr;
	}

	/**
	 * Returns grid in array form in parameter array a
	 * 
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 * @param a   Array to store result in
	 * @param <T>
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T[] toArray(T[] a) {
		int index = 0;
		if (a.length < this.size()) {
			T[] tArr = (T[]) new Object[this.size()];
			for (int i = 0; i < this.grid.size(); i++) {
				for (int j = 0; j < this.grid.get(i).size(); j++) {
					tArr[index] = (T) this.get(j, i);
					index++;
				}
			}
			return tArr;
		} else {
			for (int i = 0; i < this.grid.size(); i++) {
				for (int j = 0; j < this.grid.get(i).size(); j++) {
					a[index] = (T) this.get(j, i);
					index++;
				}
			}
			return a;
		}
	}

	/**
	 * Returns list of items between two indices
	 * 
	 * @param fromIndex
	 * @param toIndex
	 * @return List of items between fromIndex (inclusive) and toIndex (inclusive)
	 * @see java.util.ArrayList#subList(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<T> subList(int fromIndex, int toIndex) {
		List<T> returnList = new ArrayList<T>();
		T[] objs = (T[]) this.toArray();

		for (int i = fromIndex; i <= toIndex; i++) {
			returnList.add(objs[i]);
		}
		return returnList;
	}

	/**
	 * Returns grid in ArrayList form
	 * 
	 * @return 2D ArrayList grid
	 */
	public ArrayList<ArrayList<T>> getGrid() {
		return this.grid;
	}

	/**
	 * Creates clone of current grid
	 * 
	 * @return Cloned {@code Grid} Object
	 * @see java.util.ArrayList#clone()
	 */
	@Override
	public Grid<T> clone() {
		Grid<T> cloneGrid = new Grid<T>(getStartXSize(), getStartYSize());
		for (int i = 0; i < cloneGrid.grid.size(); i++) {
			for (int j = 0; j < cloneGrid.grid.get(i).size(); j++) {
				cloneGrid.set(j, i, this.get(j, i));
			}
		}
		return cloneGrid;
	}

	/**
	 * Returns iterator of items in grid
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return grid.get(0).iterator();
	}

	/**
	 * Determines if grid contains object o
	 * 
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		boolean bool = false;
		for (int i = 0; i < this.getYSize(); i++) {
			for (int j = 0; j < this.getXSize(i); j++) {
				if (this.get(j, i).equals(o)) {
					bool = true;
				}
			}
		}
		return bool;
	}

	/**
	 * Determines if grid contains all objects in collection c
	 * 
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		boolean returnBool = true;
		boolean[] bools = new boolean[c.size()];
		Object[] objs = new Object[c.size()];
		objs = c.toArray(objs);

		for (int a = 0; a < objs.length; a++) {
			for (int i = 0; i < this.getYSize(); i++) {
				for (int j = 0; j < this.getXSize(i); j++) {
					if (this.get(j, i).equals(objs[a])) {
						bools[a] = true;
					}
				}
			}
		}

		for (int i = 0; i < bools.length; i++) {
			if (!bools[i]) {
				returnBool = false;
			}
		}
		return returnBool;
	}

	/**
	 * Determines if grid is empty
	 * 
	 * @see java.util.Collection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < this.grid.size(); i++) {
			if (!this.grid.get(i).isEmpty()) {
				isEmpty = false;
			}
		}
		return isEmpty;
	}

	/**
	 * Removes all items not in collection c from grid
	 * 
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean changed = false;
		Object[] objs = new Object[c.size()];
		objs = c.toArray(objs);

		for (int a = 0; a < 5; a++) {
			for (int i = 0; i < this.getYSize(); i++) {
				for (int j = 0; j < this.getXSize(i); j++) {
					if (!c.contains(this.get(j, i))) {
						try {
							this.remove(j, i);
							changed = true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return changed;
	}
}