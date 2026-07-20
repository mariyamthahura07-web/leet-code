class FizzBuzz {
    private int n;
 private Semaphore num=new Semaphore(1);
 private Semaphore fizz=new Semaphore(0);
 private Semaphore buzz=new Semaphore(0);
 private Semaphore fizzbuzz=new Semaphore(0);
    public FizzBuzz(int n) {
        this.n = n;
    }

   
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5!=0){
                fizz.acquire();
                printFizz.run();
                num.release();
            }
        }
    }

   
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%5==0 && i%3!=0){
                buzz.acquire();
                printBuzz.run();
                num.release();
            }
        }
    }

    
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                fizzbuzz.acquire();
                printFizzBuzz.run();
                num.release();
            }
        }
    }

    
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            num.acquire();
            if(i%3==0  && i%5==0){
                fizzbuzz.release();
            }else if(i%3==0){
                fizz.release();
            }else if(i%5==0){
                buzz.release();
            }else{
                printNumber.accept(i);
                num.release();
            }
        }
    }
}