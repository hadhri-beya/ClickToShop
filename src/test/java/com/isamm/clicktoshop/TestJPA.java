package com.isamm.clicktoshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.metier.IVendeurMetier;



public class TestJPA {
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			assertTrue(true);
			/*
			IVendeurMetier metier=(IVendeurMetier) context.getBean("metier");
			List<Produit> cats1=metier.listproduits();
			metier.ajouterProduit(new Produit("dddddddd", "aaaaa", 11, false, "ddddd", 15));
			System.out.println(cats1.size());
			*/
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
