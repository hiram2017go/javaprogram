
/** 
 * wait用法 
 * @author java
 * @time 2018.3.9  
 */  
package com.zyy.thread;  
public class threadwait implements Runnable {     
        
    private String name;     
    private Object prev;     
    private Object self;     
    
    private threadwait(String name, Object prev, Object self) {     
        this.name = name;     
        this.prev = prev;     
        this.self = self;     
    }     
    
    @Override    
    public void run() {     
        int count = 10;     
        while (count > 0) {     
            synchronized (prev) {     
                synchronized (self) {     
                    System.out.print(name);     
                    count--;    
                    System.out.println("  名称是:"+name+";");
                    self.notify();     
                }     
                try {
                	System.out.println("   wait的名称是:"+name+";");
                    prev.wait();
                } catch (InterruptedException e) {     
                    e.printStackTrace();     
                }     
            }     
    
        }     
    }     
    
    public static void main(String[] args) throws Exception {     
        Object a = new Object();     
        Object b = new Object();     
        Object c = new Object();
        threadwait pa = new threadwait("A", c, a);     
        threadwait pb = new threadwait("B", a, b);     
        threadwait pc = new threadwait("C", b, c);     
             
             
        new Thread(pa).start();  
        Thread.sleep(1000);  //确保按顺序A、B、C执行  
        new Thread(pb).start();  
        Thread.sleep(1000);    
        new Thread(pc).start();     
        Thread.sleep(1000);    
        }     
}   