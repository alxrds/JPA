package dev.alexandre.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.alexandre.cliente.models.Cliente;

public class Teste {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ClienteJPA");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	public static void main(String[] args) {
		
		//CREATE
		Cliente cliente1 = new Cliente();
		cliente1.setNome("FACEBOOK");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("GOOGLE");
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente1);
		entityManager.persist(cliente2);
		entityManager.getTransaction().commit();

		//READ
		Cliente cliente = entityManager.find(Cliente.class, 1);
		System.out.println("Resultado da Busca: " + cliente.getNome());
		
		//UPDATE
		Cliente cliente3 = new Cliente();
		cliente3.setId(2);
		cliente3.setNome("GOOGLE CORP");
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente3);
		entityManager.getTransaction().commit();
				
		//DELETE
		Cliente cliente4 = entityManager.find(Cliente.class, 1);
		entityManager.getTransaction().begin();
		entityManager.remove(cliente4);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();		

	}

}
