package com.tamk.Expedition.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelTest {

	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes(new RouteBuilder() {

			public void configure() throws Exception {
				from("file:d:/conf/taobao-hsf.sar.zip").to("file:d:/test/a.zip");
			}
		});

		ctx.start();
		ctx.stop();
	}

}
