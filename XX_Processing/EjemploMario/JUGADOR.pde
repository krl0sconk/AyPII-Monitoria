PImage[] sprites = new PImage[11];

int[] IDLE = { 0 };
int[] CAMINAR = {3, 4, 5};
int[] CORRER = {6,5,7};
int[] SALTO = {9};
float x, y;
float vcaminando = 3, vcorriendo = vcaminando*5.0;
float vy;


boolean izquierda, derecha;
boolean corriendo = false;
boolean mirandoDerecha = false;

int[] animacion;                    
int frameActual  = 0;               
int ultimoCambio = 0;

void cargarSprites() {
  for( int i = 0; i < 11; i++){
    sprites[i] = loadImage("player"+i+".png");
  }
  x = width/2;
  y= height/2;
}

void cambiarAnimacion(int[] nueva) {
  if (animacion != nueva) {
    animacion = nueva;
    frameActual = 0;
  }
}

void dibujarJugador(){
  
  if (millis() - ultimoCambio >= 50){
   frameActual = (frameActual + 1) % animacion.length;   
   ultimoCambio = millis();
  }
  pushMatrix();
  translate(x,y);
  if (mirandoDerecha) scale(-1, 1);
  scale(2,2);
  image(sprites[animacion[frameActual]], 0, 0);
  popMatrix();
}

void moverJugador(){
  float v = vcaminando;
  if (corriendo) v = vcorriendo;

  float vx = 0;
  if (izquierda) { vx -= v; mirandoDerecha = false; }
  if (derecha)   { vx += v; mirandoDerecha = true;  }

  x += vx;
  resolverX(vx);

  vy += gravedad;
  y  += vy;
  enSuelo = false;
  resolverY();

  if (!enSuelo)                          cambiarAnimacion(SALTO);
  else if (!izquierda && !derecha)       cambiarAnimacion(IDLE);
  else if (corriendo)                    cambiarAnimacion(CORRER);
  else                                    cambiarAnimacion(CAMINAR);

  x = constrain(x, 30, width-30);
}
