import java.util.*;
class Product{
    int id,qty;
    String name;
    double price;
    Product(int i,String n,double p,int q){
        id=i;name=n;price=p;qty=q;
    }
    public String toString(){
        return id+" "+name+" "+price+" "+qty;
    }
}
class ProductManager{
    private static ProductManager inst;
    ArrayList<Product> list=new ArrayList<>();
    HashMap<Integer,Product> map=new HashMap<>();
    static ProductManager getInstance(){
        if(inst==null)inst=new ProductManager();
        return inst;
    }
    void add(Product p){
        if(map.containsKey(p.id))return;
        list.add(p);map.put(p.id,p);
    }
    void remove(int id){
        Product p=map.remove(id);
        if(p!=null)list.remove(p);
    }
    void display(){
        for(Product p:list)System.out.println(p);
    }
    void search(String k){
        for(Product p:list)
            if(p.name.toLowerCase().contains(k.toLowerCase()))
                System.out.println(p);
    }
    void sort(){
        list.sort(Comparator.comparingDouble(p->p.price));
    }
}
public class Main{
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        ProductManager pm=ProductManager.getInstance();
        pm.add(new Product(1,"Laptop",65000,10));
        pm.add(new Product(2,"Mouse",800,50));
        while(true){
            int ch=sc.nextInt();
            if(ch==1)
                pm.add(new Product(sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextInt()));
            else if(ch==2)
                pm.remove(sc.nextInt());
            else if(ch==3)
                pm.display();
            else if(ch==4)
                pm.search(sc.next());
            else if(ch==5){
                pm.sort();
                pm.display();
            }
            else break;
        }
    }

