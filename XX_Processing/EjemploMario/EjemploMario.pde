float gravedad = 3.0;

void setup(){
  size(800,480);
  noSmooth();
  imageMode(CENTER);
  cargarSprites();
}

void draw(){
  background(255);
  moverJugador();
  dibujarJugador();
}

void keyPressed() {
  if (key == 'a' || key == 'A') izquierda = true;
  if (key == 'd' || key == 'D') derecha   = true;
  if (key == 'w' || key == 'W') arriba    = true;
  if (key == 's' || key == 'S') abajo     = true;
  if (keyCode == SHIFT)         corriendo = true;
  
  if (key == ' ' && !saltando) {
    vy = -40;
    saltando = true;
  }
}

void keyReleased() {
  if (key == 'a' || key == 'A') izquierda = false;
  if (key == 'd' || key == 'D') derecha   = false;
  if (key == 'w' || key == 'W') arriba    = false;
  if (key == 's' || key == 'S') abajo     = false;
  if (keyCode == SHIFT)         corriendo = false;
}
