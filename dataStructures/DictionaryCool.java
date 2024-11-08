package dataStructures;

public class DictionaryCool<K, V> implements Dictionary<K, V> {

	private int size;

	
	private DictionaryCool()
	{
		
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public V find(K key) {
		
		for(int i = 0; i < size; i++)
		{
			//if(entries[i].getKey().equals(key)) return entries[i].getValue();
		}
		return null;
	}
	
	@Override
	public V insert(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
