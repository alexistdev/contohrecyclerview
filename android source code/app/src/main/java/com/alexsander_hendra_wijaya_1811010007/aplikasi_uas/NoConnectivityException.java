package com.alexsander_hendra_wijaya_1811010007.aplikasi_uas;

import java.io.IOException;

class NoConnectivityException extends IOException {
    @Override
    public String getMessage() {
        return "Tidak Ada Koneksi Internet!";
    }
}
