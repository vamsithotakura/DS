package ThreadConcepts;

public class JoinTest {
	
	public static void main(String[] args) {
		
		Runner r1 = new Runner("RUNNER 1", null);
		Runner r2 = new Runner("RUNNER 2", r1);
		Runner r3 = new Runner("RUNNER 3", r2);
		
		r1.start();
		r2.start();
		r3.start();
		
	}

}

class Runner extends Thread {

	private Runner previous = null;
	private String name;

	public Runner(String name, Runner previous) {
		this.name = name;
		this.previous = previous;
	}

	public void run() {
		if(previous != null) {
			try {
				previous.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+" says Hello :)");
		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+" says Hello :)");
		}
	}

}
