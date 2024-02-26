package dk.meem;



public class App {
	private final int NTHREADS = 4;

	
    public static void main(String[] args) {
    	ThreadTest tt = new ThreadTest();
    	tt.setup(4);
	}

}
