package com.github.mpawlucz.connectionpool;

import java.io.Closeable;
import java.io.IOException;

public interface Connection extends Closeable {

    void close() throws IOException;

}
