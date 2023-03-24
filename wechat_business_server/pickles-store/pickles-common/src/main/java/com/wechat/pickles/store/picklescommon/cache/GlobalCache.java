package com.wechat.pickles.store.picklescommon.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;
/**
 * Guava全局缓存
 * */
public class GlobalCache{
	private static Cache<String,Object> cache = CacheBuilder.newBuilder().maximumSize(15).expireAfterAccess(10, TimeUnit.MINUTES).build();

	/**
	 * 放入缓存
	 */
	public static void putCache(String key, Object obj){
		if(StringUtils.hasText(key)) {
			throw new RuntimeException("check cache key not exist");
		}
		cache.put(key,obj);
	}

	/**
	*获取缓存
	*/
	public static Object getCache(String key){
		if(StringUtils.hasText(key)){
			return null;
		}
		return cache.getIfPresent(key);
	}
}