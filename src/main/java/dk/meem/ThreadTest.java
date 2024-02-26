package dk.meem;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadTest {
	public void setup(int NTHREADS) {
		final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

		final List<String> texts = new ArrayList<String>();
		texts.add("1.");
		texts.add("2.");
		texts.add("3.");
		texts.add("4.");

		for (String text : texts) {
			System.out.println("Text: " + text);

			Runnable task = new Runnable() {
				public void run() {
					mytask(text);
				}
			};
			exec.execute(task);
		}

		exec.shutdown();
		try {
			exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			System.err.println("Fejl under venten på thread termination: " + e.getMessage());
		}
	}

	private void mytask(String text) {
		System.out.println("Thread " + text);
	}

}
