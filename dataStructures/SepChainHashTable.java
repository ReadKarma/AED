package dataStructures;

	public class SepChainHashTable<K extends Comparable<K>, V>
	extends HashTable<K,V>{
		
		private static final int DEFAULT_CAPACITY = 50;

		public SepChainHashTable( ){
			 this(DEFAULT_CAPACITY);
			 }
		
		// The array of dictionaries.
		 protected Dictionary<K,V>[] table;

		@SuppressWarnings("unchecked")
		public SepChainHashTable( int capacity ){
			int arraySize = HashTable.nextPrime((int) (1.1 *
			capacity));
			 // Compiler gives a warning.
			 table = (Dictionary<K,V>[]) new Dictionary[arraySize];
			 for ( int i = 0; i < arraySize; i++ )
			 //table[i] = new OrderedDoubleList<K,V>();
			 table[i] = null;
			 maxSize = capacity;
			 currentSize = 0;
			 }

	    //@Override
	    /*public V find( K key )
	    {
	        return table[ this.hash(key) ].find(key);
	    }*/

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

		@Override
		public V find(K key) {
			// TODO Auto-generated method stub
			return null;
		}

		
		
		
		
		
		
		
		
	}

