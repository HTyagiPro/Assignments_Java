import com.abc.graphics.Circle;
import com.abc.graphics.Rectangle;
import com.abc.utility.Calc;

import static com.abc.utility.Calc.sum;

public class Test {

	public static void main(String[] args) {
		Circle c1 = new Circle(7);
		System.out.println(c1.area());
		 Rectangle r1 = new Rectangle(15,13);
		 System.out.println(r1.area());
		 System.out.println(Calc.Pi);
		 System.out.println(Calc.power(5, 5));
		 System.out.println(sum(97,38));
	}

}
