//package Subject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Control implements Subject {
//    private DrawP1 drawP1;
//    public Control(DrawP1 drawP1){
//        this.drawP1 = drawP1;
//    }
//    private List<Observer> observers = new ArrayList<>();
//    @Override
//    public void attach(Observer observer) {
//        if (!observers.contains(observer))
//            observers.add(observer);
//    }
//    @Override
//    public void detach(Observer observer) {
//        if (observers.contains(observer)) {
//            observers.remove(observer);
//        }
//    }
//
//    @Override
//    public void notifyAllObserver() {
////        for (Observer observer : observers) {
////            observer.update(drawP1,Player1.orient);
////        }
//    }
//
////    private List<Observer> observers = new ArrayList<>();
////    @Override
////    public void attach(Observer observer) {
////        if (!observers.contains(observer))
////            observers.add(observer);
////    }
////    @Override
////    public void detach(Observer observer) {
////        if (observers.contains(observer)) {
////            observers.remove(observer);
////        }
////    }
////    public void checkStatus() {
////        for (Observer observer : observers) {
////            String status = observer.getStatus();
////            if (!status.equals("No"))
////                notifyAllObserver(status);
////        }
////    }
////    @Override
////    public void notifyAllObserver(String objectName) {
////        for (Observer observer : observers) {
////            if (observer.getClass().getName() == objectName) continue;
////            observer.update(observer);
////        }
////    }
//}
