package test;

import java.util.*;

interface Messenger {
    void sendMessage(String msg);
}

public class test {

    class NotInner implements Messenger {
        public void sendMessage(String msg) {
            System.out.println(msg);
        }
    }

    static class Inner implements Messenger {
        public void sendMessage(String msg) {
            System.out.println(msg);
        }
    }

    void Local(String msg) {
        class LocalMessenger implements Messenger {
            public void sendMessage(String msg) {
                System.out.println(msg);
            }
        }
        Messenger local = new LocalMessenger();
        local.sendMessage(msg);
    }

    void runAnonymous(String msg) {
        Messenger anonymous = new Messenger() {
            public void sendMessage(String msg) {
                System.out.println(msg);
            }
        };
        anonymous.sendMessage(msg);
    }

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
        test system = new test();
        Messenger[] msg = new Messenger[3];

        msg[0] = system.new NotInner();
        msg[0].sendMessage("Hi, Inner class! ");

        msg[1] = new test.Inner();
        msg[1].sendMessage("Hi, Static inner class! ");

        system.Local("Hi, Local class! ");

        msg[2] = new Messenger() {
            public void sendMessage(String msg) {
                System.out.println(msg);
            }
        };
        msg[2].sendMessage("Hi, from anonymous class! ");
    }
}