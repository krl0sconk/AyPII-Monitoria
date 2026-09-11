float gravedad = 3.0;

void setup(){
  size(800,480);
  noSmooth();
  imageMode(CENTER);
  cargarSprites();
}

void draw(){
  background(255);
  dibujarMundo();
  moverJugador();
  dibujarJugador();
}

void keyPressed() {
  if (key == 'a' || key == 'A') izquierda = true;
  if (key == 'd' || key == 'D') derecha   = true;
  if (keyCode == SHIFT)         corriendo = true;

  if (key == ' ' && enSuelo) {
    vy = -40;
  }
}

void keyReleased() {
  if (key == 'a' || key == 'A') izquierda = false;
  if (key == 'd' || key == 'D') derecha   = false;
  if (keyCode == SHIFT)         corriendo = false;
}
