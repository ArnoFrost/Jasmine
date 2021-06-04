package com.arno.jasmine.lib.util

import java.lang.NullPointerException
import java.lang.StringBuilder

/**
 * @see [guava](https://github.com/google/guava/blob/b86fe4fc7ec511d78507c3ba32c789d1f250f827/guava/src/com/google/common/base/Preconditions.java)
 *
 * @author [Jenly](mailto:jenly1314@gmail.com)
 */
object Preconditions {
    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalArgumentException if `expression` is false
     */
    fun checkArgument(expression: Boolean) {
        require(expression)
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression a boolean expression
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     * string using [java.lang.String.valueOf]
     * @throws IllegalArgumentException if `expression` is false
     */
    fun checkArgument(expression: Boolean, errorMessage: Any?) {
        require(expression) { errorMessage.toString() }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression a boolean expression
     * @param errorMessageTemplate a template for the exception message should the check fail. The
     * message is formed by replacing each `%s` placeholder in the template with an
     * argument. These are matched by position - the first `%s` gets `errorMessageArgs[0]`, etc. Unmatched arguments will be appended to the formatted message in
     * square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs the arguments to be substituted into the message template. Arguments
     * are converted to strings using[java.lang.String.valueOf].
     * @throws IllegalArgumentException if `expression` is false
     */
    fun checkArgument(
        expression: Boolean,
        errorMessageTemplate: String?,
        vararg errorMessageArgs: Any?,
    ) {
        require(expression) {
            lenientFormat(
                errorMessageTemplate,
                *errorMessageArgs
            )
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalStateException if `expression` is false
     */
    fun checkState(expression: Boolean) {
        check(expression)
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @param expression a boolean expression
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     * string using [java.lang.String.valueOf]
     * @throws IllegalStateException if `expression` is false
     */
    fun checkState(expression: Boolean, errorMessage: Any?) {
        check(expression) { errorMessage.toString() }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @param expression a boolean expression
     * @param errorMessageTemplate a template for the exception message should the check fail. The
     * message is formed by replacing each `%s` placeholder in the template with an
     * argument. These are matched by position - the first `%s` gets `errorMessageArgs[0]`, etc. Unmatched arguments will be appended to the formatted message in
     * square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs the arguments to be substituted into the message template. Arguments
     * are converted to strings using[java.lang.String.valueOf].
     * @throws IllegalStateException if `expression` is false
     */
    fun checkState(
        expression: Boolean,
        errorMessageTemplate: String?,
        vararg errorMessageArgs: Any?,
    ) {
        check(expression) {
            lenientFormat(
                errorMessageTemplate,
                *errorMessageArgs
            )
        }
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws NullPointerException if `reference` is null
     */
    fun <T> checkNotNull(reference: T?): T {
        if (reference == null) {
            throw NullPointerException()
        }
        return reference
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference an object reference
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     * string using[java.lang.String.valueOf]
     * @return the non-null reference that was validated
     * @throws NullPointerException if `reference` is null
     */
    fun <T> checkNotNull(reference: T?, errorMessage: Any?): T {
        if (reference == null) {
            throw NullPointerException(errorMessage.toString())
        }
        return reference
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference an object reference
     * @param errorMessageTemplate a template for the exception message should the check fail. The
     * message is formed by replacing each `%s` placeholder in the template with an
     * argument. These are matched by position - the first `%s` gets `errorMessageArgs[0]`, etc. Unmatched arguments will be appended to the formatted message in
     * square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs the arguments to be substituted into the message template. Arguments
     * are converted to strings using[java.lang.String.valueOf].
     * @return the non-null reference that was validated
     * @throws NullPointerException if `reference` is null
     */
    fun <T> checkNotNull(
        reference: T?,
        errorMessageTemplate: String?,
        vararg errorMessageArgs: Any?,
    ): T {
        if (reference == null) {
            throw NullPointerException(lenientFormat(errorMessageTemplate, *errorMessageArgs))
        }
        return reference
    }

    fun lenientFormat(
        template: String?,
        vararg args: Any?,
    ): String {
        var template = template
        var args = args
        template = template.toString() // null -> "null"
        if (args == null) {
            args = arrayOf<Any?>("(Object[])null")
        }

        // start substituting the arguments into the '%s' placeholders
        val builder = StringBuilder(template.length + 16 * args.size)
        var templateStart = 0
        var i = 0
        while (i < args.size) {
            val placeholderStart = template.indexOf("%s", templateStart)
            if (placeholderStart == -1) {
                break
            }
            builder.append(template, templateStart, placeholderStart)
            builder.append(args[i++])
            templateStart = placeholderStart + 2
        }
        builder.append(template, templateStart, template.length)

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.size) {
            builder.append(" [")
            builder.append(args[i++])
            while (i < args.size) {
                builder.append(", ")
                builder.append(args[i++])
            }
            builder.append(']')
        }
        return builder.toString()
    }
}
