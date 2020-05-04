package com.flydean;

import java.util.List;
import java.util.RandomAccess;

/**
 * @author wayne
 * @version ListInterface,  2020/5/4 11:37 上午
 */
public interface ListInterface<E> extends List<E>, RandomAccess, Cloneable, java.io.Serializable {
}