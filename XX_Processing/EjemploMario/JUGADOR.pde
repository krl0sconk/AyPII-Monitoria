PImage[] sprites = new PImage[11];

int[] IDLE = { 0 };
int[] CAMINAR = {3, 4, 5};
int[] CORRER = {6,5,7};
int[] SALTO = {9};
float x, y;
float vcaminando = 3, vcorriendo = vcaminando*5.0;
float vy;


boolean arriba, abajo, izquierda, derecha;
boolean corriendo = false;
boolean mirandoDerecha = false;
boolean saltando = false;

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
  
  vy += gravedad;
  y  += vy;
  
  if(corriendo) v = vcorriendo;
  if (izquierda) { x -= v;  mirandoDerecha = false;}
  if (derecha)   { x += v;  mirandoDerecha = true;}
  /*if(y>height){
      y=0;
  }
  if (arriba)      y -= v;                
  if (abajo)       y += v;
  */
  if(y>440) saltando = false;
  if(saltando) cambiarAnimacion(SALTO); 
  else if (!izquierda && !derecha && !arriba && !abajo) cambiarAnimacion(IDLE);
  else if(corriendo)                               cambiarAnimacion(CORRER);  
  else                                             cambiarAnimacion(CAMINAR);
  
  x = constrain(x, 30, width-30);
  y = constrain(y, 30, height-30);
  //vy = constrain(vy, 0, 9);
}
