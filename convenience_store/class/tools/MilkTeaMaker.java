package tools;

import Requests.CoffeeRequst;
import Requests.MilkTeaRequst;
import goods.MilkTea;

import java.util.ArrayList;
import java.util.Vector;
import Requests.MilkTeaRequst.Req;
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

	//@Override
	public void work(Object req, Object returnObj) {
		busy=true;
		MilkTeaRequst.Req req1 = (MilkTeaRequst.Req)req;
		MilkTea milkTea = getMilkTea(req1.type, req1.temperature,req1.sweetness,req1.price,req1.topping);
		((MilkTea) returnObj).setName(milkTea.getName());
		((MilkTea) returnObj).setTemperature(milkTea.getTemperature());
		((MilkTea) returnObj).setSweetness(milkTea.getSweetness());
		((MilkTea) returnObj).setPrice(milkTea.getPrice());
		for(String t:milkTea.getTopping()) {
			((MilkTea) returnObj).setTopping(t);
		}
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





