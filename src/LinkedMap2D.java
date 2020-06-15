import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2D LinkedHashMap Data Structure (Coordinate key implementation)
 * Similar to a Grid object, but implemented as a LinkedHashMap wrapper with a 2D Coordinate pair class
 * Can be treated as a Linked List and iterated over as such
 * @author Harris Ransom
 * @param <V> Value type 
 */
public class LinkedMap2D<V> implements Map<Coordinate, V> {
	protected LinkedHashMap<Coordinate, V> map; //Internal map structure

	//Constructor
	public LinkedMap2D() {
		map = new LinkedHashMap<Coordinate, V>();
	}

	//Clears map
	@Override
	public void clear() {
		while (!map.isEmpty()) {
			for (Entry<Coordinate, V> entry: map.entrySet()) {
				map.remove(entry.getKey(), entry.getValue());
			}
		}
		map.clear();		
	}

	@Override
	public boolean containsKey(Object arg0) {
		boolean bool = false;
		for(Coordinate key : map.keySet()) {
			if (key.equals(arg0))
				bool = true;
		}
		return bool;
	}

	@Override
	public boolean containsValue(Object arg0) {
		boolean bool = false;
		for (V value : map.values()) {
			if (value.equals(arg0))
				bool = true;
		}
		return bool;
	}

	@Override
	public Set<Entry<Coordinate, V>> entrySet() {
		return map.entrySet();
	}

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Coordinate> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(Coordinate arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends Coordinate, ? extends V> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	//Gets size of 
	@Override
	public int size() {
		return map.size();
	}

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

	@Override
	public Collection<V> values() {
		return map.values();
	}
}