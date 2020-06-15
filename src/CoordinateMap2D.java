import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2D Map Data Structure (Coordinate key implementation)
 * Similar to a Grid, but implemented as a HashMap wrapper with a 2D Coordinate pair class
 * @author Harris Ransom
 * @param <V> Value type 
 */
public class CoordinateMap2D<V> implements Map<Coordinate, V>{
	protected HashMap<Coordinate, V> map; //Internal map data structure

	//Constructor
	public CoordinateMap2D() {
		map = new HashMap<Coordinate, V>();
	}

	//Clears the map of all entries
	@Override
	public void clear() {
		while (!map.isEmpty()) {
			for (Entry<Coordinate, V> entry: map.entrySet()) {
				map.remove(entry.getKey(), entry.getValue());
			}
		}
		map.clear(); //Guarantees clear at the end
	}

	/**Clones CoordinateMap to object
	 * @return Object containing map
	 * @see java.util.HashMap#clone()
	 */
	@Override
	public Object clone() {
		return map.clone();
	}

	/**Determines if the map contains specified key
	 * @param arg0 key
	 * @return true if map contains key, false otherwise
	 */
	@Override
	public boolean containsKey(Object arg0) {
		boolean bool = false;
		for (Coordinate key : map.keySet()) {
			if (key.equals(arg0))
				bool = true;
		}
		return bool;
	}

	/**Determines if the map contains specified value
	 * @param arg0 value
	 * @return true if map contains value, false otherwise
	 */
	@Override
	public boolean containsValue(Object arg0) {
		boolean bool = false;
		for (V value : map.values()) {
			if (value.equals(arg0))
				bool = true;
		}
		return bool;
	}

	/**Returns a Set view of the mappings
	 * @return Set of entries
	 */
	@Override
	public Set<Entry<Coordinate, V>> entrySet() {
		return map.entrySet();
	}

	/**Gets specified value
	 * @param arg0 value
	 * @return Value if value is found, null otherwise
	 */
	@Override
	public V get(Object arg0) {
		V val = null;
		for (V value : map.values()) {
			if (value.equals(arg0))
				val = value;
		}
		return val;
	}

	/**Determines if map is empty
	 * @return true if map is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	/**Returns a set of Coordinates (keys) in this map
	 * @return Set of Coordinate objects (keys)
	 */
	@Override
	public Set<Coordinate> keySet() {
		return map.keySet();
	}

	/**Inserts key-value pair and associates key with value
	 * @return Value if insertion was successful, null otherwise
	 */
	@Override
	public V put(Coordinate arg0, V arg1) {
		V value = null;
		try {
			map.put(arg0, arg1);
			value = arg1;
		} catch (Exception e) {
			System.out.println("Unable to put in coordinate " + arg0.toString() + " with value " + arg1.toString());
		}
		return value;
	}


	//Copies all of the specified mappings from the given map to this map
	@Override
	public void putAll(Map<? extends Coordinate, ? extends V> arg0) {
		map.putAll(arg0);
	}

	/**Removes specified object from map
	 * @param arg0 object to be removed
	 * @return Object removed if able to be removed, null otherwise
	 */
	@Override
	public V remove(Object arg0) {
		V returnObject = null;
		try {
			returnObject = map.remove(arg0);
		} catch (Exception e) {
			System.out.println("Unable to remove object, object not found.");
		}
		return returnObject;
	}

	/**Returns size of the map
	 * @return size integer
	 */
	@Override
	public int size() {
		return map.size();
	}

	/**Transforms CoordinateMap to its String representation
	 * @return String representation of CoordinateMap
	 * @see java.util.AbstractMap#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Entry<Coordinate, V> entry: map.entrySet()) {
			sb.append("<");
			sb.append(entry.getKey().getX()); //X coord
			sb.append(", ");
			sb.append(entry.getKey().getY()); //Y coord
			sb.append("> : ");
			sb.append(entry.getValue().toString()); //Value's String representation
			sb.append('\n');
		}
		sb.append("]");
		return sb.toString();
	}

	/**Returns collection of current values in map
	 * @return Collection of values
	 */
	@Override
	public Collection<V> values() {
		return map.values();
	}
}