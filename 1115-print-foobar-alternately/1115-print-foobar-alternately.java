class FooBar {
private int n;

public FooBar(int n) {
    this.n = n;
}
AtomicBoolean flag1= new AtomicBoolean(true);

public synchronized void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
        if(!flag1.get())
        {
            wait();
        }
        printFoo.run();
        flag1.set(false);
        notifyAll();
    }
}

public synchronized void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
        if(flag1.get())
        {
            wait();
        }
        printBar.run();
        flag1.set(true);
        notifyAll();
    }
}
}

