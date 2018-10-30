package tools;

import goods.MilkTea;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 奶茶机类，用于获取指定类型的奶茶实体
 * @author liuchang
 * @version 0.1
 */
public class MilkTeaMaker extends DesertMaker {

	private MilkTeaBuilder milkTeaBuilder;
	private MilkTea emptyCup;
	private boolean busy;

	public MilkTeaMaker() {
		super();
		busy=false;
	}

	@Override
	public void work() {
		busy=true;
		System.out.println("MilkTea is ready");
		busy=false;
	}

    public  boolean isBusy(){
		return busy;
	}

	/**
	 *通过调用此接口，获得指定类型的奶茶实体
	 * @param type( choice:0  , 1 , 2 )  0.pearlMilkTea 1.taroMilkTea 2.strawberryMilkTea
	 * @param temperature( choice:0 , 1 , 2 ) 0.cool 1.normal 2.hot
	 * @param sweetness( choice:0 , 1,  2)0.freesugar 1.halfsugar 2.regularsugar
	 * @param price
	 * @param topping( choice:0 , 1 , 2)0.coconut 1.pudding 2.bean
	 * @return a entity of MilkTea
	 */
	public MilkTea getMilkTea(int type, int temperature, int sweetness,double price, ArrayList<Integer> topping){
		emptyCup=new MilkTea();
		emptyCup.setName("Empty");
		if(type==0) milkTeaBuilder=new PearlMilkTeaBuilder();
		else if(type==1)milkTeaBuilder=new TaroMilkTeaBuilder();
		else if(type==2)milkTeaBuilder=new StrawberryMilkTeaBuilder();
		else {
			emptyCup=new MilkTea();
			emptyCup.setName("Empty");
			return emptyCup;
		}

		if((temperature!=1)&&(temperature!=2)&&(temperature!=0))return emptyCup;
		if((sweetness!=1)&&(sweetness!=2)&&(sweetness!=0))return emptyCup;

		milkTeaBuilder.createNewMilkTea();
		milkTeaBuilder.buildSweetness(sweetness);
		milkTeaBuilder.buildTemprature(temperature);
		milkTeaBuilder.bulidTopping(topping);
		milkTeaBuilder.buildPrice(price);
		milkTeaBuilder.buildName();

		return milkTeaBuilder.getMilkTea();
	}

}





