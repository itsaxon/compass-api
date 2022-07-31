package com.compass.common.exception.biz;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Collection;
import java.util.Objects;

/**
 * 异常断言
 *
 * @author liushuozhen
 * @date 2022/07/31
 */
@SuppressWarnings("unused")
public interface ExceptionAssert {

    /**
     * 默认错误消息
     */
    String DEFAULT_ERROR_MESSAGE = "业务异常";

    /**
     * 新异常
     *
     * @param msg 信息
     * @return {@link BaseException}
     */
    BaseException newException(String msg);

    /**
     * 断言是空
     *
     * @param obj obj
     */
    default void assertIsNull(Object obj) {
        assertIsNull(obj, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * 断言是空
     *
     * @param obj obj
     * @param msg 信息
     */
    default void assertIsNull(Object obj, String msg) {
        if (Objects.nonNull(obj)) {
            throw newException(msg);
        }
    }

    /**
     * 断言非空
     *
     * @param obj obj
     */
    default void assertNotNull(Object obj) {
        assertNotNull(obj, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * 断言非空
     *
     * @param obj obj
     * @param msg 信息
     */
    default void assertNotNull(Object obj, String msg) {
        if (Objects.isNull(obj)) {
            throw newException(msg);
        }
    }

    /**
     * 断言是不空
     *
     * @param str str
     */
    default void assertIsNotEmpty(String str) {
        assertIsNotEmpty(str, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * 断言是不空
     *
     * @param str 字符
     * @param msg 信息
     */
    default void assertIsNotEmpty(String str, String msg) {
        if (StrUtil.isEmpty(str)) {
            throw newException(msg);
        }
    }

    /**
     * 断言真正
     *
     * @param expression 表达式
     */
    default void assertTrue(boolean expression) {
        assertTrue(expression, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * 断言真正
     *
     * @param expression 表达式
     * @param msg        信息
     */
    default void assertTrue(boolean expression, String msg) {
        if (!expression) {
            throw newException(msg);
        }
    }

    /**
     * 断言假
     *
     * @param expression 表达式
     */
    default void assertFalse(boolean expression) {
        assertTrue(expression, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * 断言假
     *
     * @param expression 表达式
     * @param msg        信息
     */
    default void assertFalse(boolean expression, String msg) {
        if (expression) {
            throw newException(msg);
        }
    }

    /**
     * 断言不空
     *
     * @param collection 集合
     */
    default void assertNotEmpty(Collection<?> collection) {
        assertNotEmpty(collection, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * 断言不空
     *
     * @param collection 集合
     * @param msg        信息
     */
    default void assertNotEmpty(Collection<?> collection, String msg) {
        if (CollUtil.isEmpty(collection)) {
            throw newException(msg);
        }
    }


}
