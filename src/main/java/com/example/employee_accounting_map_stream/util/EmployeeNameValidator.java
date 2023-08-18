package com.example.employee_accounting_map_stream.util;

import org.apache.commons.lang3.StringUtils;

public class EmployeeNameValidator {

    public static void checkNames(String... names) {

        for (String name : names) {
            if (!StringUtils.isAlpha(name)) {
                throw new IllegalArgumentException();

            }
        }

    }
}
