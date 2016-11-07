package com.tamk.Expedition.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelTest {

	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes(new RouteBuilder() {

			public void configure() throws Exception {
				from("file:d:/test?delay=3000").to("file:d:/test1");
			}
		});

		ctx.start();
		Thread.sleep(2500);
		ctx.stop();
	}

}
