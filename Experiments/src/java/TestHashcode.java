
public class TestHashcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String Aa="Aa";
		System.err.println(Aa.hashCode());
		String BB="BB";
		System.err.println(BB.hashCode());

		System.err.println(BB.equals(Aa));
		System.err.println("--------");
		Integer in1= new Integer(100);
		Integer in2= new Integer(100);
		System.err.println("int 1 equals int 2: "+in1.equals(in2));
		System.err.println("int 1 = int 2: " + (in1 == in2));
	}

}
