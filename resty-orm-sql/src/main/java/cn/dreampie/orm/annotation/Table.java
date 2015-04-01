package cn.dreampie.orm.annotation;

import cn.dreampie.orm.DS;

import java.lang.annotation.*;

/**
 * Created by ice on 14-12-30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Table {
  String name();//表名

  String primaryKey() default DS.DEFAULT_PRIMARY_KAY;//多主键策略 1自增主键+n其他主键  自增主键放在第一位

  boolean lockKey() default false;//锁定主键策略，当1自增主键+n其他主键时，锁定主键表示增删改查都必须检测主键的完整性

  boolean cached() default false;//是否使用缓存
}
