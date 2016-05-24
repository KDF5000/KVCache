package com.hydra.cache;

import junit.framework.TestCase;

public class CacheTest extends TestCase {

	public void testCache() {
		Cache cache = new Cache();
		
		for(int i=0;i<10;i++){
			cache.set("hello_"+i, "world_"+i,1000);
		}
		cache.set("hello_2", "world_22",1000);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cache.get("hello_2"));
	}
}
