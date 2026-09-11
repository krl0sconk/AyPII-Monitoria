int NUM_PLATAFORMAS = 4;
float[] plataX     = { 0,   100, 350, 600 };
float[] plataY     = { 450, 350, 270, 210 };
float[] plataAncho = { 800, 150, 150, 150 };
float[] plataAlto  = { 30,  20,  20,  20  };

float ANCHO_JUGADOR = 50;
float ALTO_JUGADOR  = 96;

boolean enSuelo;

void dibujarMundo() {
  for (int i = 0; i < NUM_PLATAFORMAS; i++) {
    rect(plataX[i], plataY[i], plataAncho[i], plataAlto[i]);
  }
}

boolean hayChoque(float ax, float ay, float aAncho, float aAlto,
                   float bx, float by, float bAncho, float bAlto) {
  if (ax + aAncho <= bx) return false;
  if (ax >= bx + bAncho) return false;
  if (ay + aAlto <= by)  return false;
  if (ay >= by + bAlto)  return false;
  return true;
}

boolean chocaConPlataforma(int i) {
  float cajaX = x - ANCHO_JUGADOR/2;
  float cajaY = y - ALTO_JUGADOR/2;
  return hayChoque(cajaX, cajaY, ANCHO_JUGADOR, ALTO_JUGADOR,
                    plataX[i], plataY[i], plataAncho[i], plataAlto[i]);
}

void resolverX(float vx) {
  for (int i = 0; i < NUM_PLATAFORMAS; i++) {
    if (chocaConPlataforma(i)) {
      if (vx > 0) x = plataX[i] - ANCHO_JUGADOR/2;
      if (vx < 0) x = plataX[i] + plataAncho[i] + ANCHO_JUGADOR/2;
    }
  }
}

void resolverY() {
  for (int i = 0; i < NUM_PLATAFORMAS; i++) {
    if (chocaConPlataforma(i)) {
      if (vy > 0) {
        y = plataY[i] - ALTO_JUGADOR/2;
        vy = 0;
        enSuelo = true;
      }
      if (vy < 0) {
        y = plataY[i] + plataAlto[i] + ALTO_JUGADOR/2;
        vy = 0;
      }
    }
  }
}
