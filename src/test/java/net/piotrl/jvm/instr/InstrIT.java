package net.piotrl.jvm.instr;

import net.piotrl.jvm.service.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class InstrIT {
	@BeforeClass
	public static void beforeClass() {
		App.main(null);
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}

	@Test
	public void agentTestWithPerformanceAnnotation() throws IOException {
		System.out.println("agentSlowTestWithPerformanceAnnotation");
		new URL("http://localhost:4567/param/Joe").openStream();;

		assertTrue(true);
	}
	@Test
	public void agentTestWithoutPerformanceAnnotation() throws IOException {
		System.out.println("agentTestWithoutPerformanceAnnotation");
		new URL("http://localhost:4567/hello").openStream();

		assertTrue(true);
	}
}