package Banco;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Banco banquito = new Banco();
		for(int i = 0; i < 100; i++) {
			EjecucionTransferencia transferencias = new EjecucionTransferencia(banquito,
													i, 20000);
			Thread hilo = new Thread(transferencias);
			hilo.start();
		}
	}

}

class Banco {
	private final double[] cuentas;
	
	private Lock cierreBanco= new ReentrantLock();
	
	public Banco() {
		cuentas = new double[100];
		
		for(int i=0; i < cuentas.length; i++) {
			cuentas[i]= 20000;
		}
	}
	
	public void transferencias(int origen, int destino, double cantidadTransferir ) {
		
		cierreBanco.lock();
		
		try {
			
			if(cuentas[origen]<cantidadTransferir) {
				return;
			}	
			System.out.println(Thread.currentThread());		
			
			cuentas[origen]-= cantidadTransferir;
			System.out.printf("numero de cuenta : %d, cantidad a transferir: %6.2f , tranferir a : %d ", origen,cantidadTransferir, destino);			
			
			cuentas[destino] += cantidadTransferir;	
				
			System.out.printf("Saldo total %10.2f \n", getSaldoTotal());
		}
		finally {
			cierreBanco.unlock();
		}	
	}
	
	public double getSaldoTotal() {
		double sumCuentas = 0;
		for(double i : cuentas) {
			sumCuentas += i;
		}
		return sumCuentas;
	}
}

class EjecucionTransferencia implements Runnable {
	
	private Banco banco;
	private int cuenta;
	private double cantidadMax;
	
	public EjecucionTransferencia(Banco banco, int cuenta, double cantidadMax) {
		this.banco = banco;
		this.cuenta = cuenta;
		this.cantidadMax = cantidadMax;
	}
	
	public void run() {
		while(true) {
			
			int destino = (int)(Math.random()*100);
			double cantidadTranferencia = (Math.random()*cantidadMax);
			
			banco.transferencias(cuenta, destino, cantidadTranferencia);
			try {
				Thread.sleep((int)(Math.random()*10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}