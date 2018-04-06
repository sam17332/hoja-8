import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasJUnit {

	@Test
	/*Pruebas para añadir al vector*/
	public void add() throws Exception{
		VectorHeap<String> vector = new VectorHeap<>();
		vector.add("A");
		assertEquals("A", vector.getFirst());
	}
	
	@Test
	public void remove() throws Exception {
		VectorHeap<String> vector2 = new VectorHeap<>();
		vector2.add("B");
		vector2.add("I");
		vector2.add("E");
		vector2.add("H");
		assertEquals("B", vector2.remove());
		
	}
	

}
