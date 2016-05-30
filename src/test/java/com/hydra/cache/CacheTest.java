package com.hydra.cache;

import junit.framework.TestCase;

public class CacheTest extends TestCase {

	public void testLRUCache() {
		Cache cache = new Cache(10);
		
		for(int i=0;i<10;i++){
			cache.set("hello_"+i, "world_"+i,100000);
		}
		System.out.println("访问后９个数据");
		for(int i=9;i>=1;i--){
			System.out.println(cache.get("hello_"+i));
		}
		
		cache.set("hello_10", "world_10",100000);
		System.out.println("替换后---");
		for(int i=0;i<11;i++){
			System.out.println(cache.get("hello_"+i));
		}
		
	}
	
	
	public void testLFUCache(){
		Cache cache = new Cache("lfu", 9);
		
		for(int i=0;i<9;i++){
			cache.set("hello_"+i, "world_"+i,100000);
		}
		
		System.out.println("获取前８个缓存数据");
		for(int i=0;i<9;i++){
			if(i==5){
				continue;
			}
			System.out.println(i+":"+cache.get("hello_"+i));
		}
		
		cache.set("hello_9", "world_9",100000);
		System.out.println("获取替换后的缓存");
		for(int i=0;i<10;i++){
			System.out.println(i+":" + cache.get("hello_"+i));
		}
	}
	
	public void testExpire() throws InterruptedException{
//		Cache cache = new Cache("lru");
		Cache cache = new Cache("lfu");
		cache.set("hello", "world", 1000);
		Thread.sleep(1000);
		System.out.println("超时后:"+cache.get("hello"));
	}
}


