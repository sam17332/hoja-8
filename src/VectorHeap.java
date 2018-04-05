import java.util.Vector;

/**
 * @author Marcos Gutierrez
 * @since 04 abril 2018
 * Clase Vector Heap
 * Basado de "http://www.cs.williams.edu/JavaStructures/doc/structure5/index.html?structure5/VectorHeap.html"
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
	/*atributo que guarda los datos almacenados dentro de un vector*/
	protected Vector<E> data; 
	
	/*construccion de la clase VectorHeap*/
	public VectorHeap(){
		/*iniciliazamos el atributo*/
		data = new Vector<E>();
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
		/*Atributo para comparar el tamaño del "root"*/
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		/*devuelve si esta vacio o esta lleno*/
		return data.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
