package de.aw3s.btDiary.reflection;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class Reflactor {

    public String getProperty(Object o, String propertyName)  {
        try {
            return BeanUtils.getProperty(o, propertyName);
        } catch (IllegalAccessException  | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
