package fr.supelec.tesl.core;

import java.util.HashMap;

public abstract class TagCalculusFactory {
	private static HashMap<Class<?>, TagCalculus<?>> calculus = new HashMap<>();
	
	public static <K> void registerCalculus(Class<K> type, TagCalculus<K> calc) {
		calculus.put(type, calc);
	}
	
	@SuppressWarnings("unchecked")
	public static <K> TagCalculus<K> getCalculus(Class<K> type) {
		return (TagCalculus<K>) calculus.get(type);
	}
	
	@SuppressWarnings("unchecked")
	public static <K> TagCalculus<K> getCalculus(K value) {
		return (TagCalculus<K>) calculus.get(value.getClass());
	}
	
}
