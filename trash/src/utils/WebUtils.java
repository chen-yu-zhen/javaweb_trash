package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author cyz
 * @create 2020-10-22 7:37
 */
public class WebUtils {
    public static<T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str,int defaultVal){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultVal;
    }
}
