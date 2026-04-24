import java.util.Scanner;

class Vector {

    double x,y,z;

    // Constructor
    Vector(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    // Addition
    Vector add(Vector v){
        return new Vector(x+v.x , y+v.y , z+v.z);
    }

    // Subtraction
    Vector subtract(Vector v){
        return new Vector(x-v.x , y-v.y , z-v.z);
    }

    // Dot product
    double dot(Vector v){
        return x*v.x + y*v.y + z*v.z;
    }

    void display(){
        System.out.println("("+x+", "+y+", "+z+")");
    }
}

public class VectorOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{

            System.out.print("Enter dimension (2 or 3): ");
            int d = sc.nextInt();

            System.out.println("Enter Vector A components:");

            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double z1 = (d==3)? sc.nextDouble():0;

            System.out.println("Enter Vector B components:");

            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double z2 = (d==3)? sc.nextDouble():0;

            Vector v1 = new Vector(x1,y1,z1);
            Vector v2 = new Vector(x2,y2,z2);

            Vector sum = v1.add(v2);
            Vector diff = v1.subtract(v2);

            System.out.print("Addition: ");
            sum.display();

            System.out.print("Subtraction: ");
            diff.display();

            System.out.println("Dot Product: "+v1.dot(v2));

        }

        catch(Exception e){
            System.out.println("Invalid input!");
        }

        sc.close();
    }
}
