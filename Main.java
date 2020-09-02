class Tarefa {
  public int valor, total;

  public Tarefa(int valor) {
    this.valor = valor;
  }

  public void run() {    
    for(int i=0; i < this.valor+1; i++){
      this.total += i;
    }
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("Núcleos.........: " + Runtime.getRuntime().availableProcessors());
    System.out.println("Thread Principal: " + Thread.currentThread().getName());

    for(int i=1; i<2; i++){
      int j = i;
      new Thread("Thread " + i){
        public void run(){
          Tarefa t = new Tarefa(j);
          t.run();
          System.out.println(t.total);
        }
      }.start();
    }
  }
}