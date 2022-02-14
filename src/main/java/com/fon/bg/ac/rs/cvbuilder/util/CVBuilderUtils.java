package com.fon.bg.ac.rs.cvbuilder.util;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;
import org.hibernate.Hibernate;

import java.util.Collection;

public class CVBuilderUtils {

    public static <T extends BaseEntity> boolean isLazyEntityInitialized(T entity) {
        return Hibernate.isInitialized(entity);
    }

    public static <T extends BaseEntity> boolean isLazyInitializedCollection(Collection<T> collection){
        return Hibernate.isInitialized(collection);
    }
}
