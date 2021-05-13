package com.java8.approaches.util;

@FunctionalInterface
public interface TransactionPredicate { //Functional Interface
	boolean test(Transaction t);
}
