package Threads;

public class SincronizacionThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*HilosVarios Hilo1 = new HilosVarios();
		HilosVarios Hilo2 = new HilosVarios();
		Hilo1.start();
		try {
			Hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Hilo2.start();
		try {
			Hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		HilosVarios Hilo1 = new HilosVarios();
		HilosVarios2  Hilo2 = new HilosVarios2(Hilo1);
		Hilo2.start();
		Hilo1.start();
		System.out.println("Terminada las tareas");
	}

}

class HilosVarios extends Thread {
	
	public void run() {
		for(int i=0; i<15; i++) {
			System.out.println("Ejecutando Hilo " + getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class HilosVarios2 extends Thread {
	
	private Thread hilo;
	
	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0; i<15; i++) {
			System.out.println("Ejecutando Hilo " + getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}