package org.piecs.Util;

import org.piecs.Modelo.EntidadeBase;

public interface Loggable <T extends EntidadeBase>{
    void logCreate(T entidade);
    void logRead(T entidade);
    void logReadAll(T entidade);
}
