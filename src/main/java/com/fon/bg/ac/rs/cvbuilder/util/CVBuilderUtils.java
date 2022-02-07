package com.fon.bg.ac.rs.cvbuilder.util;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;
import org.hibernate.Hibernate;

public class CVBuilderUtils {

    public static <T extends BaseEntity> boolean isLazyEntityInitialized(T entity){
        return Hibernate.isInitialized(entity);
    }
}
