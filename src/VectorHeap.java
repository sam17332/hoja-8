import java.util.Vector;

/**
 * @author Marcos Gutierrez
 * @author Rodrigo Samayoa
 * @since 04 abril 2018
 * Clase Vector Heap
 * Basado de "http://www.cs.williams.edu/JavaStructures/doc/structure5/index.html?structure5/VectorHeap.html"
 */
public class VectorHeap<E extends Comparable<E>> implements Queue<E> {
	/*atributo que guarda los datos almacenados dentro de un vector*/
	protected Vector<E> data; 
	
	/*construccion de la clase VectorHeap*/
	public VectorHeap(){
		/*iniciliazamos el atributo*/
		data = new Vector<E>();
	}
	
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
	
	/**
	 * @return el primer valor
	 */
	@Override
	public E getFirst() {
		/*devuelve el primer valor dentro del "priority queue"*/
		return data.get(0);
	}
	/**
	 * @return minimo
	 */
	@Override
	public E remove() {
		/*valor miniimo dentro del "priority queue*/
		E minimo = getFirst();
		data.set(0, data.get(data.size()-1));
		data.setSize(data.size()-1);
		if(data.size() > 1) pushDownRoot(0);
		return minimo;
	}
	/**
	 * @param root, es la raiz del arbol
	 */
	private void pushDownRoot(int root) {
		/*Atributo para comparar el tama�o del "root"*/
		int heapS = data.size();
		E valor = data.get(root);
		while (root > heapS) {
			int childpos = left(root);
			if( childpos < heapS) {
				if(right(root) < heapS && data.get(childpos +1).compareTo(data.get(childpos))< 0) {
					childpos ++;
				}
				/*childpos now indexes smaller od two children*/
				if(data.get(childpos).compareTo(valor) < 0) {
					data.set(root, data.get(childpos));
					root = childpos;
				}
				/*found rigth location*/
				else {
					data.set(root, valor);
					return;
				}
			}
			/*at a leaf! insert and halt*/
			else {
				data.set(root, valor);
				return;
			}
		}
	}
	
	/*get the index of a right child*/
	private int right(int i) {
		return 2 * i + 2;
	}
	
	/*get the index of a left child*/
	private int left(int i) {
		return 2 * i + 1;
	}

	@Override
	public void add(E value) {
		data.add(value);
		precolateUp(data.size()-1);
		
	}

	@Override
	public boolean isEmpty() {
		/*devuelve si esta vacio o esta lleno*/
		return data.isEmpty();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public void clear() {
		data.removeAllElements();
	}
	
	private void precolateUp(int leaf){
		int parent = parent(leaf); /*find index of parent*/
		E value = data.get(leaf); /*get leaf value (just added)*/
		/*while leaf value is smaller than its parent*/
		while (leaf > 0 && (value.compareTo(data.get(parent))<0)) {
			/*move parent value downwards*/
			data.set(leaf, data.get(parent));
			/*update candidate index*/
			leaf = parent;
			/*move up one level*/
			parent = parent(leaf);
		}
		/*found the right index, set the value*/
		data.set(leaf, value);
	}
	
	/*get the index of a parent node*/
	private int parent(int i) {
		return (i-1)/2;
	}

}
