package com.example.mitologia_chilota;

import android.provider.BaseColumns;

public final class CuentoContract {
    private CuentoContract(){
    }

    public static class CuentoEntry implements BaseColumns{
        public static final String TABLE_NAME = "cuento";
        public static final String COLUMN_ID = "id";
        public static final String TITULO = "titulo";
        public static final String HISTORIA = "historia";
        public static final String RUTA_IMAGEN = "ruta_imagen";

    }
}
