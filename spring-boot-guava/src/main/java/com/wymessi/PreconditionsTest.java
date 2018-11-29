package com.wymessi;

import static com.google.common.base.Preconditions.*;

public class PreconditionsTest {
    
    public static void main(String[] args) {
        checkArgument(1 > 5, "1 必须小于5");
        checkNotNull(null);
    }
}
