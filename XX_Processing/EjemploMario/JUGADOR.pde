PImage[] sprites = new PImage[8];

int[] IDLE = { 0 };
int[] CAMINAR = {3, 4, 5};
float x, y;
float v = 3;
boolean arriba, abajo, izquierda, derecha;
boolean mirandoDerecha = false;

int[] animacion;                    
int frameActual  = 0;               
int ultimoCambio = 0;

void cargarSprites() {
  for( int i = 0; i < 8; i++){
    sprites[i] = loadImage("player"+i+".png");
  }
  x = width/2;
  y= height/2;
}

void cambiarAnimacion(int[] nueva){
  if(animacion != nueva){
  animacion = nueva;
  frameActual = 0;
  }
}
void dibujarJugador(){
  
  if (millis() - ultimoCambio >= 200){
   frameActual = (frameActual + 1) % animacion.length;   
   ultimoCambio = millis();
  }
  pushMatrix();
  translate(x,y);
  if (mirandoDerecha) scale(-1, 1);
  image(sprites[animacion[frameActual]], 0, 0);
  popMatrix();
}

void moverJugador(){
  if (izquierda) { x -= v;  mirandoDerecha = false;}
  if (derecha)   { x += v;  mirandoDerecha = true;}
  if (arriba)      y -= v;                
  if (abajo)       y += v;
  
  if (!izquierda && !derecha && !arriba && !abajo) cambiarAnimacion(IDLE);
  else                                             cambiarAnimacion(CAMINAR);
  
  x = constrain(x, 30, width-30);
  y = constrain(y, 30, height-30);
}
