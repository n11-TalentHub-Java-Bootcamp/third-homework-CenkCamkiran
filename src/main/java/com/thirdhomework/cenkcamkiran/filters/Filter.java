package com.thirdhomework.cenkcamkiran.filters;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public interface Filter {
    SimpleFilterProvider GetFilterProvider(String filterName);

    SimpleBeanPropertyFilter GetUserFilter();
}
